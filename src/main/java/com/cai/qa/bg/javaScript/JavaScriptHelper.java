package com.cai.qa.bg.javaScript;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cai.qa.bg.log4j.LoggerHelp;

public class JavaScriptHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelp.getLogger(JavaScriptHelper.class);
	
	public JavaScriptHelper(WebDriver driver) {
		this.driver=driver;
		log.info("JavaScriptHelper has been installed");
	}
	
	public Object executeScript(String script){
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script);
	}
	
	public Object executeScript(String script, Object...args){
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script,args);
	}
	
	public void ScrollToElement(WebElement element){
		log.info("scroll to WebElement ...");
		executeScript("window.scrollTo(arguments[0],arguments[1]",element.getLocation().x,element.getLocation().y);	
	}
	
	public void scrollToElementAndClick(WebElement element){
		ScrollToElement(element);
		element.click();
		log.info("elemeent is clicked"+element.toString());
	}
	
	public void scrollIntoView(WebElement element){
		executeScript("arguments[0].scrollIntoView", element);
	}
	
	public void scrollIntoViewAndClick(WebElement element){
		scrollIntoView(element);
		element.click();
		log.info("element is clicked"+element.toString());
	}
	
	public void scrollDownVertical(){
		log.info("scroll down vertical");
		executeScript("window.scrollTo(0,document.body.scrollHeight");
	}
	
	public void scrollUpVertical(){
		log.info("scroll up vertical");
		executeScript("window.scrollTo(0,-document.body.scrollHeight");
	}
	
	public void scrollDownByPixel(int pixel){
		log.info("scroll down by pixel");
		executeScript("window.scrollBY(0,"+pixel+")");
	}
	
	public void scrollUPByPixel(int pixel){
		log.info("scroll up by pixel");
		executeScript("window.scrollBY(0,-"+pixel+")");
	}
	
	public void zoomInBy100Percentage(){
		executeScript("document.body.style.zoom='100%'");
	}
	
	public void zoomInBy60Percentage(){
		executeScript("document.body.style.zoom='60%'");
	}
	
	public void clickElement(WebElement element){
		executeScript("arguments[0].click;",element);
	}
	

}
