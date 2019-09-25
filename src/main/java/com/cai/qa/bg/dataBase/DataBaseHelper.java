package com.cai.qa.bg.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.Logger;
import com.cai.qa.bg.log4j.LoggerHelp;

public class DataBaseHelper {

	private static Logger log = LoggerHelp.getLogger(DataBaseHelper.class);
	private static String url = "jdbc:mysql://localhost/person";
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String userName = "root";
	private static String password = "password";
	private static Connection connection;
	private static DataBaseHelper instance = null;
	
	public DataBaseHelper() {
		connection = getSingleInstanceConnection();
	}

	public static DataBaseHelper getInstance(){
		if(instance==null){
			instance = new DataBaseHelper();
		}
		return instance;
	}
	
	private Connection getSingleInstanceConnection() {
		try {
			Class.forName(driverName);

			try {
				connection = DriverManager.getConnection(url, userName, password);
				if (connection != null) {
					log.info("Connected to Database ..");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			log.info("Driver not found .." + e);
		}
		return connection;
	}
	
	public Connection getConnection(){
		return connection;
		
	}
	
	public static ResultSet getResultSet(String dbQuery){
		instance = DataBaseHelper.getInstance();
		connection = instance.getConnection();
		log.info("Executing query"+ dbQuery);
		try {
			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(dbQuery);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
