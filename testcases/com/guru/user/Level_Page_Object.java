package com.guru.user;

import java.util.Random;
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
import pageObjects.liveGuru.DashboardPageObject;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.RegisterPageObject;
import pageUIs.liveGuru.RegisterPageUI;

public class Level_Page_Object{
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
			  System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver");
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
	  registerPage = new RegisterPageObject(browser);
  }
  
  @Test
  public void Register_01_Empty_Data() {
	  registerPage.enterFirstName("");
	  registerPage.enterMiddleName("");
	  registerPage.enterLastName("");
	  registerPage.enterEmail("");
	  registerPage.enterPassword("");
	  registerPage.enterConfirmPassword("");
	  registerPage.clickRegister();
  }
  @Test
  public void Register_02_Invalid_Email() {
	  registerPage.enterFirstName("");
	  registerPage.enterMiddleName("");
	  registerPage.enterLastName("");
	  registerPage.enterEmail("abc@com");
	  registerPage.enterPassword("");
	  registerPage.enterConfirmPassword("");
	  registerPage.clickRegister();
	  
  }
  @Test
  public void Register_03_Password_Less_Than_6_Char() {
	  registerPage.enterFirstName("");
	  registerPage.enterMiddleName("");
	  registerPage.enterLastName("");
	  registerPage.enterEmail("");
	  registerPage.enterPassword("123");
	  registerPage.enterConfirmPassword("");
	  registerPage.clickRegister();
	  
  }
  @Test
  public void Register_04_Confirm_Password_Not_Match() {
	  registerPage.enterFirstName("");
	  registerPage.enterMiddleName("");
	  registerPage.enterLastName("");
	  registerPage.enterEmail("");
	  registerPage.enterPassword("123123");
	  registerPage.enterConfirmPassword("123456");
	  registerPage.clickRegister();
	  
  }
  @Test
  public void Register_05_Register_Successful() { 
	  registerPage.enterFirstName("Minh");
	  registerPage.enterMiddleName("Ba");
	  registerPage.enterLastName("Pham");
	  registerPage.enterEmail("minh"+randomNumber()+"@yahoo.com");
	  registerPage.enterPassword("123123");
	  registerPage.enterConfirmPassword("123123");
	  registerPage.clickRegister();
	  dashboardPage = new DashboardPageObject(browser);
	  String welcomeMsg=dashboardPage.getWelcomeMessage();
	  Assert.assertEquals(welcomeMsg, "Thank you for registering with Main Website Store.");
	  
  }
  @AfterClass
  public void afterClass() {
	  browser.quit();
  }
  
  Random rand = new Random();
	public int randomNumber() {
		return rand.nextInt(999);
	}
  
}
