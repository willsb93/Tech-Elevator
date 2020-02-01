package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataFizzBuzzTest {
	
	KataFizzBuzz acess = new KataFizzBuzz();
	
	@Test
	
	public void testDivisibleby3ReturnFizz() {
		assertEquals("Fizz", acess.fizzBuzz(3));
		assertEquals("Fizz", acess.fizzBuzz(9));
		assertEquals("Fizz", acess.fizzBuzz(33));
		assertEquals("Fizz", acess.fizzBuzz(12));
	}
	
	

}
