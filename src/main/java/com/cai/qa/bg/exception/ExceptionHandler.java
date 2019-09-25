package com.cai.qa.bg.exception;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.cai.qa.bg.log4j.LoggerHelp;

public class ExceptionHandler {

	private Logger log = LoggerHelp.getLogger(ExceptionHandler.class);

	public void evalException(String exp) {
		if (exp.equals("java.lang.ArithmeticException")) {
			log.info("Execution interrupted because of java.lang.ArithmeticException");
		}
	}

	@Test
	public void TestMethod() {
		System.out.println("Hello world");
		try {
			int i = 1 / 0;
		} catch (Exception e) {
			ExceptionHandler exp = new ExceptionHandler();
			e.printStackTrace();
			String exception = e.getLocalizedMessage();
			// System.out.println(exception);
			exp.evalException("java.lang.ArithmeticException");
		}
	}

}
