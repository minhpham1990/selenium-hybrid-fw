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
	

}
