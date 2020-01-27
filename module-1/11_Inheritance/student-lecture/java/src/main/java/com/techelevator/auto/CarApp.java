package com.techelevator.auto;

public class CarApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Automobile a1 = new Automobile();
		a1.setMake("Ford");
		a1.setModel("Mustang");
		a1.setNumberOfDoors(2);
		a1.setYear(2020);
		
		SportsCar sportscar = new SportsCar();
		sportscar.setMake("BMW");
		sportscar.setModel("M5");
		sportscar.setSeatBelts(true);
		System.out.println(sportscar.toString());
		
		SportsCar sportscar2 = new SportsCar();
		sportscar2.setMake("BMW");
		sportscar2.setModel("855");
		sportscar2.setSeatBelts(false);
		System.out.println(sportscar2.toString());
		

	}

}
