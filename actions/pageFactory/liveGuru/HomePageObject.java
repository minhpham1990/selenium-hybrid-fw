package pageFactory.liveGuru;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

public class HomePageObject {
	
	@FindBy(how=How.XPATH,using="//div[4]//ul[1]//li[1]//a[1]")
	private WebElement myAccountLink;
	
	@FindBy(xpath="//div[4]//ul[1]//li[1]//a[1]")
	private WebElement myAccLink;
	
	@FindBy(xpath="//input")
	private List<WebElement> textboxes;
	
	@FindBys({
		@FindBy(),
		@FindBy()
	})
	private List<WebElement> bothCriteria;
}
