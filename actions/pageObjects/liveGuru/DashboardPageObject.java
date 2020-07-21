package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;
import commons.AbtractPage;
import pageUIs.liveGuru.DashboardPageUI;

public class DashboardPageObject extends AbtractPage{
	WebDriver _pageDriver;
	
	public DashboardPageObject(WebDriver pageDriver) {
		this._pageDriver=pageDriver;
	}
	public String getWelcomeMessage() {
		// TODO Auto-generated method stub
		return getTextFromElement(_pageDriver,DashboardPageUI.REGISTER_SUCCESS_MSG);
	}
	
	

}
