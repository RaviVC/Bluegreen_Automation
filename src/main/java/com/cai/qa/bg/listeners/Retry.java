package com.cai.qa.bg.listeners;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class Retry {
	
	@Test
	public void test1(){
		System.out.println("Inside test1");
	}
	
	@Test(retryAnalyzer = com.cai.qa.bg.listeners.RetryAnalyzer.class)
	public void test2(){
		int i = 1/0;
	}
	
	@Test
	public void test3(){
		System.out.println("Inside test3");
	}

}
