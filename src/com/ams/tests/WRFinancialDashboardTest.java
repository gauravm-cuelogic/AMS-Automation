package com.ams.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ams.cases.WRFinancialDashboard;

public class WRFinancialDashboardTest {

	static WebDriver driver;
	WRFinancialDashboard objectWRFinancialDashboard;
	String baseUrl = "http://ams.onestopsoul.com/login";

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
	public void test_FinancialDashboard() throws IOException, InterruptedException {

		String enteredAmount = "100";

		objectWRFinancialDashboard = new WRFinancialDashboard(driver);
		objectWRFinancialDashboard.financialDashboard("writer@gmail.com", "qwerty12", enteredAmount);
	}

	@AfterClass
	public static void quit() {
		driver.close();
	}
}
