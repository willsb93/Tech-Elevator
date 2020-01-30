package com.techelevator.bankasinterface;

import java.math.BigDecimal;
import java.util.Date;

public class SavingsAccount implements IAccount {
	
	private String accountNumber;
	private BigDecimal balance;
	
	public SavingsAccount(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public SavingsAccount(String accountNumber, BigDecimal openingBalance) {
		this.accountNumber = accountNumber;
		this.balance = openingBalance;
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
