package com.techelevator;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.ParkDAOJDBC;
import com.techelevator.npgeek.Weather;

public class ParkDAOJDBCTest {
	private static final String TEST_PARK = "JAVAGREEN";
	private static final String TEST_WEATHER = "Flooding";
	private static final String TEST_PARK_CODE = "AAAA";
	private ParkDAOJDBC dao;
	
	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	public static SingleConnectionDataSource dataSource;

	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}

	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	/* This method provides access to the DataSource for subclasses so that
	 * they can instantiate a DAO for testing */
	public DataSource getDataSource() {
		return dataSource;
	}
	
	
	@Before
	public void setup() {
		String sqlInsertPark = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) VALUES (?,?, 'XYZ', '100', '100', '100', '100', 'rain', '100', '100', 'hi', 'hello', 'describe', '100','100')";
		String sqlInsertWeather = "INSERT INTO weather (parkcode, fivedayforecastvalue, low, high, forecast) VALUES (?, '1', '10', '20', ?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertPark, TEST_PARK_CODE, TEST_PARK);
		jdbcTemplate.update(sqlInsertWeather,TEST_PARK_CODE, TEST_WEATHER);
		dao = new ParkDAOJDBC(dataSource);
		
	}
	
	@Test
	public void get_list_of_parks() {
		List<Park> parks = dao.getAllParkData();
		for(Park park : parks){
			if(park.getParkName().equals(TEST_PARK))
			assertEquals(TEST_PARK, park.getParkName());
			
		}
	}
	
	@Test 
	public void get_park_by_parkcode() {
		Park park = null;
		park = dao.getParkByParkCode(TEST_PARK_CODE);
		assertEquals(park.getParkName(), TEST_PARK);
		
	}
	@Test
	public void get_weather_by_parkcode() {
		List<Weather> weathers = dao.getWeatherByParkCode(TEST_PARK_CODE);
		for(Weather weather:weathers) {
			if(weather.getForecast().equals(TEST_WEATHER)) {
				assertEquals(weather.getForecast(), TEST_WEATHER);
			}
		}
		
	}
	
	@Test 
	public void get_park_by_parkname() {
		
		String park = dao.getParkByParkName(TEST_PARK);
		assertEquals(park, TEST_PARK_CODE);
		
	}

}
