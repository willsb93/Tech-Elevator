package com.techelevator.PostageCalculator;

public class SPU2DayBusiness implements IDeliveryDriver{

	@Override
	public double calculateRate(int distance, double weight) {
		double rate = (weight * 0.050) * distance;
		return rate;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "SPU (2-Day Business)";
	}

}
