package com.hrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.DashboardPage;

import io.qameta.allure.*;

public class LoginPage extends TestBase
{
//----------------------------------------------------------- Page Factory - Object Repository ----------------------------------------------------
	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
//-------------------------------------------------------------initialize the page object----------------------------------------------------------
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
//--------------------------------------------------------------Test Functions / Actions ----------------------------------------------------------
	@Step("getting login page title step...")
	public String validateLoginPageTtle()
	{
		return driver.getTitle();
	}
	
	@Step("login with username: {0} and password: {1} step...")
	public DashboardPage login(String _username, String _password)
	{
		username.sendKeys(_username);
		password.sendKeys(_password);
		loginBtn.click();
		
		return new DashboardPage();
	}
}
