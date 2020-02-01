package com.techelevator;

import java.util.HashMap;
import java.util.Map;

/*
 * Given the name of an animal, return the name of a group of that animal
 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
 *
 * The animal name should be case insensitive so "elephant", "Elephant", and
 * "ELEPHANT" should all return "herd".
 *
 * If the name of the animal is not found, null, or empty, return "unknown".
 *
 * Rhino -> Crash
 * Giraffe -> Tower
 * Elephant -> Herd
 * Lion -> Pride
 * Crow -> Murder
 * Pigeon -> Kit
 * Flamingo -> Pat
 * Deer -> Herd
 * Dog -> Pack
 * Crocodile -> Float
 *
 * GetHerd("giraffe") → "Tower"
 * GetHerd("") -> "unknown"
 * GetHerd("walrus") -> "unknown"
 * GetHerd("Rhino") -> "Crash"
 * GetHerd("rhino") -> "Crash"
 * GetHerd("elephants") -> "unknown"
 *
 */

public class AnimalGroupName {
	
	private Map<String, String> animalMap;
	
	public AnimalGroupName() {
		animalMap = new HashMap<String, String>();
		animalMap.put("lion","Pride");
		animalMap.put("dog","Pack");
		animalMap.put("crow","Murder");
		animalMap.put("elephant","Herd");		
	}

	
	public String getGroupName(String animal) {
		
		if (animal == null || !animalMap.containsKey(animal.toLowerCase())) {
			return "Unknown";
		}

        return animalMap.get(animal.toLowerCase());
		
	}
	
	

}
