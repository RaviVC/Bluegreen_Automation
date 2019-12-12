package com.cai.qa.bg.ObjectRepository.BGG;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BGG_PageObjects {
	
	@FindBy(how=How.XPATH,using="//a[@title='Destinations']")
	public WebElement destinations;
	
	@FindBy(how=How.XPATH,using="//div[@class='columns seventeen menu']/ul/li[1]/ul/li[2]/a")
	public WebElement Charleston;
	
	@FindBy(how=How.XPATH,using="//div[@class='columns seventeen menu']/ul/li[1]/ul/li[1]/a")
	public WebElement BoyneFalls;
	
	@FindBy(how=How.XPATH,using="//div[@class='columns seventeen menu']/ul/li[1]/ul/li[4]/a")
	public WebElement LasVegas;
	
	@FindBy(how=How.XPATH,using="//div[@class='columns seventeen menu']/ul/li[2]/ul/li[1]/a")
	public WebElement Beaches;
	
	@FindBy(how=How.XPATH,using="//*[@id='ctl00_PlaceHolderMain_DestinationExplorer_LstVwDestinationExplorer_ctrl1_ctl00_imgDestination']")
	public WebElement MyrtleBeachLink;
	
	@FindBy(how=How.XPATH,using="//div[@id='divProd_char_htl']//a[text()='Explore']")
	public WebElement explore;
	
	@FindBy(how=How.XPATH,using="//div[@id='divProd_vp']//a[text()='Explore']")
	public WebElement exploreResort;
	
	@FindBy(how=How.XPATH,using="//div[@class='hide-mobile offer-form']//a[text()='VIEW AVAILABILITY']")
	public WebElement viewavailability;
	
	@FindBy(how=How.XPATH,using="//div[@class='fourteen columns left']//a[text()='Continue']")
	public WebElement continuebutton;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='First']")
	public WebElement FirstName;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Last']")
	public WebElement LastName;
	
	@FindBy(how=How.XPATH,using="//input[@class='txtEmail']")
	public WebElement Email;
	
	@FindBy(how=How.XPATH,using="//input[@class='txtEmail txtEmail2']")
	public WebElement ConfirmEmail;
	
	@FindBy(how=How.XPATH,using="//input[@class='txtPhone']")
	public WebElement Phone;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Street Address']")
	public WebElement Address;
	
	@FindBy(how=How.XPATH,using="//input[@class='txtCity']")
	public WebElement City;
	
	@FindBy(how=How.XPATH,using="")
	public WebElement Country;
	
	@FindBy(how=How.XPATH,using="//div[label[text()='*State']]/span/div/span[2]")
	public WebElement State;
	
	@FindBy(how=How.XPATH,using="//span[@id='ddlStateContainer']/div/div/ul/li[2]")
	public WebElement StateDropdown;
	
	@FindBy(how=How.XPATH,using="//input[@class='txtZipCode']")
	public WebElement Zipcode;
	
	@FindBy(how=How.XPATH,using="//input[@value='continue']")
	public WebElement CONTINUE;
	
	@FindBy(how=How.XPATH,using="//div[label[text()='*Card Number:']]/input")
	public WebElement CardNumber;
	
	@FindBy(how=How.XPATH,using="//div[@class='five mobile-one columns']//input")
	public WebElement CVV;
	
	@FindBy(how=How.XPATH,using="//div[label[text()='*Expiration:']]//span[text()='Month']")
	public WebElement Month;
	
	@FindBy(how=How.XPATH,using="//div[@id='divPaymentDetails']/div/div[3]/div[1]/div/div/ul/li[3]")
	public WebElement MonthDropdown;
	
	@FindBy(how=How.XPATH,using="//span[text()='Year']")
	public WebElement Year;
	
	@FindBy(how=How.XPATH,using="//div[@id='divPaymentDetails']/div/div[3]/div[2]/div/div/ul/li[3]")
	public WebElement YearDropdown;
	
	@FindBy(how=How.XPATH,using="//input[@id='chkAgreement']")
	public WebElement ClickCheckbox;
	
	@FindBy(how=How.XPATH,using="//input[@value='Purchase Now']")
	public WebElement purchasenow;
	
	@FindBy(how=How.XPATH,using="//a[@title='Experiences']")
	public WebElement expereinces;
	
	@FindBy(how=How.XPATH,using="//a[@title='what to expect']")
	public WebElement whattoexpect;
	
	@FindBy(how=How.XPATH,using="//input[@name='search']")
	public WebElement searchField;
	
	@FindBy(how=How.XPATH,using="//input[@id='bg-search-btn']")
	public WebElement searchButton;
	
	@FindBy(how=How.XPATH,using="//button[@id='player_uid_851711760_1']/div[4]/button")
	public WebElement PlayIcon;
	
	//Footer Links 
	
	@FindBy(how=How.XPATH,using="//a[@title='Home']")
	public WebElement Home;
	
	@FindBy(how=How.XPATH,using="//a[@href='/about-us']")
	public WebElement About;
	
	@FindBy(how=How.XPATH,using="//a[@href='/contact-us']")
	public WebElement Contact;
	
	@FindBy(how=How.XPATH,using="//a[@href='/faqs']")
	public WebElement FAQ;
	
	@FindBy(how=How.XPATH,using="//a[@href='/details-of-participation']")
	public WebElement DetailsOfParticipation;
	
	@FindBy(how=How.XPATH,using="//a[@href='/terms-and-conditions']")
	public WebElement TermsAndConditions;
	
	@FindBy(how=How.XPATH,using="//a[@href='/privacy']")
	public WebElement Privacy;
	
	@FindBy(how=How.XPATH,using="//a[@href='/sitemap']")
	public WebElement SiteMap;
	
	@FindBy(how=How.XPATH,using="//a[@href='http://www.bluegreenvacations.com']")
	public WebElement BluegreenVacations;
	
	@FindBy(how=How.XPATH,using="//a[text()='Got it!']")
	public WebElement Gotit;
	
	
	//Social media icons 
	
	@FindBy(how=How.XPATH,using="//ul[@class='hide-desktop inline-list narrow social-links']//a[@class='facebook']")
	public WebElement Facebook;
	
	@FindBy(how=How.XPATH,using="//ul[@class='hide-desktop inline-list narrow social-links']//a[@class='pinterest']")
	public WebElement Pinterest;
	
	@FindBy(how=How.XPATH,using="//ul[@class='hide-desktop inline-list narrow social-links']//a[@class='twitter']")
	public WebElement Twitter;
	
	@FindBy(how=How.XPATH,using="//ul[@class='hide-desktop inline-list narrow social-links']//a[@class='google-plus']")
	public WebElement Instagram;
	
	
	//**********************************<>*********************************
	
	@FindBy(how=How.XPATH,using="//ul[@id='tabsList']//li[1]")
	public WebElement accomodations;
	
	@FindBy(how=How.XPATH,using="//ul[@id='tabsList']//li[2]")
	public WebElement localexperiences;
	
	@FindBy(how=How.XPATH,using="//ul[@id='tabsList']//li[3]")
	public WebElement reviews;
	
	@FindBy(how=How.XPATH,using="//a[text()='Getaway to Charleston, South Carolina']")
	public WebElement accomodationsVideo;
	
	@FindBy(how=How.XPATH,using="//div[@id='accordionTabs']")
	public WebElement accordionTabs;
	
	
	
	
	
	
	
	
	
	
	
	//Validations
	
	@FindBy(how=How.XPATH,using="//h1[text()='Bluegreen Destinations - Charleston, SC']")
	public WebElement destinationSearchResults;
	
	@FindBy(how=How.XPATH,using="//h1[text()='Bluegreen Destinations - Las Vegas, NV']")
	public WebElement destinationSearchResultsLasVegas;
	
	@FindBy(how=How.XPATH,using="//div[@class='message-success']")
	public WebElement AvailabilitySuccessMessage;
	
	@FindBy(how=How.XPATH,using="")
	public WebElement PackageCreatedConfirmation;
	
	
	
	
	
	
	
	
	
	

}
