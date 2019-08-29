package com.atmecs.shoptools.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.google.common.base.Function;

public class CommonUtilities {
	public void verifyassert(String actual, String expected, String message) {

		Assert.assertEquals(actual, expected, message);
		System.out.println("Actual is: " + actual + " " + "Expected: " + expected + " " + "Message is: " + message);

	}

	public void click(WebDriver driver, final String xpath) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(1, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS);

		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				element.click();
				return true;
			}
		});
	}

	public void selectDropdown(WebElement Xpath, int index) {

		Select option = new Select(Xpath);
		option.selectByIndex(index);
	}

	public void mouseover(WebDriver driver, final String xpath) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(1, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS);

		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				Actions act = new Actions(driver);
				act.moveToElement(element).perform();
				return true;
			}
		});

	}

}
