package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import pageUIs.liveGuru.RegisterPageUI;

public class RegisterPageObject extends AbtractPage{
	private WebDriver _pageDriver;
	
	public RegisterPageObject(WebDriver pageDriver) {
		this._pageDriver=pageDriver;
	}

	public RegisterPageObject enterFirstName(String value) {
		// TODO Auto-generated method stub
		setTextToElement(_pageDriver, RegisterPageUI.FIRSTNAME_TXB, value);
		return this;
	}

	public RegisterPageObject enterMiddleName(String value) {
		// TODO Auto-generated method stub
		setTextToElement(_pageDriver, RegisterPageUI.MIDNAME_TXB, value);
		return this;
	}

	public RegisterPageObject enterLastName(String value) {
		// TODO Auto-generated method stub
		setTextToElement(_pageDriver, RegisterPageUI.LASTNAME_TXB, value);
		return this;
	}

	public RegisterPageObject enterEmail(String value) {
		// TODO Auto-generated method stub
		setTextToElement(_pageDriver, RegisterPageUI.EMAIL_TXB, value);
		return this;
	}

	public RegisterPageObject enterPassword(String value) {
		// TODO Auto-generated method stub
		setTextToElement(_pageDriver, RegisterPageUI.PASSWORD_TXB, value);
		return this;
	}

	public RegisterPageObject enterConfirmPassword(String value) {
		// TODO Auto-generated method stub
		setTextToElement(_pageDriver, RegisterPageUI.PASSWORD_CONFIRM_TXB, value);
		return this;
	}

	public RegisterPageObject clickRegister() {
		// TODO Auto-generated method stub
		clickToElement(_pageDriver, RegisterPageUI.REGISTER_BTN);
		return this;
	}
	
	
	

}
