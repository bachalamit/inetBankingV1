package com.inetBankingV1.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver ldriver)
	{
	//	ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtUsername;
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;
	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement btnLogin;
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[10]/a")
	@CacheLookup
	WebElement logout;
	
	public void setUserName(String uname)
	{
		txtUsername.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void clicSubmit()
	{
		btnLogin.click();
	}
	public void cliclogout()
	{
		logout.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
