package controller.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.MemberSessionUtils;
import model.Question;
import model.service.QuestionManager;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CreateQuestionController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(CreateQuestionController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	request.setCharacterEncoding("UTF-8");
    	
    	MultipartRequest multi = null;
    	// 첨부파일 저장경로
    	//String savePath = request.getSession().getServletContext().getRealPath("upload");
    	String savePath = request.getRealPath("images");
    	// 첨부파일 용량 제한 10MB
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
    	// 비밀글 설정한 경우
    	if (multi.getParameter("secret") != null && multi.getParameter("secret").equals("y")) {
    		secret = "y";
    	}
    	
    	Question que = new Question(
    			0, MemberSessionUtils.getLoginMemberId(request.getSession()),
    			multi.getParameter("title"), multi.getParameter("content"),
    			null, 0, secret, filename);	
        
		try {
			QuestionManager manager = QuestionManager.getInstance();
			// 게시글 생성
			manager.createQuestion(que);
			
	    	log.debug("Create Question : {}", que);
	        return "redirect:/question/list";
	        
		} catch (Exception e) { // 게시글 생성에 실패한 경우 게시글 생성 jsp로 이동
            request.setAttribute("creationFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("que", que);
			return "/question/creationForm.jsp";
		}
    }
}