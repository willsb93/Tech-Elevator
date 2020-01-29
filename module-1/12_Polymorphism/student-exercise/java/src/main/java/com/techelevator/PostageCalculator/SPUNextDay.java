package com.techelevator.PostageCalculator;

public class SPUNextDay implements IDeliveryDriver {

	@Override
	public double calculateRate(int distance, double weight) {
		double rate = ((weight / 16) * 0.075) * distance; // converts weight to pounds
		return (double) Math.round(rate * 100) / 100;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "SPU (Next Day)";
	}

}
