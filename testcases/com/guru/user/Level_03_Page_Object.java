package com.guru.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.AbtractPage;
import pageObjects.liveGuru.DashboardPageObject;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.RegisterPageObject;

public class Level_03_Page_Object extends AbtractPage{
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	DashboardPageObject dashboardPage;
	WebDriver browser;
	String os = System.getProperty("os.name");
	
  @BeforeClass
  public void beforeClass() {
	  if(os.contains("Mac")) {
		  System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver83");}
	  else {
		  System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver83.exe");  
	  }
	  browser = new ChromeDriver();
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
	  registerPage = new RegisterPageObject(browser);
  }
  
  @Test
  public void Register_01_Empty_Data() {
	  registerPage.enterFirstName("")
	  	.enterMiddleName("")
	  	.enterLastName("")
	  	.enterEmail("")
	  	.enterPassword("")
	  	.enterConfirmPassword("")
	  	.clickRegister();
  }
  @Test
  public void Register_02_Invalid_Email() {
	  registerPage.enterFirstName("")
	  	.enterMiddleName("")
	  	.enterLastName("")
	  	.enterEmail("abc@com")
	  	.enterPassword("")
	  	.enterConfirmPassword("")
	  	.clickRegister();
	  
  }
  @Test
  public void Register_03_Password_Less_Than_6_Char() {
	  registerPage.enterFirstName("")
	  	.enterMiddleName("")
	  	.enterLastName("")
	  	.enterEmail("")
	  	.enterPassword("123")
	  	.enterConfirmPassword("")
	  	.clickRegister();
	  
  }
  @Test
  public void Register_04_Confirm_Password_Not_Match() {
	  registerPage.enterFirstName("")
	  	.enterMiddleName("")
	  	.enterLastName("")
	  	.enterEmail("")
	  	.enterPassword("123123")
	  	.enterConfirmPassword("123456")
	  	.clickRegister();
	  
  }
  @Test
  public void Register_05_Register_Successful() { 
	  registerPage.enterFirstName("Minh")
	  	.enterMiddleName("Ba")
	  	.enterLastName("Pham")
	  	.enterEmail("minh"+randomInt()+"@yahoo.com")
	  	.enterPassword("123123")
	  	.enterConfirmPassword("123123")
	  	.clickRegister();
	  dashboardPage = new DashboardPageObject(browser);
	  String welcomeMsg=dashboardPage.getWelcomeMessage();
	  Assert.assertEquals(welcomeMsg, "Thank you for registering with Main Website Store.");
	  
  }
  @AfterClass
  public void afterClass() {
	  browser.quit();
  }
  
}
