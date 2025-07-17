package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flipkart_SearchPage {

	@FindBy(name="q") private WebElement Searchkey;
	@FindBy(xpath="//button[@type='submit']") private WebElement clickbutton;
	@FindBy(xpath="(//div[@class='_30jeq3 _1_WHN1'])[1]") private WebElement prize;
	
	
	//constructor
	 public Flipkart_SearchPage(WebDriver driver)
	 {
		 PageFactory.initElements( driver,this);
	 }
	
    //methods action
	 
	 
	 public void Searchflipcart(String iphone)
	 {
		 Searchkey.sendKeys(iphone);
	 }
	 public void clickflipcart()
	 {
		clickbutton.click();
	 }
	 public void getprize()
	 {
		prize.click();
	 }
	 
	 
	}

