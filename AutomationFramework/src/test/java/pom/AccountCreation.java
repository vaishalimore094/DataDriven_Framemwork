package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreation {
	
		//1.create object of webDriver
			
			  WebDriver Ldriver;
			
			  //identify webelement
				
				@FindBy(id="id_gender2") WebElement TitleMr;
				@FindBy(id="customer_firstname") WebElement Name;
				@FindBy(id="customer_lastname") WebElement LastName;
				@FindBy(id="passwd") WebElement Password;
				@FindBy(id="submitAccount") WebElement Register;
				
			
		   //Constructor by using pagefactory
			
			public AccountCreation(WebDriver Rdriver)
			{
		       Ldriver=Rdriver;
		       PageFactory.initElements(Rdriver, this);
			}
			
			
			
			
			//method usases for identify Action on webelement
			public void SelectTitle()
			{
				TitleMr.click();
			}
			public void CustomerName(String Cname)
			{
				Name.sendKeys(Cname);
				
			}
			public void CustomerLastName(String CLname)
			{
				LastName.sendKeys(CLname);
				
			}
			public void CustomerPassword(String CPassword)
			{
				Password.sendKeys(CPassword);
				
			}
			public void clickonRegister()
			{
				Register.click();
			}

		}



