package inetbankingpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	
	WebDriver ldriver; 
	
	public LoginPage(WebDriver driver)
	{
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(name="uid")
	WebElement txtUserName;
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnlogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement lnkLogout;
	public void setUserName(String uname) {
		 txtUserName.sendKeys(uname);
		
	}
	
	
	
	
	public void setPassword(String pwd) {
		 txtPassword.sendKeys(pwd);
		
	}
	
	
	public void clickSubmit() {
		btnlogin.click();
		
	}
	
	public void clickLogout()
	{
		
		lnkLogout.click();
	}
	
	
	
	
}
