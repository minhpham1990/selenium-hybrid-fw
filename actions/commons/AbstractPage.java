package commons;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
	
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
	
	
	public void pauseBrowser(long timeSleep) {
		try {
			Thread.sleep(timeSleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Wait element
	private WebDriverWait explicitWait;
	public void waitForDisplay(WebDriver driver, By locator,int timeout) {	
		explicitWait = new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForUnDisplay(WebDriver driver, By locator,int timeout) {	
		explicitWait = new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public void takeScreenshot(WebDriver driver) {
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("uploadFiles/screenshot1.jpg");
		try {
			FileUtils.copyFile(SrcFile,DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
}
