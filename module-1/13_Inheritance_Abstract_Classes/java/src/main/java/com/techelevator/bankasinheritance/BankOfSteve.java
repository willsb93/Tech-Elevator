package com.techelevator.bankasinheritance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankOfSteve {

	public static void main(String[] args) {
	
		
	    Account steveAcct = new Account("1234444");
	    SavingsAccount steveAcct2 = new SavingsAccount("1234567");
	    Account steveAcct3 = new SavingsAccount("9999");
	    
	    System.out.println(steveAcct2.getAccountNumber());
	    System.out.println(steveAcct.getAccountNumber());
	    System.out.println(steveAcct3.getAccountNumber());
	
		
		List<Account> accountList = new ArrayList<Account>();
		Account newChecking = new CheckingAccount("456", new BigDecimal(100));
	
		Account newSavings = new SavingsAccount("123", new BigDecimal(50));
		accountList.add(newChecking);
		accountList.add(newSavings);

		
		for (Account account : accountList) {
			
			BigDecimal newBalance = account.deposit(new BigDecimal(100000));
			System.out.println(newBalance.doubleValue());
			
			
			if (account instanceof CheckingAccount) {
				CheckingAccount checking = (CheckingAccount) account;
				checking.writeCheck("100");
			}
			
		
			
		}
		
		
		
		
		

	}

}
