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
		String currentId = "";
		
		if (MemberSessionUtils.hasLogined(request.getSession())) {
			currentId = MemberSessionUtils.getLoginMemberId(request.getSession());
		}
		if (que_secret != null && que_secret.equals("y")) {
			if (currentId == "" || !currentId.equals(que_writer_id) && !currentId.equals("admin")) {
				request.setAttribute("secretAlert", true);
				return "/question/list";
			}
		}
		
		Question que = null;
		
		MemberManager manager = MemberManager.getInstance();
		manager.addQuestionHits(que_id);
		que = manager.findQuestion(que_id);
		request.setAttribute("que", que);
		
		List<Reply> replyList = manager.findReplyList(que_id);

		request.setAttribute("replyList", replyList);				
		
		request.setAttribute("currentId", currentId);
		
		return "/question/view.jsp";
    }
}

