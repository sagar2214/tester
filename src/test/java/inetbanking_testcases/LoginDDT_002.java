package inetbanking_testcases;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import inetbankingpageobjects.LoginPage;
import utilities.XLUtils;

public class LoginDDT_002 extends BaseClass {
	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException, AWTException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name is provided");
		lp.setPassword(pwd);
		logger.info("Password is provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		if( isAlertPresent()==true) // for fail scenario
		{
		
			
			//captureScreen(driver, "LoginDDT_002");
			
//			Thread.sleep(2000);

//			Thread.sleep(2000);
		Alert s= driver.switchTo().alert();
		System.out.println(s.getText());
		Thread.sleep(1000);
		
		//captureScreen(driver,"loginDDT");
		//alertCaptureScreen(driver,"loginDDT");
		
			s.accept();//close alert 
			
			Thread.sleep(3000);
			
		driver.switchTo().defaultContent();// focus on main page
		
		captureScreen(driver,"loginDDT");
		Assert.assertTrue(false);
		
		logger.info("Login failed");
		} else 
		{
			Assert.assertTrue(true);// for pass scenario
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();// close the log out alert
			driver .switchTo().defaultContent();// focus on login again
			
			
		}
		
	}
	
	public boolean isAlertPresent() {//User defined method to check ALert is present or not
		try
		{
		driver.switchTo().alert();
		return true;
		}
		
		catch
			(NoAlertPresentException e)	
		{
		return false;
		}
		
		
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
	String path =System.getProperty("user.dir")+"/src/test/java/inetbanking_testdata/LoginData.xlsx";
		int rownum= XLUtils.getRowCount(path, "Sheet1");
	int colcount= XLUtils.getCellCount(path,"Sheet1",1);
	String logindata[][]= new String [rownum][colcount];
	
	for (int i=1;i<=rownum;i++)
	{
		
		for (int j=0;j<colcount;j++)
		{
			
			logindata [i-1][j]= XLUtils.getCellData(path, "Sheet1",i,j); //i=1 & j=0
			
		}
	}
	return logindata;
	}
   
}
