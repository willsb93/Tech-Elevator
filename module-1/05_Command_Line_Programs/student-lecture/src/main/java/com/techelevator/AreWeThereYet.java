package com.techelevator;

import java.util.Scanner;

public class AreWeThereYet {

	public static void main(String[] args) {
		
		
		try (Scanner in = new Scanner(System.in)) {
		

			boolean areWeThere = false;
		
			while (!areWeThere) {
				System.out.println("Bart Simpson: Are We There Yet? (Y)es or (N)o ");
				String answer = in.nextLine();

				if(answer.equalsIgnoreCase("Y")){
					areWeThere = true;
				}
			}
			System.out.println("It is about time, dude!");
			
			
	
		}	

	}

}
