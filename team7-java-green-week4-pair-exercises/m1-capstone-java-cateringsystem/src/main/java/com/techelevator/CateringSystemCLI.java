package com.techelevator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import com.techelevator.view.CateringService;
import com.techelevator.view.Item;
import com.techelevator.view.Menu;
import com.techelevator.view.Wallet;

public class CateringSystemCLI {

	private String fileName = "cateringsystem.csv"; // For now we hard coded the file name for development purposes

	private Menu menu; // create an instance of menu class to run menus
	private CateringService catering = new CateringService(fileName);// create an instance of service to run stuff
	// pass the fileName which is our file to be read to the constructor in the cateringService class
	//constructor
	public CateringSystemCLI(Menu menu) {
		this.menu = menu;
	}
	public static void main(String[] args) {
		Menu menu = new Menu();
		CateringSystemCLI cli = new CateringSystemCLI(menu);
		cli.run();
	}

	public void run() {
		while (true) {
			// display the main menu

			String choice = menu.printMainMenu();

			if (choice.equals("1")) {
				// Retrieve a list of the catering items
				System.out.println("You picked 1");
				List<Item> itemList = catering.retrieveListOfCateringItems(); //Assigns the mainList here
				catering.printCateringItems(itemList); // prints the list
			}

			else if (choice.equals("2")) {
				// Goes to the sub menu to handle purchases
				System.out.println("You picked 2");
				runSubMenu();
			} else if (choice.equals("3")) {
				// Quits the program
				System.out.println("Thank you!");
				System.exit(1);
				;
			} else {
				menu.invalidEntry();
			}
		}
	}

	private void runSubMenu() {

		boolean exitsTheSubMenu = false;

		while (!exitsTheSubMenu) {

			// Prints the sub menu
			String choice = menu.printSubMenu(catering.getWalletBalance());
			
		

			// Deals with user choices on the sub menu

			if (choice.equals("1")) {

				System.out.println("You picked 1");
				BigDecimal balance = catering.getWalletBalance();
				BigDecimal moneyAdded = menu.promptUserToAddMoney(balance);
				catering.setWalletBalance(moneyAdded);
				

			} else if (choice.equals("2")) {
				// Selects the products to purchase
				System.out.println("You picked 2");
				String itemCode = menu.getItemCodeFromUser();
				Item item = catering.selectItemsFromTheList(itemCode);
				if (item != null) {
					int quantityToBePurchased = menu.getItemQuantityFromUser();
					if(quantityToBePurchased > 0) {
						catering.checkAndUpdateItemQuantity(item, quantityToBePurchased);
					}
					else
						menu.invalidEntry();
				}

			} else if (choice.equals("3")) {
				// Completes the transaction
				System.out.println("You picked 3");
				// Call method to complete the transaction
				catering.completeTransaction();
				run(); // creates an endless call stack, 
			} else if (choice.equals("4")) {
				// Returns to the Main Menu
				System.out.println("You picked 4");
				exitsTheSubMenu = true;

			} else {
				menu.invalidEntry();
			}

		}
	}

}
