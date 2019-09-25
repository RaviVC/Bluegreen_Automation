package com.cai.qa.bg.dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicationDBQuery {
	
	public int getEmpSalary(int empID) throws NumberFormatException, SQLException{
		int salary = 0;
		String dbQuery = "SELECT salary from person.emplyee whwere idemployee"+empID;
		ResultSet result = DataBaseHelper.getResultSet(dbQuery);
		while(result.next()){
			salary = Integer.parseInt(result.getString("salary"));
		}
		return salary;
	}
	
	public static void main(String[] args) throws NumberFormatException, SQLException {
		ApplicationDBQuery appDBQuery = new ApplicationDBQuery();
		int salary = appDBQuery.getEmpSalary(2);
		System.out.println(salary);
	}
	
}
