package com.atmecs.shoptools.testsuite;
import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.atmecs.shoptools.constants.ProjectPathConstants;
import com.atmecs.shoptools.logreports.LogReportInformation;
import com.atmecs.shoptools.util.PropertiesUtil;




public class TestBaseClass {
	LogReportInformation log=new LogReportInformation();
	 WebDriver driver;
     
   public static Properties configprops = PropertiesUtil.loadProperty(ProjectPathConstants.configpropsfile);
	public static Properties locatorprops=PropertiesUtil.loadProperty(ProjectPathConstants.locators);
	public static Properties testDatas=PropertiesUtil.loadProperty(ProjectPathConstants.testDataprops);
	
	public enum BrowserType {
	FIREFOX, CHROME, IE
	}
public WebDriver invokeBrowser() 
	{
	
	log.info("invoke");
	    String browser = configprops.getProperty("browserName");
	
	switch (BrowserType.valueOf(browser)) {
	case CHROME:{
	this.driver = setChromeDriver();
	log.info("Chrome driver set "+driver);
	log.info("chrome invoked...");
	break;
	}
	case FIREFOX:
		log.info("firefox case");
	this.driver = setFirefoxDriver();
	log.info("Firefox driver set "+driver);
	break;

	case IE:
	this.driver = setInterExplorerDriver();
	log.info("Internet driver set "+driver);
	default:
	break;
	}
	return driver;
	
}

	private WebDriver setChromeDriver() {

		String currentdir = System.getProperty("user.dir") + File.separator + "libfolder" + File.separator;
		System.setProperty("webdriver.chrome.driver", currentdir + "chromedriver.exe");
		return new ChromeDriver();
	}

	private WebDriver setFirefoxDriver() {
	String currentdir = System.getProperty("user.dir") + File.separator + "libfolder" + File.separator;
	System.setProperty("webdriver.gecko.driver", currentdir + "geckodriver.exe");
	return new FirefoxDriver();
	}

	private WebDriver setInterExplorerDriver() {
	String currentdir = System.getProperty("user.dir") + File.separator + "libfolder" + File.separator;
	System.setProperty("webdriver.ie.driver", currentdir + "IEDriverServer.exe");
	return new InternetExplorerDriver();
	}
	public WebDriver windowOperation() {
		//String winHandleBefore = driver.getWindowHandle();
		//driver.switchTo().window(winHandleBefore);
		  driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.MINUTES);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  return driver;
	
	

}
	
	}
	
	
	


