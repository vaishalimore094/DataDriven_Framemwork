package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flipcart_Serchresultpage {
	
	////div[@class='_30jeq3 _16Jk6d']
	
	@FindBy(xpath="(//div[text()='₹14,999'])[1]") private WebElement takeprize;
	
	
	//constructor
	 public Flipcart_Serchresultpage(WebDriver driver)
	 {
		 PageFactory.initElements( driver,this);
	 }
	
    //methods action
	 
	 
	 public void getresultprize()
	 {
		 String getflipcartresult = takeprize.getText();
		 System.out.println(getflipcartresult);
	 }
	 
	 

}
