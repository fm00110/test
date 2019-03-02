package com.ncu.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnOrcl {

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_stockmanage","root","1234");
			
			
			DatabaseMetaData databaseMetaData = conn.getMetaData();
			ResultSet tables = databaseMetaData.getTables(null, null, "%", null);
			ArrayList<String> tablesList = new ArrayList<String>();
			while (tables.next()) {
				tablesList.add(tables.getString("TABLE_NAME"));
				System.out.println(tables.getString("TABLE_NAME"));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
