package com.ams.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WRAssignmentExpiry {

	WebDriver driver;
	By emailAddress = By.xpath("//INPUT[@type='email']");
	By password = By.xpath("//INPUT[@type='password']");
	By signInButton = By.xpath("//BUTTON[@type='submit'][text()='Sign me in']");
	By searchInput = By.xpath("//*[contains(@id,'input')]");
	By actionButton = By.xpath("//MD-ICON[@class='material-icons ng-scope'][text()='menu']");
	By viewButton = By.xpath("//MD-ICON[@class='material-icons ng-scope'][text()='content_copy']");
	By acceptButton = By.xpath("//BUTTON[@class='md-primary md-raised md-button ng-scope md-ink-ripple']");
	By minutesTimer = By.xpath("//*[@id=\"clockdiv\"]/div[3]/span[1]");
	By secondTimer = By.xpath("//*[@id=\"clockdiv\"]/div[4]/span[1]");
	By cancelButton = By.xpath("//BUTTON[@class='md-raised md-button md-ink-ripple']");
	By StatusValue = By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div[1]/div[1]/div[1]/md-table-container[1]/table[1]/tbody[1]/tr[1]/td[9]");

	public WRAssignmentExpiry(WebDriver driver) {
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

	public void clickAcceptButton() {
		driver.findElement(acceptButton).click();
	}
	
	public void timerCheck() throws InterruptedException {
		String minutes = driver.findElement(minutesTimer).getText();
		String seconds = driver.findElement(secondTimer).getText();
		System.out.println("Minutes: "+minutes);
		System.out.println("Seconds: "+seconds);
		
		int resultMinutes = Integer.parseInt(minutes);
		int resultSeconds = Integer.parseInt(seconds);
		
		int finalResult = (resultMinutes*60)+resultSeconds;
		System.out.println("finalResult: "+finalResult);
		
		int resultMiliSecod = finalResult*1000;
		Thread.sleep(resultMiliSecod);
		
		driver.findElement(cancelButton).click();
	}
	
	public void statusVerification() {
		String ExpectedStatusValue = "Expired";
		String ActualStatusValue = driver.findElement(StatusValue).getText();
		Assert.assertEquals(ActualStatusValue, ExpectedStatusValue);
	}
	
	public void amsAssignmentExpiryCheck(String strEmailAddress, String strPassword, String strSearchInput) throws InterruptedException {

		this.setEmailAddress(strEmailAddress);
		System.out.println("Entered Email Address");

		this.setPassword(strPassword);
		System.out.println("Entered Password");

		this.clickSignInButton();
		System.out.println("Clicked on Sign In button");
		
		this.clickSearchInout(strSearchInput);
		System.out.println("Searched with input");
		Thread.sleep(3000);

		this.clickActionButton();
		System.out.println("Clicked action button");
		Thread.sleep(3000);

		this.clickViewButton();
		System.out.println("Clicked view button");
		Thread.sleep(1000);

		this.clickAcceptButton();
		System.out.println("Clicked accept button");
		Thread.sleep(1000);

		this.clickSearchInout(strSearchInput);
		System.out.println("Searched with input");
		Thread.sleep(3000);
		
		this.clickActionButton();
		System.out.println("Clicked action button");
		Thread.sleep(3000);

		this.clickViewButton();
		System.out.println("Clicked view button");
		Thread.sleep(3000);
		
		this.timerCheck();
		System.out.println("Time Finished");
		Thread.sleep(1000);
		
		this.clickSearchInout(strSearchInput);
		System.out.println("Searched with input");
		Thread.sleep(3000);
		
		this.statusVerification();
		System.out.println("Status Verified");
	}
}
