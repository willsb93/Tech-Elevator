package com.techelevator.fbn.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver webDriver;
	private final static int SLEEP_TIME = 2000;

	public HomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public MortgageCalculatorInputPage clickMortgageCalculatorLink() {
		sleepForDemoPurposes(SLEEP_TIME);
		WebElement calculatorLink = webDriver.findElement(By.linkText("Mortgage Payment Calculator"));
		sleepForDemoPurposes(SLEEP_TIME);
		calculatorLink.click();
		sleepForDemoPurposes(SLEEP_TIME);
		return new MortgageCalculatorInputPage(webDriver);
	}
	
	public CheckingAppPersonalInfoPage clickCheckingAccountApplicationLink() {
		WebElement calculatorLink = webDriver.findElement(By.linkText("Open a New Account"));
		sleepForDemoPurposes(SLEEP_TIME);
		calculatorLink.click();
		sleepForDemoPurposes(SLEEP_TIME);
		return new CheckingAppPersonalInfoPage(webDriver);
	}
	
	private void sleepForDemoPurposes(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// Ignore...
		}
	}	
}
