package com.ams.cases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PRFinancialDashboard {

	WebDriver driver;
	By emailAddress = By.xpath("//INPUT[@type='email']");
	By password = By.xpath("//INPUT[@type='password']");
	By signInButton = By.xpath("//BUTTON[@type='submit'][text()='Sign me in']");
	By financialDashboard = By.xpath("//A[@ui-sref='main.settings.financialDashboard'][text()='Financial Dashboard']");
	By enterAmount = By.xpath("//INPUT[@type='number']");
	By SubmitButton = By.xpath("//BUTTON[@type='submit'][text()='Submit']");
	By AvailableAmount = By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div[1]/div[1]/div[1]/h3[1]");

	public PRFinancialDashboard(WebDriver driver) {
		this.driver = driver;
	}

	public void setEmailAddress(String strEmailAddress) {
		driver.findElement(emailAddress).sendKeys(strEmailAddress);
	}

	public void setPassword(String strPassword) {
		driver.findElement(password).sendKeys(strPassword);
	}

	public void clickSignInButton() throws InterruptedException {
		driver.findElement(signInButton).click();
		Thread.sleep(5000);
	}

	public void clkfinancialDashboard() throws InterruptedException {
		driver.findElement(financialDashboard).click();
		Thread.sleep(3000);
	}
	
	public int getAvailableAmountBefore() {
	
		String availableAmountBefore = driver
				.findElement(AvailableAmount).getText();
		System.out.println("Before Available Amount is: " + availableAmountBefore);

		String[] splitedAvailableAmountBefore = availableAmountBefore.split("\\s+");
		System.out.println("Amount splited before: "+splitedAvailableAmountBefore[1]);

		int intAvailableAmountBefore = Integer.parseInt(splitedAvailableAmountBefore[1]);
		System.out.println("Before Integer Value "+intAvailableAmountBefore);
		
		return intAvailableAmountBefore;
	}
	
	public int getFinalAmountInteger(String intEnterAmount) {
		
		int availableAmountBefore = getAvailableAmountBefore();
		int intEnteredAmount = Integer.parseInt(intEnterAmount);
		System.out.println("Entered Integer Value "+intEnteredAmount);
		int finalAvailableAmount = (availableAmountBefore - intEnteredAmount);
		System.out.println("Final Available Amount: " + finalAvailableAmount);
		return finalAvailableAmount;
	}

	public void setAmount(String entAmount) {
		driver.findElement(enterAmount).sendKeys(entAmount);
	}

	public void clkSubmitButton() throws InterruptedException {
		driver.findElement(SubmitButton).click();
		driver.navigate().refresh();
		Thread.sleep(5000);
	}
	
	public int getAvailableAmountAfter() {
		String availableAmountAfter = driver
				.findElement(AvailableAmount).getText();
		System.out.println("After Available Amount is: " + availableAmountAfter);

		String[] splitedAvailableAmountAfter = availableAmountAfter.split("\\s+");
		System.out.println("Amount splited after: "+splitedAvailableAmountAfter[1]);

		int intAvailableAmountAfter = Integer.parseInt(splitedAvailableAmountAfter[1]);
		System.out.println("After Integer Value"+intAvailableAmountAfter);
		return intAvailableAmountAfter;
	}

	public void financialDashboard(String strEmailAddress, String strPassword, String intEnterAmount) throws IOException, InterruptedException {

		this.setEmailAddress(strEmailAddress);
		System.out.println("Entered Email Address");

		this.setPassword(strPassword);
		System.out.println("Entered Password");

		this.clickSignInButton();
		System.out.println("Clicked on Sign In button");

		this.clkfinancialDashboard();
		System.out.println("Clicked on Financial Dashboard");
		
		this.getAvailableAmountBefore();
		System.out.println("Get the available amount before");
		
		this.getFinalAmountInteger(intEnterAmount);
		System.out.println("Got the final integer value");

		this.setAmount(intEnterAmount);
		System.out.println("Amount Entered");

		this.clkSubmitButton();
		System.out.println("Amount Submitted");
		
		this.getAvailableAmountAfter();
		System.out.println("Get the available amount after");

	}
}
