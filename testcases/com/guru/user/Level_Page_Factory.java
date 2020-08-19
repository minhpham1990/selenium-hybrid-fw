package com.guru.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import pageFactory.liveGuru.DashboardPageObject;
import pageFactory.liveGuru.HomePageObject;
import pageFactory.liveGuru.LoginPageObject;
import pageFactory.liveGuru.RegisterPageObject;

public class Level_Page_Factory{
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	DashboardPageObject dashboardPage;
	WebDriver browser;
	String os = System.getProperty("os.name");
	
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String nameBrowser) {
	  if(os.contains("Mac")) {
		  if(nameBrowser.equals("firefox")) {
			  System.setProperty("webdriver.gecko.driver", "browserDrivers/geckodriver");
			  browser = new FirefoxDriver();}
		  else if(nameBrowser.equals("chrome")){
			  System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver83");
			  browser = new ChromeDriver();}
		  else {
			  throw new RuntimeException("Please choose browser name correctly");
		  }
		  }
	  else {
		  if(nameBrowser.equals("chrome")) {
			 System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver83.exe");  
		  }
		  else if(nameBrowser.equals("firefox")) {
				 System.setProperty("webdriver.gecko.driver", "browserDrivers/geckodriver.exe");  
			  }
		  
	  }
	  

	  browser.get("http://live.demoguru99.com/");
	  browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  //Open new Homepage
	  homePage = new HomePageObject(browser);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  //Click and open login page
	  homePage.clickToMyAccount();
	  loginPage = new LoginPageObject(browser);
	  
	  //Click and open register page
	  loginPage.clickToCreateAnAccount();
  }
  
  @Test
  public void Register_01_Empty_Data() {
	 System.out.println("Check TC");
  }
  @Test
  public void Register_02_Invalid_Email() {
	  System.out.println("Check TC");
	  
  }
  @Test
  public void Register_03_Password_Less_Than_6_Char() {
	  System.out.println("Check TC");
	  
  }
  @Test
  public void Register_04_Confirm_Password_Not_Match() {
	  System.out.println("Check TC");
	  
  }
  @Test
  public void Register_05_Register_Successful() { 
	  System.out.println("Check TC");
	  
  }
  @AfterClass
  public void afterClass() {
	  browser.quit();
  }
  
}
