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

public class ContactsPageTest extends TestBase
{
	 HomePage homepage;
	 LoginPage loginpage;
	 TestUtil testutil;
	 ContactsPage contactpage;
	
	public ContactsPageTest()
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
		 System.out.println("YES");
		 
	 }
	 
	 @Test(priority=1)
	 public void verifyContactsLableTest()
	 {
		 Assert.assertTrue(contactpage.verifyContactlable(),"Contacts lable is Missing on the Page");
	 }
	 
	 @Test(priority=2)
	 public void selectContactTest()
	 {
		 contactpage.selectContactsByName("praveen shaik");
	 }
	 
	 @Test(priority=3)
	 public void selectMultipleContactsTest()
	 {
		 contactpage.selectContactsByName("praveen shaik");
		 contactpage.selectContactsByName("jamsa bhai");
	 }
	 
	 @Test(priority=4)
	 public void validateCreateNewContactTest() throws InterruptedException 
	 {
		 Thread.sleep(2000);
		 homepage.clickOnNewContactLink();
		 contactpage.createNewContact("Mr.", "Scott", "Tiger", "Tester", "QA");
	 }
	 
	 
	 
	 @AfterMethod
	 public void teardown()
	 {
		 driver.close();
	 }
	

}
