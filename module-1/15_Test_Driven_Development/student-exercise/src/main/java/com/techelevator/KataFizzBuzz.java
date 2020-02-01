package com.techelevator;

public class KataFizzBuzz {

	public String fizzBuzz(int num) {

		if (num <= 0 || num >= 100) {
			return "";
		}

		if (num % 3 == 0 && num % 5 == 0 || String.valueOf(num).contains("3") && String.valueOf(num).contains("5")) {
			return "FizzBuzz";

		} else if (num % 3 == 0 || String.valueOf(num).contains("3")) {
			return "Fizz";
		}

		else if (num % 5 == 0 || String.valueOf(num).contains("5")) {
			return "Buzz";
		}

		return Integer.toString(num);
	}
}
