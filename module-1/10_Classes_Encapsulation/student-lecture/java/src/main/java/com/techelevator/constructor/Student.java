package com.techelevator.constructor;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	private String firstName;
	private String lastName;
	
	
	public Student (String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	
	
	//create a List of Grades ...
	private List<Integer> scores = new ArrayList<Integer>();

	public String getFirstName() {
		return firstName;
	}

//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}

	public String getLastName() {
		return lastName;
	}

//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}

	public String getOverallGrade() {
		
		//put logic here to calculate score
		
	    int sum = 0;
		for (int i : scores) {
			sum += i;
		}
		double avg = sum / scores.size();
		
		if (avg > 50) {
			return "A";
		}
		else {
			return "F";
		}
	}

	
	public void addStudentScore(Integer score) {
		this.scores.add(score);
		System.out.println("Score: " + score + " added");
	}

	


	
}
