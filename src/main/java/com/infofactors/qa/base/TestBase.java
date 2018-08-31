package com.infofactors.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.infofactors.qa.util.TestUtil;

public class TestBase 
{
	
	 public static WebDriver driver;
	 public static Properties prop;
	 
	 public TestBase() 
	 {
		try 
		{
			 prop=new Properties();
			 FileInputStream fis;
			 fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\infofactors\\config\\config.properties");
			 prop.load(fis);		
		}  catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}catch (IOException e) 
		{
			e.printStackTrace();
		}  
	 }
	 
	   public static void intialization()
	   {
		   String browserName=prop.getProperty("browser");
		   if (browserName.equals("chrome"))
		   {
			  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\executables\\chromedriver.exe");
			  driver=new ChromeDriver();
			
		}else if (browserName.equals("firefox"))
		   {
			   System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\executables\\geckodriver.exe");
			   driver=new FirefoxDriver();
			
		}
		   else if (browserName.equals("ie"))
		   {
			   System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\executables\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		   
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
		   driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		   driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIME_OUT, TimeUnit.SECONDS);
		   
		   driver.get(prop.getProperty("testsiteurl"));
	
	   } 
}