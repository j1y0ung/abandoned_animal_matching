package controller.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.dao.SearchingDAO;
import model.SearchingDTO;

public class SearchingController implements Controller {

	private static final Logger logger = LoggerFactory.getLogger(SearchingController.class);
	
	
	private SearchingDAO searchingDAO = new SearchingDAO();
	private static SearchingDTO searchingDTO = new SearchingDTO();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		logger.info("SearchingController");
		String pageName = "/search/main";

		String searchText = request.getParameter("searchText") != null ? request.getParameter("searchText") : "";
		String searchType = request.getParameter("searchType") != null ? request.getParameter("searchType") : "";
		searchingDTO.setSearchList(searchingDAO.searchingData(searchType, searchText));
		
		request.setAttribute("searchList", searchingDTO.getSearchList());
		return pageName;

	}
}