package com.infofactors.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.infofactors.qa.base.TestBase;

public class TaskPage extends TestBase
{
	public TaskPage()
	{
		PageFactory.initElements(driver, this);
	}

	
	 @FindBy(xpath="//input[@type='checkbox' and @name='cs_save_search']")
	 WebElement clickcheckbox;
	 
	 @FindBy(xpath="//a[contains(text(),'New Task')]")
	 WebElement newtask;
	 
	 @FindBy(xpath="//a[contains(text(),'Tasks')]")
     WebElement taskslink;
	
	  public  void clickcheckBox()
	  {
	     clickcheckbox.click(); 
	 
	  }
	
	  
	  public void clicknewtaskItem()
	  {
		  Actions act=new Actions(driver);
		  act.moveToElement(taskslink).build().perform();
		  newtask.click();
	  }

	
}
