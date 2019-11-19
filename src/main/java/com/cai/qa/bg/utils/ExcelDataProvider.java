package com.cai.qa.bg.utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cai.qa.bg.resources.ResourceHelper;

public class ExcelDataProvider {
	
	@Test(dataProvider="test1Data")
	public void test1(String username, String Password){
		System.out.println(username + "   |   " + Password);
	}
	
	
	@DataProvider(name="test1Data")
	public Object[][] getData(){
		String excelPath = "E:\\Workspace\\AutomationFramework\\TestData.xlsx";
		Object[][] data = testData(excelPath, "CreateBGG_Pacakge");
		return data;
	}
	
	public Object[][] testData(String excelPath, String sheetName ){
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColumnCount();
		System.out.println(rowCount);
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i=1;i<rowCount;i++){
			for(int j=0;j<colCount;j++){
				String cellData = excel.getStringCellValue(i, j);
				data[i-1][j] = cellData;
			}
			System.out.println();
		}
		return data;
	}

}
