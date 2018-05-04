package com.ams.proofReaderTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.ams.proofReader.ProofReaderAssignment;

public class ProofReaderAssignmentTest {
	WebDriver driver;
	ProofReaderAssignment objectProofReaderAssignment;
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
	public void test_ProofReaderAssignment() throws IOException, InterruptedException {

		objectProofReaderAssignment = new ProofReaderAssignment(driver);
		objectProofReaderAssignment.amsProofReaderAssignment("proofreader@gmail.com", "qwerty12", "PYTHON Framework", filePath);
	}
}
