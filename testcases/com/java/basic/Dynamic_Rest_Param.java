package com.java.basic;

import org.openqa.selenium.By;

public class Dynamic_Rest_Param {
	public static final String DYNAMIC_FOOTER_PAGE="//div[@class='footer']//a//[@text='%s']//";
	public static final String DYNAMIC_PAGE="//div[@class='%s']//a//[@text='%s']//";
	public static final By ABOUT_US_FOOTER_LINK = By.xpath("//a[contains(text(),'About Us')]");
	public static void main(String[] args) {
		clickElement(DYNAMIC_FOOTER_PAGE,"About Us");
		clickElement(DYNAMIC_PAGE,"Header","About Us");
	}
	
	public static void clickElement(String dynamicLocator, String pageName) {
		dynamicLocator = String.format(dynamicLocator, pageName);
		System.out.println(dynamicLocator);
	}
	
	
	public static void clickElement(String dynamicLocator, String menuPosition, String pageName ) {
		dynamicLocator = String.format(dynamicLocator, menuPosition, pageName );
		System.out.println(dynamicLocator);
	}
	
	//Rest param vd: String... values dai dien cho  multi param
	public static void  clickElement(String dynamicLocator, String... values) {
		dynamicLocator = String.format(dynamicLocator, (Object[]) values);
		System.out.println(dynamicLocator);
	}
}
