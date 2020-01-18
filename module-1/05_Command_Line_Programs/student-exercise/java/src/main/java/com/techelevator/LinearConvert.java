package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Please enter the length:");

			String length = scanner.nextLine();

			double lengthConvert = Double.parseDouble(length);

			System.out.println("Is the length in (m)eter or (f)eet ?");

			String unit = scanner.nextLine();

			if (unit.equals("m")) {
				lengthConvert = lengthConvert * 3.2808399;
				int foot = (int) lengthConvert;
				System.out.println(length + "m" + " " + "is" + " " + foot + "f");

			}
			if (unit.equals("f")) {
				lengthConvert = lengthConvert * 0.3048;
				int meters = (int) lengthConvert;
				System.out.println(length + "f" + " " + "is" + " " + meters + "m");

			}
		}
	}
}

////			
