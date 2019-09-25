package com.cai.qa.bg.config;

import com.cai.qa.bg.browser.BrowserType;

public interface ConfigReader {
	
	public int getImplicitWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public BrowserType getBrowserType();

}
