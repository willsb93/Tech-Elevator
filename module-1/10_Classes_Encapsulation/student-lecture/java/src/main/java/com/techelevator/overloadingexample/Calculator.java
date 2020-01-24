package com.techelevator.overloadingexample;

public class Calculator {
	
	private int result = 0;
	
	
    public int add (int x, int y) {
    	return x + y;
    }
    
    public int add (int x, int y, int z) {
    	return x + y + z;
    }
    
    public int add (int[] numbers) {
    	
    	int sum = 0;
    	for (int i=0; i<numbers.length; i++) {
    		sum += numbers[i];
    	}
    	
    	return sum;
    }

	
}
