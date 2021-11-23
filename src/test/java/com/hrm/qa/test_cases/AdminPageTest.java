package com.hrm.qa.test_cases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.listeners.TestAllureListener;
import com.hrm.qa.pages.AdminPage;
import com.hrm.qa.pages.DashboardPage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Listeners({TestAllureListener.class})
public class AdminPageTest extends TestBase
{
	// Object Creation
	LoginPage loginPage;
	DashboardPage dashboardPage;
	AdminPage adminPage;
	
	String sheetName =  "UserData";
	public AdminPageTest()
	{
		super();
	}
	
	//-----------------------------------------------Prerequisite-----------------------------------
	@BeforeMethod
	public void setUp()
	{
		initialization();
		
		// Object initialization
		loginPage = new LoginPage();
		adminPage = new AdminPage();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));		// Login page return return home page 
		adminPage = dashboardPage.clickOnAdminTabLink();
		 
	}
	
	//------------------------------------------------Test Cases-------------------------------------
	
	@DataProvider
	public Object[][] getOrangeHRMTestData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 1, dataProvider = "getOrangeHRMTestData")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Verify user search functionality on admin page")
	@Story("Story Name: To check the search user functionality")
	public void  Test_searchUser(String userName, String userRole, String employeeName, String userStatus)
	{
		adminPage.searchUser(userName, userRole, employeeName, userStatus);
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}
	