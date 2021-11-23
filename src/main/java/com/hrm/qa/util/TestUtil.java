package com.hrm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.hrm.qa.base.TestBase;

public class TestUtil extends TestBase 
{
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static int waitTimeInSeconds;
	public static Duration IMPLICIT_WAIT = Duration.ofSeconds(waitTimeInSeconds);;
	public static String TESTDATA_SHEET_PATH = "E:\\XordWork\\Maven\\OrangeHRMTestAutomation\\src\\main\\java\\com\\hrm\\qa\\test_data\\OrangeHRMTestData.xlsx";

	static Workbook book;
	static Sheet sheet;

	public void switchToFrame() 
	{
		driver.switchTo().frame(0);
	}

	// implicit wait
	public static void implicitWait(int waitTimeInSeconds) 
	{
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT);
	}

	// Move to element mouse action
	public static void moveCursorToElement(WebElement locator) 
	{
		Actions action = new Actions(driver);
		action.moveToElement(locator).build().perform();
	}

	// Select function
	public static void selectByText(WebElement locator, String visibleText) 
	{
		Select select = new Select(locator);
		select.selectByVisibleText(visibleText);
	}

	// Read data from Excel Sheet Function
	public static Object[][] getTestData(String sheetName) 
	{
		FileInputStream file = null;
		try 
		{
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			book = WorkbookFactory.create(file);
		} 
		catch (InvalidFormatException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum() + "-----------" + sheet.getRow(0).getLastCellNum());

		for (int i = 0; i < sheet.getLastRowNum(); i++) 
		{
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) 
			{
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
	}

	// Screenshot of Errors
	public static void takeScreenshotAtEndOfTest() throws IOException 
	{
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
//		if(osName.startWith("Mac"))
//		{
//			FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
//		}
//		else
//		{
		FileUtils.copyFile(srcFile, new File(currentDir + "\\screenshots\\" + System.currentTimeMillis() + ".png"));
//		}
	}

}
