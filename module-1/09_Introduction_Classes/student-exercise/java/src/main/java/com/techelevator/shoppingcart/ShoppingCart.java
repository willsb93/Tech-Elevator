package com.techelevator.shoppingcart;

public class ShoppingCart {

	public ShoppingCart() {

	}

	private int totalNumberOfItems = 0;
	private double totalAmountOwed = 0.0;

	public double getAveragePricePerItem() {
		if (totalAmountOwed != 0 || totalNumberOfItems != 0) {

			double amount = this.totalAmountOwed;
			double items = (double) this.totalNumberOfItems;
			double result = amount / items;
			return result;
		}

		{
			double nothing = 0.0;

			return nothing;
		}
	}

	public void addItems(int numberOfItems, double pricePerItem) {
		this.totalAmountOwed = numberOfItems * pricePerItem;
		this.totalNumberOfItems = numberOfItems;
	}

	public void empty() {
		this.totalNumberOfItems = 0;
		this.totalAmountOwed = 0.0;
	}

	public int getTotalNumberOfItems() {
		return this.totalNumberOfItems;
	}

	public double getTotalAmountOwed() {
		return this.totalAmountOwed;
	}

}
