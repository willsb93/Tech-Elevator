package com.techelevator;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


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


public class AnimalGroupNameTest {

	AnimalGroupName groupName;
	
	@Before
	public void setUp() throws Exception {
		
		groupName = new AnimalGroupName();
		Assert.assertNotNull(groupName);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAnimalsInMap() {
		//fail("Not yet implemented");
		Assert.assertEquals("Pride", groupName.getGroupName("Lion"));
		Assert.assertEquals("Pack", groupName.getGroupName("Dog"));
		Assert.assertEquals("Murder", groupName.getGroupName("Crow"));
		Assert.assertEquals("Herd", groupName.getGroupName("Elephant"));
	}
	
	@Test
	public void testAnimalsNotInMap() {
		//fail("Not yet implemented");
		Assert.assertEquals("Unknown", groupName.getGroupName("Chicacabre"));
	}
	
	@Test
	public void testEmptyString() {
		//fail("Not yet implemented");
		Assert.assertEquals("Unknown", groupName.getGroupName(""));
	}	
	
	@Test
	public void testNullAnimalInput() {
		//fail("Not yet implemented");
		Assert.assertEquals("Unknown", groupName.getGroupName(null));
	}	
	
	@Test
	public void testCase() {
		//fail("Not yet implemented");
		Assert.assertEquals("Pack", groupName.getGroupName("dog"));
		Assert.assertEquals("Herd", groupName.getGroupName("Elephant"));
		Assert.assertEquals("Herd", groupName.getGroupName("ELEPHANT"));
		Assert.assertEquals("Herd", groupName.getGroupName("elephant"));
		Assert.assertEquals("Herd", groupName.getGroupName("ElePHant"));
	}

}
