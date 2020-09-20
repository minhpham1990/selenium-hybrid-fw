package commons;

import org.openqa.selenium.By;

public class AbstractPageUI {
	public static final By ABOUT_US_FOOTER_LINK = By.xpath("//a[contains(text(),'About Us')]");
	public final static By SEARCH_TERM_FOOTER_LINK = By.xpath("//a[contains(text(),'Search Terms')]");
	public final static By CUS_SERVICE_FOOTER_LINK = By.xpath("//a[contains(text(),'Customer Service')]");
	
	//public static final String 
	public static final String DYNAMIC_FOOTER_LINK = "//a[contains(text(),'%s')]";
	
	
}
