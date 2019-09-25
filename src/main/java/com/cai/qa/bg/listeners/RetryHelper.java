package com.cai.qa.bg.listeners;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.cai.qa.bg.log4j.LoggerHelp;

public class RetryHelper implements IRetryAnalyzer {
	
	private int retryCount = 0;
	private int maxRetryCount = 2;
	
	private WebDriver driver;
	Logger log = LoggerHelp.getLogger(RetryHelper.class);
	

	public boolean retry(ITestResult arg0) {
		if(retryCount<maxRetryCount){
			log.info("Retrying test  "+ arg0.getName()+ "with status" + "PASS" + "for the " + (retryCount+1)+ "times");
			retryCount++;
			return true;
		}
		return false;
	}
	
	public String getResultStatusName(int status){
		String resultName = null;
		if(status==1){
			resultName="SUCCESS";
		}
		if(status==2){
			resultName="FAILURE";
		}
		if(status==3){
			resultName="SKIP";
		}
		return resultName;
	}

}
