package com.techelevator.bankasinheritance;

import java.math.BigDecimal;

public class Account {
	
	private String accountNumber;
	private BigDecimal balance;
	
	
	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Account(String accountNumber, BigDecimal openingBalance) {
		this.accountNumber = accountNumber;
		this.balance = openingBalance;
	}
	
	
	public BigDecimal deposit(BigDecimal depositAmount) {
		return this.balance.add(depositAmount);
	}
	
	public final void chargeStupidFees() {
		this.balance = this.balance.add(new BigDecimal(10000));
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
