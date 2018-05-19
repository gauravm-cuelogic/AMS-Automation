package com.ams.tests;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ams.cases.CreateAssignment;
import com.ams.cases.UpdateAssignment;
import com.ams.cases.PRRejectAssignment;

public class PRRejectAssignmentTest {

	static WebDriver driver;
	CreateAssignment objectCreateAssignment;
	UpdateAssignment objectUpdateAssignment;
	PRRejectAssignment objectRejectAssignment;
	String baseUrl = "http://ams.onestopsoul.com/login";
	String filePath = "/Users/cuelogic/eclipse-workspace/AMS-Automation/files/Operational Instructions.docx";
	static String AssignmentName;
	
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
	
	@Test(priority=1)
	public void test_AddAssignment() throws IOException, InterruptedException {  

		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String randomString = "";
		Random random = new Random();
		int randomLen = 5 + random.nextInt(9);
		for (int i = 0; i < randomLen; i++) {
			char c = alphabet.charAt(random.nextInt(26));
			randomString += c;
		}
		AssignmentName = randomString;
		System.out.println("Random Generated String: " + AssignmentName);
		
		//Add Assignment
		objectCreateAssignment = new CreateAssignment(driver);
		objectCreateAssignment.amsAddAssignment("admin@gmail.com", "qwerty12", AssignmentName, "50", "50", "50",
				"H1", AssignmentName);
		
		driver.close();
	}
	
	@Test(priority=2)
	public void test_UpdateAssignment() throws IOException, InterruptedException {  
		
		//Update Assignment
		objectUpdateAssignment = new UpdateAssignment(driver);
		objectUpdateAssignment.amsUpdateAssignment("writer@gmail.com", "qwerty12", AssignmentName, filePath);
	
		driver.close();
	}
	
	@Test(priority=3)
	public void test_RejectAssignment() throws IOException, InterruptedException {  
		
		//Reject Assignment
		objectRejectAssignment = new PRRejectAssignment(driver);
		objectRejectAssignment.amsPRRejectAssignment("proofreader@gmail.com", "qwerty12", AssignmentName);
	}

	@AfterClass
	public static void quit() {
		driver.close();
	}
}
