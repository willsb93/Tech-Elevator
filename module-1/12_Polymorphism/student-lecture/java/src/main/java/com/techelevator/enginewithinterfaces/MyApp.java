package com.techelevator.enginewithinterfaces;

import java.util.ArrayList;
import java.util.List;

public class MyApp {

	public static void main(String[] args) {
		
		
		ChainsawEngine chainsaw = new ChainsawEngine();
	
		HelicopterEngine helo = new HelicopterEngine();
		
		List<Engine> myListOfNoisyEngine = new ArrayList<Engine>();
		
		myListOfNoisyEngine.add(chainsaw);
		myListOfNoisyEngine.add(helo);
		
		
		for (Engine e : myListOfNoisyEngine) {
		
			e.makeNoise();
		}
		

	}

}
