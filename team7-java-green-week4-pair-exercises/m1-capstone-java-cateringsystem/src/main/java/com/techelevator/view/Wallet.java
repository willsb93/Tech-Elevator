package com.techelevator.view;

import java.math.BigDecimal;
import java.util.Scanner;

public class Wallet {

	private BigDecimal userBalance = new BigDecimal(0);

	public BigDecimal getUserBalance() {
		return userBalance;
	}

	public BigDecimal setUserBalance(BigDecimal userBalance) {
		this.userBalance = userBalance;
		return userBalance;
	}

}
