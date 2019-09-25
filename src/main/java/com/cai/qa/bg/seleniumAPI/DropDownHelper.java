package com.cai.qa.bg.seleniumAPI;

import java.util.List;
import java.util.LinkedList;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cai.qa.bg.log4j.LoggerHelp;

public class DropDownHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelp.getLogger(DropDownHelper.class);
	
	public DropDownHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void selectUisngValue(WebElement element, String value){
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void selectUisngIndex(WebElement element, int index){
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectUsingVisibleText(WebElement element, String VisibleText){
		Select select = new Select(element);
		select.selectByVisibleText(VisibleText);
	}
	
	public void deSelectUisngValue(WebElement element, String value){
		Select select = new Select(element);
		select.deselectByValue(value);
	}
	
	public void deSelectUisngIndex(WebElement element, int index){
		Select select = new Select(element);
		select.deselectByIndex(index);
	}
	
	public void deSelectUsingVisibleText(WebElement element, String VisibleText){
		Select select = new Select(element);
		select.deselectByVisibleText(VisibleText);
	}
	
	public List<String> getAllDropDownData(WebElement element){
		Select select = new Select(element);
		java.util.List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();
		for(WebElement ele:elementList){
			log.info(ele.getText());
			valueList.add(ele.getText());
		}
		return valueList;
	}
}
