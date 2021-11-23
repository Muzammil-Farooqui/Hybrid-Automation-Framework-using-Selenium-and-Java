package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.AdminPage;
import com.hrm.qa.util.TestUtil;

import io.qameta.allure.Step;

public class DashboardPage extends TestBase
{
	//----------------------------------------------------------- Page Factory - Object Repository ----------------------------------------------------
	
		// All Tabs
		@FindBy(id="menu_admin_viewAdminModule")  
		WebElement adminTabLink;
		
//		@FindBy(xpath="//b[contains(text(),'Admin')]")
//		WebElement adminTabLink;
		
		@FindBy(id="menu_pim_viewPimModule")
		WebElement pimTabLink;
		
		@FindBy(id="menu_leave_viewLeaveModule")
		WebElement LeaveTabLink;
		
		@FindBy(id="menu_time_viewTimeModule")
		WebElement timeTabLink;
		
		@FindBy(id="menu_recruitment_viewRecruitmentModule")
		WebElement RecruitmentTabLink;
		
		@FindBy(id="menu_pim_viewMyDetails")
		WebElement myInfoTabLink;
		
		@FindBy(id="menu__Performance")
		WebElement performanceTabLink;
		
		@FindBy(id="menu_directory_viewDirectory")
		WebElement diretoryTabLink;
		
		@FindBy(id="menu_maintenance_purgeEmployee")
		WebElement maintananceTabLink;
		
		@FindBy(id="menu_buzz_viewBuzz")
		WebElement buzzTabLink;
		
		// UserName
		//@FindBy(xpath="/html/body/div[1]/div[1]/a[2]")
		@FindBy(id="//a[@id='welcome']")  
		WebElement userNameLabel;
		
		//-------------------------------------------------------------initialize the page object----------------------------------------------------------
		public DashboardPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		//--------------------------------------------------------------Test Functions / Actions ----------------------------------------------------------

		@Step("getting dashboard page title step...")
		public String verifyHomePageTitle() 
		{
			//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT);
			return driver.getTitle();
		}
		
		@Step("clicking on the admin tab on the Dashboard page step...")
		public AdminPage clickOnAdminTabLink()
		{
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT);
			adminTabLink.click();
			//driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
			return new AdminPage();    // object of admin Page
		}
		
		@Step("getting user name step...")
		public boolean verifyUserName()
		{
			//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT);
			TestUtil.implicitWait(10);
			System.out.println(userNameLabel);
			return adminTabLink.isDisplayed();
		}
}
