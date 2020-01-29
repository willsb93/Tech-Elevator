package com.techelevator.PostageCalculator;

public class SPU4DayGround implements IDeliveryDriver {

	@Override
	public double calculateRate(int distance, double weight) {
		double rate = (weight * 0.0050) * distance;
		return rate;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "SPU (4-Day Ground)";
	}

}
