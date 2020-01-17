package com.techelevator;

import java.util.Scanner;

public class StateCodes {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Please enter a 2 letter state code that starts with A: ");

			String code = scanner.nextLine();

			switch (code) {
			case "AL":
				System.out.println("Alabama");
				break;
			case "AK":
				System.out.println("Alaska");
				break;
			case "AR":
				System.out.println("Arkansas");
				break;
			case "AZ":
				System.out.println("Arizona");
				break;
			default:
				System.out.println("Nope. Better Luck Next Time!");
			}
		}

	}

}
