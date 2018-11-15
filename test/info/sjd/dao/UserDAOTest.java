package info.sjd.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import info.sjd.entity.User;

class UserDAOTest {
	
	static User user = null;

	Object obj;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		user = new User();
		user.setLogin("ignatenko2207");
		user.setPassword("123456789");
		user.setFirstName("Alex");
		user.setLastName("Ignatenko");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		UserDAO.delete(user.getLogin());
	}

	@Test
	void testCreateAndGetOne() {
		User userFromDB = UserDAO.create(user);
		
		assertNotNull(userFromDB);
		assertEquals("123456789", userFromDB.getPassword());
		
		User uncheckedUserFromDB = UserDAO.getOne(user.getLogin());
		
		assertNotNull(uncheckedUserFromDB);
		assertEquals("123456789", uncheckedUserFromDB.getPassword());
	}

}
