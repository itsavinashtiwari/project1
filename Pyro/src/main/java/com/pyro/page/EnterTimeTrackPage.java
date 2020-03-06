package com.actihybrid.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterTimeTrackPage
{
	
	@FindBy(id="logoutLink")
	private WebElement lgOutBTN;
	
	@FindBy(xpath="//div[text()='TASKS']//parent::a[@class='content tasks']")
	private WebElement taskTAB;
	
	@FindBy(xpath="(//div[contains(text(),'Settings')])[1]")
	private WebElement settings;
	
	@FindBy(xpath="//a[text()='Licenses']")
	private WebElement licenses;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnTaskTb()
	{
		taskTAB.click();
	}
	public void clickOnSettings()
	{
		settings.click();
	}
	public void clickOnLicenses()
	{
		licenses.click();
	}
	
	public void clickOnLgoutBTN()
	{
		lgOutBTN.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
