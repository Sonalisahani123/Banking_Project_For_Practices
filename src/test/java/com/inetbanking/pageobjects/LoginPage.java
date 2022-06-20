package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement txtuserName;
	
	@FindBy(name="password")
	WebElement txtpassWord;
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	
	public void setUsername(String uName)
	{
		txtuserName.sendKeys(uName);
	}

	public void setPassword(String pWord)
	{
		txtpassWord.sendKeys(pWord);
	}
	
	public void clickSubmitBtn()
	{
		loginBtn.click();
	}
	
	
	
}
