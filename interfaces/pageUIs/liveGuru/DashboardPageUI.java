package pageUIs.liveGuru;

import org.openqa.selenium.By;

public class DashboardPageUI {
	public static final By REGISTER_SUCCESS_MSG=By.xpath("//li[@class='success-msg']//ul//li//span");
	public static final By ACCOUNT_ICON = By.xpath("//span[@class='label' and text()='Account']");
	public static final By LOGOUT_INDEX_MENU = By.xpath("//a[@title='Log Out']");
	public static final By LOGIN_SUCCESS_MSG= By.xpath("//p[@class='hello']/strong");
}
