package com.cai.qa.bg.listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(com.te.qa.dcs.listeners.TestNGListeners.class)
public class ListenersDemo {
	
	@Test
	public void test1(){
		System.out.println("Inside Test1");
		
	}
	
	@Test
	public void test2(){
		System.out.println("Inside Test2");
		
	}
	
	@Test
	public void test3(){
		System.out.println("Inside Test3");
		Assert.assertTrue(false);
		
	}
	
	@Test
	public void test4(){
		System.out.println("Inside Test4");
		throw new SkipException("This test is skipped");
	}

}
