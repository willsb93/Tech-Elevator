package com.techelevator;

import java.util.Scanner;

/*
Write a simple program that prompts the user for a distance, then asks the user
for a unit of measurement (k) for kilometers,  (m) for miles.  (N) for quit.
After they submit the information, calculate the response: 
    If miles, convert to km. If km, convert to miles.

Then ask them if they want to do another (Y/N). If they answer Y, repeat, 
if N, exit.

(distance in kilometers) ≈ distance in miles / 0.62137
(distance in miles) ≈ 0.6214 * (distance in kilometers)

If time, come back and refactor. What other things could we do to improve the code?
(Get working code first, then worry about cleaning it up.)
*/

public class KilometersAndMilesSolution {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			boolean shouldWeLoop = true;

			while (shouldWeLoop) {

				// greet the user and prompt them to enter a distance
				System.out.println("Enter a distance to convert (in whole numbers): ");
				String value = scanner.nextLine();
				
				
				int distanceToConvert = Integer.parseInt(value);
			
			

				System.out.println("Enter (m) for miles, (k) for kilometers: ");
				String unitOfMeasurement = scanner.nextLine();

				if (unitOfMeasurement.equals("m")) {
					float km = distanceToConvert / 0.62137f;
					System.out.println(distanceToConvert + " miles is: " + km + " kilometers.");
				} 
				else if (unitOfMeasurement.equals("k")) {
					float miles = 0.6214f * distanceToConvert;
					System.out.println(distanceToConvert + " km is: " + miles + " miles.");
				} 
				else {
					System.out.println("You have entered invalid input");
				}
			
				System.out.println("Should we do another? (Y/N) ");
				String anotherValue = scanner.nextLine();
				if (anotherValue.equals("N")) {
					shouldWeLoop = false;
				}
			
			}
			System.out.print("Thank You!");
		}
		

	}

}
