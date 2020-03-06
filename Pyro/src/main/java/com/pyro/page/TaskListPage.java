package com.actihybrid.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage 
{
	@FindBy(xpath="//div[text()='Add New']//ancestor::div[@class='addNewContainer']")
	private WebElement addNewBTN;
	
	@FindBy(xpath="//div[contains(text(),'+ New Customer')]")
	private WebElement newCustomerBTN;
	
	@FindBy(xpath="//div[contains(text(),'+ New Project')]")
	private WebElement newProjectBTN;
	
	@FindBy(id="customerLightBox_nameField")
	private WebElement customerNameTB;
	
	@FindBy(id="ext-gen102")
	private WebElement activeCustomerBTN;
	
	@FindBy(xpath="//span[text()='Create Customer']/parent::div[@class='buttonIcon']")
	private WebElement createCustomerBTN;
	
	public TaskListPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnAddNewBTN()
	{
		addNewBTN.click();
	}
	
	public void clickOnNewCustomerBTN()
	{
		newCustomerBTN.click();
	}
	public void clickOnNewProjectBTN()
	{
		newProjectBTN.click();
	}
	public void setCustomerName(String cn)
	{
		customerNameTB.sendKeys(cn);
	}
	public void clickOnActiveCustomerBTN()
	{
		activeCustomerBTN.click();
	}
	
	public void clickOnCreateCustomerBTN()
	{
		createCustomerBTN.click();
	}


}
