package com.cai.qa.bg.PageObjects.BGG;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	
	@FindBy(how=How.XPATH,using="//a[@title='Destinations']")
	public WebElement destinations;
	
	@FindBy(how=How.XPATH,using="//ul[@class='inline-list collapse main-menu']/li[1]//ul//li[6]//a")
	public WebElement orlando;

}
