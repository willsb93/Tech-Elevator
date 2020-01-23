package com.porsche;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCarApp {

	public static void main(String[] args) {
		
		Car stevesCar = new Car("red", "A");
		
		
		stevesCar.setYear(2020);
		//stevesCar.setModel("911");
		
		

		
		
		Engine engine = new Engine(8, "gas");
		
		
		System.out.println(engine.getNumberOfCylinders());
		
		
		System.out.println(stevesCar.startCar());
		
		System.out.println(stevesCar.getColor() + " " + stevesCar.getModel() + " " + stevesCar.getYear());
		

		
		Car joesCar = new Car("green", "B");
		//joesCar.setModel("Focus");
		joesCar.setYear(2019);
		System.out.println(joesCar.getColor() + " " + joesCar.getModel() + " " + joesCar.getYear());
		
		
		List<Car> carList = new ArrayList<Car> ();
		carList.add(joesCar);
		carList.add(stevesCar);
		System.out.println(carList.size());
		
		Map<String, Car> myCarMap = new HashMap<String, Car> ();
		myCarMap.put("Steve", stevesCar);
		myCarMap.put("Joe", joesCar);
		
		
		
		
		

	}

}
