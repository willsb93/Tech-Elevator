package com.techelevator.PostageCalculator;

public class SecondClass implements IDeliveryDriver {

	@Override

	public double calculateRate(int distance, double weight) {
		double perMileRate = 0.0;
		if (weight <= 2) {
			perMileRate = 0.0035;
		} else if (weight > 2 && weight <= 8) {
			perMileRate = 0.0040;
		} else if (weight > 8 && weight <= 15) {
			perMileRate = 0.0047;
		} else if (weight > 15 && weight < 16) {
			perMileRate = 0.0195;
		} else if (weight > 16 && weight < 128) {
			perMileRate = 0.0450;
		} else {
			perMileRate = 0.0500;
		}

		double rate = perMileRate * distance;
		return (double) Math.round(rate * 100) / 100;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Postal Service (2nd class)";
	}

}
