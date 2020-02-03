package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AccountApp {

	public static void main(String[] args) throws FileNotFoundException {
		

	        
        printApplicationBanner();
		
		File inputFile = getInputFileFromUser();
		try(Scanner fileScanner = new Scanner(inputFile)) {
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				System.out.println("\n" + line + "\n");
				
				//example :  Parse line based on comma-delimited fields
				splitLine(line);
			}
		}
	}

	private static void printApplicationBanner() {
		System.out.println("***************************");
		System.out.println("Killer Account File Parser!");
		System.out.println("***************************");
		System.out.println();
	}

	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter path to input file >>> ");
		String path = userInput.nextLine();
		
		File inputFile = new File(path);
		
		
		if(inputFile.exists() == false) { // checks for the existence of a file
			System.out.println(path+" does not exist");
			System.exit(1); // Ends the program
		} else if(inputFile.isFile() == false) {
			System.out.println(path+" is not a file");
			System.exit(1); // Ends the program
		}
		return inputFile;
	}
	
	private static void splitLine(String line) {
		String[] fields = line.split(",");
		
		for (int i=0; i<fields.length; i++) {
			System.out.println(fields[i]);
		}
		
	}
	
	
	
}

