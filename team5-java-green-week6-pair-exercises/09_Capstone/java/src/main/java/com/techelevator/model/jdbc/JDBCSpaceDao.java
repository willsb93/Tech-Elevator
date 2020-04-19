package com.techelevator.model.jdbc;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Space;
import com.techelevator.model.SpaceDao;
import com.techelevator.model.Venue;
import com.techelevator.model.VenueDao;

public class JDBCSpaceDao implements SpaceDao {

	private JdbcTemplate jdbcTemplate;

	public JDBCSpaceDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Space> listOfAllSpacesByVenueId(int id) {
		ArrayList<Space> spaces = new ArrayList<>();
		String sqlFindSpacesByVenueId = "SELECT name, open_from, open_to, max_occupancy, CAST(daily_rate AS decimal), venue_id "
				+ "FROM space " + "WHERE venue_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindSpacesByVenueId, id);
		while (results.next()) {
			Space space = mapRowToSpecificSpaces(results);
			spaces.add(space);
		}
		return spaces;
	}

	@Override
	public List<Space> getSpacesAvailable(int id, LocalDate startingDate, LocalDate endingDate, int maxCapacity,
			int monthNumber) {
		ArrayList<Space> spaces = new ArrayList<>();
		String sqlGetAvailableSpaces = "SELECT id, name, open_from, open_to, max_occupancy, is_accessible, CAST (daily_rate AS DECIMAL) "
				+ " From Space "
				+ " WHERE space.name NOT IN (SELECT space.name FROM space FULL OUTER JOIN reservation ON space.id = reservation.space_id FULL OUTER JOIN venue ON space.venue_id = venue.id WHERE (((open_from IS NOT NULL) AND ((? NOT BETWEEN open_from AND open_to) OR (? NOT BETWEEN open_from AND open_to)))) OR ((((? BETWEEN start_date AND end_date)))) OR (((? BETWEEN start_date AND end_date)) AND (start_date IS NOT NULL)) OR (? >= max_occupancy) OR (? != venue.id)) LIMIT 5";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAvailableSpaces, monthNumber, monthNumber, startingDate,
				endingDate, maxCapacity, id);
		while (results.next()) {
			Space space = mapRowToSpace(results);
			spaces.add(space);
		}
		return spaces;
	}

	private Space mapRowToSpecificSpaces(SqlRowSet results) {
		Space space = new Space();

		space.setSpaceName(results.getString("name"));
		space.setOpenMonth(results.getInt("open_from"));
		space.setClosingMonth(results.getInt("open_to"));
		space.setDailyRate(results.getBigDecimal("daily_rate"));
		space.setMaxCapacity(results.getInt("max_occupancy"));

		return space;
	}

	private Space mapRowToSpace(SqlRowSet results) {
		Space space = new Space();
		space.setSpaceId(results.getInt("id"));
		space.setSpaceName(results.getString("name"));
		space.setAccessible(results.getBoolean("is_accessible"));
		space.setOpenMonth(results.getInt("open_from"));
		space.setClosingMonth(results.getInt("open_to"));
		space.setDailyRate(results.getBigDecimal("daily_rate"));
		space.setMaxCapacity(results.getInt("max_occupancy"));

		return space;
	}

}
//