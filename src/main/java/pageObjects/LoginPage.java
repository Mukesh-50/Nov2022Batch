package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By closeMenu=By.xpath("//button[@aria-label='Close']");
	
	By username=By.name("email1");
	
	By password=By.id("password1");
	
	By loginButton=By.xpath("//button[normalize-space()='Sign in']");
	
	By err_msg=By.xpath("//h2[@class='errorMessage']");
	
	public Dashboard loginToApplication(String user,String pass)
	{
		driver.findElement(closeMenu).click();
		
		Utility.waitForSeconds(2);
		
		driver.findElement(username).sendKeys(user);
		
		driver.findElement(password).sendKeys(pass);
		
		
		Utility.clickOnElement(driver, loginButton);
		
		//driver.findElement(loginButton).click();
		
		
		
		Dashboard dash=new Dashboard(driver);
		
		return dash;
	}
	
	public String captureErrorMessage()
	{
		String msg=driver.findElement(err_msg).getText();
		
		return msg;
	}
	
	
	

}
