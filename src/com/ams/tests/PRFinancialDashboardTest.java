package com.ams.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.ams.cases.PRFinancialDashboard;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class PRFinancialDashboardTest {

	static WebDriver driver;
	PRFinancialDashboard objectPRFinancialDashboard;
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
	public void test_FinancialDashboard() throws IOException, InterruptedException {

		String enteredAmount = "100";
		
		
		objectPRFinancialDashboard = new PRFinancialDashboard(driver);
		objectPRFinancialDashboard.financialDashboard("proofreader@gmail.com", "qwerty12", enteredAmount);

		int finalAvailableAmount = objectPRFinancialDashboard.getFinalAmountInteger(enteredAmount);
		int intAvailableAmountAfter = objectPRFinancialDashboard.getAvailableAmountAfter();
		
		Assert.assertEquals(finalAvailableAmount, intAvailableAmountAfter);
		System.out.println("SUCCESS!!!!");
		
	}

	@AfterClass
	public static void quit() {
		driver.close();
	}

}
