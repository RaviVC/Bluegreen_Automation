package com.cai.qa.bg.testScripts.BGG;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.cai.qa.bg.log4j.LoggerHelp;
import com.cai.qa.bg.testBase.BaseTest;
import com.cai.qa.bg.utils.ExcelDataProvider;

public class VerifyYoutubeVideoAndTabsAssociated extends BaseTest {
	
	ExcelDataProvider excel = new ExcelDataProvider();
	public static Actions actions;
	
	private Logger log = LoggerHelp.getLogger(VerifyYoutubeVideoAndTabsAssociated.class);
	
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
	public void SelectDestination(){
		//*************** TEST EXECUTION ***************
		test = extent.createTest("SelectDestination");
		test.log(Status.INFO,"Charleston Destination is selected");
		
		actions = new Actions(driver);
		actions.moveToElement(bggPage.destinations).perform();
		threadsleepdelay(3000);
		bggPage.Charleston.click();
		threadsleepdelay(3000);
		
		//************ VERIFICATION ****************
		Assert.assertEquals(bggPage.destinationSearchResults.isDisplayed(), true);
	}
	
	@Test(priority=2)
	public void CheckAvailability(){
		//*************** TEST EXECUTION ***************
		test = extent.createTest("CheckAvailability");
		test.log(Status.INFO,"Check the availabilty of Destination selected");
		
		bggPage.explore.click();
		threadsleepdelay(3000);
		
		Assert.assertEquals(bggPage.accordionTabs.isDisplayed(), true);
		
	}
	
	@Test(priority=3)
	public void VerifyAccordianTabs(){
		test = extent.createTest("VerifyAccordianTabs");
		test.log(Status.INFO,"Verify the AccordianTabs should be displayed and clickable");
		
		bggPage.localexperiences.click();
		threadsleepdelay(2000);
		
		bggPage.reviews.click();
		threadsleepdelay(2000);
		
		bggPage.accomodations.click();
		threadsleepdelay(3000);
		
		/*bggPage.PlayIcon.click();
		threadsleepdelay(40000);*/
		
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	@DataProvider(name="test1Data")
	public Object[][] getData(){
		String excelPath = "E:\\Workspace\\AutomationFramework\\TestData.xlsx";
		Object[][] data = excel.testData(excelPath, "CreateBGG_Pacakge");
		return data;
	}

}
