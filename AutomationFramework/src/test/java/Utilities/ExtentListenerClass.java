package Utilities;
//Utilities.ExtentListenerClass
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener{
	ExtentSparkReporter htmlreporter;
	ExtentReports reports;
	ExtentTest test;
	public void Configurereport()
	{
		ReadConfig readConfig=new ReadConfig();
		String timestamp=new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName="AutomationFreamwork-"+timestamp + "html";
		
		
		htmlreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports\\"+reportName);
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
		
		//add system information/envirnoment info reports
		
		reports.setSystemInfo("Machine", "testpc1");
		reports.setSystemInfo("OS","window 11");
		reports.setSystemInfo("browser:",readConfig.getBrowser());
		reports.setSystemInfo("user name:","Vaishali");
		
		//configuration to change look and feel the reports
		
		htmlreporter.config().setDocumentTitle("Extent Listener Report demo");
		htmlreporter.config().setReportName("This is my first report");
		htmlreporter.config().setTheme(Theme.DARK);
		
	}
	public void onStart(ITestContext Result)
	{
		Configurereport();
		System.out.println("On Start test method invoked-----");
	}
	public void onFinish(ITestContext Result)
	{
		
		System.out.println("On finish test  method invoked-----");//invoke only onces stsrt testcases
		reports.flush();//write test information on report and its mandatory to write
	}
	public void onTestFailure(ITestContext Result)
	{
		
		System.out.println("Name of  failed test  method invoked-----"+Result.getName());//invoke only onces after testcases finish
		test=reports.createTest(Result.getName());//create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: "+ Result.getName(),ExtentColor.RED));
		String screenshotspath=System.getProperty(("user.dir")+"\\Screenshots\\"+Result.getName()+".png");
		File screenShotfile=new File(screenshotspath);
		if(screenShotfile.exists())
		{
			test.fail(" captured screenshot is belowscreenshotspath"+ test.addScreenCaptureFromPath(screenshotspath));
		}
	//	test.addScreenCaptureFromPath(null)
		
	}
	public void onTestSkipped(ITestContext Result)
	{
		
		System.out.println("Name of  Skipped  test  method -----"+Result.getName());//invoke only onces after testcases finish
		test=reports.createTest(Result.getName());//create entry in html report
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped test case is: "+ Result.getName(),ExtentColor.YELLOW));
		
	}
	public void onTestSucess(ITestContext Result)
	{
		System.out.println("Name of  failed test  method invoked-----"+Result.getName());//invoke only onces after testcases finish
		test=reports.createTest(Result.getName());//create entry in html report
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: "+ Result.getName(),ExtentColor.GREEN));
	}
	public void onTestfailedButWithinSuccessPercentageSucess(ITestContext Result)
	{
		
	}
	
	

}
