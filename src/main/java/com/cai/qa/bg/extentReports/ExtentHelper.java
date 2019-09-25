package com.cai.qa.bg.extentReports;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentHelper {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public ExtentHelper reports() {
		Date date = new Date();
		String filename = System.setProperty("user.dir",
				"\\ExtentReports\\BG_SmokeTestResults" + date.getTime() + ".html");
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
		return null;

	}

}
