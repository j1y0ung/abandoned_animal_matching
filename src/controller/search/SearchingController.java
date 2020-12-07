package controller.search;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.DispatcherServlet;
import model.Search;
import model.dao.SearchingDAO;
import model.dao.SearchingDTO;

public class SearchingController implements Controller {

	private static final Logger logger = LoggerFactory.getLogger(SearchingController.class);
	
	
	private SearchingDAO searchingDAO = new SearchingDAO();
	private static SearchingDTO searchingDTO = new SearchingDTO();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 占싸깍옙占쏙옙 占쏙옙占쏙옙 확占쏙옙
		
		logger.info("SearchingController");
		String pageName = "/main";
		
		// 占싯삼옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占�
		String searchText = request.getParameter("searchText") != null ? request.getParameter("searchText") : "";
		String searchType = request.getParameter("searchType") != null ? request.getParameter("searchType") : "";
		searchingDTO.setSearchList(searchingDAO.searchingData(searchType, searchText));
		
		request.setAttribute("searchList", searchingDTO.getSearchList());
		return pageName;

	}
}