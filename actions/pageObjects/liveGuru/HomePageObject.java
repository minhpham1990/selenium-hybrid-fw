package pageObjects.liveGuru;

import commons.AbtractPage;
import pageUIs.liveGuru.HomePageUI;

public class HomePageObject extends AbtractPage{
	//init constructor method
	public HomePageObject() {
		
	}
	
	
	public void clickToMyAccount() {
		// TODO Auto-generated method stub
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LOCATOR);
	}

}
