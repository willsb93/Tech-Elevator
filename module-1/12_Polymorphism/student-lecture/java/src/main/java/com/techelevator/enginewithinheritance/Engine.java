package com.techelevator.enginewithinheritance;

public class Engine {
	
	private int numberOfCylinders;
	private boolean isStarted;
	public int getNumberOfCylinders() {
		return numberOfCylinders;
	}
	public void setNumberOfCylinders(int numberOfCylinders) {
		this.numberOfCylinders = numberOfCylinders;
	}
	public boolean isStarted() {
		return isStarted;
	}
	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}
	
	
	public void goDoSomethingUseful() {
		System.out.println("This was something useful");
	}
	
	

}
