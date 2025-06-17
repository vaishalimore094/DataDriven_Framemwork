package Testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pom.AccountCreation;
import pom.MyAccountPage;
import pom.ResigsterdUserAccount;
import pom.indexPage;

public class TC_myAccountPageTest extends BaseClass {
	@Test
	public void verifyResistrationAndLogin() throws InterruptedException
	{
		
		
		
		//signup/indexpage object
		
		indexPage indexpg=new indexPage(driver);
		indexpg.clickonSign();
		logger.info("Clickon signUP button");
		
		//Myaccountpageobject
		
		MyAccountPage accountpg=new MyAccountPage(driver);
		accountpg.EnterCreateEmailAddress("vaishalimore2294@gmail.com");
		Thread.sleep(1000);
		accountpg.clickonCreateAccount();
		Thread.sleep(1000);
		logger.info("click on Create Button ");
		
		
		//Account Creation pageobject
		
		AccountCreation AccCreation=new AccountCreation(driver);
		AccCreation.SelectTitle();
		AccCreation.CustomerName("Vaishali");
		AccCreation.CustomerLastName("More");
		AccCreation.CustomerPassword("Vaishali@2294");
		Thread.sleep(1000);
		AccCreation.clickonRegister();
		
		logger.info("Sing in on Accoun");
		
		
		//validation of userName
		
		ResigsterdUserAccount reguser= new ResigsterdUserAccount(driver);
		String Expected = reguser.getusername();
		String Actual="Vaishali More";
		Assert.assertEquals(Actual,Expected,"Username is matched,Tc is passed");
		logger.info("Account Sccessfull created");
		
		
	}
	
}
