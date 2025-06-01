package com.facebook.app.Test;

import org.testng.Assert;
import org.testng.annotations.*;

import org.openqa.selenium.WebDriver;
import com.facebook.app.pages.*;
import com.facebook.app.utils.DriverFactory;

public class LoginTest {
	WebDriver driver;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.getDriver();
		driver.get("https://www.facebook.com/");
		loginPage = new LoginPage(driver);
	}

	@Test
	public void testValidLogin() throws InterruptedException {
		loginPage.login("your-email@example.com", "your-password");

		Thread.sleep(20000);

		String expectedUrl = driver.getCurrentUrl();

		System.out.println(expectedUrl);
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}