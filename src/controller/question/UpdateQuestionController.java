package controller.question;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.Controller;
import model.service.QuestionManager;
import model.Question;

public class UpdateQuestionController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateQuestionController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	QuestionManager manager = QuestionManager.getInstance();
    	int que_id = -1;
    	String secret = "n";
		if (request.getMethod().equals("GET")) {	
    		// GET request: Question form	
			que_id = Integer.parseInt(request.getParameter("que_id"));

			//비밀글 설정
	    	if (request.getParameter("secret") != null) {
	    		secret = "y";
	    	}
	    	// 해당 que_id 기준으로 게시글 찾기
			Question que = manager.findQuestion(que_id);
			request.setAttribute("que", que);				
			return "/question/updateForm.jsp";
	    }	
    	
    	// POST request (Question parameter)
		request.setCharacterEncoding("UTF-8");
		// 첨부파일 저장경로
		String savePath = request.getRealPath("images");
		int sizeLimit = 10 * 1024 * 1024;
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
		}
		que_id = Integer.parseInt(multi.getParameter("que_id"));
		// 기존 첨부파일이름
		String ex_filename = multi.getParameter("ex_filename");

		Question que = null;
		// 비밀글 설정
    	if (multi.getParameter("secret") != null) {
    		secret = "y";
    	}

    	// 수정 게시글 폼에 등록된 첨부파일 이름
    	String filename = multi.getFilesystemName("filename");
    	// 기존 첨부파일이 존재하지 않거나 수정하는 게시글 폼에 첨부파일이 등록되지 않았거나 기존 첨부파일을 삭제하는 경우
    	if (ex_filename == null || filename != null || multi.getParameter("deleteFile") != null) {
    		que = new Question(que_id, multi.getParameter("title"),
    				multi.getParameter("content"), secret,
    				filename);
    		// 기존 첨부파일을 삭제하는 경우
    		if (multi.getParameter("deleteFile") != null) {
    			String uploadFileName = request.getSession().getServletContext().getRealPath("/images") + "/" + ex_filename;
    			File uploadfile = new File (uploadFileName);
    			if (uploadfile.exists()&& uploadfile.isFile()) {
    				uploadfile.delete();
    			}
    		}
    	} else { // 기존 첨부파일 그대로 유지
    		que = new Question(que_id, multi.getParameter("title"),
    				multi.getParameter("content"), secret,
    				ex_filename);
    	}
    	// 게시글 업데이트
    	manager.updateQuestion(que);
    	
		return "redirect:/question/list";
    }
}