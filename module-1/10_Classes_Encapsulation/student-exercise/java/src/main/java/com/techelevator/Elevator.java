package com.techelevator;

public class Elevator {

	private int currentFloor = 1;
	private int numberOfFloors;
	private boolean doorOpen;

	// Constructor

	public Elevator(int totalNumberOffloors) {
		this.numberOfFloors = totalNumberOffloors;

	}

	public static void main(String[] args) {
		Integer i = new Integer(2345);

		System.out.println(i / 2);

		System.out.println(i.intValue() / 2);
	}

	public void openDoor() {
		doorOpen = true;
	}

	public void closeDoor() {
		doorOpen = false;
	}

	public void goUp(int desiredFloor) {
		if (doorOpen == false) {
			if (desiredFloor >= currentFloor && desiredFloor <= numberOfFloors) {
				this.currentFloor = desiredFloor;
			}
		}
	}

	public void goDown(int desiredFloor) {
		if (doorOpen == false) {
			if (desiredFloor <= currentFloor && desiredFloor > 0) {
				if (desiredFloor >= 1)
					this.currentFloor = desiredFloor;
			}

		}
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public boolean isDoorOpen() {
		return doorOpen;
	}

}
