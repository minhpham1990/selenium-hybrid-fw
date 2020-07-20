package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbtractTest {
	public void sendTextToDynamicField(WebDriver driver,By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}
}
