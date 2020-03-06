package com.techelevator.validation.model;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Registration {
	
	@NotBlank(message="First name is required")
	@Size(min=1, max=20, message="First name must be between 1 and 20 characters")
	private String firstName;
	
	@NotBlank(message="Last name is required")
	@Size(min=1, max=20, message="Last name must be between 1 and 20 characters")
	private String lastName;
	
	@Email(message="Email not valid")
	@NotBlank(message="Email not valid")
	private String email;
	
	@Email(message="Email not valid")
	@NotBlank(message="Email not valid")
	private String confirmEmail;
	
	@NotBlank(message="Password is required")
	@Size(min=8, max=30, message="Password must be between 8 and 30 characters")
	private String password;
	
	@NotBlank(message="Password is required")
	private String confirmPassword;
	
	@NotNull(message = "Date can't be empty")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate birthDate;
	
	
	@Min(value=1, message="You need at least 1 ticket")
	@Max(value=10, message="You can't get more than 10 tickets")
	private int numOfTickets;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getConfirmEmail() {
		return confirmEmail;
	}
	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public int getNumOfTickets() {
		return numOfTickets;
	}
	public void setNumOfTickets(int numOfTickets) {
		this.numOfTickets = numOfTickets;
	}
	

}