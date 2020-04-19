package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.techelevator.view.CateringService;
import com.techelevator.view.Item;
import com.techelevator.view.ItemFileReader;

import org.junit.Assert;

public class CateringServiceTest {


	
	CateringService catering = new CateringService("test.csv");
	
	@Before
	public void testSetup() {
		
		catering.setWalletBalance(new BigDecimal(100));
		

		
	}
	
	@Test
	public void testReceiveRemainingChange() {
		int numberOf20s = 6;
		int numberOf10s = 0;
		int numberOf5s = 1;
		int numberOf1s = 0;
		int numberOfQuarters = 2;
		int numberOfDimes = 0;
		int numberOfNickels = 0;
		String changeBack = numberOf20s + " (20s), " + numberOf10s + " (10s), " + numberOf5s + " (5s), " + numberOf1s
				+ " (1s), " + numberOfQuarters + " (quarters), " + numberOfDimes + " (dimes), " + numberOfNickels
				+ " (nickels).";
		Assert.assertEquals(changeBack, catering.receiveRemainingChange(new BigDecimal (125.50)));
	}
	public void testGetWalletBalance() {
		Assert.assertEquals(new BigDecimal(100), catering.getWalletBalance());
	}
	@Test
	public void testRetrieveListOfCateringItems() {
		List<Item> itemListTest = new ArrayList<Item>();

		Item itemSoda = new Item("B1", "Soda", new BigDecimal(1.5), "B");
		Item itemWine = new Item("B2", "Wine", new BigDecimal(3.05), "B");
		Item itemWater = new Item("B4", "Sparkling Water", new BigDecimal(2.35), "B");

		itemListTest.add(itemSoda);
		itemListTest.add(itemWine);
		itemListTest.add(itemWater);
		
		Assert.assertEquals(itemListTest.get(0).getItemQuantity(), (catering.retrieveListOfCateringItems()).get(0).getItemQuantity());
	}
	@Test
	public void testSetWalletBalance() {
		Assert.assertEquals(new BigDecimal(150), catering.setWalletBalance(new BigDecimal(50)));
	}
	@Test
	public void testSelectItemFromTheList() {
		Item itemTest = new Item("B1", "Soda", new BigDecimal(1.5), "B");
		Assert.assertEquals(itemTest.getItemCode(), catering.selectItemsFromTheList("B1").getItemCode());
		Assert.assertEquals(null, catering.selectItemsFromTheList("fdg"));
	}
	@Test
	public void testUpdateBalanceAfterPurchase() {
		Assert.assertEquals(true, catering.updateBalanceAfterPurchase(new BigDecimal(1.5), 10));
		Assert.assertEquals(false, catering.updateBalanceAfterPurchase(new BigDecimal(1.75), 100));
	}
}
