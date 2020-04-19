package com.techelevator;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Venue;
import com.techelevator.model.VenueDao;
import com.techelevator.model.jdbc.JDBCVenueDao;

public class JDBCVenueDaoTest {

	private static SingleConnectionDataSource dataSource;

	JdbcTemplate jdbcTemplate;
	private VenueDao dao;

	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/venues");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}

	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@Before
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		dao = new JDBCVenueDao(dataSource);

	}

	@Test
	public void testGetAllVenuesFromMenu() {
		String truncate = "truncate venue CASCADE"; // Automatically truncate all tables that have foreign-key references to any of the named tables, or to any tables added to the group due to CASCADE.
		jdbcTemplate.update(truncate);

		String createVenueSql = "INSERT INTO venue (id, name, city_id, description) VALUES (DEFAULT, ?, ?, ?)";
		jdbcTemplate.update(createVenueSql, "Place Holder", 5, "A place to have fun");

		List<Venue> returnedVenue = dao.getAllVenues();

		Assert.assertEquals(1, returnedVenue.size());

	}

	// get venue by name
	@Test
	public void testGetVenueByName() {
		Venue venue = testToVenue();
		String insertSql = "INSERT INTO venue (name, city_id, description) VALUES ( ?, ?, ?) RETURNING id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(insertSql, venue.getVenueName(), venue.getCityId(),
				venue.getVenueDescription());
		results.next();
		venue.setVenueId(results.getInt("id"));

		Venue returnedVenue = dao.getVenueByName(venue.getVenueId());

		Assert.assertNotNull(returnedVenue);
		Assert.assertEquals(venue.getVenueId(), returnedVenue.getVenueId());
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	protected DataSource getDataSource() {
		return dataSource;
	}

	private Venue testToVenue() {
		Venue venue = new Venue();
		venue.setVenueId((int) 5);
		venue.setVenueName("Skully's music hall");
		venue.setCityId((int) 2);
		venue.setVenueDescription("This crazy place where people get drunk and puke");
		venue.setCityName("Columbus");
		venue.setStateName("OH");
		return venue;
	}

} //
