package com.techelevator.PostageCalculator;

public class ThirdClass implements IDeliveryDriver {

	
	@Override

	public double calculateRate(int distance, double weight) {
		double perMileRate = 0.0;
		if (weight <= 0.125) {
			perMileRate = 0.0020;
		} else if (weight > 0.125 && weight <= 0.5) {
			perMileRate = 0.0022;
		} else if (weight > 0.5 && weight <= 0.93) {
			perMileRate = 0.0024;
		} else if (weight > 0.93 && weight < 16) {
			perMileRate = 0.0150;
		} else if (weight > 16 && weight < 128) {
			perMileRate = 0.0160;
		} else {
			perMileRate = 0.0170;
		}

		double rate = perMileRate * distance;
		return rate;
	}

	@Override
	public String getName(){
		// TODO Auto-generated method stub
		return "Postal Service (3rd Class)";
	}

}
