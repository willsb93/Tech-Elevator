package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class ParkDAOJDBC implements ParkDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ParkDAOJDBC(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParkData() {
		List<Park> parks = new ArrayList<Park>();
		String sqlGetParkData = "SELECT * FROM park ORDER BY parkname";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetParkData);

		while (results.next()) {
			Park thePark = null;
			thePark = mapRowToPark(results);
			parks.add(thePark);

		}
		return parks;
	}

	@Override
	public Park getParkByParkCode(String parkCode) {
		Park park = null;
		String getParkByParkCode = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(getParkByParkCode, parkCode);
		if (results.next()) {
			park = mapRowToPark(results);
		}
		return park;
	}

	@Override
	public List<Weather> getWeatherByParkCode(String parkCode) {
		List<Weather> weathers = new ArrayList<Weather>();
		String getWeatherByParkCode = "SELECT * FROM park INNER JOIN weather ON park.parkcode = weather.parkcode WHERE park.parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(getWeatherByParkCode, parkCode);

		while (results.next()) {
			Weather theWeather = null;
			theWeather = mapRowToWeather(results);
			weathers.add(theWeather);

		}

		return weathers;
	}

	@Override
	public String getParkByParkName(String parkName) {
		Survey survey = null;
		String getParkByParkName = "SELECT parkcode FROM park WHERE parkname = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(getParkByParkName, parkName);

		if (results.next()) {
			survey = mapRowToSurvey(results);
		}

		return survey.getParkCode();
	}

	private Park mapRowToPark(SqlRowSet results) {
		Park thePark = new Park();
		thePark.setAcreage(results.getInt("acreage"));
		thePark.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		thePark.setClimate(results.getString("climate"));
		thePark.setElevation(results.getInt("elevationinfeet"));
		thePark.setEntryFee(results.getInt("entryfee"));
		thePark.setInspirationalQuote(results.getString("inspirationalquote"));
		thePark.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
		thePark.setMiles(results.getFloat("milesoftrail"));
		thePark.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
		thePark.setNumberOfCampsites(results.getInt("numberofcampsites"));
		thePark.setParkDescription(results.getString("parkdescription"));
		thePark.setParkName(results.getString("parkname"));
		thePark.setParkCode(results.getString("parkcode"));
		thePark.setState(results.getString("state"));
		thePark.setYearFounded(results.getInt("yearfounded"));
		return thePark;
	}

	private Weather mapRowToWeather(SqlRowSet results) {
		Weather theWeather = new Weather();
		theWeather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
		theWeather.setForecast(results.getString("forecast"));
		theWeather.setHigh(results.getInt("high"));
		theWeather.setLow(results.getInt("low"));

		return theWeather;
	}

	private Survey mapRowToSurvey(SqlRowSet results) {
		Survey theSurvey = new Survey();
		theSurvey.setParkCode(results.getString("parkcode"));
		return theSurvey;
	}

}
