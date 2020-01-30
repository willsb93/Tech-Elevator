package com.techelevator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;   //Use this one...

public class AnimalGroupNameTest {
	
	AnimalGroupName animalMap;
	
	@Before
	public void setup() {
	
		animalMap = new AnimalGroupName();
	}
	
	
	@Test
	public void testForAnimalGroups() {
		
		Assert.assertEquals("Crash", animalMap.getHerd("Rhino"));
		Assert.assertEquals("Pack", animalMap.getHerd("Dog"));
		Assert.assertEquals("unknown", animalMap.getHerd("Muppet"));

	}
	
	@Test
	public void testForNullOrEmptyGroups() {
		
		Assert.assertEquals("unknown", animalMap.getHerd(""));
		Assert.assertEquals("unknown", animalMap.getHerd(null));

	}	

}
