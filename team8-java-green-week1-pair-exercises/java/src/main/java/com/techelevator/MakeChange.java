package com.techelevator;

import java.util.Scanner;

/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then
 display the change required.

 $ java MakeChange
 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
public class MakeChange {

	public static void main(String[] args) {
		
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("What is the total bill ?");
			String totalBill = in.nextLine();
			double totalConverted = Double.parseDouble(totalBill);
			
			System.out.println("What is the amount paid ?");
			String totalPaid = in.nextLine();
			double paidConverted = Double.parseDouble(totalPaid);
			
			double change = paidConverted - totalConverted;
			
			System.out.println("Here is your change: " + " " +"$" + change);
			
		}

	}

}
