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

public class Sm_1 extends BaseClass {

    @Test(dataProvider = "dataprovider")
    public void verifyLogin(String userEmail, String userPassword) {

        // Signup/indexpage object
        indexPage indexpg = new indexPage(driver);
        indexpg.clickonSign();
        logger.info("Clicked on signUP button");

        // Myaccountpage object
        MyAccountPage accountpg = new MyAccountPage(driver);

        accountpg.resisteredEmailAddress(userEmail);
        logger.info("Entered email address");

        accountpg.Registeredpassword(userPassword);  // Corrected method name
        logger.info("Entered email password");

        accountpg.clickonSignin();
        logger.info("Clicked on signin button");

        // RegisteredUserAccount
        ResigsterdUserAccount reguser = new ResigsterdUserAccount(driver);
        String actualUsername = reguser.getusername();

        if (actualUsername.equals("Vaishali More")) {
            logger.info("VerifyLogin, Passed");
            Assert.assertTrue(true, "Verification successful");
            reguser.clickonsignout();
        } else {
            logger.info("VerifyLogin, Failed");
            Assert.fail("Verification failed. Actual username: " + actualUsername);
            // You may want to capture a screenshot on failure
            // captureScreenShot(driver, "verifylogin");
        }
    }

    @DataProvider(name ="dataProvider")
    public Object[][] loginDataProvider() {
        String fileName = "E:\\AutomationDataDriven_Freamwork\\AutomationFreammwork\\TestData\\Book1.xlsx";

        int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
        int ttlColumns = ReadExcelFile.getcolCount(fileName, "LoginTestData");

        // Corrected the array size to match the number of rows and columns
        Object[][] data = new Object[ttlRows - 1][ttlColumns];

        for (int i = 1; i < ttlRows; i++) {
            for (int j = 0; j < ttlColumns; j++) {
                try {
                    data[i - 1][j] = ReadExcelFile.getcellvalue(fileName, "LoginTestData", i, j);
                } catch (EncryptedDocumentException | IOException e) {
                    logger.error("Exception while reading Excel data: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return data;
    }
}
