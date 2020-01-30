package com.techelevator.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockQuoteService {
	
	private Map<String, Integer> portfolio = new HashMap<String, Integer>();  
	
	//get list of stocks
	
	public List<Stock> getListOfStocks() {
		//return a List<Stock>
		return null;
	}
	
	
	//add stock, qty to portfolio
	public void addStockToPortfolio(String name, int quantity) {
		// add to portfolio map
		
		//write a bunch of validation code here
		
		if (isValidStockName(name) && quantity >0 ) {
			//then add to portfolio
			
		}
		
		
		
		
	}
	
	
	//get portfolio balance - loop through and demo calling a private method
	public double getPortfolioBalance() {
		return 0.0;
	}
	
	private boolean isValidStockName(String name) {
		//do validation logic 
		return true;
	}
	

}
