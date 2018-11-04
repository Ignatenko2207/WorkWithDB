package info.sjd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import info.sjd.entity.Good;

public class GoodDAO {

	public static Good create(Good good) {

		String sql = "INSERT INTO goods (article_id, good_name, price) VALUES (?,?,?)";
		Connection connection = ConnectionToDB.getConnection();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, good.getArticleId());
			statement.setString(2, good.getGoodName());
			statement.setInt(3, good.getPrice());

			statement.executeUpdate();

			return good;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionToDB.closeConnection(connection, statement);
		}

		return null;
	}

	public static Good getOne(String articleId) {

		String sql = "SELECT * FROM goods WHERE article_id=?";
		Connection connection = ConnectionToDB.getConnection();
		PreparedStatement statement = null;
		ResultSet rSet = null;

		try {

			statement = connection.prepareStatement(sql);
			statement.setString(1, articleId);

			rSet = statement.executeQuery();

			while (rSet.next()) {
				Good good = new Good();

				good.setArticleId(rSet.getString("article_id"));
				good.setGoodName(rSet.getString("good_name"));
				good.setPrice(rSet.getInt("price"));

				return good;
			}
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionToDB.closeConnection(connection, statement, rSet);
		}

		return null;
	}

	public static Good update(Good good) {

		String sql = "UPDATE goods SET good_name=?, price=? WHERE article_id=?";
		Connection connection = ConnectionToDB.getConnection();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, good.getGoodName());
			statement.setInt(2, good.getPrice());
			statement.setString(3, good.getArticleId());
			statement.executeUpdate();

			return good;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionToDB.closeConnection(connection, statement);
		}

		return null;
	}

	public static void delete(String articleId) {
		String sql = "DELETE FROM goods WHERE article_id=?";
		Connection connection = ConnectionToDB.getConnection();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, articleId);

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionToDB.closeConnection(connection, statement);
		}

	}
}
