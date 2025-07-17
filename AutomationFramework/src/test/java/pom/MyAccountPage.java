package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	//1.create object of webDriver
	
	  WebDriver Ldriver;
	//identify webelement
		
	  //Create new account
		@FindBy(id="email_create") WebElement CreateEmailId;
		@FindBy(id="SubmitCreate") WebElement ClickCreateAccount;
		
		//Already resistered user
		
		@FindBy(id="email") WebElement Registereduseremail;
		@FindBy(id="passwd") WebElement Registeredpassword;
		@FindBy(id="SubmitLogin")WebElement SignInLogin;
		
	
 //Constructor by using pagefactory
	
	public MyAccountPage(WebDriver Rdriver)
	{
     Ldriver=Rdriver;
     PageFactory.initElements(Rdriver, this);
	}
	
	
//method usases for identify Action on webelement
	
	public void EnterCreateEmailAddress(String emaiId)
	{
		CreateEmailId.sendKeys(emaiId);
	}
	public void clickonCreateAccount()
	{
		ClickCreateAccount.click();
	}
	
	
//Action methods for alrady resisterd
	public void resisteredEmailAddress(String ResisteredemaiId)
	{
		Registereduseremail.sendKeys(ResisteredemaiId);
	}
	public void Registeredpassword(String resigeredPasswoord)
	{
		Registeredpassword.sendKeys(resigeredPasswoord);
	}
	
	public void clickonSignin()
	{
		SignInLogin.click();
	}

}


