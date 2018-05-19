package com.ams.cases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.Date; 
import java.text.SimpleDateFormat; 

public class CreateAssignment {

	//*[@id="date-2018-05-13"]
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm a"); 
	Date date = new Date();  
	String DateandTime1 = formatter.format(date); 
	String[] InputDate = DateandTime1.split(" ");
	String [] InputDateSplit = InputDate[1].split(" ");
	String InputTimeSplit = InputDateSplit[0];
	String[] InputHourAndMinutes = InputTimeSplit.split(":");
	
	WebDriver driver;
	By emailAddress = By.xpath("//INPUT[@type='email']");
	By password = By.xpath("//INPUT[@type='password']");
	By signInButton = By.xpath("//BUTTON[@type='submit'][text()='Sign me in']");
	By addAssignmentButton = By.xpath("//BUTTON[@type='button'][text()='Add Assignment']");
	By assignmentTitle = By.xpath("//INPUT[@id='input_21']");
	By calenderInput = By.xpath("//*[@id=\"deadline\"]");
	By dateSelector = By.xpath("//*[@id=\"date-"+InputDate[0]+"\"]");
	//By inputDate = By.xpath("//*[@id=\"time-hours-"+InputHourAndMinutes[0].charAt(1)+"\"]");
	//By inputTime = By.xpath("//*[@id=\"time-minutes-"+numberAsString+"\"]");
	By oKButton = By.xpath("//BUTTON[@class='dtp-btn-ok md-button md-button md-ink-ripple']");
	By numberOfWords = By.xpath("//INPUT[@id='input_22']");
	By writerPayout = By.xpath("//INPUT[@id='input_23']");
	By proofRederPayout = By.xpath("//INPUT[@id='input_24']");
	By clientId = By.xpath("//INPUT[@id='input_25']");
	By details = By.xpath("//TEXTAREA[@id='input_26']");
	By submitButton = By.xpath("//BUTTON[@type='submit']");
	By getAssignmentTitle = By.xpath("//DIV[@wrap-data='item.title']");
	By searchInput = By.xpath("//*[contains(@id,'input')]");
	By cancelButton = By.xpath("//BUTTON[@class='dtp-btn-cancel md-button md-button md-ink-ripple']");

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
		Thread.sleep(5000);
	}

	public void clickAddAssignmentButton() throws InterruptedException {
		driver.findElement(addAssignmentButton).click();
		Thread.sleep(5000);
	}

	public void setAssignmentTitle(String strAssignmentTitle) {
		driver.findElement(assignmentTitle).sendKeys(strAssignmentTitle);
	}

	public void setCalenderInput() throws InterruptedException {
		driver.findElement(calenderInput).click();
		Thread.sleep(5000);
	}

	public void clickDate() throws InterruptedException {
		System.out.println("Full Date & Time :"+DateandTime1);
		System.out.println("Current Date :"+InputDate[0]);
		driver.findElement(dateSelector).click();
		Thread.sleep(5000);
	}

	public void clickHourMinutes() throws InterruptedException {
		if(InputHourAndMinutes[0].charAt(0)=='0') {
			System.out.println("InputHour1: "+InputHourAndMinutes[0].charAt(1));
			By inputDate1 = By.xpath("//*[@id=\"time-hours-"+InputHourAndMinutes[0].charAt(1)+"\"]");
			driver.findElement(inputDate1).click();
		}else {
			System.out.println("InputHour2: "+InputHourAndMinutes[0]);
			By inputDate2 = By.xpath("//*[@id=\"time-hours-"+InputHourAndMinutes[0]+"\"]");
			driver.findElement(inputDate2).click();
		}
		Thread.sleep(2000);
		if(InputHourAndMinutes[1].charAt(1)=='1') {
			int intResult1 = Integer.parseInt(InputHourAndMinutes[1]);
			int result1 = intResult1 + 9;
			if(result1==60) {
				driver.findElement(cancelButton).click();
				int intResultHour1 = Integer.parseInt(InputHourAndMinutes[0]);
				int hour1 = intResultHour1+1;
				String numberResultHour1 = new Integer(hour1).toString();
				if(numberResultHour1.charAt(0)=='0') {
					By inputTimeMax11 = By.xpath("//*[@id=\"time-hours-"+numberResultHour1.charAt(1)+"\"]");
					driver.findElement(inputTimeMax11).click();
				}else {
					By inputTimeMax12 = By.xpath("//*[@id=\"time-hours-"+numberResultHour1+"\"]");
					driver.findElement(inputTimeMax12).click();
				}
			}else {
			String numberAsString1 = new Integer(result1).toString();
			System.out.println("InputTime1: "+numberAsString1);
			By inputTime1 = By.xpath("//*[@id=\"time-minutes-"+numberAsString1+"\"]");
			driver.findElement(inputTime1).click();
			}
		}else if(InputHourAndMinutes[1].charAt(1)=='2') {
			int intResult2 = Integer.parseInt(InputHourAndMinutes[1]);
			int result2 = intResult2 + 8;
			if(result2==60) {
				driver.findElement(cancelButton).click();
				int intResultHour2 = Integer.parseInt(InputHourAndMinutes[0]);
				int hour2 = intResultHour2+1;
				String numberResultHour2 = new Integer(hour2).toString();
				if(numberResultHour2.charAt(0)=='0') {
					By inputTimeMax21 = By.xpath("//*[@id=\"time-hours-"+numberResultHour2.charAt(1)+"\"]");
					driver.findElement(inputTimeMax21).click();
				}else {
					By inputTimeMax22 = By.xpath("//*[@id=\"time-hours-"+numberResultHour2+"\"]");
					driver.findElement(inputTimeMax22).click();
				}
			}else {
			String numberAsString2 = new Integer(result2).toString();
			System.out.println("InputTime2: "+numberAsString2);
			By inputTime2 = By.xpath("//*[@id=\"time-minutes-"+numberAsString2+"\"]");
			driver.findElement(inputTime2).click();
			}
		}else if(InputHourAndMinutes[1].charAt(1)=='3') {
			int intResult3 = Integer.parseInt(InputHourAndMinutes[1]);
			int result3 = intResult3 + 7;
			if(result3==60) {
				driver.findElement(cancelButton).click();
				int intResultHour3 = Integer.parseInt(InputHourAndMinutes[0]);
				int hour3 = intResultHour3+1;
				String numberResultHour3 = new Integer(hour3).toString();
				if(numberResultHour3.charAt(0)=='0') {
					By inputTimeMax31 = By.xpath("//*[@id=\"time-hours-"+numberResultHour3.charAt(1)+"\"]");
					driver.findElement(inputTimeMax31).click();
				}else {
					By inputTimeMax32 = By.xpath("//*[@id=\"time-hours-"+numberResultHour3+"\"]");
					driver.findElement(inputTimeMax32).click();
				}
			}else {
			String numberAsString3 = new Integer(result3).toString();
			System.out.println("InputTime3: "+numberAsString3);
			By inputTime3 = By.xpath("//*[@id=\"time-minutes-"+numberAsString3+"\"]");
			driver.findElement(inputTime3).click();
			}
		}else if(InputHourAndMinutes[1].charAt(1)=='4') {
			int intResult4 = Integer.parseInt(InputHourAndMinutes[1]);
			int result4 = intResult4 + 6;
			if(result4==60) {
				driver.findElement(cancelButton).click();
				int intResultHour4 = Integer.parseInt(InputHourAndMinutes[0]);
				int hour4 = intResultHour4+1;
				String numberResultHour4 = new Integer(hour4).toString();
				if(numberResultHour4.charAt(0)=='0') {
					By inputTimeMax41 = By.xpath("//*[@id=\"time-hours-"+numberResultHour4.charAt(1)+"\"]");
					driver.findElement(inputTimeMax41).click();
				}else {
					By inputTimeMax42 = By.xpath("//*[@id=\"time-hours-"+numberResultHour4+"\"]");
					driver.findElement(inputTimeMax42).click();
				}
			}else {
			String numberAsString4 = new Integer(result4).toString();
			System.out.println("InputTime4: "+numberAsString4);
			By inputTime4 = By.xpath("//*[@id=\"time-minutes-"+numberAsString4+"\"]");
			driver.findElement(inputTime4).click();
			}
		}else if(InputHourAndMinutes[1].charAt(1)=='5') {
			int intResult5 = Integer.parseInt(InputHourAndMinutes[1]);
			int result5 = intResult5 + 5;
			if(result5==60) {
				driver.findElement(cancelButton).click();
				int intResultHour5 = Integer.parseInt(InputHourAndMinutes[0]);
				int hour5 = intResultHour5+1;
				String numberResultHour5 = new Integer(hour5).toString();
				if(numberResultHour5.charAt(0)=='0') {
					By inputTimeMax51 = By.xpath("//*[@id=\"time-hours-"+numberResultHour5.charAt(1)+"\"]");
					driver.findElement(inputTimeMax51).click();
				}else {
					By inputTimeMax52 = By.xpath("//*[@id=\"time-hours-"+numberResultHour5+"\"]");
					driver.findElement(inputTimeMax52).click();
				}
			}else {
			String numberAsString5 = new Integer(result5).toString();
			System.out.println("InputTime5: "+numberAsString5);
			By inputTime5 = By.xpath("//*[@id=\"time-minutes-"+numberAsString5+"\"]");
			driver.findElement(inputTime5).click();
			}
		}else if(InputHourAndMinutes[1].charAt(1)=='6') {
			int intResult6 = Integer.parseInt(InputHourAndMinutes[1]);
			int result6 = intResult6 + 9;
			if(result6==65) {
				driver.findElement(cancelButton).click();
				int intResultHour6 = Integer.parseInt(InputHourAndMinutes[0]);
				int hour4 = intResultHour6+1;
				String numberResultHour6 = new Integer(hour4).toString();
				if(numberResultHour6.charAt(0)=='0') {
					By inputTimeMax61 = By.xpath("//*[@id=\"time-hours-"+numberResultHour6.charAt(1)+"\"]");
					driver.findElement(inputTimeMax61).click();
				}else {
					By inputTimeMax62 = By.xpath("//*[@id=\"time-hours-"+numberResultHour6+"\"]");
					driver.findElement(inputTimeMax62).click();
				}
			}else {
			String numberAsString6 = new Integer(result6).toString();
			System.out.println("InputTime6: "+numberAsString6);
			By inputTime6 = By.xpath("//*[@id=\"time-minutes-"+numberAsString6+"\"]");
			driver.findElement(inputTime6).click();
			}
		}else if(InputHourAndMinutes[1].charAt(1)=='7') {
			int intResult7 = Integer.parseInt(InputHourAndMinutes[1]);
			int result7 = intResult7 + 8;
			if(result7==65) {
				driver.findElement(cancelButton).click();
				int intResultHour7 = Integer.parseInt(InputHourAndMinutes[0]);
				int hour7 = intResultHour7+1;
				String numberResultHour7 = new Integer(hour7).toString();
				if(numberResultHour7.charAt(0)=='0') {
					By inputTimeMax71 = By.xpath("//*[@id=\"time-hours-"+numberResultHour7.charAt(1)+"\"]");
					driver.findElement(inputTimeMax71).click();
				}else {
					By inputTimeMax72 = By.xpath("//*[@id=\"time-hours-"+numberResultHour7+"\"]");
					driver.findElement(inputTimeMax72).click();
				}
			}else {
			String numberAsString7 = new Integer(result7).toString();
			System.out.println("InputTime7: "+numberAsString7);
			By inputTime7 = By.xpath("//*[@id=\"time-minutes-"+numberAsString7+"\"]");
			driver.findElement(inputTime7).click();
			}
		}else if(InputHourAndMinutes[1].charAt(1)=='8') {
			int intResult8 = Integer.parseInt(InputHourAndMinutes[1]);
			int result8 = intResult8 + 7;
			if(result8==65) {
				driver.findElement(cancelButton).click();
				int intResultHour8 = Integer.parseInt(InputHourAndMinutes[0]);
				int hour8 = intResultHour8+1;
				String numberResultHour8 = new Integer(hour8).toString();
				if(numberResultHour8.charAt(0)=='0') {
					By inputTimeMax81 = By.xpath("//*[@id=\"time-hours-"+numberResultHour8.charAt(1)+"\"]");
					driver.findElement(inputTimeMax81).click();
				}else {
					By inputTimeMax82 = By.xpath("//*[@id=\"time-hours-"+numberResultHour8+"\"]");
					driver.findElement(inputTimeMax82).click();
				}
			}else {
			String numberAsString8 = new Integer(result8).toString();
			System.out.println("InputTime8: "+numberAsString8);
			By inputTime8 = By.xpath("//*[@id=\"time-minutes-"+numberAsString8+"\"]");
			driver.findElement(inputTime8).click();
			}
		}else if(InputHourAndMinutes[1].charAt(1)=='9') {
			int intResult9 = Integer.parseInt(InputHourAndMinutes[1]);
			int result9 = intResult9 + 6;
			if(result9==65) {
				driver.findElement(cancelButton).click();
				int intResultHour9 = Integer.parseInt(InputHourAndMinutes[0]);
				int hour9 = intResultHour9+1;
				String numberResultHour9 = new Integer(hour9).toString();
				if(numberResultHour9.charAt(0)=='0') {
					By inputTimeMax91 = By.xpath("//*[@id=\"time-hours-"+numberResultHour9.charAt(1)+"\"]");
					driver.findElement(inputTimeMax91).click();
				}else {
					By inputTimeMax92 = By.xpath("//*[@id=\"time-hours-"+numberResultHour9+"\"]");
					driver.findElement(inputTimeMax92).click();
				}
			}else {
			String numberAsString9 = new Integer(result9).toString();
			System.out.println("InputTime9: "+numberAsString9);
			By inputTime9 = By.xpath("//*[@id=\"time-minutes-"+numberAsString9+"\"]");
			driver.findElement(inputTime9).click();
			}
		}else if(InputHourAndMinutes[1].charAt(1)=='0') {
			int intResult0 = Integer.parseInt(InputHourAndMinutes[1]);
			int result0 = intResult0 + 5;
			if(result0==65) {
				driver.findElement(cancelButton).click();
				int intResultHour0 = Integer.parseInt(InputHourAndMinutes[0]);
				int hour0 = intResultHour0+1;
				String numberResultHour0 = new Integer(hour0).toString();
				if(numberResultHour0.charAt(0)=='0') {
					By inputTimeMax01 = By.xpath("//*[@id=\"time-hours-"+numberResultHour0.charAt(1)+"\"]");
					driver.findElement(inputTimeMax01).click();
				}else {
					By inputTimeMax02 = By.xpath("//*[@id=\"time-hours-"+numberResultHour0+"\"]");
					driver.findElement(inputTimeMax02).click();
				}
			}else {
			String numberAsString0 = new Integer(result0).toString();
			System.out.println("InputTime0: "+numberAsString0);
			By inputTime0 = By.xpath("//*[@id=\"time-minutes-"+numberAsString0+"\"]");
			driver.findElement(inputTime0).click();
			}
		}
		Thread.sleep(2000);
		driver.findElement(oKButton).click();
		Thread.sleep(2000);
	}

	public void setNumberOfWords(String strNumberOfwords) throws InterruptedException {
		driver.findElement(numberOfWords).sendKeys(strNumberOfwords);
		Thread.sleep(1000);
	}

	public void setWrtiterPayOut(String strWriterPayOut) throws InterruptedException {
		driver.findElement(writerPayout).sendKeys(strWriterPayOut);
		Thread.sleep(1000);
	}

	public void setProofReaderPayOut(String strProofReaderPayOut) throws InterruptedException {
		driver.findElement(proofRederPayout).sendKeys(strProofReaderPayOut);
		Thread.sleep(1000);
	}

	public void setClientId(String strClientId) throws InterruptedException {
		driver.findElement(clientId).sendKeys(strClientId);
		Thread.sleep(1000);
	}

	public void setDetails(String strDetails) throws InterruptedException {
		driver.findElement(details).sendKeys(strDetails);
		Thread.sleep(1000);
	}

	public void clickSubmitButton() throws InterruptedException {
		driver.findElement(submitButton).click();
		Thread.sleep(5000);
	}
	
	public void getAssignemtTitle(String strAssignmentTitle) throws InterruptedException {
		driver.findElement(searchInput).sendKeys(strAssignmentTitle);
		Thread.sleep(1000);
		String assignementName = driver.findElement(getAssignmentTitle).getText();
		Assert.assertEquals(strAssignmentTitle, assignementName);
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

		this.setCalenderInput();
		System.out.println("Clicked on Calender");
		
		this.clickDate();
		System.out.println("Date Clicked");
		
		this.clickHourMinutes();
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
		
		this.getAssignemtTitle(strAssignmentTitle);
		System.out.println("Assignement created successfully");
	}
}
