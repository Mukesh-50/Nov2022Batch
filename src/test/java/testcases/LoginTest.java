package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginTest extends BaseClass {

	HomePage home;
	LoginPage login;

	@Test(priority = 1)
	public void verifyTitle() {
		Assert.assertTrue(driver.getTitle().contains("Automation"));
	}

	@Test(priority = 2)
	public void verifySocialMediaPresense() {

		home = new HomePage(driver);

		int count = home.getSocialMediaCount();

		Assert.assertEquals(count, 4);
	}

	@Test(priority = 3, dataProvider = "credentials", dataProviderClass = CustomDataProvider.class)
	public void loginToApplication(String usename, String password) 
	{
		login = home.clickOnLogin();

		login.loginToApplication(usename, password);

		Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Manage']")).isDisplayed());

		home.signOutFromApplication();

		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Sign In']")).isDisplayed());
		
		driver.findElement(By.xpath("")).sendKeys(System.getProperty("user.dir")+"/TestData/thumnail.png");

	}
	
	@Test(priority = 4)
	public void verifyUserLandToLoginPageTest() throws Throwable {
		login = new LoginPage(driver);
		
		System.out.println(("Click on side nav bar and click on login"));
		Assert.assertEquals(login.verifyUserLandToLoginPage(), "https://freelance-learn-automation.vercel.app/login");

	}

}
