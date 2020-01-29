package com.techelevator.TollBoothCalculator;

public class Truck implements IVehicle {

	private int numberOfAxles;

	// Constructor

	public Truck(int numberOfAxles) {
		int nums = numberOfAxles;
		this.numberOfAxles = nums;
	}

	@Override
	public double calculateToll(int distance) {
		double toll = 0;
		if (this.numberOfAxles <= 4) {
			toll = distance * 0.040;

		} else if (this.numberOfAxles > 4 && this.numberOfAxles <= 6) {
			toll = distance * 0.045;
		} else if (this.numberOfAxles >= 8) {
			toll = distance * 0.048;
		}
		return (double) Math.round(toll * 100) / 100;
	}

	@Override
	public String getType() {
		if (this.numberOfAxles <= 4) {
			return "Truck (4 Axles)";
		} else if (this.numberOfAxles > 4 && this.numberOfAxles <= 6) {
			return "Truck (6 Axles)";
		}
		return "Truck (8 Axles)";
	}

}
