package com.atmecs.shoptools.testscript2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.shoptools.helper.HelperClass;
import com.atmecs.shoptools.logreports.LogReportInformation;
import com.atmecs.shoptools.testsuite.TestBaseClass;
import com.atmecs.shoptools.util.CommonUtilities;

public class ShopPageValidation extends TestBaseClass {

	WebDriver driver;
	WebElement ele;
	LogReportInformation log = new LogReportInformation();

	@BeforeTest
	public void setup() {
		this.driver = invokeBrowser();
		String baseUrl = configprops.getProperty("applicationurlforshop");
		driver.get(baseUrl);
		this.driver = windowOperation();

	}

	@Test
	public void shopPageValidation() {
		CommonUtilities shop = new CommonUtilities();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HelperClass product = new HelperClass();
		js.executeScript("window.scrollBy(0,2500)");
		shop.click(driver, locatorprops.getProperty("loc_shoptools_thirdpage"));
		shop.click(driver, locatorprops.getProperty("loc_shoptools_thirdpage_filtercolor"));
		product.shopValidation(driver, locatorprops.getProperty("loc_shoptools_thirdpage_filtercolor"), 18);

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
