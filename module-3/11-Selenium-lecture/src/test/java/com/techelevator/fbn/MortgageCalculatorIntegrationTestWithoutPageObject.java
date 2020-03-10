package com.techelevator.fbn;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class MortgageCalculatorIntegrationTestWithoutPageObject {

	private static WebDriver webDriver;
	private final static int SLEEP_TIME = 2000;
	
	/* Creating an instance of the WebDriver is time consuming
	 * since it opens up a browser window. Therefore, we do this
	 * only once at the start of the class and reuse the same
	 * browser window for all tests. */
	@BeforeClass
	public static void openWebBrowserForTesting() {
		
		String homeDir = System.getProperty("user.home");
		/* The ChromeDriver requires a system property with the name "webdriver.chrome.driver" that
		 * contains the directory path to the ChromeDriver executable. The following line assumes
		 * we have installed the ChromeDriver in a known location under our home directory */
		System.setProperty("webdriver.chrome.driver", homeDir+"/Development/Programs/chromedriver");
		webDriver = new ChromeDriver();
	}

	@Before
	public void openHomePage() {
		webDriver.get("http://localhost:8080/selenium-lecture/");
	}
	
	@AfterClass
	public static void closeWebBrowser() {
		webDriver.close();
	}
	
	/* In order for Selenium to interact with a web page, it needs to be
	 * able to locate elements within the page. It does this using the 
	 * WebDriver.findElementBy(...) and WebDriver.findElementsBy(...)
	 * methods. Both of these elements take a org.openqa.selenium.By
	 * object as an argument. The following static methods return
	 * By objects for different kinds of element queries:
	 * 
	 *  - By.className(String className)
	 *  - By.cssSelector(String selector)
	 *  - By.id(String id)
	 *  - By.linkText(String linkText)
	 *  - By.name(String name)
	 *  - By.tagName(String name)
	 */
	
	@Test
	/* Whenever possible, it is best to find page elements using the
	 * HTML id attribute since this is the most efficient. Remember
	 * that the element id is supposed to be unique per page */
	public void elements_can_be_found_by_id() {
		System.out.println("Checking to make sure we can find page elements...");
		sleepForDemoPurposes(SLEEP_TIME);
		WebElement savingsH2 = webDriver.findElement(By.id("savings"));
		WebElement checkingH2 = webDriver.findElement(By.id("checkings"));
		WebElement loansH2 = webDriver.findElement(By.id("loans"));
		assertEquals("Start Saving", savingsH2.getText());
		assertEquals("Open Checking", checkingH2.getText());
		assertEquals("Loans", loansH2.getText());
	}

	@Test
	public void single_elements_can_be_found_by_tag_name() {
		System.out.println("Checking header and footer...");
		sleepForDemoPurposes(SLEEP_TIME);
		WebElement header = webDriver.findElement(By.tagName("header"));
		WebElement footer = webDriver.findElement(By.tagName("footer"));
		assertNotNull(header);
		assertNotNull(footer);
	}
	
	@Test
	public void multiple_elements_can_be_found_by_tag_name() {
		sleepForDemoPurposes(SLEEP_TIME);
		List<WebElement> sections = webDriver.findElements(By.tagName("section"));
		sleepForDemoPurposes(SLEEP_TIME);
		assertEquals(3, sections.size());
		for(WebElement section : sections) {
			assertEquals("account", section.getAttribute("class"));
		}
		sleepForDemoPurposes(SLEEP_TIME);
	}
	
	@Test
	public void pages_can_be_navigated_by_clicking_on_links() {
		// Link elements (i.e. <a> tags) can be found based on their text
		System.out.println("Checking to make sure we can find/cick mortgage calcuator link...");
		sleepForDemoPurposes(SLEEP_TIME);
		WebElement calculatorLink = webDriver.findElement(By.linkText("Mortgage Payment Calculator"));
		sleepForDemoPurposes(SLEEP_TIME);
		calculatorLink.click();
		sleepForDemoPurposes(SLEEP_TIME);
		// The getTitle() method returns the value of the page title
		assertTrue(webDriver.getTitle().endsWith("Mortgage Calculator"));
		WebElement h2 = webDriver.findElement(By.tagName("h2"));
		assertEquals("Mortgage Calculator", h2.getText());
		System.out.println("Mortgage calculator found...");
	}
	
	@Test
	public void forms_can_be_edited_and_submitted() {
		sleepForDemoPurposes(SLEEP_TIME);
		
		WebElement calculatorLink = webDriver.findElement(By.linkText("Mortgage Payment Calculator"));
		sleepForDemoPurposes(SLEEP_TIME);
		calculatorLink.click();
		sleepForDemoPurposes(SLEEP_TIME);
		System.out.println("Filling out form...");
		WebElement amountField = webDriver.findElement(By.name("loanAmount"));
		// The sendKeys(...) method can be used to simulate typing in a field
		sleepForDemoPurposes(SLEEP_TIME);
		amountField.sendKeys("100000");
		sleepForDemoPurposes(SLEEP_TIME);
		// To interact with a <select> element, wrap the WebElement in a Select object
		Select termField = new Select(webDriver.findElement(By.name("loanTerm")));
		sleepForDemoPurposes(SLEEP_TIME);
		termField.selectByVisibleText("15 Years");
		sleepForDemoPurposes(SLEEP_TIME);
		WebElement interestField = webDriver.findElement(By.name("rate"));
		sleepForDemoPurposes(SLEEP_TIME);
		interestField.sendKeys("4.5");
		sleepForDemoPurposes(SLEEP_TIME);
		WebElement submitButton = webDriver.findElement(By.className("formSubmitButton"));
		sleepForDemoPurposes(SLEEP_TIME);
		System.out.println("Submitting form...");
		submitButton.click();
		
		/* Elements without an id can be found using an xPath expression.
		 * However, finding elements by xPath should generally be avoided 
		 * as it is slow and makes for brittle tests. */
		WebElement paymentValueTd = webDriver.findElement(By.xpath("//table[@id=\"loanPaymentCalculationResults\"]//tr[4]/td"));
		System.out.println("Testing Form Results...");
		assertEquals("$764.99", paymentValueTd.getText());
		sleepForDemoPurposes(20000);  // keep browser open for awhile
	}
	
	
	private void sleepForDemoPurposes(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// Ignore...
		}
	}
}
