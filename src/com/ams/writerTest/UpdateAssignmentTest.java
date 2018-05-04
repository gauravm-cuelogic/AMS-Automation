package com.ams.writerTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.ams.writer.UpdateAssignment;

public class UpdateAssignmentTest {

	WebDriver driver;
	UpdateAssignment objectUpdateAssignment;
	String baseUrl = "http://ams.onestopsoul.com/login";
	String filePath = "E:\\Gaurav_Workspace\\Personal\\Prajakta Bulbule Resume - Admin.docx";

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
		objectUpdateAssignment.amsUpdateAssignment("writer@gmail.com", "qwerty12","PYTHON Framework", filePath);
	}

}