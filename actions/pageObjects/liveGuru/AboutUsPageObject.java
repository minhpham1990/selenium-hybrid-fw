package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveGuru.AboutUsPageUI;

public class AboutUsPageObject extends AbstractPage{
	WebDriver _pageDriver;
	
	public AboutUsPageObject(WebDriver driver) {
		this._pageDriver = driver;
	}

	
}
