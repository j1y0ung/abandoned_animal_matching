package controller.question;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.Question;
import model.Reply;
import model.service.MemberManager;

public class ViewQuestionController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ViewQuestionController.class);
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int que_id = Integer.parseInt(request.getParameter("que_id"));
		String que_writer_id = request.getParameter("que_writer_id");
		String que_secret = request.getParameter("que_secret");
		String currentId = MemberSessionUtils.getLoginMemberId(request.getSession());
		
		if (que_secret != null && que_secret.equals("y")) {
			if (!currentId.equals(que_writer_id) && !currentId.equals("admin")) {
				request.setAttribute("secretAlert", true);
				return "/question/list";
			}
		}
		
		Question que = null;
		
		MemberManager manager = MemberManager.getInstance();
		manager.addQuestionHits(que_id);
		que = manager.findQuestion(que_id);		// Question 정보 검색
		request.setAttribute("que", que);	// Question 정보 저장
		
		List<Reply> replyList = manager.findReplyList(que_id);
		// replyList 객체를 request에 저장
		request.setAttribute("replyList", replyList);				
		
		// 현재 접속한 유저의 아이디-> 게시글 작성자 혹은 답변 작성자의 아이디가 같을 경우만 수정/삭제 가능하게
		request.setAttribute("currentId", currentId);
		
		return "/question/view.jsp";				// Question 보기 화면으로 이동
    }
}

