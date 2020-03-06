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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.actihybrid.pages.EnterTimeTrackPage;
import com.actihybrid.pages.LoginPage;

abstract public class BaseTest implements IAutoConstant
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
	
	@BeforeMethod
	public void openApplication()
	{

		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME,PASSWORD);
	}
	
	@AfterMethod
	public void configBM(ITestResult ite) {
		int status = ite.getStatus();
		String methodName = ite.getName();
		if(status==1) 
		{
			passCount++;
			Reporter.log("The PassCount is---->"+passCount);
			
		}
		else
		{
			failCount++;
			String pathName=PHOTO_PATH+methodName+".png";
			WebDriverUtils.takesSreeenShots(driver,pathName);
			Reporter.log("The FailCount--->"+failCount);
		}		
		
	 EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
	 etp.clickOnLgoutBTN();
	}	
	
	@AfterClass
	public void closeApplication()
	{		
		driver.close();
	}
	

	@AfterSuite
	public void print(){
		Reporter.log("Pass:"+passCount,true);
		Reporter.log("Fail:"+failCount,true);
		FWUtils.write_DataInto_Xl(REPORT_PATH,"sheet1",1,0,passCount);
		FWUtils.write_DataInto_Xl(REPORT_PATH,"sheet1",1,1,failCount);
	}


}
