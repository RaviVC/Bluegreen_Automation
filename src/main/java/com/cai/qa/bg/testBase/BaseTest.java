package com.cai.qa.bg.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cai.qa.bg.ObjectRepository.BGG.BGG_PageObjects;
import com.cai.qa.bg.extentReports.ExtentHelper;
import com.cai.qa.bg.log4j.LoggerHelp;

public class BaseTest extends TestBase {

	public static WebDriver driver;
	private Logger log = LoggerHelp.getLogger(BaseTest.class);
	public static File reportDirectory;
	public static Properties CONFIG = null;
	public static BGG_PageObjects bggPage;
	public static ExtentHelper exthelper;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	private JavascriptExecutor jse = null;

	/*@Parameters({ "BrowserName" })
	@BeforeSuite
	public void beforeSuite(String BrowserName) {
		configure(BrowserName);
	}*/
	
	@BeforeSuite
	public void beforeSuite() {
		configure("chrome");
	}

	@BeforeClass
	public void beforeClass() {
		Date date = new Date();
		String filename = System.getProperty("user.dir") + "\\ExtentReports\\BG_SmokeTestResults" + date.getTime()
				+ ".html";
		htmlReporter = new ExtentHtmlReporter(filename);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		htmlReporter.config().setReportName("BG Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);

		extent.setSystemInfo("Username", "Ravi");
		extent.setSystemInfo("Windows", "10");
		extent.setSystemInfo("Selenium", "3.11");
		extent.setSystemInfo("Java", "1.8");
	}

	@BeforeTest
	public void beforeTest() {
		bggPage = new BGG_PageObjects();
		bggPage = PageFactory.initElements(driver, BGG_PageObjects.class);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + "  is Executed and result is PASS");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.PASS, result.getName() + " is FAILED " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getName() + " SKIPPED");
		}
	}

	@AfterClass
	public void afterClass() {
		extent.flush();
	}
	
	/*@AfterTest
	public void afterTest(){
		driver.quit();
	}*/

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
		} else if (browser.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
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
		if (Env.equalsIgnoreCase("dev")) {
			targeturl = url.replace("bluegreengetaways", "dev.bluegreengetaways");
		}

		driver.get(targeturl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	public String captureScreen(String fileName) {
		if (driver == null) {
			// log.info("driver is null");
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
	
	public static String generateRandomNumber(){
		 long currentTime = System.currentTimeMillis();

         Random r = new Random(currentTime);
         int Low = 10000000;
         int High = 900000000;
         int R = r.nextInt(High - Low) + Low;
         return Integer.toString(R + 12)+"3";
		
	}
	
	public void scroll_Vertical(int scrollValue){
		try {
			jse.executeScript("scroll(0," + scrollValue + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void threadSleepWait(long millisecs) {
		try {
			Thread.sleep(millisecs);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	
	public void threadsleepdelay(long millisecs){
    	try {
			Thread.sleep(millisecs);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
    }
	
	public static void main(String[] args) {
		generateRandomNumber();
	}

}
