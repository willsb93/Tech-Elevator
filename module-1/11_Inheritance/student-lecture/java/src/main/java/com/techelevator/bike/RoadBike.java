package com.techelevator.bike;

public class RoadBike extends Bike{

	public RoadBike(int numberOfGears, String color, String brand) {
		super(numberOfGears, color, brand);

	}

	
	public String toString() {
		return "RoadBike: brand: " + this.getBrand() + ", color: " + this.getColor() + ", gears: " + this.getNumberOfGears(); 
	}
}
