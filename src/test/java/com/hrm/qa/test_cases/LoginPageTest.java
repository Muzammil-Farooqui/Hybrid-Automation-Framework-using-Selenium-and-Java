package com.hrm.qa.test_cases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.listeners.TestAllureListener;
import com.hrm.qa.pages.DashboardPage;
import com.hrm.qa.pages.LoginPage;

import io.qameta.allure.Severity;
import io.qameta.allure.*;

@Listeners({TestAllureListener.class})
public class LoginPageTest extends TestBase
{
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	private static final Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1, description="Verifying login page title test" )
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify login page title test on Login Page")
	@Story("Story Name: To check the login page title")
	public void loginPageTitleTest()
	{
		log.info("************************************************** Starting login page title test **************************************************");
		String title = loginPage.validateLoginPageTtle();
		log.info("login page title is " + title);
		Assert.assertEquals(title, "OrangeHRM", "Login page title not matched.");
		log.info("************************************************** Ending login page title test **************************************************");
	}
	
	
	@Test(priority=2, description="login into app test")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description: Verify login into application with valid credentials")
	@Story("Story Name: To check the login functionality")
	public void loginTest()
	{
		log.info("************************************************** Starting login functionality test **************************************************");
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("************************************************** Ending login functionality test **************************************************");
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
		log.info("************************************************** browser closed **************************************************");
//		log.warn("++++++++++++++++ warning ++++++++++++++++++++");
//		log.error("***********error**************");
//		log.debug("+++++++++++++++++ debug ++++++++++++++++++++++++++++++");
//		log.trace("+++++++++++ Trace mesage ++++++++++++++++++++++++++++");
//		log.fatal("++++++++++ftal message++++++++++++++++");
		
		
//		DEBUG designates fine-grained informational events that are most useful to debug a crawl configuration.
//		TRACE designates fine-grained informational events than DEBUG.
//		ERROR designates error events that might still allow the crawler to continue running.
//		FATAL designates very severe error events that will presumably lead the crawler to abort.
//		INFO designates informational messages that highlight the progress of the crawl at a coarse-grained level.
//		OFF has the highest possible rank and is intended to turn off logging.
//		WARN designates potentially harmful situations.
//		
	}

}
