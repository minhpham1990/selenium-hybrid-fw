package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;
import pageUIs.liveGuru.DashboardPageUI;

public class DashboardPageObject extends AbstractPage{
	WebDriver _pageDriver;
	
	public DashboardPageObject(WebDriver pageDriver) {
		this._pageDriver=pageDriver;
	}
	public String getWelcomeMessage() {
		// TODO Auto-generated method stub
		return getTextFromElement(_pageDriver,DashboardPageUI.REGISTER_SUCCESS_MSG);
	}
	
	public String getLoginMessage() {
		return getTextFromElement(_pageDriver,DashboardPageUI.LOGIN_SUCCESS_MSG);
	}
	public HomePageObject clickLogout() {
		// TODO Auto-generated method stub
		waitElementClickAble(_pageDriver, DashboardPageUI.ACCOUNT_ICON);
		clickToElement(_pageDriver, DashboardPageUI.ACCOUNT_ICON);
		waitElementClickAble(_pageDriver, DashboardPageUI.LOGOUT_INDEX_MENU);
		clickToElement(_pageDriver, DashboardPageUI.LOGOUT_INDEX_MENU);
		//return new HomePageObject(_pageDriver);
		return PageGeneratorManager.getHomePage(_pageDriver);
	}
	
	

}
