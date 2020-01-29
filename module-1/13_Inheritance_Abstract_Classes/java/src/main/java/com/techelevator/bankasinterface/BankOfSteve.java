package com.techelevator.bankasinterface;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankOfSteve {

	public static void main(String[] args) {
		
		List<IAccount> accountList = new ArrayList<IAccount>();
		IAccount newChecking = new CheckingAccount("456", new BigDecimal(100));
	
		IAccount newSavings = new SavingsAccount("123", new BigDecimal(50));
		accountList.add(newChecking);
		accountList.add(newSavings);
		
		for (IAccount account : accountList) {
			
			BigDecimal newBalance = account.deposit(new BigDecimal(100000));
			System.out.println(newBalance.doubleValue());
			
			
			if (account instanceof CheckingAccount) {
				CheckingAccount checking = (CheckingAccount) account;
				checking.writeCheck("100");
			}
			
		
			
		}
		
		
		
		
		

	}

}
