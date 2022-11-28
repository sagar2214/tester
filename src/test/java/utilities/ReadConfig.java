package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;


public class ReadConfig {

  Properties pro ;
	  public ReadConfig()
	  {
		  
		  File src = new File("./Configuration/config.properties");
		  
		try {
				FileInputStream fis = new FileInputStream(src);
				pro = new Properties();
				pro.load(fis);
		}catch (Exception e)
		{
			
			System.out.println("Exception is" +e.getMessage());
		}
			 
				// TODO Auto-generated catch block
			
		
		  
		
		  
		  
	  }
	  
	  

		public String getApplicationUrl() {
			
			String url= pro.getProperty("baseURL");
			return url;
			
		}
		
	public String getUserName() {
			
			String username= pro.getProperty("username");
			return username;
			
		}
		
	public String getpassword() {
		
		String password= pro.getProperty("password");
		return password;
		
	}

	public String getChromePath() {
		
		String chromepath= pro.getProperty("chromepath");
		return chromepath;
		
	}

		
	public String getFirefoxPath() {
		
		String firefoxpath= pro.getProperty("firefoxpath");
		return firefoxpath;
		
	}

		
	  
}
