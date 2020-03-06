package com.actihybrid.scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumhq.jetty9.io.NetworkTrafficListener;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actihybrid.generics.BaseTest;
import com.actihybrid.generics.BaseTest2;
import com.actihybrid.generics.FWUtils;
import com.actihybrid.pages.EnterTimeTrackPage;
import com.actihybrid.pages.LoginPage;

public class TestLoginPage extends BaseTest
{	

	@Test(priority=1)
	public void test_validLoginPage() 
	{	
        LoginPage lp = new LoginPage(driver);
        Assert.assertEquals(driver.getTitle(),FWUtils.read_Xl_Data(XL_DATA_PATH,"ValidLoginPage",1,2));
		
        EnterTimeTrackPage etp=new EnterTimeTrackPage(driver);
		etp.clickOnLgoutBTN();
		
	}
	/*@Test(priority=0)
	public void  test_InvalidLoginPage() throws InterruptedException
	{
		int rc = FWUtils.xl_Row_Count(XL_DATA_PATH,"InvalidLoginPage");
		Reporter.log("The Number of DataRow count is--->"+rc,true);
		
		LoginPage lp=new LoginPage(driver);
		for(int i=1;i<=rc;i++)
		{
			String un = FWUtils.read_Xl_Data(XL_DATA_PATH,"InvalidLoginPage",i,0);
			String pw=FWUtils.read_Xl_Data(XL_DATA_PATH,"InvalidLoginPage",i,1);
			
			
		    lp.setUserName(un);
		    lp.setPassWord(pw);
		    lp.clickonLoginBTN();
			Thread.sleep(2000);
			lp.verifyERRMSG();
		}
	}*/

}
