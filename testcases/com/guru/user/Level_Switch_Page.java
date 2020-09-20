package com.guru.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPageUI;
import pageObjects.liveGuru.AboutUsPageObject;
import pageObjects.liveGuru.CustomServicePageObject;
import pageObjects.liveGuru.DashboardPageObject;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.PageGeneratorManager;
import pageObjects.liveGuru.RegisterPageObject;
import pageObjects.liveGuru.SearchTermPageObject;

public class Level_Switch_Page{
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	DashboardPageObject dashboardPage;
	AboutUsPageObject aboutPage;
	SearchTermPageObject searchTermPage;
	CustomServicePageObject customServicePage;
	WebDriver browser;
	String os = System.getProperty("os.name");
	private String email, password;
	
  @Parameters("browser")
  @BeforeClass
  public void beforeClassxxx(String nameBrowser) {
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
			 System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe"); 
			 browser = new ChromeDriver();
		  }
		  else if(nameBrowser.equals("firefox")) {
				 System.setProperty("webdriver.gecko.driver", "browserDrivers/geckodriver.exe"); 
				 browser = new FirefoxDriver();
			  }
		  
	  }
	  
	  email = "minh"+this.randomNumber()+"@yahoo.com";
	  password = "123123";
	  
	  browser.get("http://live.demoguru99.com/");
	  browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  //Step: Open new Homepage
	  //homePage = new HomePageObject(browser);
	  homePage = PageGeneratorManager.getHomePage(browser);
  }
  @Test
  public void TC_01_Register() { 
	  
	  //Step: Click to open login & register page
	  loginPage = homePage.clickToMyAccount();
	  //loginPage = new LoginPageObject(browser);
	  
	  //Step: Click and open register page`		
	  registerPage = loginPage.clickToCreateAnAccount();
	  //registerPage = new RegisterPageObject(browser);
	  
	  
	  registerPage.enterFirstName("Minh");
	  registerPage.enterMiddleName("Ba");
	  registerPage.enterLastName("Pham");
	  registerPage.enterEmail(email);
	  registerPage.enterPassword(password);
	  registerPage.enterConfirmPassword(password);
	  dashboardPage = registerPage.clickRegister();
	  //dashboardPage = new DashboardPageObject(browser);
	  
	  String welcomeMsg=dashboardPage.getWelcomeMessage();
	  Assert.assertEquals(welcomeMsg, "Thank you for registering with Main Website Store.");
	  
	  
	  homePage = dashboardPage.clickLogout();
	  	  
	    
  }
  
  @Test
  public void TC_02_Login() {
	  //homePage = new HomePageObject(browser);
	  loginPage = homePage.clickToMyAccount();
	  //loginPage = new LoginPageObject(browser);
	  loginPage.enterEmail(email);
	  loginPage.enterPassword(password);
	  dashboardPage = loginPage.clickLoginBtn();
	  String loginMsg=dashboardPage.getLoginMessage();
	  Assert.assertTrue(loginMsg.contains("Hello"));
	  //dashboardPage = new DashboardPageObject(browser);
	  
  }
  
  @Test
  public void TC_03_Navigate_Page_In_Footer() {
	  aboutPage = dashboardPage.openAboutUsPage(browser);
	  
	  searchTermPage = aboutPage.openSearchTermPage(browser);
	  
	  customServicePage = searchTermPage.openCustomServicePage(browser);
	  
	  aboutPage = customServicePage.openAboutUsPage(browser);
	  
	  customServicePage = aboutPage.openCustomServicePage(browser);
  }
//	  advancedSearchPage = customServicePage.openAdvancedSearchPage();	  
	  
  @Test
  public void TC_04_Dynamic_Page_() {
	  customServicePage.openFooterByPageName(browser, AbstractPageUI.DYNAMIC_FOOTER_LINK, "About Us");
	  aboutPage = PageGeneratorManager.getAboutUsPage(browser);
	  customServicePage.openFooterByPageName(browser, AbstractPageUI.DYNAMIC_FOOTER_LINK, "Search Terms");
	  searchTermPage = PageGeneratorManager.getSearchTermPagePage(browser);
		  
  }
  @AfterClass
  public void afterClass() {
	  browser.quit();
  }
  
  Random rand = new Random();
	public int randomNumber() {
		return rand.nextInt(9999);
	}
  
}
