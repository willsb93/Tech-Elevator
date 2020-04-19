package com.techelevator;

public class HourlyWorker implements IWorker {

	private double hourlyRate;
	private String firstName;
	private String lastName;

	// Constructor

	public HourlyWorker(String firstName, String lastName, double hourlyRate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.hourlyRate = hourlyRate;
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		String name = firstName;
		return name;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		String name = lastName;
		return name;
	}

	@Override
	public double calculateWeeklyPay(int hoursWorked) {
		double pay = this.hourlyRate * hoursWorked;
		if (hoursWorked > 40) {
			double overtime = hoursWorked - 40;
			pay = pay + (hourlyRate * overtime * .5);
			return (double) Math.round(pay * 100) / 100;
		}

		return (double) Math.round(pay * 100) / 100;

	}

	public double getHourlyRate() {
		return hourlyRate;
	}

}
