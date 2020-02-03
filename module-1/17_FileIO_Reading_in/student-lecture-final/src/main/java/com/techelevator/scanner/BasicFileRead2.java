package com.techelevator.scanner;


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BasicFileRead2 {

	public static void main(String[] args) {
	
		String myFileLocation = "BasicFileRead2Dummy";
		File text = new File(myFileLocation);
		
		try(Scanner fileScanner = new Scanner(text)) {
			
			while (fileScanner.hasNextLine()) {
				String s = fileScanner.nextLine();
				System.out.println(s);
				
				//now split into fields
				String[] myFields = s.split(",");
				
				if (myFields.length != 0) {
					String name = myFields[0];
					String id = myFields[1];
					String whatever = myFields[2];
					System.out.println("values: " + "Name: " + name + ", id: " + id + " whatever: " + whatever);
					System.out.println ("************");
				}
				

			}
		

		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}
