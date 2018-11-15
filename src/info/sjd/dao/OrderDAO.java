package info.sjd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import info.sjd.entity.Order;

public class OrderDAO {

	public static Order create(Order order) {

		String sql = "INSERT INTO orders (order_id, article_id, amount, cart_id) VALUES (?,?,?,?)";
		Connection connection = ConnectionToDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, order.getOrderId());
			statement.setString(2, order.getArticleId());
			statement.setInt(3, order.getAmount());
			statement.setInt(4, order.getCartId());

			statement.executeUpdate();
			
			return order;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionToDB.closeConnection(connection, statement);
		}
		
		
		return null;
	}

	public static Order getOne(Integer orderId) {

		String sql = "SELECT * FROM orders WHERE order_id=?";
		Connection connection = ConnectionToDB.getConnection();
		PreparedStatement statement = null;
		ResultSet rSet = null;
		
		try {
			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, orderId);
			
			rSet = statement.executeQuery();
			
			while (rSet.next()) {
				Order order = new Order();
				
				order.setOrderId(rSet.getInt("order_id"));
				order.setArticleId(rSet.getString("article_id"));
				order.setAmount(rSet.getInt("amount"));
				order.setCartId(rSet.getInt("cart_id"));

				return order;
			}
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionToDB.closeConnection(connection, statement, rSet);
		}
		
		return null;
	}

	public static Integer getSumByUserAndPeriod(String userLogin, Long startPeriod, Long endPeriod) {

		String sql = "SELECT SUM(gd.price*o.amount) AS results FROM orders o " +
				"JOIN carts cr ON o.cart_id=cr.cart_id " +
				"JOIN goods gd ON o.article_id=gd.article_id " +
				"WHERE cr.creation_time>? " +
				"AND  cr.creation_time<? " +
				"AND cr.user_login=?";

		ResultSet rSet = null;

		try (
				Connection connection = ConnectionToDB.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
			){

			statement.setLong(1, startPeriod);
			statement.setLong(2, endPeriod);
			statement.setString(3, userLogin);

			rSet = statement.executeQuery();

			while (rSet.next()) {

				return rSet.getInt("results");
			}
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static Order update(Order order) {
		
		String sql = "UPDATE orders SET article_id=?, amount=?, cart_id=? WHERE order_id=?";
		Connection connection = ConnectionToDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, order.getArticleId());
			statement.setInt(2, order.getAmount());
			statement.setInt(3, order.getCartId());
			statement.setInt(4, order.getOrderId());

			statement.executeUpdate();
			
			return order;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionToDB.closeConnection(connection, statement);
		}
		
		
		return null;
	}

	public static void delete(Integer orderId) {
		String sql = "DELETE FROM orders WHERE order_id=?";
		Connection connection = ConnectionToDB.getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, orderId);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionToDB.closeConnection(connection, statement);
		}
		
	}
}
