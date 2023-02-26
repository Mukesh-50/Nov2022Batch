package pageObjects;

import java.time.Duration;

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
	
	By navBar=By.xpath("//span[@class='navbar-toggler-icon']");
	
	By loginBTN= By.xpath("//button[normalize-space()='Log in']");
	
	By crossNavBar= By.xpath("//button[@aria-label='Close']");

	
	public Dashboard loginToApplication(String user,String pass)
	{
		driver.findElement(closeMenu).click();
		
		Utility.waitForSeconds(2);
		
		driver.findElement(username).sendKeys(user);
		
		driver.findElement(password).sendKeys(pass);
		
		driver.findElement(loginButton).click();
		
		Dashboard dash=new Dashboard(driver);
		
		return dash;
	}
	
	public String captureErrorMessage()
	{
		String msg=driver.findElement(err_msg).getText();
		
		return msg;
	}
	
	public String verifyUserLandToLoginPage() throws Throwable {
		Utility.waitForElementToBeVisible(driver, navBar, Duration.ofSeconds(10));
		if (driver.findElement(navBar).isDisplayed()) {
			Utility.clickOnElement(driver, navBar);
			Utility.waitTillElementToBeClickable(driver, loginBTN, Duration.ofSeconds(10));
			Utility.clickOnElement(driver, loginBTN);
			Utility.waitTillElementToBeClickable(driver, crossNavBar, Duration.ofSeconds(10));
			Utility.clickOnElement(driver, crossNavBar);
			Thread.sleep(1000);
			System.out.println(driver.getCurrentUrl());
			return driver.getCurrentUrl();

		}
		return null;

	}
	
	
	

}
