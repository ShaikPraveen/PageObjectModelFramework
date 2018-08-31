package com.infofactors.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.infofactors.qa.base.TestBase;

public class HomePage extends TestBase
{
	
	@FindBy(xpath="//td[contains(text(),'User: gopi kamma')]")
	WebElement namedisplayed;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskslink;
	
	@FindBy(xpath="//a[contains(text(),'Email')]")
	WebElement emaillink;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newcontactlink;

	////a[contains(text(),'New Contact')]
	
	      public HomePage()
	      {
	    	PageFactory.initElements(driver, this);
	      }
	      
	      public String verifyhomepageTitle()
	      {
	    	  return driver.getTitle();
	      }
	      
	      public boolean verifycorrecrusername()
	      {
	    	 return namedisplayed.isDisplayed();
	      }
	      
	      
	      public ContactsPage clickcontactsLink()
	      {
	    	  contactslink.click();
	    	  return new ContactsPage();
	      }
	      
	      
	      
	      public DealsPage clickcDealsLink()
	      {
	    	  contactslink.click();
	    	  return new DealsPage();
	      }
	      
	      
	      public TaskPage clickcTaskLink()
	      {
	    	  taskslink.click();
	    	  return new TaskPage();
	      }
	      
	      public EmailPage clickcEmailLink()
	      {
	    	  emaillink.click();
	    	  return new EmailPage();
	      }
	      
	       public void clickOnNewContactLink() throws InterruptedException
	       {
	    	 
	    	 Actions act=new Actions(driver);
	    	 act.moveToElement(contactslink).build().perform();
	    	 newcontactlink.click();
	    	 System.out.println("OK");	 
	      }
}
