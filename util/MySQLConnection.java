package com.chainsys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/parking_spot_database", "root",
					"Angelin#18");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	private MySQLConnection() {
	}

}
