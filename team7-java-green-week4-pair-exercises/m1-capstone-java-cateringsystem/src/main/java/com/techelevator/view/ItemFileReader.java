package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemFileReader {
	/*
	 * This class will read the input file and assign the values to a List It will
	 * have a scanner to read the input file It will create an instance of the Item
	 */

	private Scanner cateringFileScanner;

	
	//read the file and create a list of available items from file
	public List<Item> readItemFile(String fileName) {

		List<Item> itemList = new ArrayList<Item>(); // List of Items available for purchase
		File fileToBeRead = new File(fileName);

		try {
			cateringFileScanner = new Scanner(fileToBeRead);

			// Scan trough the file while it has a next line
			while (cateringFileScanner.hasNext()) {

				String itemInfo = cateringFileScanner.nextLine(); // assign the content of the file to a String
				String[] itemVariables = itemInfo.split("\\|"); // Separates the content into an array, so we get name,
																// type, etc
				double price = Double.valueOf(itemVariables[2]); // Converts String to double and then double to big decimal
				
				
				Item item = new Item(itemVariables[0], itemVariables[1],new BigDecimal(price), itemVariables[3]);
				itemList.add(item);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return itemList;
	}
}
