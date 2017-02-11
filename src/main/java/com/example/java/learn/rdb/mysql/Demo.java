package com.example.java.learn.rdb.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test?user=root&password=";
		Connection con = DriverManager.getConnection(url);
		Statement stmt = con.createStatement();
		String query = "select * from account";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			long id = rs.getLong(1);
			String name = rs.getString(2);

			System.out.println("cn.bing.c");
			System.out.println(id + ", " + name);
		}
	}

}
