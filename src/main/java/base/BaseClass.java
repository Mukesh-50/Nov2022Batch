package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import browserFactory.BrowserFactory;

public class BaseClass {

	public WebDriver driver;
	
	/*
	 *  1- Need to change of Config file for any changes
	 *  2- Dynamic- User or Any CI Tool can pass this parameter
	 * 
	 */

	@Parameters({"Browser","URL"})
	@BeforeClass
	public void setup(String browser,String url)
	{
		System.out.println("LOG:INFO - Before Class Executing- Setting up browser");
		
		//driver=BrowserFactory.startBrowser(ConfigReader.getProperty("Browser"),ConfigReader.getProperty("qaenv"));	
		
		driver=BrowserFactory.startBrowser(browser,url);	
	}
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("LOG:INFO - After Class Executing- Closing browsers");
		BrowserFactory.closeBrowser(driver);
	}
	
	
}
