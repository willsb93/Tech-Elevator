package com.techelevator;

public class Attendee {

	private String firstName;
	private String lastName;
	private boolean isVIP;
	private boolean isCheckedIn;
	private long attendeeId;
	
	public Attendee (String firstName, String lastName, long attendeeId, boolean isVip) {
		this.attendeeId = attendeeId;
		this.firstName = firstName;
		this.isVIP = isVip;
		this.lastName = lastName;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isVIP() {
		return isVIP;
	}

	public void setVIP(boolean isVIP) {
		this.isVIP = isVIP;
	}

	public boolean isCheckedIn() {
		return isCheckedIn;
	}

	public void setCheckedIn(boolean isCheckedIn) {
		this.isCheckedIn = isCheckedIn;
	}

	public long getAttendeeId() {
		return attendeeId;
	}

	public void setAttendeeId(long attendeeId) {
		this.attendeeId = attendeeId;
	}

}
