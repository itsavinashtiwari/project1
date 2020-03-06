package com.actihybrid.scripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actihybrid.generics.BaseTest;

public class TestDemo extends BaseTest{

	@Test
	public void testSC()
	{
		Reporter.log("FrameWork Executed",true);
	}
}
