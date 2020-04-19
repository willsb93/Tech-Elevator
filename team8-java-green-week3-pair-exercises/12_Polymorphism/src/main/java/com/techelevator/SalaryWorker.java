package com.techelevator;

public class SalaryWorker implements IWorker {

	// Constructor

	private double annualSalary;
	private String firstName;
	private String lastName;

	public SalaryWorker(String firstName, String lastName, double annualSalary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.annualSalary = annualSalary;
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
		double pay = annualSalary / 52;
		return (double) Math.round(pay*100) / 100;
	}

	public double getAnnualSalary() {
		double pay = annualSalary;
		return pay;
	}

}
