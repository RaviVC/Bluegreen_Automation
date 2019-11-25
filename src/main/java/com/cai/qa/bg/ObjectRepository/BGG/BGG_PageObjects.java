package com.cai.qa.bg.ObjectRepository.BGG;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BGG_PageObjects {
	
	@FindBy(how=How.XPATH,using="//a[@title='Destinations']")
	public WebElement destinations;
	
	@FindBy(how=How.XPATH,using="//div[@class='columns seventeen menu']/ul/li[1]/ul/li[2]/a")
	public WebElement Charleston;
	
	//@FindBy(how=How.XPATH,using="//div[@class='row content']//a[text()='Myrtle Beach, SC']")
	@FindBy(how=How.XPATH,using="//*[@id='ctl00_PlaceHolderMain_DestinationExplorer_LstVwDestinationExplorer_ctrl1_ctl00_imgDestination']")
	public WebElement MyrtleBeachLink;
	
	@FindBy(how=How.XPATH,using="//div[@id='divProd_char_htl']//a[text()='Explore']")
	public WebElement explore;
	
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
	
	
	
	//Validations
	
	@FindBy(how=How.XPATH,using="//h1[text()='Bluegreen Destinations - Charleston, SC']")
	public WebElement destinationSearchResults;
	
	@FindBy(how=How.XPATH,using="//div[@class='message-success']")
	public WebElement AvailabilitySuccessMessage;
	
	@FindBy(how=How.XPATH,using="")
	public WebElement PackageCreatedConfirmation;
	
	
	
	
	
	
	
	
	
	

}
