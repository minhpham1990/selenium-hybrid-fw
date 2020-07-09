package com.guru.user;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class User_01_Order {
  @Test(dataProvider="getData")
  public void Order_01_EmptyAllField(String Name, String Product) {
	  {
		  System.out.println("your username is: "+Name);
		  System.out.println("your product order is: "+Product);
	  }
	  
	  
  }
  
  
  @DataProvider(name="getData")
  public Object[][] UserAndOrder(){
	  return new Object[][] {
		  {"minh","Iphone X"},
		  {"vy", "iphone 8"},
		  
	  };
  }
  
}
