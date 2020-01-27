package com.techelevator.account;

import java.math.BigDecimal;

public class Account {
	
	
	private BigDecimal balance;
	private String accountNumber;
	
	public Account (BigDecimal openingBalance, String accountNumber) {
		this.balance = openingBalance;
		this.accountNumber = accountNumber;
	}

	
	public BigDecimal getBalance() {
		return balance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public BigDecimal deposit (BigDecimal depositAmount) {
	
	    this.balance = this.balance.add(depositAmount);
		return this.balance;
	}
	
	public BigDecimal withdrawal (BigDecimal withdrawalAmount) {
		this.balance = this.balance.subtract(withdrawalAmount);
		return this.balance;
	}
	
	

}
