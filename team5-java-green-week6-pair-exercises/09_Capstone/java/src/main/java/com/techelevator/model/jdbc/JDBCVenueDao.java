package com.techelevator.model.jdbc;

import java.util.List;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.techelevator.model.Venue;
import com.techelevator.model.VenueDao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCVenueDao implements VenueDao {

	private JdbcTemplate jdbcTemplate;

	public JDBCVenueDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Venue> getAllVenues() {
		ArrayList<Venue> venue = new ArrayList<>();
		String sqlGetAllVenues = "SELECT id, name, city_id, description " + "FROM Venue" + " ORDER BY name";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllVenues);
		while (results.next()) {
			Venue venues = mapRowToVenue(results);
			venue.add(venues);
			// Goes to the database pull all the venues and add/return a list of venues

		}
		return venue;
	}

	@Override
	public Venue getVenueByName(int id) {
		String sqlGetVenueById = "SELECT venue.id, venue.name, city.name as city_name, state.abbreviation as state_name, description, string_agg(category.name, ', ') AS category "
				+ "FROM venue JOIN city on venue.city_id = city.id JOIN state ON city.state_abbreviation = state.abbreviation LEFT JOIN category_venue ON venue.id = category_venue.venue_id LEFT JOIN category ON category_venue.category_id = category.id "
				+ "WHERE venue.id = ? " + "GROUP BY venue.id, venue.name, city.name, state.abbreviation, description "
				+ "ORDER BY venue.name";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetVenueById, id);
		Venue venue = new Venue();
		results.next();
		venue = populateSingleVenue(results);

		return venue;

	}

	// Returns a single venue with it's info
	private Venue mapRowToVenue(SqlRowSet results) {
		Venue venue = new Venue();
		venue.setVenueName(results.getString("name"));
		venue.setVenueId(results.getInt("id"));
		venue.setVenueDescription(results.getString("description"));
		venue.setCityId(results.getInt("city_id"));

		return venue;
	}

	/*
	 * I created this method to clean the code, because it was all in one single
	 * line This method will take care of populating the single venue from the
	 * getVenueById, it will set the city,name, etc PLUS the state, categories ,
	 * since we are merging a lot of tables up there
	 */
	private Venue populateSingleVenue(SqlRowSet results) {
		Venue venue = new Venue();
		venue.setVenueName(results.getString("name"));
		venue.setVenueId(results.getInt("id"));
		venue.setVenueDescription(results.getString("description"));
		venue.setStateName(results.getString("state_name"));
		venue.setCategoryName(results.getString("category"));
		venue.setCityName(results.getString("city_name"));

		return venue;

	}

}
//