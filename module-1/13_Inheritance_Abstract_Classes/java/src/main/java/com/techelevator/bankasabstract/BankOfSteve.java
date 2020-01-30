package com.techelevator.bankasabstract;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankOfSteve {

	public static void main(String[] args) {
		
	BigDecimal openBalance = new BigDecimal(1000);	
	
	CheckingAccount checking = new CheckingAccount("123", openBalance);
	System.out.println(checking.fundsTransfer(4, 5));

	
	CheckingAccount newAccount = new CheckingAccount("123", openBalance);
	



	Account savings = new SavingsAccount("456");
	System.out.println(savings.fundsTransfer(6, 2));
	

	CheckingAccount checking2 = new CheckingAccount("123", openBalance);
	checking2.writeCheck();

	

	
	
	}

}
