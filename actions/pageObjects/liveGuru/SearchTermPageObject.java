package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveGuru.SearchTermPageUI;

public class SearchTermPageObject extends AbstractPage{
	WebDriver _pageDriver;
	public SearchTermPageObject(WebDriver driver) {
		this._pageDriver = driver;
	}
	
}
