package com.techelevator.bankasinterface;

import java.math.BigDecimal;

public class CheckingAccount implements IAccount{
	
	private String accountNumber;
	private BigDecimal balance;
	
	public CheckingAccount(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public CheckingAccount(String accountNumber, BigDecimal openingBalance) {
		this.accountNumber = accountNumber;
		this.balance = openingBalance;
	}
	
	
	public void writeCheck(String checkNumber) {
		
	}
	
	
	@Override
	public BigDecimal deposit(BigDecimal depositAmount) {
		return this.balance.add(depositAmount);
	}

	@Override
	public BigDecimal withdraw(BigDecimal withdrawAmount) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public BigDecimal getBalance() {
		return balance;
	}
	

}
