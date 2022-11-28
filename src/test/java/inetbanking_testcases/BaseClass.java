package inetbanking_testcases;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ReadConfig;

public class BaseClass {
	
ReadConfig readconfig = new ReadConfig();
public String baseURL= readconfig.getApplicationUrl();
public String username=readconfig.getUserName();
public String password=readconfig.getpassword();
	
public static WebDriver driver;


public static Logger logger;

@Parameters("browser")
@BeforeClass 
public void setup(String br)
 {
	
	 logger = Logger.getLogger("ebanking");
	 PropertyConfigurator.configure("Log4j.properties");
//	  System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
//		 driver = new ChromeDriver();
	 
	 //If the browser is chrome
	 if (br.equals("chrome")) {
		 System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		 driver = new ChromeDriver();
	 }
	 //If the browser is Firefox
	 else
		 if(br.equals("firefox"))
		 {
			 
			 System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			 driver = new FirefoxDriver();
		 }
	 driver.manage().window().maximize();
	 driver.get(baseURL);
 }
@AfterClass
public void tearDown() {
	
	driver.quit();
}

public  void captureScreen(WebDriver driver, String tname) throws IOException 
{
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
	
	TakesScreenshot ts= (TakesScreenshot) driver;
	File source= ts.getScreenshotAs(OutputType.FILE);
	File target= new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
	FileUtils.copyFile(source,target);
	System.out.println("Screenshot taken");
	
}

public  void alertCaptureScreen(WebDriver driver, String tname) throws HeadlessException, AWTException, IOException
{
	BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	ImageIO.write(image,"png",new File("D:/eclipse-workspace/tester/Screenshots/"+tname+".png"));
}


public String randomestring()
{
	String gereratedString= RandomStringUtils.randomAlphabetic(8);
	return gereratedString;
	
}	

public String randomeNum()
{
	String gereratedString2= RandomStringUtils.randomAlphabetic(8);
	return gereratedString2;
	
}

}
