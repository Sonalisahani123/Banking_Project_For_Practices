package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	 ReadConfig config=new ReadConfig();
	
	public String baseUrl=config.getApplicationURL();
	public String userName=config.getUsername();
	public String passWord=config.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
	  
	  logger=Logger.getLogger("ebanking");
	  PropertyConfigurator.configure("Log4j.properties");
	  if(br.equals("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver",config.getChromePath());
		  driver=new ChromeDriver();
	  }else if(br.equals("ie"))
	  {
		  System.setProperty("webdriver.ie.driver",config.getIEPath());
		  driver=new InternetExplorerDriver();
	  }else if(br.equals("firefox"))
	  {
		  System.setProperty("webdriver.firefox.driver",config.getFirefoxPath());
		  driver=new FirefoxDriver(); 
	  }
	}
	
	
	
	
	@AfterClass
  public void tearDown()
  {
	  driver.quit();
  }
	
	public void captureScreen(WebDriver driver, String tcname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
	 File source=ts.getScreenshotAs(OutputType.FILE);
	 File target=new File(System.getProperty("user.dir")+"/Screenshots/" +tcname +".png");
	 FileUtils.copyFile(source, target);
	 System.out.println("screenshot taken");
	 
	 
		
	}

}
