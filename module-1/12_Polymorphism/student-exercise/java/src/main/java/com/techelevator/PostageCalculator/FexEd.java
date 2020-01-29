package com.techelevator.PostageCalculator;

public class FexEd implements IDeliveryDriver {

	@Override
	public double calculateRate(int distance, double weight) {
		double rate = 20.0;
		if (distance > 500) {
			rate = (double) Math.round(rate * 100) / 100 + 5;
		}
		if (weight > 48) {
			rate = (double) Math.round(rate * 100) / 100 + 3;
		}
		return rate;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "FexEd";
	}

}
