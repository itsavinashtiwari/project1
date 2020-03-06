package com.actihybrid.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actihybrid.generics.BaseTest2;
import com.actihybrid.generics.FWUtils;
import com.actihybrid.pages.LoginPage;

public class TestInvalidLoginPage extends BaseTest2
{
	
	@Test(priority=0)
	public void  test_InvalidLoginPage() throws InterruptedException
	{
		int rc = FWUtils.xl_Row_Count(XL_DATA_PATH,"InvalidLoginPage");
		Reporter.log("The Number of DataRow count is--->"+rc,true);
		
		LoginPage lp=new LoginPage(driver);
		for(int i=1;i<=rc;i++)
		{
			String un = FWUtils.read_Xl_Data(XL_DATA_PATH,"InvalidLoginPage",i,0);
			String pw=FWUtils.read_Xl_Data(XL_DATA_PATH,"InvalidLoginPage",i,1);
			
			driver.get(URL);
		   lp.login(un, pw);
			Thread.sleep(2000);
			lp.verifyERRMSG();
		}
	}

}
