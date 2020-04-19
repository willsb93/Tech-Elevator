package com.techelevator;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
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

import com.techelevator.model.Reservation;
import com.techelevator.model.Space;
import com.techelevator.model.SpaceDao;
import com.techelevator.model.jdbc.JDBCSpaceDao;

public class JDBCSpaceDaoTest {

	private static SingleConnectionDataSource dataSource;

	private JdbcTemplate jdbcTemplate;
	private SpaceDao dao;
	private Space spaceWithValues;

	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/venues");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}

	@Before
	public void setup() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		dao = new JDBCSpaceDao(dataSource);
		spaceWithValues = spaceToTest();

		String createReservation = "INSERT INTO space (venue_id, name, open_from, open_to, daily_rate, max_occupancy, is_accessible) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING venue_id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(createReservation, spaceWithValues.getVenueId(),
				spaceWithValues.getSpaceName(), spaceWithValues.getOpenMonth(), spaceWithValues.getClosingMonth(),
				spaceWithValues.getDailyRate(), spaceWithValues.getMaxCapacity(), spaceWithValues.isAccessible());
		results.next();

	}

	@Test
	public void testReservation() {

		Assert.assertNotNull(spaceWithValues);

	}

	@Test
	public void testVenueId() {
		Assert.assertEquals(8, spaceWithValues.getVenueId());
	}

	@Test
	public void testSpaceName() {
		Assert.assertEquals("Skully", spaceWithValues.getSpaceName());
	}

	@Test
	public void testOpenMonth() {
		Assert.assertEquals(4, spaceWithValues.getOpenMonth());
	}

	@Test
	public void testClosingMonth() {
		Assert.assertEquals(6, spaceWithValues.getClosingMonth());
	}

	@Test
	public void testDailyRate() {
		Assert.assertEquals(new BigDecimal(100), spaceWithValues.getDailyRate());
	}

	@Test
	public void testCapacity() {
		Assert.assertEquals(45, spaceWithValues.getMaxCapacity());
	}

	@Test
	public void testIsAcessible() {
		Assert.assertEquals(true, spaceWithValues.isAccessible());
	}

	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	protected DataSource getDataSource() {
		return dataSource;
	}

	// populate space
	private Space spaceToTest() {
		Space space = new Space();
		space.setSpaceId(5);
		space.setOpenMonth(4);
		space.setClosingMonth(6);
		space.setSpaceName("Skully");
		space.setDailyRate(new BigDecimal(100));
		space.setVenueId(8);
		space.setAccessible(true);
		space.setMaxCapacity(45);

		return space;
	}

}
//