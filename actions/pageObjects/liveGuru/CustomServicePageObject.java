package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveGuru.AboutUsPageUI;
import pageUIs.liveGuru.CusServicePageUI;

public class CustomServicePageObject extends AbstractPage{
	WebDriver _pageDriver;
	public CustomServicePageObject(WebDriver driver) {
		this._pageDriver = driver;
	}
	
	
}