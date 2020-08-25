package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends AbstractPage{
	
	private WebDriver _pageDriver;
	
	public LoginPageObject(WebDriver pageDriver){
		this._pageDriver=pageDriver;
	}
	
	public RegisterPageObject clickToCreateAnAccount() {
		// TODO Auto-generated method stub
		clickToElement(_pageDriver, LoginPageUI.CREATE_AN_ACCOUNT_BTN);
		//return new RegisterPageObject(_pageDriver);
		return PageGeneratorManager.getRegisterPage(_pageDriver);
	}

	public void enterEmail(String email) {
		// TODO Auto-generated method stub
		setTextToElement(_pageDriver, LoginPageUI.EMAIL_TXT, email);
		
	}

	public void enterPassword(String password) {
		// TODO Auto-generated method stub
		setTextToElement(_pageDriver, LoginPageUI.PASSWORD_TXT, password);
	}

	public DashboardPageObject clickLoginBtn() {
		// TODO Auto-generated method stub
		clickToElement(_pageDriver, LoginPageUI.LOGIN_BTN);
		//return new DashboardPageObject(_pageDriver);
		return PageGeneratorManager.getDashBoardPage(_pageDriver);
		
	}

}
