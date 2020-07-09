package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIs.liveGuru.HomePageUI;

public class HomePageObject extends AbtractPage{
	private WebDriver _pageDriver;
	
	
	//init constructor method
	public HomePageObject(WebDriver pageDriver) {
		this._pageDriver=pageDriver;
	}
	
	
	public void clickToMyAccount() {
		// TODO Auto-generated method stub
		clickToElement(_pageDriver, HomePageUI.MY_ACCOUNT_LOCATOR);
	}

}
