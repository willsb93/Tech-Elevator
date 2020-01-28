package com.techelevator.noisy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NoiseApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		INoise bird = new Bird();
		
		Bird b = (Bird) bird;
		b.poop();
		
		System.out.println(bird.makeNoise());
		
//		Bird bigbird = new Bird();
//		bigbird.makeNoise();
		
		
//		Guitar guitar = new Guitar();
		
		INoise fenderGuitar = new Guitar();
		System.out.println(fenderGuitar.makeNoise());
		
//		List<Guitar> guitarList = new ArrayList<Guitar>();
//		guitarList.add(fenderGuitar);
	
		
		List<INoise> noiseList = new ArrayList<INoise>();
		noiseList.add(fenderGuitar);
		noiseList.add(bird);
		noiseList.add(b);
		
		System.out.println("*************************");
		
		for (INoise n : noiseList) {
			
			if (n instanceof Bird) {   // checks the data type
				((Bird) n).poop();
			}
			System.out.println(n.makeNoise());    // the implemented interface method
		}
		
		
		Map<String, String> stringMap = new HashMap<String, String> ();
		
		
		
		Map<String, String> treeMap = new TreeMap<String, String> ();
		
		
		Map<String, String> linkedMap = new LinkedHashMap<String, String> ();
		
		Map<String, String> stevesMap = new SteveMap ();
	}
	
	

}
