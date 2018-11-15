package info.sjd.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import info.sjd.entity.Cart;
import info.sjd.entity.User;

class CartDAOTest {

	static User user = null;
	static List<Cart> carts = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		user = new User();
		user.setLogin("ignatenko2207");
		user.setPassword("123456789");
		user.setFirstName("Alex");
		user.setLastName("Ignatenko");
		
		User userDB = UserDAO.create(user);
		
		carts = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {

			Cart cart = new Cart();
			cart.setCartId(i);
			cart.setCreationTime(System.currentTimeMillis());
			cart.setUserLogin(user.getLogin());
			
			Cart cartDB = CartDAO.create(cart);
			
			carts.add(cartDB);
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		for (Cart cart : carts) {
			CartDAO.delete(cart.getCartId());
		}
		
		UserDAO.delete(user.getLogin());
	}

	@Test
	void testGetCartsByUser() {
		
		String userLogin = "ignatenko2207";
		
		List<Cart> cartsFromDB = CartDAO.getAllByUser(userLogin);
		
		assertNotNull(cartsFromDB);
		assertTrue(!cartsFromDB.isEmpty());
		assertEquals(5, cartsFromDB.size());

	}

}
