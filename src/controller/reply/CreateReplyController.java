package controller.reply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.Reply;
import model.service.QuestionManager;

public class CreateReplyController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(CreateReplyController.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 해당 게시글의 que_id
		int que_id = Integer.parseInt(request.getParameter("que_id"));
		// parent_re_id(부모 댓글)이 0이면 원댓글, 0이 아니면 보무 댓글의 대댓글
		int parent_re_id = Integer.parseInt(request.getParameter("parent_re_id"));
		
		Reply reply = new Reply(
				0, que_id, MemberSessionUtils.getLoginMemberId(request.getSession()),
				null, request.getParameter("content"), parent_re_id);
		
		QuestionManager manager = QuestionManager.getInstance();
		// 댓글 등록
		manager.createReply(reply);
			
		log.debug("Create Reply : {}", reply);
        return "/question/view";
	        
	}
}
