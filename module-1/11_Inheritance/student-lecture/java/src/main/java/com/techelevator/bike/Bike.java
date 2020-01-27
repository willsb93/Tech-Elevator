package com.techelevator.bike;

public class Bike {
	
	private int numberOfGears;
	private String brand;
	private String color;
	
	public Bike(int numberOfGears, String color, String brand) {
		this.numberOfGears = numberOfGears;
		this.color = color;
		this.brand = brand;
	}
	
    public String ride() {
    	return "Woohoo!";
    }
    
	
	
	public int getNumberOfGears() {
		return numberOfGears;
	}
	public void setNumberOfGears(int numberOfGears) {
		this.numberOfGears = numberOfGears;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	

}
