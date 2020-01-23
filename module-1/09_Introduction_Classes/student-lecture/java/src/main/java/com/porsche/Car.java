package com.porsche;

import java.util.ArrayList;
import java.util.List;

public class Car {
	
	
	public Car (String color, String model) {
		this.color = color;
		this.model = model;
	}
	
	//class/instance variables
	private String color = "red";


	private String model;
	private int year;
	private boolean isStarted;
	private List<Tire> tires = new ArrayList<Tire>();
	private Engine engine = new Engine(4, "diesel");
	
	
	
	public boolean startCar() {
		isStarted = true;
		driveCar();
		return isStarted;
	}
	
	private void driveCar() {
		System.out.println("Vroom Vroom");
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public List<Tire> getTires() {
		return tires;
	}

	public void setTires(List<Tire> tires) {
		this.tires = tires;
	}

	public Engine getEngine() {
		return engine;
	}
	
	
	


}
