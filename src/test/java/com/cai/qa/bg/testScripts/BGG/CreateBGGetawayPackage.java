package com.cai.qa.bg.testScripts.BGG;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cai.qa.bg.javaScript.JavaScriptHelper;
import com.cai.qa.bg.log4j.LoggerHelp;
import com.cai.qa.bg.testBase.BaseTest;
import com.cai.qa.bg.testBase.TestBase;
import com.cai.qa.bg.utils.ExcelDataProvider;

public class CreateBGGetawayPackage extends BaseTest { 
	
	ExcelDataProvider excel = new ExcelDataProvider();
	public static Actions actions;
	
	private Logger log = LoggerHelp.getLogger(CreateBGGetawayPackage.class);
	
	
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
		bggPage.viewavailability.click();
		threadsleepdelay(3000);
		
		//************ VERIFICATION ****************
		Assert.assertEquals(bggPage.AvailabilitySuccessMessage.isDisplayed(), true);
	}
	
	@Test(priority=3)
	public void ConfirmAvailability(){
		
		test = extent.createTest("confirmAvailability");
		test.log(Status.INFO,"Confirm the availabilty of Destination selected");
		
		bggPage.continuebutton.click();
		threadsleepdelay(3000);
		
		//*************** VERIFICATION ***************
		String PersonalInformationtitle = driver.getTitle();
		System.out.println(PersonalInformationtitle);
		Assert.assertEquals(PersonalInformationtitle, "Personal Information");
	}
	
	@Test(dataProvider="test1Data",priority=4)
	public void EnterPersonalInformationnBookPackage(String FirstName,String LastName,String Email,String Phone,String StreetAddress,
			String ApartmentNo,String City,String Zipcode,String CardNumber,String CVV){
		
		//*************** TEST EXECUTION ***************
		test = extent.createTest("enterPersonalInformation");
		test.log(Status.INFO,"Personal information entered and booked package");
		
		bggPage.FirstName.sendKeys(FirstName);
		bggPage.LastName.sendKeys(LastName);
		bggPage.Email.sendKeys(Email);
		bggPage.ConfirmEmail.sendKeys(Email);
		bggPage.Phone.sendKeys(Phone);
		bggPage.Address.sendKeys(StreetAddress);
		bggPage.City.sendKeys(City);
		bggPage.State.click();
		threadsleepdelay(2000);
		bggPage.StateDropdown.click();
		threadsleepdelay(2000);
		bggPage.Zipcode.sendKeys(Zipcode);
		bggPage.CONTINUE.click();
		bggPage.CardNumber.sendKeys(CardNumber);
		bggPage.CVV.sendKeys(CVV);
		System.out.println("CVV Before");
		threadsleepdelay(2000);
		bggPage.Month.click();
		threadsleepdelay(2000);
		System.out.println("CVV After");
		bggPage.MonthDropdown.click();
		bggPage.Year.click();
		threadsleepdelay(2000);
		bggPage.YearDropdown.click();
		bggPage.ClickCheckbox.click();
		threadsleepdelay(2000);
		bggPage.purchasenow.click();
		
		String confirmationPagetitle = driver.getTitle();
		System.out.println(confirmationPagetitle);
		
		//*************** VERIFICATION ***************
		Assert.assertEquals(confirmationPagetitle, "Confirmation");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@DataProvider(name="test1Data")
	public Object[][] getData(){
		String excelPath = "E:\\Workspace\\AutomationFramework\\TestData.xlsx";
		Object[][] data = excel.testData(excelPath, "CreateBGG_Pacakge");
		return data;
	}
}
