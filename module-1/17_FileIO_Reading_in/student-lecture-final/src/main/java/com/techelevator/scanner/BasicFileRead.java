package com.techelevator.scanner;


import java.util.Scanner;
import java.io.File;

/*
 * 
 * If time allows, after walking through this... How could we refactor this code for better readability?
 *
 */


public class BasicFileRead {

	public static void main(String[] args) {
	
		File text = new File("Dummy.txt");
		
		
		
	
		
		try(Scanner fileScanner = new Scanner(text)) {
			String firstLine = fileScanner.nextLine();
			System.out.println("Let's print the first line: " + firstLine);
			
			
			String[] mySplitLine1 = firstLine.split(" ");
			
			System.out.println("Now let's parse it...");
			int i = 0;
			for (i = 0; i< mySplitLine1.length; i++) {
				//while loop here, while has next line
				
				System.out.println(mySplitLine1[i]);
			}
			System.out.println(i);
			
			
			String secondLine = fileScanner.nextLine();
			System.out.println("Now printing second line: " + secondLine);
			

		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}
