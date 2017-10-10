package by.htp.main.service;

import java.util.List;

import by.htp.main.entity.News;
import by.htp.main.service.exception.ServiceException;

public interface NewsService {

	public List<News> getNews();

	public void saveNews(News theNews) throws ServiceException;

	public News getNews(int theId);

	public void deleteNews(int theId);
	
}
