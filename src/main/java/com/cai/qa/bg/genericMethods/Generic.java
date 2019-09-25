package com.cai.qa.bg.genericMethods;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class Generic {

	public static WebDriver driver;
	public static WebElement element;

	public boolean getTitle(String expected) {
		String actual = driver.getTitle();
		if (actual.trim().equalsIgnoreCase(expected)) {

			return true;
		} else {
			return false;
		}
	}

	public static String getRand() {

		long currentTime = System.currentTimeMillis();

		Random r = new Random(currentTime);
		int Low = 1000;
		int High = 9080;
		int R = r.nextInt(High - Low) + Low;

		return Integer.toString(R + 1);

	}

}
