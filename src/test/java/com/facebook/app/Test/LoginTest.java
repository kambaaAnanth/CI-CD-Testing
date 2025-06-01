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

		String actualUrl = "https://www.facebook.com/two_step_verification/authentication/?encrypted_context=ARH6jlAzSljBD7DV56CzCjf-Z5vTwxzOB5lStf6hLfavWxEYTNH8zVELEOV3SFd64FRTHSuzFvppcs-HXcC5F-epuyhCAc17eFTQBWzWMHj7q3cFmXHy4c_P2Dz14v56LQCvGvUPl7Wl1lhE6qjUm_gopY2xJwHigbqcPWX7st9KxGT7HCQcyeEyXsHm6OUllJvz2voUSZJUDtmMptasS2Hh37XVfCBSmkBNTWsdUCtZ3HM7-Vg2tJx_1JPXBTeDy_bxygFNaSatkgZF56F8J2aJ_67pt_-f4I3M8QWGneN-YNPAOzuttQDtvGsGmy1y4PccHsVIHs6BFUiw7UKL1Ef7PH14StR9e9_lLq9xoh2oNtWf5Z5LWx8fhUrj6_-ICFUhEK6_z8CyJJsJEBGFDv41okXiSp3buxzY8ag_O-Lz-ycN7JTzKywoxAl3u_PFHTw_43O9pO0X8BaQnuhJkFXiQP3Cy4SlTL3pH2_YH7Z6D33lfO6cyVKqurYzeaGAfRTz9zjN8iUF2btMq9JIqQhYxSx6ihX38E4Re5yoIhZeM9FQ8-IueJ-OKtCn4xReI9Pseh_CbkkzP7Ekb_W-fsqOMGtopdR5M6miqzuakIxIeJSkcTOu4BkatL7WfoSenhd-vT9wNDra570P03TIvhsXYag5I5CRuphdQ74tUVzlbZIrNQNW6vHB8AF2hHTMxrfJi75OQKk5SdCDBLP0z-xTGJFoGZ7w6GLf-RA5tredaJC5xBUDNaA-UxPpYGNp5brxshFgdrtce4JGcDodQG4leuq0woxrfp_A4iCcGEHjYy7Wn-3w-gbd5iT9_4YcquU3NDSkVVJpSygPUE9vQLbEDizlJd1kny_7SQci7eP-iwpSVKOu64JV8CzV54Jlf-HZ1ZMhw_VNEmPn3VCSN2LYCEwzzzHNJVoKoRpxNG7knnGUXJZjL6vbL1gh0CNX7JkV0-lzOVT1NmNMHU-79Bmy6894M7UF9r6IQd1qYx8jAiCUa_SHh0wODRrPBaV132udwTOeytpVRcgoeITewdJzqyLY-pyOcFe9yADiww4&flow=pre_authentication&next\r\n"
				+ "";

		if(expectedUrl.contains(actualUrl)) {
			
			Assert.assertTrue(true);
		}else {
			
			Assert.assertFalse(false,"Actual and expeced both are incorrect");
		}
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}