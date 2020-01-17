package com.techelevator;

public class MainArgsIntegerExample {
	
	/*
	 * Example designed to pull args from RuntimeConfig
	 */
	
	public static void main(String[] args) {

		for(int i = 0; i < args.length; i++) {
			int numbers = Integer.parseInt(args[i]);
			System.out.println("Numbers: " + numbers);
			System.out.println(args[i]);
		}
	}
}
