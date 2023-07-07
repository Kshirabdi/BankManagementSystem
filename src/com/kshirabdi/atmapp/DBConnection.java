package com.kshirabdi.atmapp;

import java.sql.*;
public class DBConnection {
	public Connection connection;
	public Statement statement;
	public PreparedStatement pstmt;
	public ResultSet rs ;
	public DBConnection()
	{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","kshirabdi","1234");
			statement=connection.createStatement();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
