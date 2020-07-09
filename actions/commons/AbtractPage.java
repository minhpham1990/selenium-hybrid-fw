package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class AbtractPage {
	
	// action for browser
	public void openPageUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public void backPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	private Alert alert;
	private WebElement element;
	private Select dropdown;
	
	public void acceptAlert(WebDriver driver) {
		alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void dismissAlert(WebDriver driver) {
		alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public String getTextAlert(WebDriver driver) {
		alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	//action for element
	public WebElement find(WebDriver driver, By locator) {
		return driver.findElement(locator);
	}
	
	public void clickToElement(WebDriver driver, By locator) {
		find(driver,locator).click();
	}
	
	public void setTextToElement(WebDriver driver, By locator, String text) {
		element = find(driver,locator);
		element.clear();
		element.sendKeys(text);
	}
	
	public String getTextFromElement(WebDriver driver, By locator) {
		element = find(driver,locator);
		return element.getText();
	}

	
}
