package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends AbstractPage{
	
	private WebDriver _pageDriver;
	
	public LoginPageObject(WebDriver pageDriver){
		this._pageDriver=pageDriver;
	}
	
	public void clickToCreateAnAccount() {
		// TODO Auto-generated method stub
		clickToElement(_pageDriver, LoginPageUI.CREATE_AN_ACCOUNT_BTN);
	}

}
