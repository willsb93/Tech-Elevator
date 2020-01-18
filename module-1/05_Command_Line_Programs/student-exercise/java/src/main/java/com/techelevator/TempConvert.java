package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println ("Please enter the temperature:");
			
			String temperature = scanner.nextLine();
			
			double temperatureConvert = Double.parseDouble (temperature);
			
			System.out.println ("Is the temperature in C or F ?");
			
			String unit = scanner.nextLine();
			
			if (unit.equals("C")) {
				temperatureConvert = (temperatureConvert * 1.8) + 32;
				int fTemperature = (int) temperatureConvert;
				System.out.println(temperature +"C" + " " + "is" + " " + fTemperature + "F");
				
	
			}
			if (unit.equals("F")) {
				temperatureConvert = (temperatureConvert - 32) / 1.8;
				int cTemperature = (int) temperatureConvert;
				System.out.println(temperature +"F" + " " + "is" + " " + cTemperature + "C");
			
		}
			else {
				System.out.println ("Please type C for celsius or F for fahrenheit");
			}

	}

} }
