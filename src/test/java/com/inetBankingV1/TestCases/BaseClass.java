package com.inetBankingV1.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBankingV1.Utilities.ReadConfig;

public class BaseClass {
	ReadConfig redconfig = new ReadConfig(); 
	public String baseURL = redconfig.getApplicationURL();
	public String username = redconfig.getUsername();
	public String password = redconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		logger=Logger.getLogger("eBanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", redconfig.getChromePath());
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		}
		else if(br.equals("edge"))
		{
		System.setProperty("webdriver.edge.driver", redconfig.getEdgePath());
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void capturescreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(src, target);
		System.out.println("Screenshot taken");
	}
	public String randomstring()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	public String randomnum()
	{
		String generatedstring2 = RandomStringUtils.randomNumeric(2);
		return(generatedstring2);
	}
	
	
	
	
	
	
	
	
	
}
