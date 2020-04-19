package com.techelevator;

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
import com.techelevator.model.ReservationDao;
import com.techelevator.model.Space;
import com.techelevator.model.Venue;
import com.techelevator.model.VenueDao;
import com.techelevator.model.jdbc.JDBCReservationDao;
import com.techelevator.model.jdbc.JDBCSpaceDao;
import com.techelevator.model.jdbc.JDBCVenueDao;

public class JDBCReservationDaoTest {

	private static SingleConnectionDataSource dataSource;

	private JDBCReservationDao dao;
	private Reservation reserve;
	private Reservation reservationToTest;

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
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		dao = new JDBCReservationDao(dataSource);
		reserve = reservationToTest();

		String sqlNewReservation = "INSERT INTO reservation (space_id, reserved_for, start_date, end_date, number_of_attendees)"
				+ " VALUES (?, ?, ?, ?, ?) RETURNING reservation_id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlNewReservation, reserve.getSpaceId(),
				reserve.getReservationForUser(), reserve.getStartingDate(), reserve.getEndDate(),
				reserve.getNumberOfPeopleAttending());
		results.next();

		reservationToTest = dao.makeReserve(reserve);

	}

	@Test
	public void testReservationNotNull() {
		Reservation reservation = dao.makeReserve(reservationToTest);
		Assert.assertNotNull(reservationToTest);

	}

	@Test
	public void testReservationId() {
		Reservation reservation = dao.makeReserve(reservationToTest);
		Assert.assertEquals(5, reservation.getSpaceId());
	}

	@Test
	public void testReservationStartDate() {
		Reservation reservation = dao.makeReserve(reservationToTest);
		Assert.assertEquals(LocalDate.of(2020, 10, 04), reservation.getStartingDate());
	}

	@Test
	public void testReservationEndDate() {
		Reservation reservation = dao.makeReserve(reservationToTest);
		Assert.assertEquals(LocalDate.of(2020, 10, 07), reservation.getEndDate());
	}

	@Test
	public void testReservationPeopleGoing() {
		Reservation reservation = dao.makeReserve(reservationToTest);
		Assert.assertEquals(45, reservation.getNumberOfPeopleAttending());
	}

	@Test
	public void testNameOfPersonGoing() {
		Reservation reservation = dao.makeReserve(reservationToTest);
		Assert.assertEquals("SpongeBob", reservation.getReservationForUser());
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	protected DataSource getDataSource() {
		return dataSource;
	}

	// populate reservation
	private Reservation reservationToTest() {
		Reservation reservation = new Reservation();
		reservation.setSpaceId(5);
		reservation.setStartingDate(LocalDate.of(2020, 10, 04));
		reservation.setEndDate(LocalDate.of(2020, 10, 07));
		reservation.setNumberOfPeopleAttending(45);
		reservation.setReservationForUser("SpongeBob");

		return reservation;
	}

}
//