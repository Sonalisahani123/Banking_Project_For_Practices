package com.inetbanking.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass{
	      
	        @Test
	        public void loginTest() throws InterruptedException, IOException
	        {
	        	
	        	driver.get(baseUrl);
	        	logger.info("URL is opened");
	        	LoginPage loginpage=new LoginPage(driver);
	        	
	        	loginpage.setUsername(userName);
	        	logger.info("Enter UserName");
	        	
	        	loginpage.setPassword(passWord);
	        	logger.info("Enter Password");
	        	loginpage.clickSubmitBtn();
	        	
	        	System.out.println(driver.getTitle());
	        	if(driver.getTitle().equals("Guru99 Bank Manager HomePage123"))
	        	{
	        		Assert.assertTrue(true);
	        		logger.info("Login Test passed");
	        	}else
	        	{
	        		captureScreen(driver,"loginTest");
	        		Assert.assertTrue(false);
	        		logger.info("Login Test Failed");
	        		
	        	}
	        	
	      	
	        }
}
