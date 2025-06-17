package pom;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
//1.create object of webDriver
	
	  WebDriver Ldriver;
	
	  //identify webelement
		
		@FindBy(linkText="Sign in") WebElement signIn;
		
	
   //Constructor by using pagefactory
	
	public indexPage(WebDriver Rdriver)
	{
       Ldriver=Rdriver;
       PageFactory.initElements(Rdriver, this);
	}
	
	
	
	
	//method usases for identify Action on webelement
	public void clickonSign()
	{
		signIn.click();
	}

}
