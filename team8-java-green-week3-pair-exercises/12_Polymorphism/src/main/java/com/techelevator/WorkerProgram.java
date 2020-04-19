package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorkerProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HourlyWorker Bill = new HourlyWorker("Bill", "Hourly", 15.0);
		SalaryWorker James = new SalaryWorker("James", "Salary", 43000);
		VolunteerWorker Timmy = new VolunteerWorker("Timmy", "Volunteer");

		List<IWorker> payroll = new ArrayList<IWorker>();
		payroll.add(Bill);
		payroll.add(James);
		payroll.add(Timmy);

		double totalHours = 0;
		double totalPay = 0;
			System.out.println(String.format("%-20s | %-15s | %8s ", "Employee", "Hours Worked", "Pay"));
			System.out.println("***************************************");
			
		for (IWorker name : payroll) {
			Random rand = new Random();
				int hours = rand.nextInt(50);
				totalHours += hours;
				totalPay += name.calculateWeeklyPay(hours);
				totalPay = (double) Math.round(totalPay*100) / 100;
				
			
			System.out.println(String.format("%-20s | %-15s | %-8s", name.getLastName() + "," + name.getFirstName(), hours, "$" +name.calculateWeeklyPay(hours)));
				
		}
		System.out.println("**********************************");
		System.out.println("Total Hours:" + " " + "$" + totalHours);
		System.out.println("Total Pay:" + " " + "$" + totalPay);
	}

}
