package com.cai.qa.bg.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.xml.transform.Source;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cai.qa.bg.PageObjects.BGG.HomePage;
import com.cai.qa.bg.browser.BrowserType;
import com.cai.qa.bg.browser.ChromeBrowser;
import com.cai.qa.bg.config.ObjectReader;
import com.cai.qa.bg.config.PropertyReader;
import com.cai.qa.bg.extentReports.ExtentHelper;
import com.cai.qa.bg.extentReports.ExtentManager;
import com.cai.qa.bg.javaScript.JavaScriptHelper;
import com.cai.qa.bg.log4j.LoggerHelp;
import com.cai.qa.bg.resources.ResourceHelper;
import com.cai.qa.bg.wait.WaitHelper;

public class TestBase  {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	private Logger log = LoggerHelp.getLogger(TestBase.class);
	public static File reportDirectory;
	public static Properties CONFIG = null;
	public static HomePage homepage;
	public static ExtentHelper exthelper;

	
	@AfterMethod
	public void afterMethod(ITestResult result){
		if(result.getStatus() == ITestResult.SUCCESS){
			test.log(Status.PASS, result.getName()+ "  is PASS");
		}
		else if(result.getStatus() == ITestResult.FAILURE){
			test.log(Status.PASS, result.getName() + " is FAILED " + result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SKIP){
			test.log(Status.SKIP,result.getName()+ " SKIPPED");
		}
		
	}

	public String configure(String browser) {

		String targetBrowser = null;

		try {

			CONFIG = new Properties();
			FileInputStream fis = new FileInputStream("config\\config.properties");
			CONFIG.load(fis);
		} catch (FileNotFoundException e1) {
			Reporter.log("Config file not found", true);
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		return targetBrowser;
	}
	
	public void launchApp(String url, String Env) {
		String targeturl = null;
		if (Env.equalsIgnoreCase("stg")) {
			targeturl = url.replace("bluegreengetaways", "stg.bluegreengetaways");
		} else if (Env.equalsIgnoreCase("qa")) {
			targeturl = url.replace("bluegreengetaways.", "qa.bluegreengetaways");
		}

		driver.get(targeturl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	public WebDriver getBrowserObject(BrowserType btype) {
		try {
			switch (btype) {
			case Chrome:
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				ChromeOptions option = chrome.getChromeOptions();
				chrome.getChromeDriver(option);

			default:
				throw new Exception("Driver not found" + btype.name());
			}

		} catch (Exception e) {
			//log.info(e.getMessage());
			e.getCause();
		}
		return driver;
	}

	public void setUpDriver(BrowserType btype) {
		driver = getBrowserObject(btype);
		// log.info("Initialize webdriver"+ driver.hashCode());
		WaitHelper wait = new WaitHelper(driver);
		wait.setImplicitWait(ObjectReader.reader.getImplicitWait(), TimeUnit.SECONDS);
		wait.pageLoadTime(ObjectReader.reader.getPageLoadTime(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public String captureScreen(String fileName) {
		if (driver == null) {
			//log.info("driver is null");
			return null;
		}
		if (fileName == "") {
			fileName = "blank";
		}

		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			destFile = new File(reportDirectory + "/" + fileName + "_" + formater.format(calendar.getTime()) + ".png");
			Files.copy(srcFile.toPath(), destFile.toPath());
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");
		} catch (Exception e) {

		}
		return destFile.toString();
	}
}
