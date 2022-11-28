package inetbanking_testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import inetbankingpageobjects.LoginPage;

public class TC_LoginTesst extends BaseClass {

	@Test
	public void loginTest() throws IOException {
		
		
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickSubmit();
		
		logger.info(driver.getTitle());
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage@"))
		{
			
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}		
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
			
		}
	}
}
