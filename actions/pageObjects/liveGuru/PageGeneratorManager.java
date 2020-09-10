package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static HomePageObject getHomePage(WebDriver _pageDriver) {
		return new HomePageObject(_pageDriver);
	}
	
	public static DashboardPageObject getDashBoardPage(WebDriver _pageDriver) {
		return new DashboardPageObject(_pageDriver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver _pageDriver) {
		return new LoginPageObject(_pageDriver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver _pageDriver) {
		return new RegisterPageObject(_pageDriver);
	}

	public static AboutUsPageObject getAboutUsPage(WebDriver _pageDriver) {
		// TODO Auto-generated method stub
		return new AboutUsPageObject(_pageDriver);
	}
	
	public static SearchTermPageObject getSearchTermPagePage(WebDriver _pageDriver) {
		// TODO Auto-generated method stub
		return new SearchTermPageObject(_pageDriver);
	}

	public static CustomServicePageObject getCusServicePage(WebDriver aaa) {
		// TODO Auto-generated method stub
		return new CustomServicePageObject(aaa);
	}
	
	
	

}
