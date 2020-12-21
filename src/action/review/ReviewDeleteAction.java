  
package action.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDAO;

// 입양후기 삭제작업
@WebServlet("/review/delete")
public class ReviewDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String strIdx = request.getParameter("rev_idx");
		
		int rev_idx = Integer.parseInt(strIdx);
		
		//DAO에서 해당 idx의 행을 지우는 작업 완료 후 결과 값 받음
		int res = ReviewDAO.getInstance().delete(rev_idx); //1이면 성공, 0이면 실패
		
		//json 반환
		String result = String.format("[{'res':'%d'},{'rev_idx':'%d'}]", res, rev_idx);
		response.getWriter().println(result);
	}
}