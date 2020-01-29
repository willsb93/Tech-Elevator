package com.techelevator.TollBoothCalculator;

public class Car implements IVehicle {

	private boolean hasTrailer;

	// Constructor
	public Car(boolean hasTrailer) {
		boolean trailer = hasTrailer;
		this.hasTrailer = trailer;
	}

	public boolean isHasTrailer() {
		return hasTrailer;
	}

	@Override
	public double calculateToll(int distance) {
		double toll = distance * 0.020;
		if (hasTrailer == true) {
			toll = toll + 1.00;
		}
		return (double) Math.round(toll * 100) / 100;
	}

	@Override
	public String getType() {
		if (hasTrailer == true) {
			return "Car (with trailer)";
		}
		return "Car";
	}

}
