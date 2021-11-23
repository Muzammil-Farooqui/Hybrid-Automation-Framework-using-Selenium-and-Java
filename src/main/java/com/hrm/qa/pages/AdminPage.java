package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.util.TestUtil;

import io.qameta.allure.Step;

public class AdminPage extends TestBase
{
	// Object Creation
	
	
	// Page Factory
	
	@FindBy(id="searchSystemUser_userName")
	@CacheLookup 
	WebElement username;
	
	@FindBy(id="searchSystemUser_userType")
	WebElement userrole;
	
	@FindBy(id="searchSystemUser_employeeName_empName")
	WebElement employeename;
	
	@FindBy(id="searchSystemUser_status") 
	WebElement status;
	
	@FindBy(id="searchBtn11") // wrong remove 11
	WebElement searchbtn;
	
	@FindBy(id="resetBtn")
	WebElement resetbtn;
	
	// Page Factory initialization
	
	public AdminPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Test Functions / Action
	
//	public String userName = "alanw";
//	public String userRole = "ESS";
//	public String employeeName = "alanw v wilson";
//	public String _status = "Enable";
	
	@Step("Search user  with username: {0}, user role: {1}, employee Name: {2}, and user status: {3}  step...")
	public void searchUser(String userName, String userRole, String employeeName, String userStatus)
	{
		username.sendKeys(userName);
		
//		Select select = new Select(userrole);
//		select.selectByVisibleText(userRole);
		
		TestUtil.selectByText(userrole, userRole);
		
		employeename.sendKeys(employeeName);
//		
		TestUtil.selectByText(status, userStatus);
//		Select select = new Select(status);
//		select.selectByVisibleText(_status);
//		
		searchbtn.click();
		
		
		
		
		
		
		
	}

}
