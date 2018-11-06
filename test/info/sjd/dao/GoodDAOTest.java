package info.sjd.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import info.sjd.entity.Good;

class GoodDAOTest {

	private static Good good;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		good = new Good();
		
		good.setArticleId("123456");
		good.setGoodName("Test good v.01");
		good.setPrice(1695);
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		GoodDAO.delete(good.getArticleId());
	}

	@Test
	void testCreateAndGet() {
		Good testGood = GoodDAO.create(good);
		
		assertNotNull(testGood);
		assertEquals("Test good v.01", testGood.getGoodName());
	
		Good testGoodFromDB = GoodDAO.getOne(good.getArticleId());
		
		assertNotNull(testGoodFromDB);
		assertEquals("Test good v.01", testGoodFromDB.getGoodName());
	}
}
