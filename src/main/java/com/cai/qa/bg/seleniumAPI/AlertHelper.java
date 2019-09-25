package com.cai.qa.bg.seleniumAPI;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.cai.qa.bg.log4j.LoggerHelp;

public class AlertHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelp.getLogger(AlertHelper.class);
	
	public AlertHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public Alert getAlert(){
		log.info("alert test .."+ driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}
	
	public void acceptAlert(){
		getAlert().accept();
		log.info("accept alert .. ");
	}
	
	public void dismissAlert(){
		getAlert().dismiss();
		log.info("dismiss alert .. ");
	}
	
	public String getAlertText(){
		String text = getAlert().getText();
		log.info("Alert text is " + text);
		return text;
	}
	
	public boolean isAlertPresent(){
		try {
			driver.switchTo().alert();
			log.info("Alert is present");
			return true;
		} catch (Exception e) {
			log.info(e.getCause());
			return false;
		}
	}
	
	public boolean acceptAlertIfPresent(){
		if(isAlertPresent()){
			acceptAlert();
			return true;
		}else{
			return false;
		}
	}
	
	public boolean dismissAlertIfPresent(){
		if(isAlertPresent()){
			dismissAlert();
			return true;
		}else{
			log.info("Alert is not present");
			return false;
		}
	}
	
	public void acceptPrompt(String text){
		if(isAlertPresent()){
			Alert alert = getAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("Accept alert is done");
		}
	}

}
