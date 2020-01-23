package com.porsche;

public class Engine {
	
	private int numberOfCylinders = 0;
	private String type = null;
	
	
	public Engine (int numberOfCylinders, String type) {
		this.numberOfCylinders = numberOfCylinders;
		this.type = type;
		
	}
	

	
	public String getType() {
		return type;
	}



	public int getNumberOfCylinders() {
		return numberOfCylinders;
	}

//	public void setNumberOfCylinders(int num) {
//		this.numberOfCylinders = num;
//	}
	
}
