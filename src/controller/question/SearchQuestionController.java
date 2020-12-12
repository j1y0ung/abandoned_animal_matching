package controller.question;

import java.util.List;
import controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pagination;
import model.Question;
import model.service.MemberManager;

public class SearchQuestionController implements Controller {
	
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	String search = request.getParameter("search");
    	String categories = request.getParameter("categories");
    	
    	MemberManager manager = MemberManager.getInstance();
    	
    	int listCnt = -1;
    	listCnt = manager.totalSearchQuestion(search, categories);
    	int curPage = (request.getParameter("curPage") == null ? 1 : Integer.parseInt(request.getParameter("curPage")));
    	Pagination pagination = new Pagination(listCnt, curPage);
    	int startIndex = pagination.getStartIndex();
    	int pageSize = pagination.getPageSize();
    	
    	List<Question> queList = manager.searchQuestion(search, categories, startIndex, pageSize);
    	
    	request.setAttribute("queList", queList);		
    	request.setAttribute("pagination", pagination);	
    	return "/question/list.jsp";    
    }

}
