package com.techelevator.npgeek;

import java.time.LocalDate;

public class Weather {

	private int fiveDayForecastValue;
	private int low;
	private int high;
	private String forecast;
	private String forecastAdvice;
	private String temperatureAdvice;
	private String weatherEmoji;
	private LocalDate date;
	private boolean isCelsius;
	private String stringTempHigh;
	private String stringTempLow;

	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	public String getForecastAdvice() {
		String message = "";
		if(this.forecast.equals("snow")) {
			message = "Pack snowshoes!";
		}
		if(this.forecast.equals("sunny")) {
			message = "Pack sunblock!";
		}
		if(this.forecast.equals("rain")) {
			message = "Pack rain gear and wear waterproof shoes!";
		}
		if(this.forecast.equals("thunderstorms")) {
			message = "Seek shelter and avoid hiking on exposed ridges!";
		}
		if(this.forecast.contains("cloudy")) {
			message = "Enjoy your day!";
		}
		return message;
	}
	public void setForecastAdvice(String forecastAdvice) {
		this.forecastAdvice = forecastAdvice;
	}
	public String getTemperatureAdvice() {
		String message = "";
		if(this.high > 75) {
			message = "Bring an extra gallon of water";
		}
		if(this.low < 20) {
			message = "Warning! You will be exposed to frigid temperatures!";
		}
		if(this.high - this.low > 20) {
			message = "Wear breathable layers.";
		}
		return message;
	}
	public void setTemperatureAdvice(String temperatureAdvice) {
		this.temperatureAdvice = temperatureAdvice;
	}
	public String getWeatherEmoji() {
		String message = "";
		if(this.forecast.equals("snow")) {
			message = "&#x1F328";
		}
		if(this.forecast.equals("sunny")) {
			message = "&#x1F506";
		}
		if(this.forecast.equals("rain")) {
			message = "&#x2614";
		}
		if(this.forecast.equals("thunderstorms")) {
			message = "&#x26C8";
		}
		if(this.forecast.equals("cloudy")) {
			message = "&#x26C5";
		}
		if(this.forecast.equals("partly cloudy")) {
			message = "&#x26c5";
		}
		return message;
	}
	
	public void setWeatherEmoji(String weatherEmoji) {
		this.weatherEmoji = weatherEmoji;
	}
	public String getStringHighFarenheit() {
		return ""+this.high+"ºF";
	}

	public LocalDate getDate() {
		LocalDate today = LocalDate.now();
		return today;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public boolean isCelsius() {
		return isCelsius;
	}
	public void setCelsius(boolean isCelsius) {
		this.isCelsius = isCelsius;
	}

	public String getStringTempHigh() {
		if(isCelsius) {
			Float degreeCelsius = (float) ((this.high  - 32) / 1.8);
			String stringDegreeCelsius = String.format("%.1f", degreeCelsius);
			return ""+stringDegreeCelsius+"ºC";
		}
		return ""+this.high+"ºF";
	}
	public void setStringTempHigh(String stringTempHigh) {
		this.stringTempHigh = stringTempHigh;
	}
	public String getStringTempLow() {
		if(isCelsius) {
			Float degreeCelsius = (float) ((this.low  - 32) / 1.8);
			String stringDegreeCelsius = String.format("%.1f", degreeCelsius);
			return ""+stringDegreeCelsius+"ºC";
		}
		return ""+this.low+"ºF";
	}
	public void setStringTempLow(String stringTempLow) {
		this.stringTempLow = stringTempLow;
	}
	
	
	

	
}
