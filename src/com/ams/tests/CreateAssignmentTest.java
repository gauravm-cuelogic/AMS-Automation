package com.ams.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ams.cases.CreateAssignment;

public class CreateAssignmentTest {

	static WebDriver driver;
	CreateAssignment objectCreateAssignment;
	String baseUrl = "http://ams.onestopsoul.com/login";

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Gaurav\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void test_CreateAssignment() throws IOException, InterruptedException {

		objectCreateAssignment = new CreateAssignment(driver);
		objectCreateAssignment.amsAddAssignment("admin@gmail.com", "qwerty12", "Maven Framework", "50",
				"50", "50", "H1", "Maven Framework");
	}
	
	@AfterClass
	public static void quit() {
		driver.close();
	}
}
