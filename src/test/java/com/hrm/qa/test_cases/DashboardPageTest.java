package com.hrm.qa.test_cases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.listeners.TestAllureListener;
import com.hrm.qa.pages.AdminPage;
import com.hrm.qa.pages.DashboardPage;
import com.hrm.qa.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Listeners({TestAllureListener.class})
public class DashboardPageTest extends TestBase
{
	// Object Creation
		LoginPage loginPage;
		DashboardPage dashboardPage;
		AdminPage adminPage;
		
		
		public DashboardPageTest()
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
			 
		}
		
		//------------------------------------------------Test Cases-------------------------------------
		
		@Test(priority=1, description="Verifying dashboard page title test" )
		@Severity(SeverityLevel.NORMAL)
		@Description("Test Case Description: Verify dashboard page title test on dashboard Page")
		@Story("Story Name: To check the dashboard page title")
		public void  Test_verifyHomePageTitle()
		{
			String homePageTitle = dashboardPage.verifyHomePageTitle();
			Assert.assertEquals(homePageTitle, "OrangeHRM", "Home page title not matched.");
		}
		
		@Test(priority=2, description="Verifying user name" )
		@Severity(SeverityLevel.CRITICAL)
		@Description("Test Case Description: Verify the user name test on dashboard Page")
		@Story("Story Name: To check the username")
		public void Test_verifyUserName() 
		{
			//boolean userName = homePage.verifyUserName();
			//Thread.sleep(2000);
			Assert.assertTrue(dashboardPage.verifyUserName());
		}
		
		
		@Test(priority=3, description="Verifying admin tab link")
		@Severity(SeverityLevel.BLOCKER)
		@Description("Test Case Description: Verify the admin tab link test on dashboard Page")
		@Story("Story Name: To check the admin tab link")
		public void Test_adminTabLink()
		{
			adminPage = dashboardPage.clickOnAdminTabLink();
		}
		
		
		@AfterMethod
		public void tearDown() throws InterruptedException
		{
			Thread.sleep(2000);
			driver.quit();
		}

}
