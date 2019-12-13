package com.cai.qa.bg.testScripts.BGG;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.cai.qa.bg.log4j.LoggerHelp;
import com.cai.qa.bg.testBase.BaseTest;
import com.cai.qa.bg.utils.ExcelDataProvider;

public class VerifyHeaderLinks extends BaseTest {
	
	ExcelDataProvider excel = new ExcelDataProvider();
	public static Actions actions;
	
	private Logger log = LoggerHelp.getLogger(CreateBGGetawayPackage_Hotel.class);
	
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
	public void Verify_HeaderLinks(){
		test = extent.createTest("Verify_HeaderLinks");
		test.log(Status.INFO,"Header Links are verified");
		
		actions = new Actions(driver);
		
		actions.moveToElement(bggPage.destinations).perform();
		threadsleepdelay(2000);
		Assert.assertEquals(bggPage.LasVegas.isDisplayed(), true);
		
		actions.moveToElement(bggPage.expereinces).perform();
		threadsleepdelay(2000);
		Assert.assertEquals(bggPage.Beaches.isDisplayed(), true);
		
		actions.moveToElement(bggPage.whattoexpect).perform();
		threadsleepdelay(2000);
		
		Assert.assertEquals(bggPage.searchField.isDisplayed(), true);
		
		Assert.assertEquals(bggPage.searchButton.isDisplayed(), true);
	}
}
