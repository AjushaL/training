package com.bank.axis.BankApps;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String username = "system";
	String password = "orcl";
	Connection connection;

	public Connection getConnection() throws SQLException {
		connection = DriverManager.getConnection(url, username, password);
		return connection;

	}

	public void insert() throws SQLException {
		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		stmt.execute("insert into customer values(101,'don','1214')");
		System.out.println("Data inserted");
		connection.close();
	}

	public void select() throws SQLException {
		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from customer");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
		}
		connection.close();
	}

	public static void main(String[] args) {
		try {
			App customer = new App();
			customer.insert();
			customer.select();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
