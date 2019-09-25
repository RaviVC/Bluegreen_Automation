package com.cai.qa.bg.verification;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cai.qa.bg.log4j.LoggerHelp;

public class VerificationHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelp.getLogger(VerificationHelper.class);
	
	public VerificationHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean isDisplayed(WebElement element){
		
		try {
			element.isDisplayed();
			log.info("element is displayed .. "+ element.getText());
			return true;
		} catch (Exception e) {
			log.error("element is not displayed .. "+ e.getCause());
			return false;
		}
	}
	
	public boolean isNotDisplayed(WebElement element){
		
		try {
			element.isDisplayed();
			log.info("element is present .. "+ element.getText());
			return false;
		} catch (Exception e) {
			log.error("element is not present .. "+ e.getCause());
			return true;
		}
	}
	
	public String getText(WebElement element){
		if(null==element){
			log.info("WebElement is null .. ");
			return null;
		}
		boolean status = isDisplayed(element);
		if(status){
			log.info("element text is .."+ element.getText());
			return element.getText();
		}else{
			return null;
		}
	}
	
	public String getTitle(){
		log.info("page title is .. " + driver.getTitle());
		return driver.getTitle();
	}
}
