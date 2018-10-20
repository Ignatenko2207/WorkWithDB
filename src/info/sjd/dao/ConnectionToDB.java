package info.sjd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionToDB {

    private static final String URL = "jdbc:postgresql://localhost:5432/test_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "248842";

    static Connection getConnection(){

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
}
