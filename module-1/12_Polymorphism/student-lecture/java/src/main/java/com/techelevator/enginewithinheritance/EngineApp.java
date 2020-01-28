package com.techelevator.enginewithinheritance;

public class EngineApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RaceCarEngine engine = new RaceCarEngine();
		engine.setNumberOfCylinders(12);
		engine.goDoSomethingUseful();
		
		HelicopterEngine helicopter = new HelicopterEngine();
		helicopter.setNumberOfCylinders(3);
		helicopter.goDoSomethingUseful();
		
		
		
		

	}

}
