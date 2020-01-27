package com.techelevator.auto;

public class Automobile {
	
	private String make;
	private String model;
	private int year;
	private int numberOfDoors;
	private boolean seatBelts;

	public boolean isSeatBelts() {
		return seatBelts;
	}

	public void setSeatBelts(boolean seatBelts) {
		this.seatBelts = seatBelts;
	}

	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getNumberOfDoors() {
		return numberOfDoors;
	}
	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}
	
	
	public String toString() {
		
		return this.make + " " + this.model;
	}
	

}
