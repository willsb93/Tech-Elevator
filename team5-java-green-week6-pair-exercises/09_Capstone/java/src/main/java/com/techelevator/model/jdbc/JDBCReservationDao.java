package com.techelevator.model.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Reservation;
import com.techelevator.model.ReservationDao;

public class JDBCReservationDao implements ReservationDao {

	private JdbcTemplate jdbcTemplate;

	public JDBCReservationDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Reservation makeReserve(Reservation reservation) {
		String sqlInsertReservation = "INSERT INTO reservation (space_id, reserved_for, start_date, end_date, number_of_attendees)"
				+ "VALUES (?, ?, ?, ?, ?) RETURNING reservation_id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlInsertReservation, reservation.getSpaceId(),
				reservation.getReservationForUser(), reservation.getStartingDate(), reservation.getEndDate(),
				reservation.getNumberOfPeopleAttending());
		results.next();

		return reservation;
	}

}
//