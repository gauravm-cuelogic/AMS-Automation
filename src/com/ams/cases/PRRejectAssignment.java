package com.ams.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PRRejectAssignment {

	WebDriver driver;
	By emailAddress = By.xpath("//INPUT[@type='email']");
	By password = By.xpath("//INPUT[@type='password']");
	By signInButton = By.xpath("//BUTTON[@type='submit'][text()='Sign me in']");
	By searchInput = By.xpath("//*[contains(@id,'input')]");
	By actionButton = By.xpath("//MD-ICON[@class='material-icons ng-scope'][text()='menu']");
	By viewButton = By.xpath("//MD-ICON[@class='material-icons ng-scope'][text()='content_copy']");
	By rejectButton = By.xpath("//*[@id=\"content\"]/div[2]/div[1]/md-card[1]/md-card-content[1]/div[1]/form[1]/div[2]/button[3]");
	By verifyRejectedAssignment = By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div[1]/div[1]/div[1]/md-table-container[1]/table[1]/tbody[1]/tr[1]/td[9]");
	
	public PRRejectAssignment(WebDriver driver) {
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
	
	public void clickSearchInout(String strSearchInput) {
		driver.findElement(searchInput).sendKeys(strSearchInput);
	}

	public void clickActionButton() {
		driver.findElement(actionButton).click();
	}

	public void clickViewButton() {
		driver.findElement(viewButton).click();
	}
	
	public void clickRejectButton() {
		driver.findElement(rejectButton).click();
	}
	
	public void verifyRejectedAssignment() {
		
		String ExpectedText = "Rejected by Proofreader";
		String VerifyRejectedAssignment = driver.findElement(verifyRejectedAssignment).getText();
		System.out.println("Status of Rejected File"+VerifyRejectedAssignment);
		Assert.assertEquals(VerifyRejectedAssignment, ExpectedText);
	}
	
	public void amsPRRejectAssignment(String strEmailAddress, String strPassword, String strSearchInput) throws InterruptedException {

		this.setEmailAddress(strEmailAddress);
		System.out.println("Entered Email Address");

		this.setPassword(strPassword);
		System.out.println("Entered Password");

		this.clickSignInButton();
		System.out.println("Clicked on Sign In button");
		
		this.clickSearchInout(strSearchInput);
		System.out.println("Searched with input");
		Thread.sleep(1000);

		this.clickActionButton();
		System.out.println("Clicked action button");
		Thread.sleep(3000);

		this.clickViewButton();
		System.out.println("Clicked view button");
		Thread.sleep(2000);

		this.clickRejectButton();
		System.out.println("Clicked reject button");
		Thread.sleep(2000);
		
		this.clickSearchInout(strSearchInput);
		System.out.println("Searched with input");
		Thread.sleep(1000);
		
		this.verifyRejectedAssignment();
		System.out.println("Assignement Rejected Successfully");
	}
}


