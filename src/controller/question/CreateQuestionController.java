package controller.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.Question;
import model.service.MemberManager;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CreateQuestionController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(CreateQuestionController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	request.setCharacterEncoding("UTF-8");
    	
    	MultipartRequest multi = null;
    	//String savePath = request.getSession().getServletContext().getRealPath("upload");
    	String savePath = request.getRealPath("images");
    	int sizeLimit = 10 * 1024 * 1024;
    	
    	try {
    		multi = new MultipartRequest (
    				request,
    				savePath,
    				sizeLimit,
    				"UTF-8",
    				new DefaultFileRenamePolicy());
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	String filename = multi.getFilesystemName("filename");
    	String secret = "n"; 
    	if (multi.getParameter("secret") != null && multi.getParameter("secret").equals("y")) {
    		secret = "y";
    	}
    	
    	Question que = new Question(
    			0, MemberSessionUtils.getLoginMemberId(request.getSession()),
    			multi.getParameter("title"), multi.getParameter("content"),
    			null, 0, secret, filename);	
        
		try {
			MemberManager manager = MemberManager.getInstance();
			manager.createQuestion(que);
			
	    	log.debug("Create Question : {}", que);
	        return "redirect:/question/list";	// 성공 시 커뮤니티 리스트 화면으로 redirect
	        
		} catch (Exception e) {		// 예외 발생 시 입력 form으로 forwarding
            request.setAttribute("creationFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("que", que);
			return "/question/creationForm.jsp";
		}
    }
}