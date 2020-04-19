package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) {

		try (Scanner fileScanner = new Scanner(System.in)) {

			System.out.println("Where is the file that should be searched?");

			File sourceFile = new File(fileScanner.nextLine());

			System.out.println("What is the search word?");

			String searchWord = "" + fileScanner.nextLine() + "";

			System.out.println("What is the word you want to replace the search word with?");

			String replaceWord = fileScanner.nextLine();

			System.out.println("Enter a name for the new file >>> ");

			String fileName = fileScanner.nextLine();

			File newFile = new File(fileName);

			newFile.createNewFile();

			try (Scanner source = new Scanner(sourceFile)) {

				try (PrintWriter writer = new PrintWriter(newFile)) {

					while (source.hasNextLine()) {

						String line = source.nextLine();

						if (line.contains(searchWord)) {
							line = line.replaceAll(searchWord, replaceWord);

						}
						writer.println(line);

					}
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("File not found.");
				e.printStackTrace();
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
