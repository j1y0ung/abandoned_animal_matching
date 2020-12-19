package controller.reply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.QuestionManager;
import model.Reply;

public class UpdateReplyController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(UpdateReplyController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		int re_id = Integer.parseInt(request.getParameter("re_id"));
		
		Reply reply = new Reply(re_id, request.getParameter("content"));
		log.debug("Update Reply : {}", request.getParameter("content"));
		
		QuestionManager manager = QuestionManager.getInstance();
		// 댓글 수정
		manager.updateReply(reply);
		
		log.debug("Update Reply : {}", reply);
		
		return "/question/view";			
    }
}
