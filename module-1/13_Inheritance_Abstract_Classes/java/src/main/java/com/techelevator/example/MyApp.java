package com.techelevator.example;

import java.util.List;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StockQuoteService service = new StockQuoteService();
		service.addStockToPortfolio("Goog", 1000);

		
		List<Stock> myList = service.getListOfStocks();
		

	}

}
