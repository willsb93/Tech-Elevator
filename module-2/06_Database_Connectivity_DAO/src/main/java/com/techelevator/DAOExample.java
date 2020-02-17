package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

public class DAOExample {

	public static void main(String[] args) {
	
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		CityDAO dao = new JDBCCityDAO(worldDataSource);
		
		City smallville = new City();
		smallville.setCountryCode("USA");
		smallville.setDistrict("OH");
		smallville.setName("Big Arlington");
		smallville.setPopulation(43035);
		
		dao.save(smallville);
		
		City theCity = dao.findCityById(smallville.getId());
		
		System.out.println("ID: " + theCity.getId() + ", NAME: " +  theCity.getName() 
		               + ", COUNTRY_CODE: " + theCity.getCountryCode() + ", POPULATION: " + theCity.getPopulation());
		
		theCity.setName("Little Arlington");

		dao.update(theCity);
		
		System.out.println("ID: " + theCity.getId() + ", NAME: " +  theCity.getName() 
        + ", COUNTRY_CODE: " + theCity.getCountryCode() + ", POPULATION: " + theCity.getPopulation());
		
		theCity = dao.findCityById(theCity.getId());
		
		System.out.println("ID: " + theCity.getId() + ", NAME: " +  theCity.getName() 
        + ", COUNTRY_CODE: " + theCity.getCountryCode() + ", POPULATION: " + theCity.getPopulation());
		
	}

}
