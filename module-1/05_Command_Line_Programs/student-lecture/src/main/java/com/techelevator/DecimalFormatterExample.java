package com.techelevator;

import java.text.DecimalFormat;

public class DecimalFormatterExample {

	public static void main(String[] args) {
		// This is just a simple example of how you can take s
		
		DecimalFormat formatter = new DecimalFormat();
		formatter.setMaximumFractionDigits(2);
		String formattedString = formatter.format(0.45628f);
		System.out.println(formattedString);
	
		

	}

}
