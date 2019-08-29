package com.atmecs.shoptools.testscript3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.shoptools.helper.HelperClass;
import com.atmecs.shoptools.logreports.LogReportInformation;
import com.atmecs.shoptools.testsuite.TestBaseClass;
import com.atmecs.shoptools.util.CommonUtilities;

public class ShopPageSortValidation extends TestBaseClass {

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
	public void shopPageSorting() {
		CommonUtilities shop = new CommonUtilities();

		HelperClass product = new HelperClass();
		shop.click(driver, locatorprops.getProperty("loc_shoptools_shoppage_filtercolor"));

		product.shopValidation(driver, locatorprops.getProperty("loc_shoptools_shoppage_filtercolor"), 18);

		shop.click(driver, locatorprops.getProperty("loc_shoptools_shoppage_defaultsorting"));
		product.shopValidation(driver, locatorprops.getProperty("loc_shoptools_shoppage_defaultsorting"), 5);

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
