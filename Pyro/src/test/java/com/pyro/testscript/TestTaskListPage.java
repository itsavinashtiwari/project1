package com.actihybrid.scripts;

import org.testng.annotations.Test;

import com.actihybrid.generics.BaseTest;
import com.actihybrid.generics.FWUtils;
import com.actihybrid.pages.EnterTimeTrackPage;
import com.actihybrid.pages.LoginPage;
import com.actihybrid.pages.TaskListPage;

public class TestTaskListPage extends BaseTest 
{
	
	@Test
	public void test_CreateCustomer() throws InterruptedException
	{
		
		String expectedETPTitle = FWUtils.read_Xl_Data(XL_DATA_PATH, "TaskListPage", 1,2);
		String expectedTLPTitle = FWUtils.read_Xl_Data(XL_DATA_PATH,"TaskListPage",1,3);
		
		
		EnterTimeTrackPage etp=new EnterTimeTrackPage(driver);
		Thread.sleep(1000);
		FWUtils.verifyPage(driver, expectedETPTitle);
		etp.clickOnTaskTb();
		Thread.sleep(1000);
		TaskListPage tsp=new TaskListPage(driver);
		Thread.sleep(1000);
		FWUtils.verifyPage(driver, expectedTLPTitle);
	}

}
