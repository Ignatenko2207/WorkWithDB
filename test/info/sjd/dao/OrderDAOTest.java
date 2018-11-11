package info.sjd.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import info.sjd.entity.Cart;
import info.sjd.entity.Good;
import info.sjd.entity.Order;
import info.sjd.entity.User;

class OrderDAOTest {

	static Good good1;
	static Good good2;
	static Good good3;
	static User user;
	static Cart oldCart;
	static Cart newCart;

	static Order oldOrder;

	static Order newOrder1;
	static Order newOrder2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

//		user = new User();
//	
//		user.setLogin("ignatenko2207");
//		user.setPassword("123456789");
//		user.setFirstName("Alex");
//		user.setLastName("Ignatenko");
//		UserDAO.create(user);
//
//		good1 = new Good();
//
//		good1.setArticleId("111");
//		good1.setGoodName("Test good v.01");
//		good1.setPrice(1700);
//		GoodDAO.create(good1);
//		
//		good2 = new Good();
//
//		good2.setArticleId("222");
//		good2.setGoodName("Test good v.02");
//		good2.setPrice(2000);
//		GoodDAO.create(good2);
//		
//		good3 = new Good();
//
//		good3.setArticleId("333");
//		good3.setGoodName("Test good v.03");
//		good3.setPrice(3000);
//		GoodDAO.create(good3);
//		
//		oldCart = new Cart();
//		oldCart.setCartId(1111);
//		oldCart.setCreationTime(System.currentTimeMillis() - (1000*60*60*24*5));
//		oldCart.setUserLogin(user.getLogin());
//		CartDAO.create(oldCart);
//		
//		newCart = new Cart();
//		newCart.setCartId(2222);
//		newCart.setCreationTime(System.currentTimeMillis());
//		newCart.setUserLogin(user.getLogin());
//		CartDAO.create(newCart);
//		
//		oldOrder = new Order();
//		oldOrder.setOrderId(11111);
//		oldOrder.setArticleId(good1.getArticleId());
//		oldOrder.setCartId(oldCart.getCartId());
//		oldOrder.setAmount(3);
//		OrderDAO.create(oldOrder);
//		
//		newOrder1 = new Order();
//		newOrder1.setOrderId(22222);
//		newOrder1.setArticleId(good2.getArticleId());
//		newOrder1.setCartId(newCart.getCartId());
//		newOrder1.setAmount(4);
//		OrderDAO.create(newOrder1);
//		
//		newOrder2 = new Order();
//		newOrder2.setOrderId(33333);
//		newOrder2.setArticleId(good3.getArticleId());
//		newOrder2.setCartId(newCart.getCartId());
//		newOrder2.setAmount(4);
//		OrderDAO.create(newOrder2);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
//		OrderDAO.delete(newOrder1.getOrderId());
//		OrderDAO.delete(newOrder2.getOrderId());
//		OrderDAO.delete(oldOrder.getOrderId());
//		
//		CartDAO.delete(newCart.getCartId());
//		CartDAO.delete(oldCart.getCartId());
//		
//		UserDAO.delete(user.getLogin());
//		
//		GoodDAO.delete(good1.getArticleId());
//		GoodDAO.delete(good2.getArticleId());
//		GoodDAO.delete(good3.getArticleId());
		
	}
	
	@Ignore
	@Test
	void testGetSumOfOrdersByUserAndTime() {
		Long startPeriod = System.currentTimeMillis() - (1000*60*60*24*3);
		Integer sum = OrderDAO.getSumOfOrdersByUserAndTime(startPeriod, System.currentTimeMillis(), user.getLogin());
		
		assertNotNull(sum);
		assertEquals((Integer)4, sum);
	}

}
