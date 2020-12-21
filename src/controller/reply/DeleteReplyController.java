package controller.reply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.Controller;
import model.service.QuestionManager;

public class DeleteReplyController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(DeleteReplyController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
 
		int re_id = Integer.parseInt(request.getParameter("re_id"));
		
		QuestionManager manager = QuestionManager.getInstance();
		// 댓글 삭제
		manager.deleteReply(re_id);
		
		log.debug("Delete Reply : {}");
		
		return "/question/view";			
    }
}