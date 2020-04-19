package com.techelevator;

public class VolunteerWorker implements IWorker {

	private String firstName;
	private String lastName;

	public VolunteerWorker(String firstName, String lastName) {

		this.firstName = firstName;
		this.lastName = lastName;

	}

	@Override
	public String getFirstName() {
		String name = firstName;
		return name;
	}

	@Override
	public String getLastName() {
		String name = lastName;
		return name;
	}

	@Override
	public double calculateWeeklyPay(int hoursWorked) {
		// TODO Auto-generated method stub
		double pay = hoursWorked * 0;
		return pay;
	}

}
