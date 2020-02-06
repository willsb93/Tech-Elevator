package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttendeeFileReader {
	
	private Scanner fileScanner;
	
	public List<Attendee> readAttendeeFile(String fileName) {
		//TODO: load code from File system
		File file = new File(fileName);
		List<Attendee> attendeeList = new ArrayList<Attendee>();
		
		try {
			fileScanner = new Scanner(file);
			
			while (fileScanner.hasNext()) {
				
				String record = fileScanner.next();
				String[] fields = record.split(",");
				
				 //(String firstName, String lastName, long attendeeId, boolean isVip)
				//101,LT,Dan,true
				Attendee attendee = new Attendee(fields[1], fields[2], Long.parseLong(fields[0]), Boolean.parseBoolean(fields[3]));
				attendeeList.add(attendee);
			
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return attendeeList;
		
	}
	

}
