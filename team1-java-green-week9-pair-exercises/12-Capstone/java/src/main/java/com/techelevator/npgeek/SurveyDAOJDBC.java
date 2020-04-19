package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class SurveyDAOJDBC implements SurveyDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public SurveyDAOJDBC(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addNewSurveyToDatabase(Survey surveySubmitted) {
		String insertSurvey = "INSERT INTO survey_result (surveyid, parkcode, emailaddress, state, activitylevel)"
				+ "VALUES (DEFAULT, ?, ?, ?, ?) ";
		jdbcTemplate.update(insertSurvey, surveySubmitted.getParkCode(), surveySubmitted.getEmail(),
				surveySubmitted.getState(), surveySubmitted.getActivityLevel());


	}

	@Override
	public List<PopularPark> listMostPopularParks() {
		List<PopularPark> popularParks = new ArrayList<PopularPark>();

		String getMostPopularParks = "SELECT count(survey_result.parkcode), park.parkname, park.parkcode FROM survey_result INNER JOIN park ON park.parkcode = survey_result.parkcode GROUP BY park.parkname, park.parkcode HAVING count(survey_result.parkcode) >= 1 ORDER BY count DESC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(getMostPopularParks);
		while (results.next()) {
			PopularPark park = null;
			park = mapRowToPopularPark(results);
			popularParks.add(park);
		}
		return popularParks;
	}

	private PopularPark mapRowToPopularPark(SqlRowSet results) {
		PopularPark park = new PopularPark();
		park.setParkName(results.getString("parkname"));
		park.setCount(results.getInt("count"));
		park.setParkCode(results.getString("parkcode"));
		return park;
	}

}
