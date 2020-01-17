package com.techelevator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * NOTE:  This is only here to show you that other ways exist.  For this cohort, the Scanner option is
 * the preferred approach. Use Scanner approach on your homeowrk assignments, etc
 * 
 * @author Steve
 * 
 * 
 */

public class BufferedReaderExample {

	public static void main(String[] args) throws IOException {
		// Enter data using BufferReader
		System.out.println("Go ahead, Steve... Author a Harry Potter book... ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Reading data using readLine
		String name = reader.readLine();

		// Printing the read line
		System.out.println(name);
	}

}
