package com.infofactors.qa.testcaes;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.infofactors.pages.ContactsPage;
import com.infofactors.pages.HomePage;
import com.infofactors.pages.LoginPage;
import com.infofactors.pages.TaskPage;
import com.infofactors.qa.base.TestBase;
import com.infofactors.qa.util.TestUtil;

public class TaskPageTest extends TestBase
{
	 HomePage homepage;
	 LoginPage loginpage;
	 TestUtil testutil;
	 ContactsPage contactpage; 
	 TaskPage taskpage;
	 
	public TaskPageTest()
	{
		super();
	}
	
	
	 @BeforeMethod
	 public void setup() 
	 {
		 intialization();
		 testutil=new TestUtil();
		 contactpage=new ContactsPage();
		 LoginPage loginpage=new LoginPage();
		 homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		 testutil.switchtoFrame();
		 contactpage=homepage.clickcontactsLink();
		 taskpage=new TaskPage();
		 taskpage=homepage.clickcTaskLink(); 
	 }
	
	   @Test
	   public void clickcheckBoxTest()
	   {
		    taskpage.clickcheckBox(); 
	   }
	   
	   @Test
	   public void clicknewTaskItemTest()
	   {
		   taskpage.clicknewtaskItem();
	   }
	
	 
	 
	/* @AfterMethod
	 public void teardown()
	 {
		 driver.close();
	 }*/
	
	
	
	
	
	
	

	
	
	
}
