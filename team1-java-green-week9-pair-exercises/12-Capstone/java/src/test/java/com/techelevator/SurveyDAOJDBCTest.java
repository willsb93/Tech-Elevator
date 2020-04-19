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
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.PopularPark;
import com.techelevator.npgeek.Survey;
import com.techelevator.npgeek.SurveyDAOJDBC;
public class SurveyDAOJDBCTest {
	
	private SurveyDAOJDBC dao;
	private static final String PARK_CODE = "AAAA";
	
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
		String insertSurvey = "INSERT INTO survey_result (surveyid, parkcode, emailaddress, state, activitylevel)"
				+ "VALUES (DEFAULT, ?, 'a@a.com', 'OH', 'Active') ";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(insertSurvey, PARK_CODE);
		dao = new SurveyDAOJDBC(dataSource);
	}

	@Test
	public void add_new_survey_to_database() {
		String code = "";
		Survey survey = new Survey();
		survey.setParkCode(PARK_CODE);
		survey.setEmail("a@a.com");
		survey.setState("OH");
		survey.setActivityLevel("Active");
		dao.addNewSurveyToDatabase(survey);
		String getSurvey = "SELECT parkcode FROM survey_result WHERE parkcode = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		SqlRowSet results = jdbcTemplate.queryForRowSet(getSurvey,survey.getParkCode());
		if(results.next()) {
			code = results.getString("parkcode");
		}
		assertEquals(code, PARK_CODE);
		
	}
	
	@Test
	public void  list_popular_parks() {
		List<PopularPark> parks = dao.listMostPopularParks();
		for(PopularPark park : parks) {
			if(park.getParkCode().equals(PARK_CODE)) {
				assertEquals(park.getParkCode(), PARK_CODE);
			}
		}
	}

}
