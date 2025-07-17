package TestPacage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Testbaseclass {
	public WebDriver driver;
	@BeforeClass
	public void browsesetup()
	{
		System.setProperty("webdriver.chrome.driver","D:\\selenium setup\\chromedriver-win32\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		//driver.get("https://www.amazon.in");
		
		
		
			
	}
	
	
	}
