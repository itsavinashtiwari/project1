package com.actihybrid.generics;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.AcceptAlert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FWUtils extends BaseTest
{
	/**
	 * This Method is Used to Verify The page.
	 * @param driver
	 * @param expectedTitle
	 */
	
	public static void verifyPage(WebDriver driver,String expectedTitle)
	{	
		
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("The Expected Page Title is Displayed-->"+expectedTitle);
	}
	/**
	 * This Method Use To Read The Data From The Excel
	 * @param path
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String read_Xl_Data(String path,String sheet,int row,int cell) 
	{
		String data="";
		try
		{
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		 data= wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	/**
	 * This Method Is Used to Write Data Into XL File
	 * @param path
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 */
	public static String write_DataInto_Xl(String path,String sheet,int row,int cell,int count) 
	{
		String data="";
		try
		{
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
	    wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(data);
	    
	    wb.write(new FileOutputStream(path));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	/**
	 * This Method Is Used To Count The Data Rows
	 * @param path
	 * @param sheet
	 * @return
	 */
	public static int xl_Row_Count(String path,String sheet)
	{
		int rc=0;
		try
		{
		Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		rc=wb.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rc;
	}
	
}
