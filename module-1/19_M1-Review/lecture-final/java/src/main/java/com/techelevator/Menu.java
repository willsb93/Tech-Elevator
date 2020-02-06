package com.techelevator;

import java.util.Scanner;

/**
 * The purpose of this class to to print menus and collect user responses. You
 * do not implement business functionality here.
 * 
 * @author Steve
 *
 */

public class Menu {

	// Create Scanner object to capture user input and return choice
	private Scanner inputScanner = new Scanner(System.in);

	/*
	 * 1. List Registered Attendees 
	 * 2. Check In Attendees 
	 * 3. Print Attendee Report
	 * 4. Exit Program
	 */
	public String printMainMenu() {

		// code that lists our main menu options
		System.out.println("1. List Registered Attendees");
		System.out.println("2. Check In Attendees");
		System.out.println("3. Print Attendee Report");
		System.out.println("4. Exit Program");

		return inputScanner.nextLine();

	}

	/*
	 * 1. Check in by attendee id 
	 * 2. Check in using first and last name 
	 * 3. Return to previous menu
	 * 
	 */
	public String printSubMenu() {

		System.out.println("1. Check in by attendee id");
		System.out.println("2. Check in using first and last name");
		System.out.println("3. Return to previous menu");
		
		return inputScanner.nextLine();
	}
	
	public long retrieveAttendeeIdFromUser() {

		System.out.println("Please enter the id of the attendee that you want to check in");
		return Long.parseLong(inputScanner.nextLine());

	}
	
	public String  retrieveFirstNameFromUser() {

		System.out.println("Please enter the attendees first name: ");
		return inputScanner.nextLine();

	}	
	
	public String retrieveLastNameFromUser() {

		System.out.println("Please enter the attendees last name: ");
		return inputScanner.nextLine();

	}		
		

}
