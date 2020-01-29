package com.techelevator.PostageCalculator;

import java.text.DecimalFormat;

public class FirstClass implements IDeliveryDriver {

	@Override
	public double calculateRate(int distance, double weight) {
		double perMileRate = 0.0;
		if (weight <= 2) {
			perMileRate = 0.035;
		} else if (weight > 2 && weight <= 8) {
			perMileRate = 0.040;
		} else if (weight > 8 && weight <= 15) {
			perMileRate = 0.047;
		} else if (weight > 15 && weight < 16) {
			perMileRate = 0.195;
		} else if (weight > 16 && weight < 128) {
			perMileRate = 0.450;
		} else {
			perMileRate = 0.500;
		}

		double rate = perMileRate * distance;
		return (double) Math.round(rate * 100) / 100;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Postal Service (1st class)";
	}

}
