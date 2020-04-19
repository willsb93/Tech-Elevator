package com.techelevator.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import javax.sql.DataSource;

import java.time.*;

import com.techelevator.ExcelsiorCLI;
import com.techelevator.VenueService;

public class Menu {

	private Scanner inputScanner = new Scanner(System.in);

	public String printMainMenu() {

		System.out.println("1) List Venues");
		System.out.println("Q) Quit");

		return inputScanner.nextLine();

	}

	public int printHandleVenueView() {
		System.out.println("Which venue would you like to view?");
		String value = inputScanner.nextLine();
		int venueId = Integer.parseInt(value);
		return venueId;
	}

	public String printVenueMenu() {
		System.out.println("1) View Space");
		System.out.println("R) Return to previous screen");

		return inputScanner.nextLine();
	}

	public String printReservationMenu() {
		System.out.println("----------------------------------");
		System.out.println("What would you like to do next?");
		System.out.println("1) Reserve a Space");
		System.out.println("R) Return to Previous Menu");

		return inputScanner.nextLine();
	}

	public LocalDate startDateForReservation() {
		LocalDate initialDate = LocalDate.now();
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");

		boolean condition = true;
		while (condition == true) {

			try {
				System.out.println("When do you need the space? YYYY-MM-DD ");
				String choice = inputScanner.nextLine();
				initialDate = LocalDate.parse(choice);
				if (initialDate.compareTo(LocalDate.now()) < 0) {
					System.out.println("Invalid input. Please input a date on or after " + LocalDate.now());
				}

				else
					condition = false;

			} catch (Exception e) {
				System.out.println("Invalid input. Please try again.");
			}

		}
		return initialDate;
	}

	public LocalDate endDateForReservation(LocalDate finalDate) {
		LocalDate endDate = finalDate;
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");

		boolean condition = true;
		while (condition == true) {
			try {
				System.out.println("How many days are you staying?");
				String choice = inputScanner.nextLine();
				if (Integer.parseInt(choice) <= 0) {
					System.out.println("Value needs to be greater than 0. Please try again.");
				}

				else if (Integer.parseInt(choice) > 0) {
					endDate = finalDate.plusDays(Long.parseLong(choice));
					condition = false;
				}

			} catch (Exception e) {
				System.out.println("Invalid input. Please try again.");
			}

		}

		return endDate;
	}

	public int peopleThatAreGoingToAttend() {

		int numberOfPeople = 0;
		boolean condition = true;
		while (condition == true) {
			try {
				System.out.println("How many people will be in attendance?");
				String choice = inputScanner.nextLine();

				if (Integer.parseInt(choice) <= 0) {
					System.out.println("Value needs to be greater than 0. Please try again.");
				}

				else if (Integer.parseInt(choice) > 0) {
					numberOfPeople = Integer.parseInt(choice);
					condition = false;
				}

			} catch (Exception e) {
				System.out.println("Invalid input.Please try again.");
			}

		}
		return numberOfPeople;
	}

}
//