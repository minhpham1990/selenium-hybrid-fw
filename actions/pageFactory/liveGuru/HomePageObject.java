package pageFactory.liveGuru;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends AbstractPage{
	private WebDriver _pageDriver;
	
	public HomePageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this._pageDriver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//div[@class='footer']//a[@title=\"My Account\"]")
	private WebElement myAccountLink;
	
//	@FindBy(xpath="//div[4]//ul[1]//li[1]//a[1]")
//	private WebElement myAccLink;
//	
//	@FindBy(xpath="//input")
//	private List<WebElement> textboxes;
//	
//	@FindBys({
//		@FindBy(),
//		@FindBy()
//	})
//	private List<WebElement> bothCriteria;
//	
//	@FindAll({
//		@FindBy(),
//		@FindBy()
//	})
//	private List<WebElement> eitherCriteria;
	
	public void clickToMyAccount() {
		waitElementClickAble(_pageDriver, myAccountLink);
		clickToElement(_pageDriver, myAccountLink);
	}
}
