package com.actihybrid.generics;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils implements IAutoConstant{
	/**
	 * This Method is Used to TakesScreenShot If the testcase gets Faile
	 * @param driver
	 * @param path
	 */
	public static void takesSreeenShots(WebDriver driver,String path) 
	{
		try
		{		
		     TakesScreenshot ts = (TakesScreenshot)driver;
		     File src = ts.getScreenshotAs(OutputType.FILE);
		     File des=new File(path);
		     FileUtils.copyFile(src, des);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This Method is Created For Specifying ExplicitWaiting Conditions
	 * @param wait
	 * @return
	 */
	
	public static  void waitingCondition(WebDriver driver , WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static  void waitForTitle(WebDriver driver , String expPageTitle)
	{
		WebDriverWait wait = new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.titleContains(expPageTitle));
	}
	
	public static void select(WebElement element , String optionText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(optionText);
	}
	
	public static void select(WebElement element , int optionsIndex) {
		Select sel = new Select(element);
		sel.selectByIndex(optionsIndex);
	}
	
	public static void moveToElement(WebElement elemnet , WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(elemnet);
		
	}
	
	

}
