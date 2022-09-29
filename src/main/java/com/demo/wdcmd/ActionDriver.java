package com.demo.wdcmd;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.demo.config.StartBrowser;

public class ActionDriver 
{

	public WebDriver driver;
	
	public ActionDriver()
	{
		driver= StartBrowser.driver;
	}
	
	/**
	 * used to navigate to any application
	 * @param url -- URL of application
	 */
	public void navigateToApplication(String url)
	{
		try
		{
			driver.get(url);
			StartBrowser.childTest.pass("Successfully navigated to : " + url);
		}
		catch(Exception e)
		{
			StartBrowser.childTest.fail("Unable to navigated to : " + url);
		}
		
	}
	/**
	 * Used to perform click on links, buttons, radio buttons and check boxes
	 * @param locator -- Get it from Object Repository
	 * @param eleName -- Name of the element
	 * @throws Exception
	 */
	public void click(By locator, String eleName) throws Exception
	{
		try {
			driver.findElement(locator).click();
			StartBrowser.childTest.pass("performed click action on:"+ eleName);
		}
		catch( Exception e)
		{
			StartBrowser.childTest.fail("Unable to perform click action on:"+ eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	
	public void type(By locator, String testData, String eleName) throws Exception
	{
		try
		{
			driver.findElement(locator).sendKeys(testData);
			StartBrowser.childTest.pass("Successfully performed type action ion : "+eleName + " Wih test data : "+ testData);
		}
		catch(Exception e)
		{
			StartBrowser.childTest.fail("unable to perform type action ion : "+eleName + " Wih test data : "+ testData , 
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
		
	}
	
	
	public void getTitle(By locator, String eleName) throws Exception
	{
		try
		{
			String str = driver.findElement(locator).getText();
			System.out.println(str);
			StartBrowser.childTest.pass("Successfully got the text : "+eleName, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			
		}
		catch(Exception e)
		{
			StartBrowser.childTest.fail("unable to get the text type : "+eleName , 
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	
	public String screenShot()
	{
		return((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
}

