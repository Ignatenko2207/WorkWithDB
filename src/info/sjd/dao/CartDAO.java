package info.sjd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import info.sjd.entity.Cart;

public class CartDAO {

	public static Cart create(Cart cart) {

		String sql = "INSERT INTO carts (cart_id, creation_time, user_login) VALUES (?,?,?)";
		Connection connection = ConnectionToDB.getConnection();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, cart.getCartId());
			statement.setLong(2, cart.getCreationTime());
			statement.setString(3, cart.getUserLogin());

			statement.executeUpdate();

			return cart;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionToDB.closeConnection(connection, statement);
		}

		return null;
	}

	public static Cart getOne(Integer cartId) {

		String sql = "SELECT * FROM carts WHERE cart_id=?";
		Connection connection = ConnectionToDB.getConnection();
		PreparedStatement statement = null;
		ResultSet rSet = null;

		try {

			statement = connection.prepareStatement(sql);
			statement.setInt(1, cartId);

			rSet = statement.executeQuery();

			while (rSet.next()) {
				Cart cart = new Cart();

				cart.setCartId(rSet.getInt("cart_id"));
				cart.setCreationTime(rSet.getLong("creation_time"));
				cart.setUserLogin(rSet.getString("user_login"));

				return cart;
			}
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionToDB.closeConnection(connection, statement, rSet);
		}

		return null;
	}

	public static Cart update(Cart cart) {

		String sql = "UPDATE carts SET creation_time=?, user_login=? WHERE cart_id=?";
		Connection connection = ConnectionToDB.getConnection();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.setLong(1, cart.getCreationTime());
			statement.setString(2, cart.getUserLogin());
			statement.setInt(3, cart.getCartId());

			statement.executeUpdate();

			return cart;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionToDB.closeConnection(connection, statement);
		}

		return null;
	}

	public static void delete(Integer cartId) {
		String sql = "DELETE FROM carts WHERE cart_id=?";
		Connection connection = ConnectionToDB.getConnection();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, cartId);

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionToDB.closeConnection(connection, statement);
		}

	}
}
