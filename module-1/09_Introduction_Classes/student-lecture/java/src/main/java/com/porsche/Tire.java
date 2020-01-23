package com.porsche;

public class Tire {
	
	private String brand;
	private String model;
	
	
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	//derived property
	public String getDescription() {
		return brand +  " " + model;
	}
	
	

}
