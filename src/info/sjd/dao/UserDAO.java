package info.sjd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import info.sjd.entity.User;

public class UserDAO {

	public static User create(User user) {

		String sql = "INSERT INTO users (login, user_password, first_name, last_name) VALUES (?,?,?,?)";
		Connection connection = ConnectionToDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, user.getLogin());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());

			statement.executeUpdate();
			
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionToDB.closeConnection(connection, statement);
		}
		
		
		return null;
	}

	public static User getOne(String login) {

		String sql = "SELECT * FROM users WHERE login=?";
		Connection connection = ConnectionToDB.getConnection();
		PreparedStatement statement = null;
		ResultSet rSet = null;
		
		try {
			
			statement = connection.prepareStatement(sql);
			statement.setString(1, login);
			
			rSet = statement.executeQuery();
			
			while (rSet.next()) {
				User user = new User();
				
				user.setLogin(rSet.getString("login"));
				user.setPassword(rSet.getString("user_password"));
				user.setFirstName(rSet.getString("first_name"));
				user.setLastName(rSet.getString("last_name"));

				return user;
			}
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionToDB.closeConnection(connection, statement, rSet);
		}
		
		return null;
	}

	public static User update(User user) {

		return null;
	}

	public static void delete(String login) {
		String sql = "DELETE FROM users WHERE login=?";
		Connection connection = ConnectionToDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, login);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionToDB.closeConnection(connection, statement);
		}
		
	}
}
