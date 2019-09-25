package com.cai.qa.bg.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+ "********** Test Execution Started **********");
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+ " ->> Test Passed ");
		System.out.println("********** Test Execution Completed **********");
		System.out.println("*****************************************************************************************************");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+ "**********Test Failed  **********");
		System.out.println("*****************************************************************************************************");
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName()+ "**********Test Skipped **********");
		System.out.println("*****************************************************************************************************");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		System.out.println(context.getName()+ "********** Execution Finished **********");// TODO Auto-generated method stub
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
	}

}
