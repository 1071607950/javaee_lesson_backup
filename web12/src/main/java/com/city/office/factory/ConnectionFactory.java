package com.city.office.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/CITYINFO?useSSL=false&useUnicode=true&characterEncoding=UTF8&serverTimezone=UTC","root","12345");
	}
}
