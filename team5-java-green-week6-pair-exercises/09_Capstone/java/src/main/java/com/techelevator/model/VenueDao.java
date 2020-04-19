package com.techelevator.model;

import java.util.List;

public interface VenueDao {

	public List<Venue> getAllVenues();

	public Venue getVenueByName(int id);

}
//