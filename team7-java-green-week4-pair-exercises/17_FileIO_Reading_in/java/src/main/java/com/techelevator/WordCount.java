package com.techelevator;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {

		File text = new File("alices_adventures_in_wonderland.txt");

		try (Scanner fileScanner = new Scanner(text)) {

			int wordCount = 0;
			int sentenceCount = 0;

			while (fileScanner.hasNextLine()) {

				String aliceText = fileScanner.nextLine();

				String[] mySplitLine = aliceText.split("\\s+");



				if (aliceText.contains(".") || aliceText.contains("!") || aliceText.contains("?")) {
					sentenceCount += 1;

				}

				for (int i = 0; i < mySplitLine.length; i++) {
					if (!mySplitLine[i].isEmpty()) {
						wordCount++;
					}

				}
			}

			System.out.println("Word Count: " + wordCount);
			System.out.println("Sentence Count: " + sentenceCount);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
