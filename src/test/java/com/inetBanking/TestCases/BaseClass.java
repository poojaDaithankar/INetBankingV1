package com.inetBanking.TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.inetBanking.uitillits.ReadConfig;


public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	//public String baseURL="http://demo.guru99.com/";
	public String baseURL=readconfig.getApplicationURL();
	//public String EmailID="test@gmail.com";
	//public String Emailid="mngr47659";
	//public String password="1@";
	public String Emailid=readconfig.getEmailID();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger Logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser)
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("userdir")+"//Drivers//chromedriver.exe");
		Logger= Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
			
			driver=new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
			
driver = new InternetExplorerDriver();
		}
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
