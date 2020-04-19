package com.techelevator;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.model.Space;
import com.techelevator.model.Venue;
import com.techelevator.view.Menu;

public class ExcelsiorCLI {

	private final static String LIST_VENUES = "1";
	private final static String QUIT_PROGRAM = "Q";

	private final static String VIEW_SPACES = "1";
	private final static String VENUE_MENU_RETURN = "R";

	private final static String RESERVE_SPACE = "1";
	private final static String RESERVATION_SPACE_RETURN = "R";

	private VenueService venueService;

	private Menu menu;
	private List<Space> availableSpace = new ArrayList();
	private List<Venue> venueList = new ArrayList();
	private List<Space> spaceList = new ArrayList();
	private LocalDate startDate;
	private LocalDate endDate;
	private int peopleAttending;
	private int specificVenueId;
	private Scanner returnInput = new Scanner(System.in);
	private int venueIdGlobal = 0;

	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/venues");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		ExcelsiorCLI application = new ExcelsiorCLI(dataSource);

		while (true) {
			application.run();
		}

	}

	public ExcelsiorCLI(DataSource dataSource) {
		venueService = new VenueService(dataSource);

		// pass this datasource to the service classes constructor so you can define the
		// DAO's in your service class(es) that need them.

	}

	public void run() {
		{

			menu = new Menu();
			System.out.println("Welcome to our Venue Reservation System. What would you like to do?");
			String choice = menu.printMainMenu();

			if (choice.equals(LIST_VENUES)) {
				boolean condition = true;
				while (condition == true) {
					venueList = venueService.getVenueList();
					venueService.printVenueList(venueList);
					System.out.println("Which venue would you like to view?");

					String possibleReturn = returnInput.nextLine();
					if (possibleReturn.equalsIgnoreCase("R")) {
						return;
					}

					try {

						if (Integer.parseInt(possibleReturn) > 0 && Integer.parseInt(possibleReturn) < 16) {
							venueIdGlobal = Integer.parseInt(possibleReturn);
							venueIdGlobal = venueService.getStringChoiceForVenueId(venueList, venueIdGlobal);
							specificVenueId = Integer.parseInt(possibleReturn); // holds the list number corresponding to the venue in the console
							handleVenueMenu();
						}

						else
							System.out.println("Invalid entry. Please try again.");

					} catch (Exception e) {

						System.out.println("Invalid entry. Please try again.");

					}
				}

			}

			else if (choice.equalsIgnoreCase(QUIT_PROGRAM)) {
				System.out.println("Thank you!");
				System.exit(0);
			}

			else {
				System.out.println("Invalid entry. Please try again");
				return;
			}
		}
	}

	public void handleVenueMenu() {
		{

			boolean condition = true;

			while (condition == true)

			{
				String choice = menu.printVenueMenu();
				if (choice.contentEquals(VIEW_SPACES)) {
					spaceList = venueService.getSpaceList();
					venueService.printSpaceList(spaceList);

					boolean repeat = venueService.printAvailableSpaces(handleSpaceReservation());
					if (repeat == false) {
						handleVenueMenu();
					} else {
						handleWhichSpaceToReserve();
					}

				}

				else if (choice.equalsIgnoreCase(VENUE_MENU_RETURN)) {
//				call the previous menu with choice equals 1
					while (condition == true) {
						venueList = venueService.getVenueList();
						venueService.printVenueList(venueList);
						System.out.println("Which venue would you like to view?");

						String possibleReturn = returnInput.nextLine();
						if (possibleReturn.equalsIgnoreCase("R")) {
							return;
						}

						try {

							if (Integer.parseInt(possibleReturn) > 0 && Integer.parseInt(possibleReturn) < 16) {
								venueIdGlobal = Integer.parseInt(possibleReturn);
								specificVenueId = Integer.parseInt(possibleReturn);
								venueIdGlobal = venueService.getStringChoiceForVenueId(venueList, specificVenueId);

								handleVenueMenu();
							}

						} catch (Exception e) {

							System.out.println("Invalid entry. Please try again.");

						}
					}
				}

				else
					System.out.println("Invalid entry. Please try again.");
				venueService.getStringChoiceForVenueId(venueList, venueIdGlobal);

			}
		}

	}

	public List<Space> handleSpaceReservation() {

		boolean condition = true;
		while (condition == true) {
			String choice = menu.printReservationMenu();
			if (choice.equalsIgnoreCase(RESERVATION_SPACE_RETURN)) {
				venueService.getStringChoiceForVenueId(venueList, specificVenueId); // passes the list value from the console instead of the specific id
				handleVenueMenu();

			}

			else if (choice.equalsIgnoreCase(RESERVE_SPACE)) {
				startDate = menu.startDateForReservation();
				endDate = menu.endDateForReservation(startDate);
				peopleAttending = menu.peopleThatAreGoingToAttend();
				int monthNumber = startDate.getMonthValue();

				availableSpace = venueService.getAvailableSpacesFromDao(venueIdGlobal, startDate, endDate,
						peopleAttending, monthNumber);
				condition = false;

			} else if (!choice.equalsIgnoreCase(RESERVE_SPACE)) {
				System.out.println("Invalid entry. Please try again");
				venueService.printSpaceList(spaceList);
			}

		}
		return availableSpace;
	}

	public void handleWhichSpaceToReserve() {
		venueService.getReservationInfo(availableSpace, startDate, endDate, peopleAttending);
	}

}
//