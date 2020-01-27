package com.techelevator.account;

import java.math.BigDecimal;

public class SavingsAccount extends Account {
	
	private BigDecimal interestRate;

	public SavingsAccount(BigDecimal openingBalance, String accountNumber, BigDecimal openingInterestRate) {
		super(openingBalance, accountNumber);
		this.interestRate = openingInterestRate;
		
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}
	
	
	


}
