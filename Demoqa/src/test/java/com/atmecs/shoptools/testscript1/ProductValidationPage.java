package com.atmecs.shoptools.testscript1;


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

public class ProductValidationPage extends TestBaseClass {
	WebDriver driver;
	WebElement ele;
	LogReportInformation log = new LogReportInformation();

	@BeforeTest
	public void setup() {
		this.driver = invokeBrowser();
		String baseUrl = configprops.getProperty("applicationurl");
		driver.get(baseUrl);
		this.driver = windowOperation();

	}

	@Test
	public void productValidation() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HelperClass products = new HelperClass();

		String firstProductName = products.getXpath("loc_shoptools_pinktshirt");
		String expectedFirstProductName = products.getTestXpaths("FirstProduct");
		String firstProductPrice = products.getXpath("loc_shoptools_firstproductprice");
		String expectedFirstProductPrice = products.getTestXpaths("FirstProductPrice");
		String firstProductRating = products.getXpath("loc_shoptools_pinktshirt_ratingvalidation");
		String expectedFirstProductRating = products.getTestXpaths("FirstProductRating");

		String secondProductName = products.getXpath("loc_shoptools_secondproductplayboy");
		String expectedSecondProductName = products.getTestXpaths("SecondProduct");
		String secondProductPrice = products.getXpath("loc_shoptools_secondproductprice");
		String expectedSecondProductPrice = products.getTestXpaths("SecondProductPrice");
		String SecondProductRating = products.getXpath("loc_shoptools_secondproductplayboy_ratingvalidation");
		String expectedSecondProductRating = products.getTestXpaths("SecondProductRating");

		String thirdProductName = products.getXpath("loc_shoptools_thirdproduct_blackluxgraphictshirt");
		String expectedThirdProductName = products.getTestXpaths("ThirdProduct");
		String thirdProductPrice = products.getXpath("loc_shoptools_thirdproductprice");
		String expectedthirdProductPrice = products.getTestXpaths("ThirdProductPrice");
		String ThirdProductRating = products
				.getXpath("loc_shoptools_thirdproduct_blackluxgraphictshirt_ratingvalidation");
		String expectedThirdProductRating = products.getTestXpaths("ThirdProductRating");

		String fourthProductName = products.getXpath("loc_shooptools_fourthproduct_tokyotalkies");
		String expectedFourthProductName = products.getTestXpaths("FourthProduct");
		String fourthProductPrice = products.getXpath("loc_shoptools_fourthproductprice");
		String expectedFourthProductPrice = products.getTestXpaths("FourthProductPrice");
		String FourthProductRating = products.getXpath("loc_shooptools_fourthproduct_tokyotalkies_ratingvalidation");
		String expectedFourthProductRating = products.getTestXpaths("FourthProductRating");

		String fifthProductName = products.getXpath("loc_shooptools_fifthproduct_blackcrossmaxidress");
		String expectedFifthProductName = products.getTestXpaths("FifthProduct");
		String fifthProductPrice = products.getXpath("loc_shoptools_fifthproductprice");
		String expectedFifthProductPrice = products.getTestXpaths("FifthProductPrice");
		String FifthProductRating = products
				.getXpath("loc_shooptools_fifthproduct_blackcrossmaxidress_ratingvalidation");
		String expectedFifthProductRating = products.getTestXpaths("FifthProductRating");

		String sixthProductName = products.getXpath("loc_shooptools_sixthproduct_redsatinmaxidress");
		String expectedSixthProductName = products.getTestXpaths("SixthProduct");
		String sixthProductPrice = products.getXpath("loc_shoptools_sixthproductprice");
		String expectedSixthProductPrice = products.getTestXpaths("SixthProductPrice");
		String sixthProductRating = products.getXpath("loc_shooptools_sixthproduct_redsatinmaxidress_ratingvalidation");
		String expectedSixthProductRating = products.getTestXpaths("SixthProductRating");

		js.executeScript("window.scrollBy(0,1000)");
		products.productValidation(driver, firstProductName, expectedFirstProductName);
		products.priceValidation(driver, firstProductPrice, expectedFirstProductPrice);
		products.ratingValidation(driver, firstProductRating, expectedFirstProductRating);

		products.productValidation(driver, secondProductName, expectedSecondProductName);
		products.priceValidation(driver, secondProductPrice, expectedSecondProductPrice);
		products.ratingValidation(driver, SecondProductRating, expectedSecondProductRating);

		products.productValidation(driver, thirdProductName, expectedThirdProductName);
		products.priceValidation(driver, thirdProductPrice, expectedthirdProductPrice);
		products.ratingValidation(driver, ThirdProductRating, expectedThirdProductRating);

		products.productValidation(driver, fourthProductName, expectedFourthProductName);
		products.priceValidation(driver, fourthProductPrice, expectedFourthProductPrice);
		products.ratingValidation(driver, FourthProductRating, expectedFourthProductRating);

		products.productValidation(driver, fifthProductName, expectedFifthProductName);
		products.priceValidation(driver, fifthProductPrice, expectedFifthProductPrice);
		products.ratingValidation(driver, FifthProductRating, expectedFifthProductRating);

		products.productValidation(driver, sixthProductName, expectedSixthProductName);
		products.priceValidation(driver, sixthProductPrice, expectedSixthProductPrice);
		products.ratingValidation(driver, sixthProductRating, expectedSixthProductRating);

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
