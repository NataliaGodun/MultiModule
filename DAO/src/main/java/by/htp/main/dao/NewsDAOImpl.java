package by.htp.main.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import by.htp.main.entity.News;


@Repository
public class NewsDAOImpl implements NewsDAO {

	private static final String NEWS_ID="newsId";
	private static final String NEWS_ORDER_BY_TITLE="from News order by newsTitle";
	private static final String DELETE_NEWS="delete from News where id=:newsId";
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	//@Override
	public List<News> getNews() {
		System.out.println(sessionFactory);
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by news title
		Query<News> theQuery = 
				currentSession.createQuery(NEWS_ORDER_BY_TITLE,
											News.class);
		
		// execute query and get result list
		List<News> news = theQuery.getResultList();
				
		// return the results		
		return news;
	}

	//@Override
	
	public void saveNews(News theNews) {
		
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the news
		currentSession.saveOrUpdate(theNews);
		
	}

	//@Override
	public News getNews(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		News theNews = currentSession.get(News.class, theId);
		
		return theNews;
	}

	//@Override
	public void deleteNews(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(DELETE_NEWS);
		theQuery.setParameter(NEWS_ID, theId);
		
		theQuery.executeUpdate();		
	}

}











