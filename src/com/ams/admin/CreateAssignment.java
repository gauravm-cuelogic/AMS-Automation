package com.ams.admin;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAssignment {

	WebDriver driver;
	By emailAddress = By.xpath("//INPUT[@type='email']");
	By password = By.xpath("//INPUT[@type='password']");
	By signInButton = By.xpath("//BUTTON[@type='submit'][text()='Sign me in']");
	By addAssignmentButton = By.xpath("//BUTTON[@type='button'][text()='Add Assignment']");
	By assignmentTitle = By.xpath("//INPUT[@id='input_21']");
	By calenderInput = By.xpath("//DIV[@class='md-dialog-container ng-scope']");
	By dateSelector = By.xpath("//A[@id='date-2018-05-04']");
	By timeSelector = By.xpath("//BUTTON[@class='dtp-btn-ok md-button md-button md-ink-ripple']");
	By numberOfWords = By.xpath("//INPUT[@id='input_22']");
	By writerPayout = By.xpath("//INPUT[@id='input_23']");
	By proofRederPayout = By.xpath("//INPUT[@id='input_24']");
	By clientId = By.xpath("//INPUT[@id='input_25']");
	By details = By.xpath("//TEXTAREA[@id='input_26']");
	By submitButton = By.xpath("//BUTTON[@type='submit']");

	public CreateAssignment(WebDriver driver) {
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
		Thread.sleep(10000);
	}

	public void clickAddAssignmentButton() throws InterruptedException {
		driver.findElement(addAssignmentButton).click();
		Thread.sleep(10000);
	}

	public void setAssignmentTitle(String strAssignmentTitle) {
		driver.findElement(assignmentTitle).sendKeys(strAssignmentTitle);
	}

	public void clickCalenderInput() throws InterruptedException {
		driver.findElement(calenderInput).click();
		Thread.sleep(10000);
	}

	public void clickDate() throws InterruptedException {
		driver.findElement(dateSelector).click();
		Thread.sleep(10000);
	}

	public void clickTime() throws InterruptedException {
		driver.findElement(timeSelector).click();
		driver.findElement(timeSelector).click();
		Thread.sleep(10000);
	}

	public void setNumberOfWords(String strNumberOfwords) {
		driver.findElement(numberOfWords).sendKeys(strNumberOfwords);
	}

	public void setWrtiterPayOut(String strWriterPayOut) {
		driver.findElement(numberOfWords).sendKeys(strWriterPayOut);
	}

	public void setProofReaderPayOut(String strProofReaderPayOut) {
		driver.findElement(proofRederPayout).sendKeys(strProofReaderPayOut);
	}

	public void setClientId(String strClientId) {
		driver.findElement(clientId).sendKeys(strClientId);
	}

	public void setDetails(String strDetails) {
		driver.findElement(details).sendKeys(strDetails);
	}

	public void clickSubmitButton() throws InterruptedException {
		driver.findElement(submitButton).click();
		Thread.sleep(10000);
	}

	public void amsAddAssignment(String strEmailAddress, String strPassword, String strAssignmentTitle,
			String strNumberOfwords, String strWriterPayOut, String strProofReaderPayOut, String strClientId,
			String strDetails) throws IOException, InterruptedException {

		this.setEmailAddress(strEmailAddress);
		System.out.println("Entered Email Address");

		this.setPassword(strPassword);
		System.out.println("Entered Password");

		this.clickSignInButton();
		System.out.println("Clicked on Sign In button");

		this.clickAddAssignmentButton();
		System.out.println("Clicked on Assignemtn Button");

		this.setAssignmentTitle(strAssignmentTitle);
		System.out.println("Enetered Assignment Title");

		this.clickCalenderInput();
		System.out.println("Calender Opened");
		
		this.clickDate();
		System.out.println("Date Clicked");
		
		this.clickTime();
		System.out.println("Time Clicked");
		
		this.setNumberOfWords(strNumberOfwords);
		System.out.println("Enetered number of words");
		
		this.setWrtiterPayOut(strWriterPayOut);
		System.out.println("Enetered writer pay out");
		
		this.setProofReaderPayOut(strProofReaderPayOut);
		System.out.println("Enetered proof reader  pay out");
		
		this.setClientId(strClientId);
		System.out.println("Enetered client id");
		
		this.setDetails(strDetails);
		System.out.println("Enetered details");
		
		this.clickSubmitButton();
		System.out.println("Clicked on submit button");
	}
}
