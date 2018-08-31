package com.infofactors.qa.testcaes;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.infofactors.pages.ContactsPage;
import com.infofactors.pages.HomePage;
import com.infofactors.pages.LoginPage;
import com.infofactors.qa.base.TestBase;
import com.infofactors.qa.util.TestUtil;

public class HomePageTest extends TestBase
{
	 HomePage homepage;
	 LoginPage loginpage;
	 TestUtil testutil;
	 ContactsPage contactpage;
	
	 public HomePageTest()
	 {
		 super();
	 }
	 
	 
	 @BeforeMethod
	 public void setup()
	 {
		 intialization();
		 testutil=new TestUtil();
		 contactpage=new ContactsPage();
		 loginpage=new LoginPage();
		 homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	 }
	 
	 @Test(priority=1)
	 public void verifyhomepageTitleTest()
	 {
		 String homepageTitle=homepage.verifyhomepageTitle();
		 Assert.assertEquals(homepageTitle, "CRMPRO","Title is not Matched");	 
	 }
	 
	 @Test(priority=2)
	 public void verifyhomepagenameTest()
	 {
		testutil.switchtoFrame();
		Assert.assertTrue(homepage.verifycorrecrusername());
	 }
	 
	 @Test(priority=3)
	 public void verifycontactlinkTest()
	 {
		testutil.switchtoFrame(); 
		contactpage= homepage.clickcontactsLink();
	 }
	 
	 
	 
	 @AfterMethod
	 public void teardown()
	 {
		 driver.close();
	 }
	 
	 

}
