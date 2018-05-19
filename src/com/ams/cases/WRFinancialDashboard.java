package com.ams.cases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class WRFinancialDashboard {

	WebDriver driver;
	By emailAddress = By.xpath("//INPUT[@type='email']");
	By password = By.xpath("//INPUT[@type='password']");
	By signInButton = By.xpath("//BUTTON[@type='submit'][text()='Sign me in']");
	By financialDashboard = By.xpath("//*[@id=\"financialdashboard\"]/a[1]");
	By enterAmount = By.xpath("//*[@id=\"reqDiv\"]/form[1]/input[1]");
	By SubmitButton = By.xpath("//*[@id=\"reqDiv\"]/form[1]/button[1]");
	By AvailableAmount = By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div[1]/div[1]/div[1]/h3[1]");

	public WRFinancialDashboard(WebDriver driver) {
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

	public void setAmount(String entAmount) {
		driver.findElement(enterAmount).sendKeys(entAmount);
	}

	public void clkSubmitButton() throws InterruptedException {
		driver.findElement(SubmitButton).click();
		Thread.sleep(3000);
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
	
	public void availableAmountVerification(String intEnterAmount) {
		
		int availableAmountBefore = getAvailableAmountBefore();
		int intEnteredAmount = Integer.parseInt(intEnterAmount);
		System.out.println("Entered Integer Value "+intEnteredAmount);
		
		int finalAvailableAmount = (availableAmountBefore - intEnteredAmount+intEnteredAmount);
		System.out.println("Final Available Amount: " + finalAvailableAmount);
		
		int intAvailableAmountAfter = getAvailableAmountAfter();
		
		Assert.assertEquals(finalAvailableAmount, intAvailableAmountAfter);
		System.out.println("SUCCESS!!!!");
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

		this.setAmount(intEnterAmount);
		System.out.println("Amount Entered");

		this.clkSubmitButton();
		System.out.println("Amount Submitted");
		
		this.getAvailableAmountAfter();
		System.out.println("Get the available amount after");
		
		this.availableAmountVerification(intEnterAmount);
		System.out.println("Assertion Complete");

	}
}
