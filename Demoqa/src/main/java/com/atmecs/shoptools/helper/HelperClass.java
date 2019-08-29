package com.atmecs.shoptools.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import com.atmecs.shoptools.testsuite.TestBaseClass;
import com.atmecs.shoptools.util.CommonUtilities;
import com.google.common.base.Function;

public class HelperClass {
	
	CommonUtilities product=new CommonUtilities();
	
	public String  getXpath(String xpath)
	{
	 return TestBaseClass.locatorprops.getProperty(xpath);
	}
	public String getTestXpaths(String xpath)
	{
		return TestBaseClass.testDatas.getProperty(xpath);	
	}
	public   void productValidation(WebDriver driver, final String xpath,final String expected) 
	{
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).ignoring(ElementClickInterceptedException.class).pollingEvery(1, TimeUnit.SECONDS).withTimeout(30, TimeUnit.SECONDS);
	
		fluentWait.until
		(new Function<WebDriver, Boolean>()
		{
		public Boolean apply(WebDriver driver)
		{
		WebElement element = driver.findElement(By.xpath(xpath));
		String title=element.getText();
		product.verifyassert(title, expected, "the product is present");
		return true;
		}
		});
		}
	
	
	
	public   void ratingValidation(WebDriver driver, final String xpath,final String expected) 
	{
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).ignoring(ElementClickInterceptedException.class).pollingEvery(1, TimeUnit.SECONDS).withTimeout(30, TimeUnit.SECONDS);
	
		fluentWait.until
		(new Function<WebDriver, Boolean>()
		{
		public Boolean apply(WebDriver driver)
		{
		WebElement element = driver.findElement(By.xpath(xpath));
		String title=element.getText();
		product.verifyassert(title, expected, "Rating Validated");
		return true;
		}
		});
		}
	
	
	public void priceValidation(WebDriver driver, final String xpath,final String expected)
	{
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).ignoring(ElementClickInterceptedException.class).pollingEvery(1, TimeUnit.SECONDS).withTimeout(30, TimeUnit.SECONDS);
		
		fluentWait.until
		(new Function<WebDriver, Boolean>()
		{
		public Boolean apply(WebDriver driver)
		{
		WebElement element = driver.findElement(By.xpath(xpath));
		String title=element.getText();
		String price=title.replaceAll("[^0-9.]", "");
		double i = Double.parseDouble(price);
		product.verifyassert(title, expected, "Price Validated");
		return true;
		}
		});
	}
		public void shopValidation(WebDriver driver, final String xpath,int i)
		{
			FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).ignoring(ElementClickInterceptedException.class).pollingEvery(1, TimeUnit.SECONDS).withTimeout(30, TimeUnit.SECONDS);
			
			fluentWait.until
			(new Function<WebDriver, Boolean>()
			{
			public Boolean apply(WebDriver driver)
			{
			WebElement element = driver.findElement(By.xpath(xpath));
			String title=element.getText();
			Select dropdown = new Select(element);
			dropdown.selectByIndex(i);
			//product.verifyassert(title, expected, "Price Validated");
			return true;
			}
			});
		
		 
		
		
	}
	

}
