package action.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDAO;
import vo.ReviewVO;

// 선택된 입양후기 정보 가져와서 입양후기 상세 페이지로 이동
@WebServlet("/review/view")
public class ReviewViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int rev_idx = Integer.parseInt(request.getParameter("rev_idx"));
		System.out.println(rev_idx);
		
		ReviewVO vo = ReviewDAO.getInstance().selectOne(rev_idx);
		request.setAttribute("vo", vo);
		
		RequestDispatcher disp = request.getRequestDispatcher("/review/review_view.jsp");
		disp.forward(request, response);
	}
}