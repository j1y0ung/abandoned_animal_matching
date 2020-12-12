package action.review;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ReviewDAO;
import vo.ReviewVO;

// 입양후기 추가작업 후 입양후기 목록 페이지로 이동
@WebServlet("/review/insert")
public class ReviewInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String path = request.getServletContext().getRealPath("/images/");
		System.out.println(path);

		int max_size = 1024*1024*100; 

		MultipartRequest mr = new MultipartRequest(	request, 
													path, // 업로드 위치
													max_size, // 최대 업로드 용량
													"utf-8", // 수신 인코딩
													new DefaultFileRenamePolicy());
		String rev_img = "no_file";

		File f = mr.getFile("rev_img"); // <input type="file" name="r_img">
		if(f != null) {
			rev_img = f.getName(); // 실제로 업로드된 파일명
		}

		// 파일 외의 파라미터 획득 (request 에선 찾을수 없음)
		String rev_title = mr.getParameter("rev_title");
		String rev_content = mr.getParameter("rev_content");

		System.out.println(rev_title);
		System.out.println(rev_content);

		ReviewVO vo = new ReviewVO();

		vo.setRev_title(rev_title);
		vo.setRev_content(rev_content);
		vo.setRev_img(rev_img);

		// DB에 insert
		int res = ReviewDAO.getInstance().insert(vo);
		System.out.println("결과값 : " + res);

		response.sendRedirect("/review/list");
	}
} 