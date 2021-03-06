package commons;

import java.io.File;
import java.io.IOException;
import java.util.List;
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

import pageObjects.liveGuru.AboutUsPageObject;
import pageObjects.liveGuru.CustomServicePageObject;
import pageObjects.liveGuru.PageGeneratorManager;
import pageObjects.liveGuru.SearchTermPageObject;
import pageUIs.liveGuru.AboutUsPageUI;
import pageUIs.liveGuru.DashboardPageUI;
import pageUIs.liveGuru.SearchTermPageUI;

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
	
	public void clickToElement(WebDriver driver,String locator) {
		driver.findElement(By.xpath(locator)).click();
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
	private long timeout=10;
	public void waitForDisplay(WebDriver driver, By locator) {	
		explicitWait = new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForUnDisplay(WebDriver driver, By locator) {	
		explicitWait = new WebDriverWait(driver,timeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public void waitElementClickAble(WebDriver driver,By locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	
	//ham open c�c page , chi nen mo nhung menu chung trong footer , header
	public AboutUsPageObject openAboutUsPage(WebDriver driver) {
		// TODO Auto-generated method stub
		waitElementClickAble(driver, AbstractPageUI.ABOUT_US_FOOTER_LINK);
		clickToElement(driver, AbstractPageUI.ABOUT_US_FOOTER_LINK);
		return PageGeneratorManager.getAboutUsPage(driver);
	}
	
	
	public SearchTermPageObject openSearchTermPage(WebDriver driver) {
		// TODO Auto-generated method stub	
		waitElementClickAble(driver, AbstractPageUI.SEARCH_TERM_FOOTER_LINK);
		clickToElement(driver,AbstractPageUI.SEARCH_TERM_FOOTER_LINK);
		return PageGeneratorManager.getSearchTermPagePage(driver);
	}

	public CustomServicePageObject openCustomServicePage(WebDriver driver) {
		// TODO Auto-generated method stub
		waitElementClickAble(driver,AbstractPageUI.CUS_SERVICE_FOOTER_LINK);
		clickToElement(driver,AbstractPageUI.CUS_SERVICE_FOOTER_LINK);
		return PageGeneratorManager.getCusServicePage(driver);
	}
	
	
	//Using dynamic page
	public String getDynamicLocator(String xpathDynamic, String value) {
		return String.format(xpathDynamic, value);
	}	
	public void openFooterByPageName(WebDriver driver,String locator, String Pagename) {
		clickToElement(driver, getDynamicLocator(locator, Pagename));
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
