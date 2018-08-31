package com.infofactors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.infofactors.qa.base.TestBase;

public class ContactsPage extends TestBase
{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactlabel;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement surname;
	
	@FindBy(id="company_position")
	WebElement position;
	
	@FindBy(id="department")
	WebElement department;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactlable()
	{
		return contactlabel.isDisplayed();
	}
	
	public void selectContactsByName(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	
	public void createNewContact(String title,String fn,String sn, String pos, String dept)
	{
		Select sele=new Select(driver.findElement(By.name("title")));
		sele.deselectByVisibleText(title);
		firstname.sendKeys(fn);
		surname.sendKeys(sn);
		position.sendKeys(pos);
		department.sendKeys(dept);
		saveBtn.click();

	}
}
