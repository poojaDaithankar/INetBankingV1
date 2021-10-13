package com.inetBanking.TestCases;
import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;


public class TC_LoginTest_1 extends BaseClass {
	
	
		@Test
		public void loginTest() throws IOException 
		{
			
			
			Logger.info("URL is opened");
			
			LoginPage lp=new LoginPage(driver);
			lp.SetEmailID(Emailid);
			Logger.info("Entered Emailid");
			
			lp.setPassword(password);
			Logger.info("Entered password");
			
			lp.clickSubmit();
			
			if(driver.getTitle().equals("Successfully Logged in"))
			{
				Assert.assertTrue(true);
				Logger.info("Login test passed");
			}
			else
			{
				Assert.assertTrue(false);
				Logger.info("Login test Failed");
			}
				
		}
		
		

	}


