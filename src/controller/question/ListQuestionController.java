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
import model.service.MemberManager;

public class ListQuestionController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ListQuestionController.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String order = (request.getParameter("order") == null ? "orderOfId" : request.getParameter("order"));
    	String currentId = MemberSessionUtils.getLoginMemberId(request.getSession());
    	
    	MemberManager manager = MemberManager.getInstance();
    	
    	int listCnt = -1;
    	int curPage = (request.getParameter("curPage") == null ? 1 : Integer.parseInt(request.getParameter("curPage")));
		//최신순 -> orderOfDate, 댓글순 -> orderOfReply, 조회순->orderOfClick
    	
    	if (order.equals("my_question")) {
    		listCnt = manager.totalMyQuestion(currentId);
    	} else {
    		listCnt = manager.totalQuestion();
    	}
    	
    	Pagination pagination = new Pagination(listCnt, curPage);

    	int startIndex = pagination.getStartIndex();
    	int pageSize = pagination.getPageSize();
    	List<Question> queList = null;
    	
    	if (order.equals("orderOfId")) {
    		queList = manager.findQuestionList(startIndex, pageSize);
    	} else if (order.equals("orderOfDate") || order.equals("orderOfReply") || order.equals("orderOfClick")) {
    		queList = manager.sortQuestionListBy(order, startIndex, pageSize);
    	} else if (order.equals("my_question")) {
    		queList = manager.findMyQuestionList(currentId, startIndex, pageSize);
    	}

    	request.setAttribute("order", order);
		request.setAttribute("secretAlert", request.getAttribute("secretAlert"));
		// queList 객체를 request에 저장하여 큐앤에이 리스트 화면으로 이동(forwarding)
		request.setAttribute("queList", queList);
		request.setAttribute("listCnt", listCnt);
		request.setAttribute("pagination", pagination);
		return "/question/list.jsp";        
    }
}
