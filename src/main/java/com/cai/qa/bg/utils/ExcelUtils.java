package com.cai.qa.bg.utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;



public class ExcelUtils {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception exp) {
			exp.getCause();
			exp.printStackTrace();
		}
	}

	public static int getRowCount() {
		int rowcount = 0;
		try {
			rowcount = sheet.getPhysicalNumberOfRows();
		} catch (Exception exp) {
			exp.getMessage();
			exp.printStackTrace();
		}
		return rowcount;
		
	}
	
	public static int getColumnCount() {
		int colCount = 0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		} catch (Exception exp) {
			exp.getMessage();
			exp.printStackTrace();
		}
		return colCount;
	}
	
	public static String getStringCellValue(int rowNum, int colNum){
		String cellData = null;
		
		try {
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		} catch (Exception exp) {
			
			exp.getCause();
			exp.printStackTrace();
		}
		return cellData;
		
	}
	
	public static void getNumericCellValue(int rowNum, int colNum){
		double cellData = 0;
		try {
			cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		} catch (Exception exp) {
			exp.getCause();
			exp.printStackTrace();
		}
		
	}
	
	@Test
	public void TestMethod(){
		getRowCount();
		getStringCellValue(1,1);
	}
}












/*String excelpath = ResourceHelper.getResourcePath("\\TestData.xlsx");
System.out.println(excelpath);*/
