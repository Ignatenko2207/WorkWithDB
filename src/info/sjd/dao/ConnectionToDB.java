package info.sjd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class ConnectionToDB {

	private static final String URL = "jdbc:postgresql://localhost:5432/test_db";
	private static final String USER = "postgres";
	private static final String PASSWORD = "248842";

//  private static final String URL = "jdbc:h2:~/test_db";
//  private static final String USER = "alex";
//  private static final String PASSWORD = "12345";

//  private static final String URL = "jdbc:mysql://localhost:3306/test_db";
//  private static final String USER = "root";
//  private static final String PASSWORD = "248842";

	static Connection getConnection() {

		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void closeConnection(Connection connection, PreparedStatement statement) {
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void closeConnection(Connection connection, PreparedStatement statement, ResultSet rSet) {
		try {
			rSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
