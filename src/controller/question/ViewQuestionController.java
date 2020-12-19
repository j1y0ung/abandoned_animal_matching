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
import model.service.QuestionManager;

public class ViewQuestionController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ViewQuestionController.class);
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// que_id, 작성자, 비밀글 여부
		int que_id = Integer.parseInt(request.getParameter("que_id"));
		String que_writer_id = request.getParameter("que_writer_id");
		String que_secret = request.getParameter("que_secret");
		String currentId = "";
		
		// 로그인했을 경우 currentId에 mem_id설정해주기
		if (MemberSessionUtils.hasLogined(request.getSession())) {
			currentId = MemberSessionUtils.getLoginMemberId(request.getSession());
		}
		// 비밀글인 경우 비밀글 경고
		if (que_secret != null && que_secret.equals("y")) {
			if (currentId == "" || !currentId.equals(que_writer_id) && !currentId.equals("admin")) {
				request.setAttribute("secretAlert", true);
				return "/question/list";
			}
		}
		
		Question que = null;
		
		QuestionManager manager = QuestionManager.getInstance();
		// 해당 게시글의 조회수 1 증가시키기
		manager.addQuestionHits(que_id);
		// 해당 que_id의 게시글 찾기 
		que = manager.findQuestion(que_id);
		request.setAttribute("que", que);
		
		// 해당 que_id 게시글의 답변 목록 찾기
		List<Reply> replyList = manager.findReplyList(que_id);

		request.setAttribute("replyList", replyList);				
		
		request.setAttribute("currentId", currentId);
		
		return "/question/view.jsp";
    }
}

