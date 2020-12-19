package controller.question;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.Pagination;
import model.Question;
import model.service.QuestionManager;

public class ListQuestionController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ListQuestionController.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String order = (request.getParameter("order") == null ? "orderOfId" : request.getParameter("order"));
    	String currentId = MemberSessionUtils.getLoginMemberId(request.getSession());
    	
    	QuestionManager manager = QuestionManager.getInstance();
    	
    	int listCnt = -1;
    	// 페이징에 필요한 현재 페이지
    	int curPage = (request.getParameter("curPage") == null ? 1 : Integer.parseInt(request.getParameter("curPage")));
    	
    	// 내가(로그인한 유저) 쓴 글 보기의 경우 로그인한 유저가 쓴 게시글의 개수 구함, 전체 게시글 검색의 경우 전체 게시글의 개수 구함.
    	if (order.equals("my_question")) {
    		listCnt = manager.totalMyQuestion(currentId);
    	} else {
    		listCnt = manager.totalQuestion();
    	}
    	
    	Pagination pagination = new Pagination(listCnt, curPage);

    	int startIndex = pagination.getStartIndex();
    	int pageSize = pagination.getPageSize();
    	List<Question> queList = null;
    	
    	if (order.equals("orderOfId")) { // 게시글 que_id 기준 정렬
    		queList = manager.findQuestionList(startIndex, pageSize);
    	} 
    	// 최신순, 댓글순, 조회순 기준 정렬
    	else if (order.equals("orderOfDate") || order.equals("orderOfReply") || order.equals("orderOfClick")) {
    		queList = manager.sortQuestionListBy(order, startIndex, pageSize);
    	} 
    	// 내가(로그인한 유저) 쓴 글 보기의 경우
    	else if (order.equals("my_question")) {
    		queList = manager.findMyQuestionList(currentId, startIndex, pageSize);
    	}

    	// 정렬 기준
    	request.setAttribute("order", order);
    	// 비밀글 alert
		request.setAttribute("secretAlert", request.getAttribute("secretAlert"));

		request.setAttribute("queList", queList);
		request.setAttribute("listCnt", listCnt);
		request.setAttribute("pagination", pagination);
		return "/question/list.jsp";        
    }
}
