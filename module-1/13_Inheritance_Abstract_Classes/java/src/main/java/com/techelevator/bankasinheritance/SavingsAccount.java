package com.techelevator.bankasinheritance;

import java.math.BigDecimal;
import java.util.Date;

public class SavingsAccount extends Account{
	
	boolean isCorporate;

	
	public SavingsAccount(String accountNumber) {
		super(accountNumber);
	}

	public SavingsAccount(String accountNumber, BigDecimal openingBalance) {
	    super(accountNumber, openingBalance);
	}
	
	public SavingsAccount(String accountNumber, BigDecimal openingBalance, boolean isCorporate) {
		super(accountNumber, openingBalance);
		this.isCorporate = isCorporate;
	}
	


	


}
