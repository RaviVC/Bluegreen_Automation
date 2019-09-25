package com.cai.qa.bg.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeBrowser {
	
	public ChromeOptions getChromeOptions(){
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--test--type");
		option.addArguments("-- disable -- pop up blocking --");
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		option.setCapability(ChromeOptions.CAPABILITY, option);
		
		//Linux
		if(System.getProperty("os.name").contains("Linux")){
			option.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
		}
		return option;
	}


public WebDriver getChromeDriver(ChromeOptions cap){
	
	if(System.getProperty("os.anme").contains("Mac")){
		System.setProperty("webdriver.chrome.driver", "F:\\TE_Workspace\\AutomationFramework\\drivers\\chromedriver");
		return new ChromeDriver(cap);
	}
	else if(System.getProperty("os.anme").contains("Window")){
		System.setProperty("webdriver.chrome.driver", "F:\\TE_Workspace\\AutomationFramework\\src\\main\\java\\com\\te\\qa\\dcs\\drivers\\chromedriver.exe");
		return new ChromeDriver(cap);
	}
	else if(System.getProperty("os.anme").contains("Linux")){
		System.setProperty("webdriver.chrome.driver", "F:\\TE_Workspace\\AutomationFramework\\drivers\\chromedriver.exe");
		return new ChromeDriver(cap);
	}
	return null;
	}
}
