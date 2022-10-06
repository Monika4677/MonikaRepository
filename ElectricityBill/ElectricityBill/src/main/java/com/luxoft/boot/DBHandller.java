package com.luxoft.boot;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBHandller {
	public Connection establishConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/ebbill",
					"root",
					"root123");
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	}


