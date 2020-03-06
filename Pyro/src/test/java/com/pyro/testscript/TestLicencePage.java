package com.actihybrid.scripts;

import org.openqa.selenium.support.ui.Wait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actihybrid.generics.BaseTest;
import com.actihybrid.generics.FWUtils;
import com.actihybrid.pages.EnterTimeTrackPage;
import com.actihybrid.pages.LicensesPage;
import com.actihybrid.pages.LoginPage;

public class TestLicencePage extends BaseTest
{
	
	@Test
	public void test_VerifyissueDate() throws InterruptedException
	{

		String expectedETPTitle = FWUtils.read_Xl_Data(XL_DATA_PATH,"CheckIssueDate",1,2);
		String expectedLCPTitle = FWUtils.read_Xl_Data(XL_DATA_PATH,"CheckIssueDate",1,3);
		String expectedIssueDate = FWUtils.read_Xl_Data(XL_DATA_PATH,"CheckIssueDate",1,4);

		EnterTimeTrackPage etp=new EnterTimeTrackPage(driver);
		FWUtils.verifyPage(driver, expectedETPTitle);
		Thread.sleep(1000);
		etp.clickOnSettings();
		etp.clickOnLicenses();
		
		LicensesPage lcp=new LicensesPage(driver);
		FWUtils.verifyPage(driver, expectedLCPTitle);
		Thread.sleep(1000);
		lcp.verifyIssueDate(expectedIssueDate);

	}
	
	@Test
	public void test_VerifyProductEdition() throws InterruptedException
	{
		Reporter.log("================================",true);

		String expectedETPTitle = FWUtils.read_Xl_Data(XL_DATA_PATH,"CheckProductEdition",1,2);
		String expectedLCPTitle = FWUtils.read_Xl_Data(XL_DATA_PATH,"CheckProductEdition",1,3);
		String expectedProductEdition = FWUtils.read_Xl_Data(XL_DATA_PATH,"CheckProductEdition",1,4);

		EnterTimeTrackPage etp=new EnterTimeTrackPage(driver);
		Thread.sleep(1000);
		FWUtils.verifyPage(driver, expectedETPTitle);
		Thread.sleep(1000);
		etp.clickOnSettings();
		etp.clickOnLicenses();
		
		LicensesPage lcp=new LicensesPage(driver);
		FWUtils.verifyPage(driver, expectedLCPTitle);
		Thread.sleep(1000);
		lcp.verifyProductEdition(expectedProductEdition);

	}

}
