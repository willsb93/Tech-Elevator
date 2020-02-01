package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataFizzBuzzTest {
	
	KataFizzBuzz acess = new KataFizzBuzz();
	
	@Test
	
	public void testDivisibleBy3ReturnFizz() {
		assertEquals("Fizz", acess.fizzBuzz(3));
		assertEquals("Fizz", acess.fizzBuzz(9));
		assertEquals("Fizz", acess.fizzBuzz(33));
		assertEquals("Fizz", acess.fizzBuzz(12));
	}
	
	@Test
	public void testDivisibleBy5ReturnBuzz() {
		assertEquals("Buzz", acess.fizzBuzz(5));
		assertEquals("Buzz", acess.fizzBuzz(10));
		assertEquals("Buzz", acess.fizzBuzz(20));
		assertEquals("Buzz", acess.fizzBuzz(25));
	}
	
	

}
