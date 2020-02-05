package com.techelevator;

import java.util.List;

/**
 * This class is the main app class. 
 * @author Steve
 *
 */
public class ConferenceApp {
	
	/*
	 * Main Menu - 
	 * 1. List Registered Attendees 
	 * 2. Check In Attendees 
	 * 3. Print Attendee Report
	 * 4. Exit Program
	 */	
	private final static String LIST_REGISTERED_ATTENDEES = "1"; 
	private final static String CHECK_IN_ATTENDEES = "2"; 
	private final static String PRINT_ATTENDEE_REPORT = "3"; 
	private final static String EXIT_PROGRAM = "4"; 
	
	/*
	 * Sub-menu for Check in attendees 
	 * 1. Check in by attendee id 
	 * 2. Check in using first and last name 
	 * 3. Return to previous menu
	 * 
	 */	
	private final static String CHECK_IN_BY_ID = "1"; 
	private final static String CHECK_IN_BY_NAME = "2"; 
	private final static String BACK_TO_MAIN_MENU = "3"; 
	
	private Menu menu = new Menu();
	private ConferenceService service;
	
	private String fileName = "registered-attendees.txt";
	
	public ConferenceApp() {
		service = new ConferenceService(fileName);
	}

	
	//The main starts the app only
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConferenceApp dilbertsConferenceApp = new ConferenceApp();
		dilbertsConferenceApp.run();
	}
	
	/**
	 * This method controls the main looping and presentation of menus and responses, then DELEGATES to the 
	 * EmployeePayRoll class. There are many ways to do this. We could have used switch statement, etc.  The loop
	 * keeps your program alive.  Program only exits if
	 */
	public void run() {
		
		
		//create loop 
		while(true) { 
			
			 //print main menu)
		     String choice = menu.printMainMenu();
		     
		     if (choice.equals(LIST_REGISTERED_ATTENDEES)) {
		    	 // retrieve a list of registered attendees
		    	 System.out.println("You picked 1");
		    	 List<Attendee> registeredAttendees = service.retrieveListOfAttendees();
		    	 printAttendeeList(registeredAttendees);

		     }
		     else if (choice.equals(CHECK_IN_ATTENDEES)) {
		    	 System.out.println("You picked 2");
		    	 //load submenu
		    	 handleSubMenu();
		    	
		     }
		     else if (choice.equals(PRINT_ATTENDEE_REPORT)) {
		    	 //go print the report
		    	 System.out.println("You picked 3");
		     }
		     else if (choice.equals(EXIT_PROGRAM)) {
		    	 System.out.println("Yabba Dabba Doo! Work day is done!");
		    	  //we are done... let's go home!
                  System.exit(1);
		     }		     
		     else {
		    	System.out.println("Invalid entry. Please try again!");
		     }
		}
		

	}
	
	/*
	 * 1. Check in by attendee id 
	 * 2. Check in using first and last name 
	 * 3. Return to previous menu
	 * 
	 */	
	
	private void handleSubMenu() {
		
		boolean escapeMe = false;
		
		while (!escapeMe) {
			 String choice = menu.printSubMenu();
	    	 //logic to delegate based on user input provided

	    	 if (choice.equals(CHECK_IN_BY_ID))  {
	    		 //check in by id 
	    		 System.out.println("You picked 1");
	    		 service.checkInAttendeeById(menu.retrieveAttendeeIdFromUser());
	    	
	    	 }
	    	 else if (choice.equals(CHECK_IN_BY_NAME)) {
	    		//check in by first name and last name 
	    		 System.out.println("You picked 2");
	    	
	    		 service.checkInAttendeeByName(menu.retrieveFirstNameFromUser(), menu.retrieveLastNameFromUser());
	  
	    	 }
	    	 else if (choice.equals(BACK_TO_MAIN_MENU)) {
	    		 // let's go back to main menu and create havoc
	    		 System.out.println("You picked 3");
	    		 escapeMe = true;
	 
	    	 }
		     else {
		    	System.out.println("Invalid entry. Please try again!");
		     }
	    
		}
		
	}
	
	private void printAttendeeList(List<Attendee> printMeList) {
		
		for (Attendee a : printMeList) {
			System.out.println(a.getFirstName() + " " + a.getLastName());
		}
	}


}
