package com.actihybrid.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.actihybrid.pages.EnterTimeTrackPage;
import com.actihybrid.pages.LoginPage;

abstract public class BaseTest2 implements IAutoConstant
{
	static
	{
		System.setProperty(CHROM_KEY,CHROM_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}
	
	
	public static int passCount=0,failCount=0;
	public static WebDriver driver;
	
	
	
	@Parameters("sBrowser")
	@BeforeClass
	public void openBrowser(String sBrowser) 
	{
		if(sBrowser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(sBrowser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new InternetExplorerDriver();
		}
		
		
	}
	
	
	
//	@AfterTest
	@AfterClass
	public void closeApplication()
	{
		
		
		driver.close();
	}


}
