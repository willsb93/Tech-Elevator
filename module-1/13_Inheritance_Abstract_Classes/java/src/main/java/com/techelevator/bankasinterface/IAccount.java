package com.techelevator.bankasinterface;

import java.math.BigDecimal;
import java.util.Date;

public interface IAccount {

	
	//define any methods I want others to implement
	BigDecimal deposit(BigDecimal depositAmount);
	BigDecimal withdraw(BigDecimal withdrawAmount);

}
