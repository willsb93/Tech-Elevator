package com.techelevator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import javax.sql.DataSource;

import com.techelevator.model.Reservation;
import com.techelevator.model.ReservationDao;
import com.techelevator.model.Space;
import com.techelevator.model.SpaceDao;
import com.techelevator.model.Venue;
import com.techelevator.model.VenueDao;
import com.techelevator.model.jdbc.JDBCReservationDao;
import com.techelevator.model.jdbc.JDBCSpaceDao;
import com.techelevator.model.jdbc.JDBCVenueDao;
import com.techelevator.view.Menu;

public class VenueService {

	private VenueDao venueDao;
	private ReservationDao reservationDao;
	private SpaceDao spaceDao;
	private List<Space> space;
	private Scanner inputScanner = new Scanner(System.in);
	private int days = 0;
	private String selectedVenue = "";
	private String spaceName = "";
	private BigDecimal totalCost = new BigDecimal(0);

	public VenueService(DataSource dataSource) {

		venueDao = new JDBCVenueDao(dataSource);
		reservationDao = new JDBCReservationDao(dataSource);
		spaceDao = new JDBCSpaceDao(dataSource);
	}

	public List<Venue> getVenueList() {
		return venueDao.getAllVenues();
	}

	public List<Space> getSpaceList() {
		return space;
	}

	public List<Space> getAvailableSpacesFromDao(int id, LocalDate startingDate, LocalDate endingDate, int maxCapacity,
			int monthNumber) {
		List<Space> availableSpacesList = spaceDao.getSpacesAvailable(id, startingDate, endingDate, maxCapacity,
				monthNumber);
		days = (int) ChronoUnit.DAYS.between(startingDate, endingDate); //days to be printed in confirmation
		return availableSpacesList;
	}

	public Reservation getReservationInfo(List<Space> availableSpaces, LocalDate startDate, LocalDate endDate,
			int peopleGoing) {

		Reservation reservation = new Reservation();

		reservation.setStartingDate(startDate);
		reservation.setEndDate(endDate);
		reservation.setNumberOfPeopleAttending(peopleGoing);

		int spaceIdConverted = 0;
		boolean condition = true;
		while (condition == true) {
			System.out.println("What space would you like to reserve (press 0 to cancel) ?");
			String spaceId = inputScanner.nextLine();
			try {
				spaceIdConverted = Integer.parseInt(spaceId);
				if (spaceIdConverted == 0) {
					System.out.println("Thank you for using our reservation program!");
					System.exit(0);
				} else if (spaceIdConverted < 0) {
					System.out.println("Please type the corresponding venue number.");
				}

				else if (spaceIdConverted == Integer.parseInt(spaceId)) {
					for (Space a : availableSpaces) {

						if (spaceIdConverted == a.getSpaceId()) {
							System.out.println("Who is this reservation for?");
							String userName = inputScanner.nextLine();
							spaceName = a.getSpaceName();
							days = (int) ChronoUnit.DAYS.between(startDate, endDate);
							totalCost = a.getDailyRate().multiply(new BigDecimal(days));
							System.out.println("Thank you for submitting your reservation! Here are your details:");
							reservation.setSpaceId(a.getSpaceId());
							reservation.setReservationForUser(userName);
							condition = false;
						} else if (spaceIdConverted != Integer.parseInt(spaceId)) {
							System.out.println("Please type the corresponding venue number.");
						}

					}
				}

			} catch (Exception e) {
				System.out.println("Invalid input. Please type the corresponding venue number.");
			}
		}
		finalReserve(reservation);
		System.exit(0);
		return reservation;

	}

	public void finalReserve(Reservation reservation) {

		Reservation finalReserve = reservationDao.makeReserve(reservation);
		System.out.println("-----------------------------");
		System.out.println("Confirmation # " + new Random().nextInt(1000000 - 900000) + 1 + 900000);
		System.out.println("Venue: " + selectedVenue);
		System.out.println("Space: " + spaceName);
		System.out.println("Reserved for: " + finalReserve.getReservationForUser());
		System.out.println("Number of people attending: " + finalReserve.getNumberOfPeopleAttending());
		System.out.println("Arrival Date: " + finalReserve.getStartingDate());
		System.out.println("Depart Date: " + finalReserve.getEndDate());
		System.out.println("Total Cost: $" + totalCost);
		System.out.println("Thank you!");
	}

	public void printVenueList(List<Venue> printVenues) {
		int count = 1; // the number by the side of the venue name
		System.out.println(String.format("%-9s%s", "Venue Number   ||", "   Venue Name"));
		System.out.println("------------------------------------");
		for (Venue a : printVenues) {
			System.out.println(String.format("%-5s%s", count, a.getVenueName()));
			System.out.println("------------------------------------");
			count++;

		}
		System.out.println("R) Return");
	}

	public int getStringChoiceForVenueId(List<Venue> printVenue, int id) {

		int count = 1;
		int venueId = 0;

		{
			for (Venue a : printVenue) {

				if (count == id) {
					venueId = a.getVenueId();
					Venue SelectedVenue = venueDao.getVenueByName(venueId);
					venueDetail(SelectedVenue);
					space = spaceDao.listOfAllSpacesByVenueId(venueId);
					selectedVenue = a.getVenueName();
					break; // breaks after if finds the correct venue
				}

				count++;
			}

			return venueId; // returns the actual venue Id
		}
	}

	public void venueDetail(Venue venue) {
		System.out.println("------------------------");
		System.out.println("Name of Venue: " + venue.getVenueName());
		System.out.println("Venue Location : " + venue.getCityName() + ", " + venue.getStateName());
		System.out.println("Category: " + venue.getCategoryName());
		System.out.println(" ");
		System.out.println(venue.getVenueDescription());
		System.out.println("------------------------");
	}

	public void printSpaceList(List<Space> printSpaces) {
		int count = 1;
		System.out.println(String.format("%-5s%-25s%-12s%-10s%-15s%s", " ", "Name", "Open", "Close", "Daily Fee",
				"Max Occupancy"));
		for (Space a : printSpaces) {

			if (a.getOpenMonth() == 0 || a.getClosingMonth() == 0) {
				System.out.println(String.format("%-5s%-25s%-10s%-12s%-15s%s", "#" + count, a.getSpaceName(), " ", " ",
						"$" + a.getDailyRate(), a.getMaxCapacity()));
				count++;
			}

			else {

				System.out.println(String.format("%-5s%-25s%-12s%-10s%-15s%s", "#" + count + " ", a.getSpaceName(),
						" " + Month.of(a.getOpenMonth()).getDisplayName(TextStyle.SHORT, Locale.US),
						Month.of(a.getClosingMonth()).getDisplayName(TextStyle.SHORT, Locale.US),
						"$" + a.getDailyRate(), a.getMaxCapacity()));
				count++;
			}
		}
	}

	public boolean printAvailableSpaces(List<Space> printAvailableSpaces) {
		if (printAvailableSpaces.isEmpty()) {

			boolean condition = true;
			while (condition == true) {
				try {
					System.out.println(
							"Sorry there are no spaces available for those dates. Would you like to try a different date or choosing a different space/venue ? Y/N");

					String choice = inputScanner.nextLine();

					if (choice.equalsIgnoreCase("N")) {
						System.out.println("Thank you for using our program!");
						System.exit(0);
					} else if (choice.equalsIgnoreCase("Y")) {

						return false;
					} else {
						System.out.println("Invalid entry. Please try again.");

					}
				} catch (Exception e) {
					System.out.println("Invalid entry. Please try again.");
				}
			}
		}

		else if (!printAvailableSpaces.isEmpty()) {
			System.out.println("The following spaces are available based on your needs: ");
			System.out.println(String.format("%-5s%-20s%-15s%-10s%-15s%s", "Space Id", "  Space Name", "  Daily Cost",
					"  Max Occupancy   ", "   Acessible", "Total Cost"));

			for (Space a : printAvailableSpaces) {

				System.out.println(
						"--------------------------------------------------------------------------------------");

				System.out.println(
						String.format("%-10s%-21s%-16s%-19s%-12s%s", a.getSpaceId(), a.getSpaceName(), a.getDailyRate(),
								a.getMaxCapacity(), a.isAccessible(), new BigDecimal(days).multiply(a.getDailyRate())));

			}
		}
		return true;
	}

}
//