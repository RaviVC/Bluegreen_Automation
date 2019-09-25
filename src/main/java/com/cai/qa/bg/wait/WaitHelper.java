package com.cai.qa.bg.wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cai.qa.bg.log4j.LoggerHelp;

public class WaitHelper {
	
	private WebDriver driver;
	Logger log = LoggerHelp.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void setImplicitWait(long timeout, TimeUnit unit){
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}
	
	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryMiliSec){
		
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryMiliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
	
	public void WaitForElementVisibleWithPolliingTime(WebElement element, int timeOutInSeconds, int pollingEveryMiliSec){
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void WaitForElementClickable(WebElement element, int timeOutInSeconds){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void WaitForElementNotPresent(WebElement element, int timeOutInSeconds){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void WaitForframeToBeAvailableAndSwitchToIt(WebElement element, int timeOutInSeconds){
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	
	public Wait<WebDriver> getfluentWait(int timeOutInSeconds, int pollingEveryMiliSec){
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOutInSeconds)).pollingEvery(Duration.ofMillis(pollingEveryMiliSec)).ignoring(NoSuchElementException.class);
		return fwait;
	}
	
	public Wait<WebDriver> waitForElement(WebElement element, int timeOutInSeconds, int pollingEveryMiliSec){
		Wait<WebDriver> fwait = getfluentWait(timeOutInSeconds, pollingEveryMiliSec);
		fwait.until(ExpectedConditions.visibilityOf(element));
		return fwait;
	}
	
	public void pageLoadTime(long timeout, TimeUnit unit){
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
	}
}
