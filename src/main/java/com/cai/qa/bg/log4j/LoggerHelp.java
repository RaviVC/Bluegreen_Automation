package com.cai.qa.bg.log4j;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class LoggerHelp {
	
	public static Logger logger = LogManager.getLogger();
	
	private static boolean root = false;
	
	@Test
	public void TestMethod(){
		logger = LogManager.getLogger();
		  
		logger.debug("This is a debug message");
		logger.info("This is an info message");
		logger.warn("This is a warn message");
		logger.fatal("This is a fatal message"); 
	}
	
	public static Logger getLogger(Class cls){
		if(root){
			return logger;
		}
		root = true;
		return logger;
	}
}
