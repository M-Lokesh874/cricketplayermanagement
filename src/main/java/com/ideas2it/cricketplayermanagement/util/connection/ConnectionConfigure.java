package com.ideas2it.cricketplayermanagement.util.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * <p>
 * The ConnectionConfigure program creates a connection between java to mysql to
 * access data from the database.
 * </p>
 *
 * @author -Lokesh
 */
public class ConnectionConfigure {

	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static String URL = "jdbc:mysql://localhost:3306/playermanagement";
	private static String USERNAME = "root";
	private static String PASSWORD = "lokesh";
	private static ConnectionConfigure connectionConfigure;

	private ConnectionConfigure() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	public static Connection getInstance() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connectionConfigure = new ConnectionConfigure();
		}
		return connection;
	}

	public static void closeConnection() {
		try {
			if (null != connection) {
				connection.close();
			}
		} catch (SQLException sqlException) {
			System.out.println(sqlException);
		}
		try {
			if (null != statement) {
				statement.close();
			}
		} catch (SQLException sqlException) {
			System.out.println(sqlException);
		}
	}
}