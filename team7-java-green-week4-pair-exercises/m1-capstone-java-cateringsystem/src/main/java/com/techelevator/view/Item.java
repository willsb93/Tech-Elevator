package com.techelevator.view;

import java.math.BigDecimal;

public class Item {

	private String itemCode;
	private String itemType;
	private String itemName;
	private BigDecimal itemPrice;
	private int itemQuantity = 50;
	private boolean isSoldOut = false;

	public Item(String itemCode, String itemName, BigDecimal itemPrice, String itemType) {
		// the item indexes hold the values above
		// Constructor for the Item
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemType = itemType;
		this.itemQuantity = 50;
		isSoldOut = false;

	}

	public String getItemCode() {
		return itemCode;
	}

	public String getItemType() {
		return itemType;
	}

	public String getItemName() {
		return itemName;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	// We need this to be able to change the quantity as purchases occur
	public void setItemQuantity(int itemQuantity) {

		this.itemQuantity = itemQuantity;
	}

	public Boolean getIsSoldOut() {
		if (getItemQuantity() <= 0) {
			isSoldOut = true;
		} else
			isSoldOut = false;
		return isSoldOut;
	}

	// We need this to be able to change the soldOut to true when the quantity < = 0
	public void setIsSoldOut(Boolean isSoldOut) {
		this.isSoldOut = isSoldOut;
	}

}
