package com.techelevator.fbn.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MortgageCalculatorInputPage {

	private WebDriver webDriver;
	private final static int SLEEP_TIME = 2000;

	public MortgageCalculatorInputPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public MortgageCalculatorInputPage enterLoanAmount(String loanAmount) {
		sleepForDemoPurposes(SLEEP_TIME);
		WebElement amountField = webDriver.findElement(By.name("loanAmount"));
		sleepForDemoPurposes(SLEEP_TIME);
		amountField.sendKeys(loanAmount);
		sleepForDemoPurposes(SLEEP_TIME);
		return this;
	}
	
	public MortgageCalculatorInputPage enterLoanTerm(String loanTerm) {
		sleepForDemoPurposes(SLEEP_TIME);
		Select termField = new Select(webDriver.findElement(By.name("loanTerm")));
		sleepForDemoPurposes(SLEEP_TIME);
		termField.selectByVisibleText(loanTerm);
		sleepForDemoPurposes(SLEEP_TIME);
		return this;
	}
	
	public MortgageCalculatorInputPage enterInterestRate(String rate) {
		sleepForDemoPurposes(SLEEP_TIME);
		WebElement amountField = webDriver.findElement(By.name("rate"));
		sleepForDemoPurposes(SLEEP_TIME);
		amountField.sendKeys(rate);
		sleepForDemoPurposes(SLEEP_TIME);
		return this;
	}
	
	public MortgageCalculatorResultPage submitForm() {
		sleepForDemoPurposes(SLEEP_TIME);
		WebElement submitButton = webDriver.findElement(By.className("formSubmitButton"));
		sleepForDemoPurposes(SLEEP_TIME);
		submitButton.click();
		sleepForDemoPurposes(SLEEP_TIME);
		return new MortgageCalculatorResultPage(webDriver);
	}
	
	private void sleepForDemoPurposes(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// Ignore...
		}
	}	
}
