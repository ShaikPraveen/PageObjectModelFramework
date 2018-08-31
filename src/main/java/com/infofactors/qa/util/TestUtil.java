package com.infofactors.qa.util;


import com.infofactors.qa.base.TestBase;

public class TestUtil  extends TestBase
{
	
	public static long PAGE_LOAD_TIME=40;
	public static long IMPLICIT_TIME_OUT=20;
	
	
	
	 public void switchtoFrame()
	 {
		 driver.switchTo().frame("mainpanel");
		 
	 }
	 
	 
	 
	 
	 

}
