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

public class TC2_SignInAccountPage extends BaseClass {
//	@Test
//	public void verifylogin() throws IOException
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
//				accountpg.resisteredEmailAddress("vaishalimore2294@gmail.com");
//				accountpg.Registeredpassword("Vaishali@2294");
//				accountpg.clickonSignin();
//				logger.info("Clickon signin button");
//				
//				//registeredUserAccount
//				
//				ResigsterdUserAccount reguser= new ResigsterdUserAccount(driver);
//				String ExpectedUserName = reguser.getusername();
//				String ActualUserName="Vaishali More";
//				//Assert.assertEquals(ActualUserName,ExpectedUserName,"Username is matched,Tc is passed");
//				if(ExpectedUserName.equals(ActualUserName))
//				{
//					logger.info("VerifyLogin,Passed");
//					Assert.assertTrue(true);
//				}
//				else
//				{
//					logger.info("VerifyLogin,failed");
//					Assert.assertTrue(false);
//					captureScreenShot(driver,"verifylogin");
//				}
//				
//				
//				
//				
//	}
//	
//
//}
}
