package com.ams.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ams.cases.UpdateAssignment;

public class UpdateAssignmentTest {

	static WebDriver driver;
	UpdateAssignment objectUpdateAssignment;
	String baseUrl = "http://ams.onestopsoul.com/login";
	String filePath = "D:\\Gaurav\\AMS - Requirement Understanding & Estimation Document.docx";

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Gaurav\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void test_UPdateAssignment() throws IOException, InterruptedException {  

		objectUpdateAssignment = new UpdateAssignment(driver);
		objectUpdateAssignment.amsUpdateAssignment("writer@gmail.com", "qwerty12", "Maven Framework", filePath);
	}

	@AfterClass
	public static void quit() {
		driver.close();
	}

}