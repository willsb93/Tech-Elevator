package com.techelevator.account;

import java.math.BigDecimal;

public class CheckingAccount extends Account {
	
	private boolean writeChecks;

	public CheckingAccount(BigDecimal openingBalance, String accountNumber, boolean canWriteChecks) {
		super(openingBalance, accountNumber);
		this.writeChecks = canWriteChecks;
		
	}

	public boolean isWriteChecks() {
		return writeChecks;
	}
	
	public BigDecimal deposit (BigDecimal depositAmount) {
		
		
		//return super.deposit(depositAmount.add(new BigDecimal(50)));
		return new BigDecimal(0);
		

	}
	
	
	
	

}
