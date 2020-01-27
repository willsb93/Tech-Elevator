package com.techelevator.account;

import java.math.BigDecimal;

public class CollegeSavingsAccount extends SavingsAccount{
	
	private String school;

	public CollegeSavingsAccount(BigDecimal openingBalance, String accountNumber, BigDecimal openingInterestRate, String school) {
		super(openingBalance, accountNumber, openingInterestRate);
		this.school = school;
		// TODO Auto-generated constructor stub
	}
	
	

}
