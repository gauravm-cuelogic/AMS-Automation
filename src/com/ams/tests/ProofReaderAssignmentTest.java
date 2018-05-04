package com.ams.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ams.cases.ProofReaderAssignment;

public class ProofReaderAssignmentTest {
	static WebDriver driver;
	ProofReaderAssignment objectProofReaderAssignment;
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
	public void test_ProofReaderAssignment() throws IOException, InterruptedException {

		objectProofReaderAssignment = new ProofReaderAssignment(driver);
		objectProofReaderAssignment.amsProofReaderAssignment("proofreader@gmail.com", "qwerty12", "ROR Framework", filePath);
	}
	
	@AfterClass
	public static void quit() {
		driver.close();
	}
}
