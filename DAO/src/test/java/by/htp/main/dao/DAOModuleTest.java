																																																																																																																	package by.htp.main.dao;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import by.htp.main.entity.News;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContextDAOtest.xml")
public class DAOModuleTest {

	@Autowired
	private NewsDAO newsDao;

	

	@Test
	@Transactional
	public void testGetNews() {
		List<News> news = newsDao.getNews();
		assertNotNull(news);
		for (News theNews : newsDao.getNews()) {
			System.out.println("News id: " + theNews.getId() + " News title: " + theNews.getNewsTitle());
		}
	}

	@Test
	@Transactional

	public void testGetNewsID() {
		int theId = 15;

		News theNews = newsDao.getNews(theId);
		News MyNews = new News();
		MyNews.setNewsTitle("ypa");

		String expected = MyNews.getNewsTitle();
		String actual = theNews.getNewsTitle();
		assertEquals(expected, actual);

	}
	
	@Test
	@Transactional

	public void testSaveNews() {
		News MyNewsTest = new News();
		MyNewsTest.setId(2);
		MyNewsTest.setNewsTitle("ypa");
		MyNewsTest.setBrief("News TEST");
		MyNewsTest.setContent("Test");
		
		
		newsDao.saveNews(MyNewsTest);
		News theNews = newsDao.getNews(2);
		
		News expected = theNews;
		News actual =  MyNewsTest;
		assertEquals(expected, actual);

	}
	
	@Test
	@Transactional

	public void testDeleteNews() {
		newsDao.deleteNews(2);
		News theNews = newsDao.getNews(2);
		
		assertNull(theNews);

	}

}
