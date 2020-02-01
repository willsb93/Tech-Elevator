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

	@Test
	public void testDivisibleBy5And3ReturnFizzBuzz() {
		assertEquals("FizzBuzz", acess.fizzBuzz(15));
		assertEquals("FizzBuzz", acess.fizzBuzz(30));
		assertEquals("FizzBuzz", acess.fizzBuzz(45));
		assertEquals("FizzBuzz", acess.fizzBuzz(90));
	}

	@Test
	public void testNotDivisibleBetween1And100() {
		assertEquals("11", acess.fizzBuzz(11).toString());
		assertEquals("7", acess.fizzBuzz(7).toString());
		assertEquals("14", acess.fizzBuzz(14).toString());
		assertEquals("74", acess.fizzBuzz(74).toString());
	}

	@Test
	public void testNotBetween1And100() {
		assertEquals("", acess.fizzBuzz(-1).toString());
		assertEquals("", acess.fizzBuzz(-67).toString());
		assertEquals("", acess.fizzBuzz(101).toString());
		assertEquals("", acess.fizzBuzz(0).toString());
	}

}
