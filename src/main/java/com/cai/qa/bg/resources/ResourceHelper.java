package com.cai.qa.bg.resources;

import org.testng.annotations.Test;

public class ResourceHelper {
	
	public static String getResourcePath(String path){
		String resourcePath = System.getProperty("user.dir")+ path;
		System.out.println(resourcePath);
		return resourcePath ;
	}
	
	@Test
	public void TestMethod(){
		getResourcePath("\\TestData.xlsx");
	}
	
}


