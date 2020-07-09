package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends AbtractPage{
	
	private WebDriver _pageDriver;
	
	public LoginPageObject(WebDriver pageDriver){
		this._pageDriver=pageDriver;
	}
	
	public void clickToCreateAnAccount() {
		// TODO Auto-generated method stub
		clickToElement(_pageDriver, LoginPageUI.CREATE_AN_ACCOUNT_BTN);
	}

}
