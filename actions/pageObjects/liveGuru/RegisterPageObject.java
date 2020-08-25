package pageObjects.liveGuru;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveGuru.RegisterPageUI;

public class RegisterPageObject extends AbstractPage{
	private WebDriver _pageDriver;
	
	public RegisterPageObject(WebDriver pageDriver) {
		this._pageDriver=pageDriver;
	}

	public void enterFirstName(String value) {
		// TODO Auto-generated method stub
		waitForDisplay(_pageDriver, RegisterPageUI.FIRSTNAME_TXB);
		setTextToElement(_pageDriver, RegisterPageUI.FIRSTNAME_TXB, value);
	}

	public void enterMiddleName(String value) {
		// TODO Auto-generated method stub
		setTextToElement(_pageDriver, RegisterPageUI.MIDNAME_TXB, value);
		
	}

	public void enterLastName(String value) {
		// TODO Auto-generated method stub
		setTextToElement(_pageDriver, RegisterPageUI.LASTNAME_TXB, value);
	}

	public void enterEmail(String value) {
		// TODO Auto-generated method stub
		setTextToElement(_pageDriver, RegisterPageUI.EMAIL_TXB, value);
	}

	public void enterPassword(String value) {
		// TODO Auto-generated method stub
		setTextToElement(_pageDriver, RegisterPageUI.PASSWORD_TXB, value);
	}

	public void enterConfirmPassword(String value) {
		// TODO Auto-generated method stub
		setTextToElement(_pageDriver, RegisterPageUI.PASSWORD_CONFIRM_TXB, value);
	}

	public DashboardPageObject clickRegister() {
		// TODO Auto-generated method stub
		clickToElement(_pageDriver, RegisterPageUI.REGISTER_BTN);
		//return new DashboardPageObject(_pageDriver);
		return PageGeneratorManager.getDashBoardPage(_pageDriver);
	}
	
	
	
	
	
	

}
