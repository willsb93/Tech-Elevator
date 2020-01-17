package com.techelevator;

import java.util.Scanner;

public class InputASequenceOfNumbersAndParseSolution {
	
	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Please enter in a series of numeric values (separated by commas): ");

			String input = scanner.nextLine();
		
			
			String[] numbers = input.split(",");          // note: these are String representation of numbers....
			
			String[] numbers2 = input.split("|");
			System.out.println("You entered " + numbers.length + " numbers.");
			for (int i=0; i<numbers.length; i++) {
				System.out.println("value of numbers[" + i + "] = " + numbers[i]);
			}
			
			for (int i=0; i<numbers2.length; i++) {
				System.out.println("value of numbers2[" + i + "] = " + numbers2[i]);
			}
		}
	}
	
}
