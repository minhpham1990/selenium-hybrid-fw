package com.java.basic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class Casting_Type {
	private static final WebElement e = null;

	// Array: co dinh
	static String[] address= {"NhaTrang","Hanoi", "SaiGon"};
	
	static List<WebElement> textbox;
 
	static List<String> helloList;		 
	//Collection: List/ Set? Queue
	static List<String> city = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		city.add("can tho");
		city.add("bac lieu");
//		helloList.add("vy");
		
		// TODO Auto-generated method stub
		System.out.println(address[2].toString());
		System.out.println(city.get(1));
		//System.out.println(helloList.get(1));
	}

}
