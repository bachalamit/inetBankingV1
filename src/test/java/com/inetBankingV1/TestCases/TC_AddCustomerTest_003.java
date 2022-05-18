package com.inetBankingV1.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBankingV1.PageObjects.AddCustomerPage;
import com.inetBankingV1.PageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clicSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("Amit");
		addcust.custgender("male");
		addcust.custdob("16","02","1994");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("PUNE");
		addcust.custstate("MH");
		addcust.custpinno("411058");
		addcust.custtelephoneno("987890091");
		
		String email=randomstring()+"@gmail.com";
		addcust.custemailid(email);
		
		addcust.custsubmit();
		addcust.custpassword("abcdef");
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			logger.info("Test case 003 is passed...");
		}
		else
		{
			logger.info("test case failed....");
			logger.info("Test case 003 is failed...");
			capturescreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
			
	}
	
}
