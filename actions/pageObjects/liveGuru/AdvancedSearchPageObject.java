package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;

public class AdvancedSearchPageObject extends AbstractPage{
	WebDriver _pageDriver;
	public AdvancedSearchPageObject(WebDriver driver) {
		this._pageDriver = driver;
	}
}
