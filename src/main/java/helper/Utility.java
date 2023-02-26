package helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	/*
	 *  	create a method for alert which will wait and return the text of alert > accept the alert
	 * 	
	 * 		create a method for alert which will wait and return alert interface reference
	 * 
	 */
	
	
	public static WebElement highLight(WebDriver driver,By locator)
	{
		
		WebElement ele=driver.findElement(locator);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].setAttribute('style','background:yellow; border: 2px solid red');", ele);
		
		waitForSeconds(1);
		
		js.executeScript("arguments[0].setAttribute('style','border: 2px solid white');", ele);
		
		return ele;
	}
	
	

	// present > visible> enable
	public static WebElement waitForWebElement(WebDriver driver, By locator) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].setAttribute('style','background:yellow; border: 2px solid red');", element);
		
		waitForSeconds(1);
		
		js.executeScript("arguments[0].setAttribute('style','border: 2px solid white');", element);
		
		
		return element;
	}

	public static WebElement waitForWebElement(WebDriver driver, By locator, int time) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		return element;
	}
	
	public static WebElement waitForElementToBeVisible(WebDriver driver, By webElement, Duration seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
		return element;
	}
	
	public static WebElement waitTillElementToBeClickable(WebDriver driver,By locator, Duration seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		WebElement element =wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;
	}



	public static void selectValuesFromList(WebDriver driver, By locator, String value) {
		List<WebElement> allValues = driver.findElements(locator);

		for (WebElement ele : allValues) {
			if (ele.getText().contains(value)) {
				System.out.println("LOG:INFO- Value found");
				ele.click();
				System.out.println("LOG:INFO- Clicked on element");
				break;
			}
		}
	}

	public static void captureScreenshot(WebDriver driver)
	{
		
		TakesScreenshot ts=(TakesScreenshot) driver;

		try 
		{
			FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")+"/screenshots/Sample"+getCurrentTimeStamp()+".png"));
			
		} catch (WebDriverException e) 
		{
			System.out.println("Exception "+e.getMessage());
		} catch (IOException e) 
		{
			System.out.println("IO Execption "+e.getMessage());
		}

	}
	
	public static String captureScreenshotInBase64(WebDriver driver)
	{
		
		TakesScreenshot ts=(TakesScreenshot) driver;

		String src=ts.getScreenshotAs(OutputType.BASE64);
		
		return src;
	}
	
	
	public static void captureScreenShot(WebDriver driver,WebElement ele) 
	{
		
		/*
		 *  Complete this method > use custom date time stamp
		 * 
		 */
		
	}
	
	
	public static String getCurrentTimeStamp()
	{
		String date=new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date());
		
		return date;
	}
	
	public static void clickOnElement(WebDriver driver,By locator)
	{
		
		try 
		{
			driver.findElement(locator).click();
			
		} catch (Exception e) 
		{
			
			System.out.println("Normal Click Failed - Clicking using JS");
			
			waitForSeconds(2);
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].click()", driver.findElement(locator));

		}
		
	}
	
	public static void type(WebDriver driver,By locator,String text)
	{
	
		try 
		{
			driver.findElement(locator).sendKeys(text);
			
		} catch (Exception e) 
		{
			
			System.out.println("WebElement sendKeys Failed - Setting value using JS");
			
			waitForSeconds(2);
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].value=arguments[1]", driver.findElement(locator),text);

		}
		
	}
	
	
	public static void waitForSeconds(int seconds)
	{
		//System.out.println("Waiting for "+seconds+" seconds");
		
		try 
		{
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			
		}	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
