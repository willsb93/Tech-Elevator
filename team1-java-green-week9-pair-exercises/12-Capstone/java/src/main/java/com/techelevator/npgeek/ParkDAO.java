package com.techelevator.npgeek;

import java.util.List;

public interface ParkDAO {
	public List<Park> getAllParkData();
	public Park getParkByParkCode(String parkCode);
	public List<Weather> getWeatherByParkCode(String parkCode);
	public String getParkByParkName(String parkName);

}
