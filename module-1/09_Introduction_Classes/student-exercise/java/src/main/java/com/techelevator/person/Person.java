package com.techelevator.person;

public class Person {

	private String firstName;
	private String LastName;
	private int age;

	public String getFullName() {
		String fullName = firstName + " " + LastName;
		return fullName;
	}

	public boolean isAdult() {
		if (age >= 18) {
			boolean adult = true;
			return adult;
		}
		return false;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
