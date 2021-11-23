//package com.hrm.qa.base;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Properties;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
//import org.testng.log4testng.Logger;
//
//import com.hrm.qa.util.WebEventListener;
//
//public class TestBase 
//{
////	static ResourceBundle rb; 
//	
//	public static WebDriver driver;
//	//public static WebDriver e_driver;
//	public static Properties prop;
//	public static EventFiringWebDriver e_driver;
//	public static WebEventListener eventListener;
//	
//	public static Logger log = Logger.getLogger(TestBase.class);
//	
//	public TestBase()
//	{
//		log.info("******************************** Starting Testing ******************************************");
//		try
//		{
//			prop = new Properties();
//			FileInputStream ip = new FileInputStream("E:\\XordWork\\Maven\\DarazTest\\src\\main\\java\\com\\daraz"+"\\qa\\config\\config.properties");
//			prop.load(ip);
//		}
//		catch(FileNotFoundException e)
//		{
//			e.printStackTrace();
//		}
//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}
//	}
//	
//	public static void initialization()
//	{
//		String browserName = prop.getProperty("browser");
//		
//		if(browserName.equals("chrome"))
//		{
//			System.setProperty("webdriver.chrome.driver", "C:\\Automation Drivers\\Selenium Web Drivers\\Chrome\\chromedriver-v95.0.46-win32\\chromedriver.exe");
//			driver= new ChromeDriver();
//			log.info("******************************************* Launching chrome browser *******************************************");
//		}
//		else if(browserName.equals("firefox"))
//		{
//			System.setProperty("webdriver.gecko.driver", "C:\\Automation Drivers\\Selenium Web Drivers\\Firefox\\geckodriver-v0.30.0-win32\\geckodriver.exe");
//			driver= new FirefoxDriver();
//			log.info("******************************************* Launching firefox browser *******************************************");
//		}
//		
//		e_driver = new EventFiringWebDriver(driver);
//		eventListener = new WebEventListener();
//		e_driver.register(eventListener);
//		driver = e_driver;
//		
//		
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		
//		driver.get(prop.getProperty("url"));
//		log.info("Entering application URL");
//	}
//	
//	// Resource Bundle
////	public TestBase()
////	{
////		rb = ResourceBundle.getBundle("config");
////	}
////	
////	public static void initialization() 
////	{
////		ResourceBundle rb = ResourceBundle.getBundle("config");
////		
////		String browserName = rb.getString("browser");
////		
////		if(browserName.equals("chrome"))
////		{
////			WebDriverManager.chromedriver().setup();
////			WebDriver driver = new ChromeDriver();
////			driver.manage().window().maximize();
////			driver.manage().deleteAllCookies();
////			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
////			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
////			
////			driver.get(rb.getString("url"));
////
////		}
////		else if(browserName.equals("firefox")) 
////		{
////			WebDriverManager.firefoxdriver().setup();
////			WebDriver driver = new FirefoxDriver();
////			driver.manage().window().maximize();
////			driver.manage().deleteAllCookies();
////			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
////			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
////			
////			driver.get(rb.getString("url"));
////		}					
////	}
//
//}


package com.hrm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.log4testng.Logger;

import com.hrm.qa.listeners.WebEventListener;

import org.apache.commons.io.FileUtils;

public class TestBase 
{
	public static WebDriver driver;
	//public static WebDriver e_driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	public static Logger log = Logger.getLogger(TestBase.class);
	
	public TestBase()
	{
		log.info("******************************** Starting Testing ******************************************");
		try
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("E:\\XordWork\\Maven\\OrangeHRMTestAutomation\\src\\main\\java\\com\\hrm\\qa\\config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//public static void initialization()
	public static WebDriver initialization()
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Automation Drivers\\Selenium Web Drivers\\Chrome\\chromedriver-v95.0.46-win32\\chromedriver.exe");
			driver= new ChromeDriver();
			log.info("******************************************* Launching chrome browser *******************************************");
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Automation Drivers\\Selenium Web Drivers\\Firefox\\geckodriver-v0.30.0-win32\\geckodriver.exe");
			driver= new FirefoxDriver();
			log.info("******************************************* Launching firefox browser *******************************************");
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		log.info("Entering application URL");
		
		///////////
		
		tdriver.set(driver);
		return getDriver();
	}
	
	//////////
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}
	
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}
	

}

