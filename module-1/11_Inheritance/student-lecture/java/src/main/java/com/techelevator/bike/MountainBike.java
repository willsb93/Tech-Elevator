package com.techelevator.bike;

public class MountainBike extends Bike {

	public MountainBike(int numberOfGears, String color, String brand) {
		super(numberOfGears, color, brand);
		
		//do something like initialize local instance variable
	}
	
    public String ride() {
    	return super.ride() + " yippee!";
    }

}
