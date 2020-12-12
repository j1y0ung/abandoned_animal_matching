package controller.reply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.Reply;
import model.service.MemberManager;

public class CreateReplyController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(CreateReplyController.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int que_id = Integer.parseInt(request.getParameter("que_id"));
		int parent_re_id = Integer.parseInt(request.getParameter("parent_re_id"));
		
		Reply reply = new Reply(
				0, que_id, MemberSessionUtils.getLoginMemberId(request.getSession()),
				null, request.getParameter("content"), parent_re_id);
		
		MemberManager manager = MemberManager.getInstance();
		manager.createReply(reply);
			
		log.debug("Create Reply : {}", reply);
        return "/question/view";
	        
	}
}
