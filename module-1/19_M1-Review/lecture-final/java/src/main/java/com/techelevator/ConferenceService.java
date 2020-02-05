package com.techelevator;

import java.util.List;

public class ConferenceService {
	
	List<Attendee> masterList;
	
	public ConferenceService (String fileName) {
		AttendeeFileReader fileReader = new AttendeeFileReader();
		masterList = fileReader.readAttendeeFile(fileName);
	}

	
	public List<Attendee> retrieveListOfAttendees() {
		//retrieve list of attendees
		return masterList;
	}
	
	public void printReport() {
		
	}
	
	public void checkInAttendeeById (long attendeeId) {
		
		//option 1:  Loop through the list looking for attendee id, update Attendee object setting the isCheckedIn to true;
		
		System.out.println("Attendee " + attendeeId + " is checked in");
		
		
		// look up attendee in the attendee map
	}
	
	public void checkInAttendeeByName (String firstName, String lastName) {
		//TODO: implement this for real
		System.out.println("Attendee First Name" + firstName + " " + lastName + " is checked in");
		
	}
	
	
	
	
	
	

}
