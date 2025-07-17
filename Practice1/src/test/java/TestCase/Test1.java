package TestPacage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.Flipcart_Serchresultpage;
import POM.Flipkart_SearchPage;

public class Test1 extends Testbaseclass {
	Flipkart_SearchPage search;
	Flipcart_Serchresultpage result;
	
	@BeforeMethod
	public void Launchbrowser() throws InterruptedException
	{
		 //browsesetup();
		 search=new Flipkart_SearchPage(driver);
		 Thread.sleep(1000);
		 result= new Flipcart_Serchresultpage (driver);
	}
	
	@Test
	public void takeaction()
	{
		
		 search.Searchflipcart("REDMI 12 5G (Pastel Blue, 256 GB)  (8 GB RAM)");
		 
		 search.clickflipcart();
		 search.getprize();
	}
	@Test
	public void gettprize()
	{
		 result.getresultprize();
		 
	}
	

}
