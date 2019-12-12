package com.cai.qa.bg.testScripts.BGG;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.cai.qa.bg.testBase.BaseTest;

public class VerifySearchFunctionality extends BaseTest {
	
	
	@Test(priority=0)
	public void Launch(){
		//*************** TEST EXECUTION ***************
		test = extent.createTest("Launch BGG");
		test.log(Status.INFO,"BGG Application Launched");
		
		launchApp(CONFIG.getProperty("BGG_URL"), "stg");
		String bggPagetitle = driver.getTitle();
		System.out.println(bggPagetitle);
		
		//*************** VERIFICATION ***************
		Assert.assertEquals(bggPagetitle, "Bluegreen Getaways | Vacation Packages");
		
	}
	
	@Test(priority=1)
	public void verifySearch(){
		bggPage.searchField.sendKeys("Orlando");
		bggPage.searchButton.click();
	}

}
