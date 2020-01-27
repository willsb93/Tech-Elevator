package com.techelevator.bike;

public class BMXBike extends Bike{

	boolean hasPegs;
	
	public BMXBike(int numberOfGears, String color, String brand, boolean hasPegs) {
		super(numberOfGears, color, brand);
		this.hasPegs = hasPegs;
	}
	
    public String ride() {
    	return "DUUUUUDDDDEEEE!";
    }
    
    public String ride(String noise) {
    	return noise;
    }

	public boolean isHasPegs() {
		return hasPegs;
	}

	public void setHasPegs(boolean hasPegs) {
		this.hasPegs = hasPegs;
	}
	
	
	public String toString() {
		return "BMXBike: brand: " + this.getBrand() + ", color: " + this.getColor() + ", gears: " + this.getNumberOfGears(); 
	}	
	
}
