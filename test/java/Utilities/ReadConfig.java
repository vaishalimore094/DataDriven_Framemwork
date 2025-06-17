package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	Properties properties;
	String path="E:\\AutomationDataDriven_Freamwork\\AutomationFreammwork\\Configuration.properties\\Cofig.properties";
	public ReadConfig()
	{
		
		try {
			properties=new Properties();
			FileInputStream file=new FileInputStream(path);
			properties.load(file);
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
	}
	
	//baseUrl method
	
	public String getBaseUrl() 
	{
		String value=properties.getProperty("baseUrl");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config properties file");
	}
	//browser method
	public String getBrowser() 
	{
		String value=properties.getProperty("browser");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("browser not specified in config properties file");
	}

}
