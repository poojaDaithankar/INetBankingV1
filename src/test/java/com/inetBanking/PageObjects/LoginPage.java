package com.inetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);	
		
	}
	
	@FindBy(name="email")
	@CacheLookup
	WebElement textEmail;
	
	@FindBy(name="passwd")
	@CacheLookup
    WebElement txtpassword;
	
	@FindBy(name="SubmitLogin")
	@CacheLookup
	WebElement btnSubmit;
	
	//public void setUserName(String uname)
	//{
	//	txtUserName.sendKeys(uname);
	//}
	
	public void SetEmailID(String emailid)
	{
		textEmail.sendKeys(emailid);
	}

	
	public void setPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}

}
