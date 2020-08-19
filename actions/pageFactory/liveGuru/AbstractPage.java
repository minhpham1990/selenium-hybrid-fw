package pageFactory.liveGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	//wait click element
	private WebDriverWait explicitWait;
	private long longTimeout=30;
	public void waitElementClickAble(WebDriver driver,WebElement element) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//wait visible element
	public void waitElementVisible(WebDriver driver,WebElement element, int timeout) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//get text element
	public String getTextElement(WebElement element) {
		return element.getText();
	}
	
	//send text element
	public void sendTextElement(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	//click element
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
}
