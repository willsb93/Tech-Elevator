package com.techelevator.view;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.techelevator.CateringSystemCLI;

public class CateringService {

	private List<Item> mainListOfItems; // Our main list of items
	private List<Item> cartList = new ArrayList<Item>(); 
	private List<Log> logList = new ArrayList<Log>();
	private Wallet userWallet = new Wallet(); // creates a user wallet so we can access the balance , etc
	private MathContext mc = new MathContext(4);// precision for the BigDecimal
	private LogFilePrinter logPrinter = new LogFilePrinter();

	// Constructor that initializes and reads the input file
	public CateringService(String fileName) {
		ItemFileReader fileReader = new ItemFileReader();
		mainListOfItems = fileReader.readItemFile(fileName);
	}

	public List<Item> retrieveListOfCateringItems() {
		// retrieve list of items
		return mainListOfItems;
	}

	// Writes the action taken into the log
	public void auditInLogList(Log log) {
		if (logList.isEmpty()) {
			logPrinter.createLogFile();
		}
		logList.add(log);
		logPrinter.printLog(log);
	}

	public BigDecimal getWalletBalance() {
		return userWallet.getUserBalance();
	}

	public BigDecimal setWalletBalance(BigDecimal moneyAdded) {
		BigDecimal updatedBalance = userWallet.getUserBalance().add(moneyAdded);
		Log log = new Log(java.time.LocalDate.now(), java.time.LocalTime.now(), "Money Added: $" + moneyAdded,
				updatedBalance.round(mc));
		auditInLogList(log);
		return userWallet.setUserBalance(updatedBalance);
	}

	public void printCateringItems(List<Item> printCateringList) {
		// print the list of items, goes trough a loop and prints each line
		System.out.println(
				String.format("%-5s | %-20s | %15s | %-5s | %-5s", "CODE", "PRODUCT", "PRICE", "TYPE", "QUANTITY"));
		System.out.println("------------------------------------------------------------------------------------");
		for (Item a : printCateringList) {
			// format the lines
			if (a.getItemQuantity() <= 0) {
				System.out.println(String.format("%-5s | %-20s | %15s | %-5s | %-5s", a.getItemCode(), a.getItemName(),
						"$" + a.getItemPrice().round(mc), a.getItemType(), "SOLD OUT"));
			} else {
				System.out.println(String.format("%-5s | %-20s | %15s | %-5s | %-5s", a.getItemCode(), a.getItemName(),
						"$" + a.getItemPrice().round(mc), a.getItemType(), "Quantity:" + a.getItemQuantity()));
			}
		}
		System.out.println("------------------------------------------------------------------------------------");
	}

	public Item selectItemsFromTheList(String itemCode) {

		for (Item item : mainListOfItems) {

			if (itemCode.equalsIgnoreCase(item.getItemCode())) {
				//Goes to the item class and retrieves the item code
				return item;
			}
		}
		System.out.println("Product code does not exist. Please input another product code.");
		return null;
	}

	public void checkAndUpdateItemQuantity(Item item, int quantityToBePurchased) {

		if (item.getIsSoldOut() == true) {
			System.out.println("This product is SOLD OUT.");

		} else if (quantityToBePurchased > item.getItemQuantity()) {
			System.out.println("Insufficient stock. Current stock of the product is " + item.getItemQuantity());
		}

		else {

			if (updateBalanceAfterPurchase(item.getItemPrice(), quantityToBePurchased)) {
				item.setItemQuantity(item.getItemQuantity() - quantityToBePurchased);
				item.getIsSoldOut();
				updateCart(item, quantityToBePurchased);
				BigDecimal quantityPurchasedConverted = new BigDecimal(quantityToBePurchased);
				BigDecimal totalItemPrice = item.getItemPrice().multiply(quantityPurchasedConverted).round(mc);
				String logActionTaken = quantityToBePurchased + " " + item.getItemName() + " " + item.getItemCode()
						+ " " + totalItemPrice;
				Log log = new Log(java.time.LocalDate.now(), java.time.LocalTime.now(), logActionTaken,
						userWallet.getUserBalance().round(mc));
				auditInLogList(log);
				System.out.println("You selected " + item.getItemName() + " " + quantityToBePurchased + " unit(s)");
			}

		}
	}

	public void updateCart(Item item, int quantity) {
		Item itemInCart = new Item(item.getItemCode(), item.getItemName(), item.getItemPrice(), item.getItemType());
		itemInCart.setItemQuantity(quantity);
		cartList.add(itemInCart); // List that holds the user cart selected items

	}

	public boolean updateBalanceAfterPurchase(BigDecimal itemPrice, int quantity) {
		BigDecimal quantityConverted = new BigDecimal(quantity);
		BigDecimal valueToBeSubtracted = itemPrice.multiply(quantityConverted);
		if (valueToBeSubtracted.compareTo(getWalletBalance()) != 1) {
			BigDecimal updatedBalance = userWallet.getUserBalance().subtract(valueToBeSubtracted);
			userWallet.setUserBalance(updatedBalance);
			return true;
		} else
			System.out.println("Insufficient funds.");
		return false;

	}

	public void updateMainListOfItems(Item item) {
		for (Item i : mainListOfItems) {
			if (i.equals(item)) {
				i.setItemQuantity(item.getItemQuantity());
			}
		}
	}

	public void completeTransaction() {

		BigDecimal totalAmountSpent = new BigDecimal(0);
		String typeUserFriendly = "";
		System.out.println(String.format("%-10s | %-10s | %20s | %-15s | %-5s", "QUANTITY", "TYPE", "PRODUCT",
				"PRICE PER ITEM", "SUBTOTAL"));
		for (Item i : cartList) {
			BigDecimal itemQuantityConverted = new BigDecimal(i.getItemQuantity());
			BigDecimal totalPriceOfItem = (i.getItemPrice()).multiply(itemQuantityConverted);// price of whatever amount
																								// of units have been purchased
			totalAmountSpent = totalAmountSpent.add(totalPriceOfItem);

			if (i.getItemType().equalsIgnoreCase("B")) {
				typeUserFriendly = "Beverage";
			} else if (i.getItemType().equalsIgnoreCase("E")) {
				typeUserFriendly = "Entree";
			} else if (i.getItemType().equalsIgnoreCase("A")) {
				typeUserFriendly = "Appetizer";
			} else if (i.getItemType().equalsIgnoreCase("D")) {
				typeUserFriendly = "Dessert";
			}

			System.out.println("---------------------------------------------------------------------------");
			System.out.println(
					String.format("%-10s | %-10s | %20s | %-15s | %-10s", i.getItemQuantity(), typeUserFriendly,
							i.getItemName(), "$" + i.getItemPrice().round(mc), "$" + totalPriceOfItem.round(mc)));

		}

		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Total: $" + totalAmountSpent.round(mc));
		BigDecimal balance = userWallet.getUserBalance().round(mc);
		System.out.println("Your change is: $" + balance);
		System.out.println("Your change format is: " + receiveRemainingChange(balance));
		System.out.println("---------------------------------------------------------------------------");

	}

	public String receiveRemainingChange(BigDecimal change) {
		userWallet.setUserBalance(new BigDecimal(0));// update the balance to 0 after change
		Log log = new Log(java.time.LocalDate.now(), java.time.LocalTime.now(), "Give Change:" + change,
				userWallet.getUserBalance());
		auditInLogList(log);

		int numberOf20s = 0;
		int numberOf10s = 0;
		int numberOf5s = 0;
		int numberOf1s = 0;
		int numberOfQuarters = 0;
		int numberOfDimes = 0;
		int numberOfNickels = 0;

		BigDecimal nickel = new BigDecimal(0.05).round(mc); // Added to be precise and get correct change
		BigDecimal dime = new BigDecimal(0.10).round(mc);
		BigDecimal quarter = new BigDecimal(0.25).round(mc);
		
		while (change.compareTo(new BigDecimal(20)) == 1 || change.compareTo(new BigDecimal(20)) == 0) {
			change = change.subtract(new BigDecimal(20).round(mc));
			numberOf20s += 1;
		}
		while (change.compareTo(new BigDecimal(10)) == 1 || change.compareTo(new BigDecimal(10)) == 0) {
			change = change.subtract(new BigDecimal(10).round(mc));
			numberOf10s += 1;
		}
		while (change.compareTo(new BigDecimal(5)) == 1 || change.compareTo(new BigDecimal(5)) == 0) {
			change = change.subtract(new BigDecimal(5).round(mc));
			numberOf5s += 1;
		}
		while (change.compareTo(new BigDecimal(1)) == 1 || change.compareTo(new BigDecimal(1)) == 0) {
			change = change.subtract(new BigDecimal(1).round(mc));
			numberOf1s += 1;
		}
		while (change.compareTo(quarter) == 1 || change.compareTo(quarter) == 0) {
			change = change.subtract(new BigDecimal(0.25).round(mc));
			numberOfQuarters += 1;
		}
		while (change.compareTo(dime) == 1 || change.compareTo(dime) == 0) {
			change = change.subtract(new BigDecimal(0.10).round(mc));
			numberOfDimes += 1;
		}

		while (change.compareTo(nickel) == 1 || change.round(mc).compareTo(nickel) == 0) {
			change = change.subtract(new BigDecimal(0.05).round(mc));
			numberOfNickels += 1;
		}
		String changeBack = numberOf20s + " (20s), " + numberOf10s + " (10s), " + numberOf5s + " (5s), " + numberOf1s
				+ " (1s), " + numberOfQuarters + " (quarters), " + numberOfDimes + " (dimes), " + numberOfNickels
				+ " (nickels).";

		return changeBack;
	
	}

}
