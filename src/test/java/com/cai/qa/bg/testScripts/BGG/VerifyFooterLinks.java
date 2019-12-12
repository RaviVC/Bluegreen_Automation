package com.cai.qa.bg.testScripts.BGG;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.cai.qa.bg.testBase.BaseTest;

public class VerifyFooterLinks extends BaseTest{
	
	
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
	public void verifyFooterLinks(){
		//*************** TEST EXECUTION ***************
		threadsleepdelay(1000);
		bggPage.Gotit.click();
		threadsleepdelay(2000);
		scroll_Vertical(700);
		bggPage.About.click();
		String AboutTitle = driver.getTitle();
		System.out.println(AboutTitle);
		Assert.assertEquals(AboutTitle, "About Bluegreen Getaways");
		threadsleepdelay(2000);
		bggPage.Home.click();
		
		bggPage.Contact.click();
		String ContactTitle = driver.getTitle();
		System.out.println(ContactTitle);
		Assert.assertEquals(ContactTitle, "Contact Us | Bluegreen Getaways");
		threadsleepdelay(2000);
		bggPage.Home.click();
		
		bggPage.FAQ.click();
		String FAQTitle = driver.getTitle();
		System.out.println(FAQTitle);
		Assert.assertEquals(FAQTitle, "Frequently Asked Questions | Bluegreen Getaways");
		threadsleepdelay(2000);
		bggPage.Home.click();
		
		bggPage.DetailsOfParticipation.click();
		String DetailsOfParticipationTitle = driver.getTitle();
		System.out.println(DetailsOfParticipationTitle);
		Assert.assertEquals(DetailsOfParticipationTitle, "Details of Participation | Bluegreen Getaways");
		threadsleepdelay(2000);
		bggPage.Home.click();
		
		bggPage.TermsAndConditions.click();
		String TermsAndConditionsTitle = driver.getTitle();
		System.out.println(TermsAndConditionsTitle);
		Assert.assertEquals(TermsAndConditionsTitle, "Terms and Conditions | Bluegreen Getaways");
		threadsleepdelay(2000);
		bggPage.Home.click();
		
		bggPage.Privacy.click();
		String PrivacyTitle = driver.getTitle();
		System.out.println(PrivacyTitle);
		Assert.assertEquals(PrivacyTitle, "Privacy Policy | Bluegreen Getaways");
		threadsleepdelay(2000);
		bggPage.Home.click();
		
		bggPage.SiteMap.click();
		String SiteMapTitle = driver.getTitle();
		System.out.println(SiteMapTitle);
		Assert.assertEquals(SiteMapTitle, "Site Map");
		threadsleepdelay(2000);
		bggPage.Home.click();
		
		bggPage.BluegreenVacations.click();
		String BluegreenVacationsTitle = driver.getTitle();
		System.out.println(BluegreenVacationsTitle);
		threadsleepdelay(2000);
		bggPage.Home.click();
		
	}

}
