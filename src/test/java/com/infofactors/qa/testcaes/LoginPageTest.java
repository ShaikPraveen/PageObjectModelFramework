package com.infofactors.qa.testcaes;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.infofactors.pages.HomePage;
import com.infofactors.pages.LoginPage;
import com.infofactors.qa.base.TestBase;

public class LoginPageTest extends TestBase 
{
	LoginPage loginpage;
	HomePage  homepage;
	
	  public LoginPageTest()
	  {
		   super();
	  }
	  
	  @BeforeMethod
	  public void setUp()
	  {
		  intialization();
		  loginpage=new LoginPage();  
	  }
	  
	    @Test(priority=1)
	    public void verifyLoginPagetitleTest()
	    {
	    	String title=loginpage.verifyLoginpageTitle();
	    	Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	    }
	    
	    @Test(priority=2)
	    public void verifycrmLogoTest()
	    {
	    	boolean flag=loginpage.verifyCrmLogo();
	    	Assert.assertTrue(flag);
	    }
	    
	    @Test(priority=3)
	    public void loginTest()
	    {
	    	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
	    }
	 
	  @AfterMethod
	  public void tearDown()
	  {
		  driver.close();
	  }

}
