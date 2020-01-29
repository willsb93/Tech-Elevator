package com.techelevator.PostageCalculator;

public class FirstClass implements IDeliveryDriver{

	
	
	
	
	@Override
	public double calculateRate(int distance, double weight) {
		double perMileRate = 0.0;
		if (weight <= 0.125) {
			perMileRate = 0.035;
		}
		else if (weight > 0.125 && weight <= 0.5) {
			perMileRate = 0.040;
		}
		else if (weight > 0.5 && weight <=0.93) {
			perMileRate = 0.047;
		}
		else if (weight > 0.93 && weight < 16 ) {
			perMileRate = 0.195;
		}
		else if (weight > 16 && weight < 128) {
			perMileRate = 0.450;
		}
		else {
			perMileRate = 0.500;
		}
		
		double rate = perMileRate * distance;
		return rate;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Postal Service (1st class)";
	}

}
