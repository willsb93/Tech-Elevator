package com.techelevator.PostageCalculator;

public class SPU4DayGround implements IDeliveryDriver {

	@Override
	public double calculateRate(int distance, double weight) {
		double rate = ((weight / 16) * 0.0050) * distance; // divide by 16 to convert to pounds
		return (double) Math.round(rate * 100) / 100;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "SPU (4-Day Ground)";
	}

}
