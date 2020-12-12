package controller.question;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.Controller;
import model.service.MemberManager;
import model.Question;

public class UpdateQuestionController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateQuestionController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	MemberManager manager = MemberManager.getInstance();
    	int que_id = -1;
    	String secret = "n";
		if (request.getMethod().equals("GET")) {	
    		// GET request: Question form	
			que_id = Integer.parseInt(request.getParameter("que_id"));

	    	if (request.getParameter("secret") != null) {
	    		secret = "y";
	    	}
			Question que = manager.findQuestion(que_id);
			request.setAttribute("que", que);				
			return "/question/updateForm.jsp";
	    }	
    	
    	// POST request (Question parameter)
		request.setCharacterEncoding("UTF-8");
		String savePath = request.getRealPath("images");
		int sizeLimit = 10 * 1024 * 1024;
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
		}
		que_id = Integer.parseInt(multi.getParameter("que_id"));
		String ex_filename = multi.getParameter("ex_filename");

		Question que = null;
    	if (multi.getParameter("secret") != null) {
    		secret = "y";
    	}

    	String filename = multi.getFilesystemName("filename");
    	if (ex_filename == null || filename != null || multi.getParameter("deleteFile") != null) {
    		que = new Question(que_id, multi.getParameter("title"),
    				multi.getParameter("content"), secret,
    				filename);
    		if (multi.getParameter("deleteFile") != null) {
    			String uploadFileName = request.getSession().getServletContext().getRealPath("/images") + "/" + ex_filename;
    			File uploadfile = new File (uploadFileName);
    			if (uploadfile.exists()&& uploadfile.isFile()) {
    				uploadfile.delete();
    			}
    		}
    	} else {
    		que = new Question(que_id, multi.getParameter("title"),
    				multi.getParameter("content"), secret,
    				ex_filename);
    	}

    	manager.updateQuestion(que);
    	
		return "redirect:/question/list";
    }
}