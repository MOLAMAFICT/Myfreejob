package com.qa.pompages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.pombase.TestBase;
// this  is  the page library for home page
public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User:Naveen K')]")
	@CacheLookup // store data in the cache memory, however if the page is 
	             // if the page is refreshed , it will be  faulty 
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contacts')]")
	WebElement newContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	
	//initializing the objects
	public HomePage(){
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		
		return driver.getTitle();
	}
public boolean verifyCorrectUserName(){
		
	return	 userNameLabel.isDisplayed();
		 
	}
    
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	/*public ContactPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactPage();
		
	}*/
	public void clickOnNewContactsLink(){
		Actions  action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
		
	}
}
