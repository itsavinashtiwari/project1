package com.actihybrid.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LicensesPage 
{
	
	@FindBy(xpath="//nobr[text()='Issue Date:']/../../td[2]")
	private WebElement issueDate;
	
	@FindBy(xpath="//nobr[text()='Product Edition:']/../../td[2]")
	private WebElement productEdition;
	

	
	public LicensesPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
		
	public  void verifyIssueDate(String expectIssueDate)
	{
		
		String actualIssueDate = issueDate.getText();
		if(actualIssueDate.equals(expectIssueDate))
		{
			System.out.println("Expected issued date is proper-->"+expectIssueDate);
		}
		else
		{
				System.out.println("Expected issued date is not proper-->"+actualIssueDate);
		}
		
	}
	
	public  void verifyProductEdition(String expecteProductEdition)
	{
		
		String actualProductEdition = productEdition.getText();
		if(actualProductEdition.equals(expecteProductEdition))
		{
			System.out.println("Expected ProductEdition  is proper-->"+expecteProductEdition);
		}
		else
		{
				System.out.println("Expected ProductEdition is not proper-->"+actualProductEdition);
		}
		
	}
	
	
	

}
