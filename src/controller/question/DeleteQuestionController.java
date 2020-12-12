package controller.question;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.Controller;
import model.service.MemberManager;

public class DeleteQuestionController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(DeleteQuestionController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
 
		int que_id = Integer.parseInt(request.getParameter("que_id"));
		String filename = request.getParameter("filename");
		String uploadFileName = request.getSession().getServletContext().getRealPath("/images") + "/" + filename;
		
		File uploadfile = new File (uploadFileName);
		if (uploadfile.exists()&& uploadfile.isFile()) {
			uploadfile.delete();
		}
		MemberManager manager = MemberManager.getInstance();
		manager.deleteQuestion(que_id);
		
		log.debug("Delete Question : {}");
		
		return "redirect:/question/list";			
    }
}