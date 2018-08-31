package com.infofactors.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.infofactors.qa.base.TestBase;

public class LoginPage extends TestBase 
{
	
	//Page Factory : OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(linkText="Sign Up")
	WebElement signupLink;
	
	@FindBy(xpath="//img[@class='img-responsive' and @alt='free crm logo']")
	WebElement crmLogo;
	
	
	   //Initializing the Objects
	   public LoginPage()
	   {
		   PageFactory.initElements(driver, this);   
	   }
	   
	   //Actions
	   public String verifyLoginpageTitle()
	   {
		  return driver.getTitle(); 
	   }
	   
	   public boolean verifyCrmLogo()
	   {
		   return crmLogo.isDisplayed();
	   }
	   
	   public HomePage login(String un, String pwd)
	   {
		   username.sendKeys(un);
		   password.sendKeys(pwd);
		   loginBtn.click();
		   
		   return new HomePage();
	   }
	
	
}
