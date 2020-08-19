package pageFactory.liveGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPageObject extends AbstractPage{
	private WebDriver _pageDriver;
	
	public LoginPageObject(WebDriver driver) {
		this._pageDriver=driver;
		PageFactory.initElements(_pageDriver, this);
	}
	// UI
	@FindBy(xpath="//a[@class='button']//span//span")
	private WebElement CreateAnAccBtn;
	
	
	
	// Action
	public void clickToCreateAnAccount() {
		// TODO Auto-generated method stub
		clickToElement(_pageDriver, CreateAnAccBtn);
	}
}
