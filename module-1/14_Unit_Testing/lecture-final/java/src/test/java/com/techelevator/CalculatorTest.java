package com.techelevator;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;   //Use this one...


public class CalculatorTest {

	Calculator calc;
	
	@BeforeClass
	public static void beforeAllTests() {
		System.out.println("I am executed before all tests!");
		
	}	
	
	@Before
	public void beforeEachTest() {
		System.out.println("I am executed before each test!");
		calc = new Calculator();
		
	}
	
	@After
	public void afterEachTest() {
		System.out.println("I am executed after each test!");

		
	}
	
	@AfterClass
	public static void afterAllTests() {
		System.out.println("I am executed after all tests!");
		
	}		
	
	@Test
	public void testCalculatorAddTwoNumbers() {
		System.out.println("I am testCalculatorAddTwoNumbers");
		// Arrange
		
		// Act
		// Assert
		Assert.assertEquals(5, calc.add(2, 3));
		Assert.assertEquals(0, calc.add(0, 0));
		int result = calc.add(-8, 4);
		Assert.assertEquals(-4,result);
		
		
	}
	
	@Test
	public void testCalculatorAddWrappedValues() {
		System.out.println("I am testCalculatorAddWrappedValues");
		//Arrange
		WrappedNumbers nums = new WrappedNumbers(3, 4);
		
		//Act
		
		Assert.assertEquals(7, calc.add(nums).getResult());
		

	
	}
	
	@Test
	public void testForNull() {
		
		Assert.assertNull(calc.returnNull());

	}
	
	@Test
	public void isAGreaterThanB() {
		
		Assert.assertTrue(calc.isAGreaterThanB(6, 2));
		Assert.assertFalse(calc.isAGreaterThanB(2, 7));

		
	}
	
	@Test
	public void testFizzBuzz() {
		
		//test is divisible by 3 AND 5
		Assert.assertEquals("fizzbuzz", calc.fizzBuzz(15));
		//test is divisible by 3 
		Assert.assertEquals("fizz", calc.fizzBuzz(3));
		//test is divisible by 5 
		Assert.assertEquals("buzz", calc.fizzBuzz(5));
		//test is divisible 
		Assert.assertEquals("fizzbuzz", calc.fizzBuzz(0));
		//test is divisible 
		Assert.assertEquals("1", calc.fizzBuzz(1));
	
		
	}	
	
	@Test
	public void testFizzBuzz3And5() {
		
		//test is divisible by 3 AND 5
		Assert.assertEquals("fizzbuzz", calc.fizzBuzz(15));

		
	}	
	
	@Test
	public void testFizzBuzz3() {
		
		//test is divisible by 3 AND 5
		Assert.assertEquals("fizzy", calc.fizzBuzz(3));
	
		
		
	}	
	



}
