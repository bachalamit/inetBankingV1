package com.inetBankingV1.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.PageObjects.LoginPage;

public class TC_loginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {
		
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		logger.info("Username entered");
		lp.setUserName(username);
		logger.info("Password entered");
		lp.setPassword(password);
		lp.clicSubmit();
	
		if (driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Test Case 001 is passed");
		} else 
		{
			capturescreen(driver, "login test");
			Assert.assertTrue(false);
			logger.info("Test Case 001 is failed");
		}
	}

}
