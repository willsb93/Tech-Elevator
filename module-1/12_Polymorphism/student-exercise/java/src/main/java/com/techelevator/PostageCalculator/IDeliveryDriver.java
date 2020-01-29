package com.techelevator.PostageCalculator;

public interface IDeliveryDriver {
	double calculateRate(int distance, double weight);
	String getName();
}
