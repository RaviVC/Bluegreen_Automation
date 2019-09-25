package com.cai.qa.bg.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.cai.qa.bg.browser.BrowserType;
import com.cai.qa.bg.resources.ResourceHelper;

public class PropertyReader implements ConfigReader {
	
	public static FileInputStream file;
	public static Properties CONFIG;
	
	public PropertyReader() {
		//String filepath = ResourceHelper.getResourcePath("\\config.properties");
		String filepath = "F:\\TE_Workspace\\AutomationFramework\\src\\main\\java\\com\\te\\qa\\dcs\\config\\config.properties";
		try {
			file = new FileInputStream(new File(filepath));
			CONFIG = new Properties();
			CONFIG.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getImplicitWait() {
		return Integer.parseInt(CONFIG.getProperty("implicitwait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(CONFIG.getProperty("explicitwait"));
	}

	public int getPageLoadTime() {
		return Integer.parseInt(CONFIG.getProperty("pageloadtime"));
	}

	public BrowserType getBrowserType() {
		return BrowserType.valueOf(CONFIG.getProperty("browserType"));
	}

}
