package com.techelevator.constructor;

public class StudentApp {

	public static void main(String[] args) {
		
		// Creating a Student using default constructor
		Student johnny = new Student("John", "Wayne");

		johnny.addStudentScore(100);
		johnny.addStudentScore(50);
		johnny.addStudentScore(75);
		
		
		System.out.println(johnny.getOverallGrade());
		
		
		
		

	}

}
