package com.techelevator;

import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.techelevator.view.Item;
import com.techelevator.view.ItemFileReader;

import org.junit.Assert;

public class ItemFileReaderTest {

	ItemFileReader fileReaderTest = new ItemFileReader();

	@Test
	public void testIfListItemPropertiesAreEqualToExpected() {
		List<Item> itemListTest = new ArrayList<Item>();

		Item itemSoda = new Item("B1", "Soda", new BigDecimal(1.5), "B");
		Item itemWine = new Item("B2", "Wine", new BigDecimal(3.05), "B");
		Item itemWater = new Item("B4", "Sparkling Water", new BigDecimal(2.35), "B");

		itemListTest.add(itemSoda);
		itemListTest.add(itemWine);
		itemListTest.add(itemWater);

		Assert.assertEquals(itemListTest.get(2).getItemPrice(),
				fileReaderTest.readItemFile("test.csv").get(2).getItemPrice());
		Assert.assertEquals(itemListTest.get(2).getItemType(),
				fileReaderTest.readItemFile("test.csv").get(2).getItemType());
		Assert.assertEquals(itemListTest.get(2).getItemName(),
				fileReaderTest.readItemFile("test.csv").get(2).getItemName());
		Assert.assertEquals(itemListTest.get(2).getItemCode(),
				fileReaderTest.readItemFile("test.csv").get(2).getItemCode());
		Assert.assertEquals(itemListTest.get(2).getItemQuantity(),
				fileReaderTest.readItemFile("test.csv").get(2).getItemQuantity());
		Assert.assertEquals(itemListTest.get(2).getIsSoldOut(),
				fileReaderTest.readItemFile("test.csv").get(2).getIsSoldOut());
	}

}
