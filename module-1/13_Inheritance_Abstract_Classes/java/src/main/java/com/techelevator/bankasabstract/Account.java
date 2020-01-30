package com.techelevator.bankasabstract;

import java.math.BigDecimal;

public  abstract class Account {
	
	private String accountNumber;
	private BigDecimal balance;
	
	
	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Account(String accountNumber, BigDecimal openingBalance) {
		this.accountNumber = accountNumber;
		this.balance = openingBalance;
	}
	
	public abstract double fundsTransfer(int x, int y);
	
	
	public BigDecimal deposit(BigDecimal depositAmount) {
		return this.balance.add(depositAmount);
	}


	public BigDecimal withdraw(BigDecimal withdrawAmount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	

}
