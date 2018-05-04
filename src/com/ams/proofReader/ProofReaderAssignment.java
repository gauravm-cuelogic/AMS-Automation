package com.ams.proofReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProofReaderAssignment {

	WebDriver driver;
	By emailAddress = By.xpath("//INPUT[@type='email']");
	By password = By.xpath("//INPUT[@type='password']");
	By signInButton = By.xpath("//BUTTON[@type='submit'][text()='Sign me in']");
	By searchInput = By.xpath("//*[contains(@id,'input')]");
	By actionButton = By.xpath("//MD-ICON[@class='material-icons ng-scope'][text()='menu']");
	By viewButton = By.xpath("//MD-ICON[@class='material-icons ng-scope'][text()='content_copy']");
	By acceptButton = By.xpath("//BUTTON[@class='md-primary md-raised md-button ng-scope md-ink-ripple']");
	By chooseFileButton = By.xpath("//*[contains(@id,'input')]");
	By submitButton = By.xpath("//*[@id=\"content\"]/div[2]/div[1]/md-card[1]/md-card-content[1]/div[1]/form[1]/div[2]/button[2]");
	
	public ProofReaderAssignment(WebDriver driver) {
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

	public void setChooseFileButton(String filePath) {
		driver.findElement(chooseFileButton).sendKeys(filePath);
	}
	
	public void clickSubmitButton() {
		driver.findElement(submitButton).click();
	}

	public void amsProofReaderAssignment(String strEmailAddress, String strPassword, String strSearchInput, String filePath) throws InterruptedException {

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
		Thread.sleep(1000);

		this.clickAcceptButton();
		System.out.println("Clicked accept button");
		Thread.sleep(1000);

		this.clickSearchInout(strSearchInput);
		System.out.println("Searched with input");
		Thread.sleep(1000);

		this.clickActionButton();
		System.out.println("Clicked action button");
		Thread.sleep(1000);

		this.clickViewButton();
		System.out.println("Clicked view button");
		Thread.sleep(1000);

		this.setChooseFileButton(filePath);
		System.out.println("Browse pop up opened");
		Thread.sleep(1000);
		
		this.clickSubmitButton();
		System.out.println("Clicked on submit button");
		Thread.sleep(1000);
	}
}
