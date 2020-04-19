package com.techelevator.model;

import java.time.LocalDate;

public class Reservation {

	private int reservationId;
	private int spaceId;
	private int numberOfPeopleAttending;
	private LocalDate startingDate;
	private LocalDate endDate;
	private String reservationForUser;

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}

	public int getNumberOfPeopleAttending() {
		return numberOfPeopleAttending;
	}

	public void setNumberOfPeopleAttending(int numberOfPeopleAttending) {
		this.numberOfPeopleAttending = numberOfPeopleAttending;
	}

	public LocalDate getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getReservationForUser() {
		return reservationForUser;
	}

	public void setReservationForUser(String reservationForUser) {
		this.reservationForUser = reservationForUser;
	}

}
//