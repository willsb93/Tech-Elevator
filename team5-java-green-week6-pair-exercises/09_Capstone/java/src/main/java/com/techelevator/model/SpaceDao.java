package com.techelevator.model;

import java.time.LocalDate;
import java.util.List;

public interface SpaceDao {

	public List<Space> listOfAllSpacesByVenueId(int id);

	public List<Space> getSpacesAvailable(int id, LocalDate startingDate, LocalDate endingDate, int maxCapacity,
			int monthNumber);

}
//