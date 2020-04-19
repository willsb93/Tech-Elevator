package com.techelevator.view;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class Menu {

	// Create Scanner object to capture user input and return choice
	private Scanner inputScanner = new Scanner(System.in);
	private MathContext mc = new MathContext(4);

	/*
	 * 1. Display Catering Items 2. Order 3. Quit
	 */
	public String printMainMenu() {

		// code that lists our main menu options
		System.out.println("1. Display Catering Items");
		System.out.println("2. Order");
		System.out.println("3. Quit");

		return inputScanner.nextLine();

	}

	/*
	 * This is the sub menu (1) Add Money (2) Select Products (3) Complete
	 * Transaction Current Account Balance: $20.00
	 */
	public String printSubMenu(BigDecimal balance) {

		System.out.println("1. Add Money");
		System.out.println("2. Select Products");
		System.out.println("3. Complete Transaction");
		System.out.println("4. Return To The Main Menu");
		System.out.println("Current balance is $" + balance.round(mc));

		return inputScanner.nextLine();

	}

	public BigDecimal promptUserToAddMoney(BigDecimal balance) {
		System.out.println("Please insert any whole dollar ammount :");
		int moneyAdded = 0; // its int because we need a whole dollar ammount
		try {
			moneyAdded = inputScanner.nextInt();
			inputScanner.nextLine();

		} catch (Exception ex) {
			invalidEntry();
			inputScanner.nextLine();
			return new BigDecimal(0);

		}
		BigDecimal moneyAddedConverted = new BigDecimal(moneyAdded);
		if (moneyAddedConverted.compareTo(new BigDecimal(0)) == -1 || moneyAdded < 0) {
			invalidEntry(); // if the values is less than 0

			return new BigDecimal(0);
		} else if ((moneyAddedConverted.add(balance).compareTo(new BigDecimal(5000)) == 1)) {
			//If the ammount passed plus the balance is greater than 5000;
			System.out.println("You can't have a balance greater than 5000");
			return new BigDecimal(0);
		}

		return moneyAddedConverted;

	}

	public String getItemCodeFromUser() {

		System.out.println("Please enter the product code to be added to your cart:");

		return inputScanner.nextLine();
	}

	public int getItemQuantityFromUser() {
		System.out.println("Please enter the product quantity:");
		int itemQuantity = 0;
		try {
			itemQuantity = inputScanner.nextInt();
		} catch (Exception e) {
		
		}
		inputScanner.nextLine();// with this we are able to read the next input
		return itemQuantity;

	}

	public static void invalidEntry() {
		System.out.println("Invalid input. Please try Again.");
	}

}
