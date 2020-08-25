package pageUIs.liveGuru;

import org.openqa.selenium.By;

public class LoginPageUI {
	public static final By CREATE_AN_ACCOUNT_BTN = By.xpath("//a[@class='button']//span//span");
	public static final By EMAIL_TXT = By.xpath("//input[@id='email']");
	public static final By PASSWORD_TXT = By.xpath("//input[@id='pass']");
	public static final By LOGIN_BTN = By.xpath("//button[@id='send2']");
}
