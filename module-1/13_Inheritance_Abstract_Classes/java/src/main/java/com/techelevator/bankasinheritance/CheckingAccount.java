package com.techelevator.bankasinheritance;

import java.math.BigDecimal;

public class CheckingAccount extends Account implements InterestBearing{
	


	public CheckingAccount(String accountNumber) {
		super(accountNumber);
		// TODO Auto-generated constructor stub
	}
	

	public CheckingAccount(String accountNumber, BigDecimal openingBalance) {
	    super(accountNumber, openingBalance);
	}

	public void writeCheck(String checkNumber) {
		
	}


	@Override
	public BigDecimal calculateInterest() {
		// TODO Auto-generated method stub
		return null;
	}
	

	

}
