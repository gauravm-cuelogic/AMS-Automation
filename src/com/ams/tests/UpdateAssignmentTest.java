package com.ams.tests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ams.tests.CreateAssignmentTest;
import com.ams.cases.UpdateAssignment;

public class UpdateAssignmentTest {

	static WebDriver driver;
	UpdateAssignment objectUpdateAssignment;
	String baseUrl = "http://ams.onestopsoul.com/login";
	//String filePath = "D:\\Gaurav\\AMS - Requirement Understanding & Estimation Document.docx";
	String filePath = "/Users/cuelogic/eclipse-workspace/AMS-Automation/files/Operational Instructions.docx";
	
	@BeforeMethod
	public void setup() {
		String os = System.getProperty("os.name").toLowerCase();
		driver = new ChromeDriver();

		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		}
		
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void test_UpdateAssignment() throws IOException, InterruptedException {  

		String UpdateAssignmentName = CreateAssignmentTest.AssignmentName;
		System.out.println("Updated Assignment Name: "+UpdateAssignmentName);
		objectUpdateAssignment = new UpdateAssignment(driver);
		objectUpdateAssignment.amsUpdateAssignment("writer@gmail.com", "qwerty12", UpdateAssignmentName, filePath);
	}

	@AfterClass
	public static void quit() {
		driver.close();
	}

}