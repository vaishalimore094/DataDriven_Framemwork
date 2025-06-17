package Testcases;



import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	ReadConfig readfileconfig=new ReadConfig();
	String Url=readfileconfig.getBaseUrl();
	String Browser=readfileconfig.getBrowser();
	
	public static WebDriver driver;
	public static Logger logger;;
	
	//Setup browsers
	@BeforeClass
	 public void setup()
	 {
		switch(Browser.toLowerCase())
		 {
		 case"chrome":
		
			 WebDriverManager.chromedriver().setup();
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("--remote-allow-origins=*");
			 driver=new ChromeDriver(options);
			 break;
			 
		 case "msedge":
		 WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
		 break;
		 
	     case "Firefox":
		 WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
		 break;
		 default:
		 driver=null;
		 break;
	 }
	 
	 //use Waits
		
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	 
	
	 //for logging
	
	 logger=LogManager.getLogger("AutomationFreamwork");
	
	 //open url
		
		driver.get(Url);
		logger.info("url opened");
	 
	 }
	
	
	 //close browser
	
//	@AfterClass 
//	 public void closebrowser()
//	 {
//		 driver.close();
//		 driver.quit();
//	 }
	 
	//user method to capture screen shot
		public void captureScreenShot(WebDriver driver,String testName) throws IOException
		{
			//step1: convert webdriver object to TakesScreenshot interface
			TakesScreenshot screenshot = ((TakesScreenshot)driver);
			
			//step2: call getScreenshotAs method to create image file
			
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			
			File dest = new File(System.getProperty("user dir")+"\\Screenshots"+ testName + ".png");
		
			//step3: copy image file to destination
			FileHandler.copy(src,dest);
		}
		
 }

