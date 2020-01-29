package com.techelevator.TollBoothCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TollCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car tesla = new Car(false);
		Car ford = new Car(true);
		Tank tiger = new Tank();
		Truck ranger = new Truck(4);
		Truck tacoma = new Truck(6);
		Truck hilux = new Truck(8);

		List<IVehicle> allVehicles = new ArrayList<IVehicle>();

		allVehicles.add(tesla);
		allVehicles.add(ford);
		allVehicles.add(tiger);
		allVehicles.add(ranger);
		allVehicles.add(tacoma);
		allVehicles.add(hilux);

		int totalMiles = 0;
		double totalRevenue = 0.0;

		System.out.println(String.format("%-20s | %-19s | %-20s ", "Vehicle", "Distance Traveled", "Toll $"));
		System.out.println("***************************************************");
		for (IVehicle print : allVehicles) {
			Random r = new Random();
			int low = 10;
			int high = 240;
			int randomNumberDistance = r.nextInt(high - low) + low;
			totalMiles += randomNumberDistance;
			totalRevenue = totalRevenue + print.calculateToll(randomNumberDistance);

			System.out.println(String.format("%-20s | %-20s| %-20s", print.getType(), randomNumberDistance,
					"$" + print.calculateToll((randomNumberDistance))));

		}
		System.out.println("**************************************************");
		System.out.println("Total Miles Traveled: " + totalMiles);
		System.out.println("Total Tollbooth Revenue: $" + totalRevenue);
	}

}
