package by.htp.main.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.htp.main.dao.NewsDAO;
import by.htp.main.entity.News;
import by.htp.main.service.exception.ServiceException;

@Service
public class NewsServiceImpl implements NewsService {

	private static final Logger myLogger = Logger.getLogger(NewsServiceImpl.class);

	// need to inject news dao
	@Autowired
	private NewsDAO newsDAO;

	// @Override
	@Transactional
	public List<News> getNews() {
		return newsDAO.getNews();
	}

	// @Override
	@Transactional
	public void saveNews(News theNews) throws ServiceException {
		
		if (theNews.getNewsTitle().isEmpty()) {
			myLogger.error("The title is empty!");
			throw new ServiceException("Incorrect news");
	
		} else {
			newsDAO.saveNews(theNews);
		}
	}

	// @Override
	@Transactional
	public News getNews(int theId) {

		if (theId == 0) {
			myLogger.error("The news doesn't exist!");
			new ServiceException("Incorrect news");
			

		} 
			return newsDAO.getNews(theId);
		
	}

	// @Override
	@Transactional
	public void deleteNews(int theId) {

		if (theId == 0) {
			new ServiceException("Incorrect news");
			myLogger.error("The news doesn't exist!");

		}
		newsDAO.deleteNews(theId);
	}
}
