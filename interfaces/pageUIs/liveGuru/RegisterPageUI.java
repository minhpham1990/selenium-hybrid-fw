package pageUIs.liveGuru;

import org.openqa.selenium.By;

public class RegisterPageUI {
	public static final By REGISTER_BTN = By.xpath("//div[@class='buttons-set']//button[@class='button']");
	public static final By FIRSTNAME_TXB = By.xpath("//input[@id='firstname']");
	public static final By MIDNAME_TXB = By.xpath("//input[@id='middlename']");
	public static final By LASTNAME_TXB = By.xpath("//input[@id='lastname']");
	public static final By EMAIL_TXB = By.xpath("//input[@id='email_address']");
	public static final By PASSWORD_TXB = By.xpath("//input[@id='password']");
	public static final By PASSWORD_CONFIRM_TXB = By.xpath("//input[@id='confirmation']");
}
