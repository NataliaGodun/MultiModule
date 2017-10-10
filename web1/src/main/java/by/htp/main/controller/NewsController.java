package by.htp.main.controller;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import by.htp.main.entity.News;
import by.htp.main.service.NewsService;
import by.htp.main.service.exception.ServiceException;


@Controller
@Component
@RequestMapping("/news")
public class NewsController {
	private static final String NEWS="news";
	private static final String LIST_NEWS="list-news";
	private static final String NEWS_FORM="news-form";
	private static final String NEWS_ID="newsId";
	private static final String TEMP_NEWS="tempNews";
	private static final String REQUEST_LIST="/list";
	private static final String REQUEST_SHOW_FORM_ADD="/showFormForAdd";
	private static final String REQUEST_SAVE_NEWS="/saveNews";
	private static final String REQUEST_DELETE="/delete";
	private static final String REQUEST_SHOW_NEWS_DETAILS="/showNewsDetails";
	private static final String REQUEST_SHOW_NEWS_UPDATE="/showFormForUpdate";
	private static final String ERROR="error";
	private static final String REDIRECT_NEWS_LIST="redirect:/news/list";
	
	private static final Logger myLogger = Logger.getLogger(NewsController.class);
	
	// need to inject our news service
	@Autowired
	private NewsService newsService;
	
	
	@RequestMapping(REQUEST_LIST)
	public String listNews(Model theModel, HttpServletRequest request) {
		
		String s=request.getRequestURI();
		myLogger.info("Url : "+s);
		
		// get news from the service
		List<News> theNews = newsService.getNews();
				
		// add the news to the model
		theModel.addAttribute(NEWS, theNews);
		
		return LIST_NEWS;
	}
	
	@GetMapping(REQUEST_SHOW_FORM_ADD)
	public String showFormForAdd(Model theModel, HttpServletRequest request) {
		
		String s=request.getRequestURI();
		myLogger.info("Url : "+s);
		
		// create model attribute to bind form data
		News theNews = new News();
		
		theModel.addAttribute(NEWS, theNews);
		
		return NEWS_FORM;
	}
	
	
	@PostMapping(REQUEST_SAVE_NEWS)
	
	public String saveNews(@ModelAttribute(NEWS) News theNews, HttpServletRequest request){
		String page;
		String s=request.getRequestURI();
		myLogger.info("Url : "+s);
		
		// save the news using our service
		try {
			newsService.saveNews(theNews);
			System.out.println("newsService.saveNews(theNews);");
			page=REDIRECT_NEWS_LIST;
		} catch (ServiceException e) {
			System.out.println("error");
			page=ERROR;
			myLogger.error("Incorrect news!");
			
		}	
		
		return page;
	}
	
	@GetMapping(REQUEST_SHOW_NEWS_UPDATE)
	public String showFormForUpdate(@RequestParam(NEWS_ID) int theId,
									Model theModel, HttpServletRequest request) {
		
		String s=request.getRequestURI();
		myLogger.info("Url : "+s);
		
		// get the news from our service
		News theNews = newsService.getNews(theId);	
		
		// set news as a model attribute to pre-populate the form
		theModel.addAttribute(NEWS, theNews);
		
		// send over to our form		
		return NEWS_FORM;
	}
	
	@GetMapping(REQUEST_SHOW_NEWS_DETAILS)
	public String showNewsDetails(@RequestParam(NEWS_ID) int theId,
									Model theModel, HttpServletRequest request) {
		String s=request.getRequestURI();
		myLogger.info("Url : "+s);
		
		// get the news from our service
		News theNews = newsService.getNews(theId);	
		
		// set news as a model attribute to pre-populate the form
		theModel.addAttribute(TEMP_NEWS, theNews);
		System.out.println(theNews.getContent());
		// send over to our form		
		return "showNewsDetails";
	}
	
	@GetMapping(REQUEST_DELETE)
	public String deleteNews(@RequestParam(NEWS_ID) int theId, HttpServletRequest request) {
		
		String s=request.getRequestURI();
		myLogger.info("Url : "+s);
		
		// delete the news
		newsService.deleteNews(theId);
		
		return REDIRECT_NEWS_LIST;
	}
}










