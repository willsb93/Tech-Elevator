package com.techelevator.calculator;

public class Calculator {

	public Calculator() {

	}

	private int result = 0;

	public int getResult() {
		return result;
	}

	public int add(int addend) {
		int add = addend;
		result = add + this.result;
		return result;
	}

	public int multiply(int multiplier) {

		return result *= multiplier;

	}

	public int power(int exponent) {
		if (exponent < 0) {
			exponent = exponent * -1;
		}

		result = (int) Math.pow(result, exponent);
		return result;
	}

	public void reset() {
		result = 0;
	}

	public int subtract(int subtrahend) {
		result -= subtrahend;
		return result;
	}
}
