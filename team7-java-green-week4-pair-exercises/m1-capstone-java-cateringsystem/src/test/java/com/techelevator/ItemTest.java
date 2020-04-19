package com.techelevator;

import com.techelevator.view.Item;
import com.techelevator.view.Menu;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

public class ItemTest {
	Item itemTest = new Item("B1", "Soda",new BigDecimal(1.50), "B");

	@Test
	public void testGetCode() {
		Assert.assertEquals("B1", itemTest.getItemCode());
	}
	@Test
	public void testGetPrice() {
		Assert.assertEquals(new BigDecimal(1.50), itemTest.getItemPrice());
	}
	@Test
	public void testGetName() {
		Assert.assertEquals("Soda", itemTest.getItemName());
	}
	@Test
	public void testGetType() {
		Assert.assertEquals("B", itemTest.getItemType());
	}
	@Test
	public void testGetDefaultQuantity() {
		Assert.assertEquals(50, itemTest.getItemQuantity());
	}
	@Test
	public void testIsSoldOut() {
		itemTest.setItemQuantity(0);
		Assert.assertEquals(true, itemTest.getIsSoldOut());
		itemTest.setItemQuantity(1);
		Assert.assertEquals(false, itemTest.getIsSoldOut());
	}

	@Test
	public void testSetQuantity() {

		itemTest.setItemQuantity(20);
		Assert.assertEquals(20, itemTest.getItemQuantity());
		itemTest.setItemQuantity(30);
		Assert.assertEquals(30, itemTest.getItemQuantity());
		itemTest.setItemQuantity(-10);
		Assert.assertEquals((-10), itemTest.getItemQuantity());
		

	}
}


