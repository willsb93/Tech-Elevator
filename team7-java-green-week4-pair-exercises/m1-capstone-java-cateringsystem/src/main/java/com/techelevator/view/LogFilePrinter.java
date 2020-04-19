package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LogFilePrinter {

	File logFile = new File("logFile.txt");
	PrintWriter writer;

	public void createLogFile() {
		try {

			logFile.createNewFile();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printLog(Log log) {
		String convertedString = "";
		convertedString = convertedString + log.getDateOfAction() + " ";
		convertedString = convertedString + log.getTimeOfAction() + " ";
		convertedString = convertedString + log.getActionTaken() + " ";
		convertedString = convertedString + " $"+ log.getNewCustomerBalance();
		try {
			FileWriter fileWriter = new FileWriter(logFile, true);
			PrintWriter writer = new PrintWriter(fileWriter);
			writer.println(convertedString);
			writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}