package com.cai.qa.bg.testScripts.BGG;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cai.qa.bg.javaScript.JavaScriptHelper;
import com.cai.qa.bg.log4j.LoggerHelp;
import com.cai.qa.bg.testBase.BaseTest;
import com.cai.qa.bg.testBase.TestBase;

public class CreateBGGetawayPackage extends BaseTest { 
	
	private Logger log = LoggerHelp.getLogger(CreateBGGetawayPackage.class);
	
	
	@Test
	public void Launch(){
		test = extent.createTest("Launch BGG");
		test.log(Status.INFO,"Test Case Execution Started");
		try {
			launchApp(CONFIG.getProperty("BGG_URL"), "stg");
			System.out.println("BGG App Launched");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
}
