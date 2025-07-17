package Testcases;




import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ReadExcelFile;
import pom.MyAccountPage;
import pom.ResigsterdUserAccount;
import pom.indexPage;

public class TC2_SignInAccountPage2_Excelread extends BaseClass {
	
//	@Test(dataProvider="LoginDataProvider")
//	public void verifylogin(String userEmail,String userPAssword) 
//	{
//		
//		    //signup/indexpage object
//		
//				indexPage indexpg=new indexPage(driver);
//				indexpg.clickonSign();
//				logger.info("Clickon signUP button");
//				
//				//Myaccountpageobject
//				
//				MyAccountPage accountpg=new MyAccountPage(driver);
//				
//			    accountpg.resisteredEmailAddress(userEmail);
//			    logger.info("Emtered email address");
//			    
//				accountpg.Registeredpassword(userPAssword);
//				logger.info("Emtered email password");
//				
//				
//				accountpg.clickonSignin();
//				logger.info("Clickon signin button");
//				
//				
//				//registeredUserAccount
//				
//				ResigsterdUserAccount reguser= new ResigsterdUserAccount(driver);
//				String ActualUsername = reguser.getusername();
//				
//				
//				if(ActualUsername.equals("Vaishali More"))
//				{
//					logger.info("VerifyLogin,Passed");
//					Assert.assertTrue(true);
//					
//					reguser.clickonsignout();
//				}
//				else
//				{
//					logger.info("VerifyLogin,failed");
//					Assert.assertTrue(false);
//					
//					//captureScreenShot(driver,"verifylogin");
//				}
//	}
//						
//	
//	
////	@DataProvider(name="LoginDataProvider")
////	public String[][] LoginDataProvider() throws EncryptedDocumentException, IOException 
////	{
////		
////		String filePath="E:\\AutomationDataDriven_Freamwork\\AutomationFreammwork\\TestData\\Book1.xlsx";
////	
////		//String sheetName ="LoginTestData";
////		
////		int ttlRows = ReadExcelFile.getRowCount(filePath,"LoginTestData");
////		System.out.println("Total Rows: " + ttlRows);
////    	int ttlColumns = ReadExcelFile.getcolCount(filePath,"LoginTestData");
////		System.out.println("Total colums: " +ttlColumns );
////
////		String data[][]=new String[ttlRows-1][ttlColumns];
////
////		for(int i=1;i<ttlRows;i++)//rows =1,2
////		{
////			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
////			{
////
////				data[i-1][j]=ReadExcelFile.getcellvalue(filePath,"LoginTestData", i,j);
////			}
////
////		}
////		return data;
////	}
//// 
////}
//	@DataProvider(name = "LoginDataProvider")
//	public String[][] LoginDataProvider()
//	{
//		//System.out.println(System.getProperty("user.dir"));
//		String fileName ="E:\\AutomationDataDriven_Freamwork\\AutomationFreammwork\\TestData\\Book1.xlsx";
//
//		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
//		int ttlColumns = ReadExcelFile.getcolCount(fileName, "LoginTestData");
//	
//
//		String data[][]=new String[ttlRows-1][ttlColumns];
//
//		for(int i=1;i<ttlRows;i++)//rows =1,2
//		{
//			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
//			{
//
//				try {
//					data[i-1][j]=ReadExcelFile.getcellvalue(fileName,"LoginTestData", i,j);
//				} catch (EncryptedDocumentException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//
//		}
//		return data;
//	}
//
	
@Test(dataProvider = "LoginDataProvider")
	
	public void VerifyLogin(String userEmail, String userPwd, String expectedUsername) throws IOException 
	{

		logger.info("***************TestCase VerifyLogin starts*****************"); 


		indexPage pg = new indexPage(driver);

		pg.clickonSign();
		logger.info("Clicked on sign in link");

		MyAccountPage myAcpg = new MyAccountPage(driver);

		myAcpg.EnterCreateEmailAddress(userEmail);
		logger.info("Entered email address");
		
		myAcpg.Registeredpassword(userPwd);
		logger.info("Entered password");

		myAcpg.clickonSignin();
		logger.info("Clicked on sign in link..");

		ResigsterdUserAccount reguser= new ResigsterdUserAccount(driver); 
		
		String userName = reguser.getusername();
		
		
		if(userName.equals(expectedUsername))
		{
			logger.info("VerifyLogin - Passed");
			Assert.assertTrue(true);
			
			reguser.clickonsignout();
			
		}
		else
		{
			logger.info("VerifyLogin - Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);

		} 
		
		 
		logger.info("***************TestCase Verify login ends*****************"); 


	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider() throws EncryptedDocumentException, IOException
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName ="E:\\AutomationDataDriven_Freamwork\\AutomationFreammwork\\TestData\\Book1.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getcolCount(fileName, "LoginTestData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getcellvalue(fileName,"LoginTestData", i,j);
			}

		}
		return data;
	}

}

