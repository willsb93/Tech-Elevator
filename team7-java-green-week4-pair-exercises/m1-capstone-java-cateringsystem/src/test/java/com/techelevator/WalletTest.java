package com.techelevator;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.techelevator.view.Wallet;

import org.junit.Assert;

public class WalletTest {
	Wallet walletTest = new Wallet();
	
	@Test
	public void testGetUserBalance() {
		Assert.assertEquals(new BigDecimal(0), walletTest.getUserBalance());
	}
	@Test
	public void testSetUserBalance() {
		Assert.assertEquals(new BigDecimal(20), walletTest.setUserBalance(new BigDecimal(20)));
	}
}
