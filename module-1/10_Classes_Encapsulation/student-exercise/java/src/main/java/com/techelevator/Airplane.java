package com.techelevator;

public class Airplane {

	private String planeNumber;
	private int bookedFirstClassSeats;

	private int totalFirstClassSeats;
	private int bookedCoachSeats;

	private int totalCoachSeats;

	// Constructor

	public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
		this.planeNumber = planeNumber;
		this.totalFirstClassSeats = totalFirstClassSeats;
		this.totalCoachSeats = totalCoachSeats;
	}

	public String getPlaneNumber() {
		return planeNumber;
	}

	public int getBookedFirstClassSeats() {

		return bookedFirstClassSeats;
	}

	public int getAvailableFirstClassSeats() {
		int availableSeats = Math.abs(bookedFirstClassSeats - totalFirstClassSeats);

		return availableSeats;
	}

	public int getTotalFirstClassSeats() {
		return totalFirstClassSeats;
	}

	public int getBookedCoachSeats() {
		return bookedCoachSeats;
	}

	public int getAvailableCoachSeats() {
		int coachSeats = Math.abs(bookedCoachSeats - totalCoachSeats);

		return coachSeats;
	}

	public int getTotalCoachSeats() {
		return totalCoachSeats;
	}

	public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {

		if (forFirstClass == false) {
			if (totalNumberOfSeats < totalCoachSeats) {
				this.bookedCoachSeats = totalNumberOfSeats;
				return true;
			}
		}
		if (forFirstClass == true)

		{
			if (totalNumberOfSeats < totalFirstClassSeats) {
				this.bookedFirstClassSeats = totalNumberOfSeats;
				return true;
			}

		}

		return false;
	}
}
