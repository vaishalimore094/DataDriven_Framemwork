package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResigsterdUserAccount {
	//1.create object of webDriver
	
	  WebDriver Ldriver;
	    //identify webelement
		
		@FindBy(xpath="//a[@title='View my customer account']") WebElement UserName;
		
		//signout
		@FindBy(linkText="Sign Out") WebElement SignOut;
		
		
	
//Constructor by using pagefactory
	
	public ResigsterdUserAccount(WebDriver Rdriver)
	{
   Ldriver=Rdriver;
   PageFactory.initElements(Rdriver, this);
	}
	
	
//method usases for identify Action on webelement
	
	public String getusername()
	{
		String text = UserName.getText();
		return text;
		
	}
	public void clickonsignout()
	{
		
		SignOut.click();
	}
	
}




