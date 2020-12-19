package action.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MatchingDAO;
import dao.MemberDAO;
import dao.ReviewDAO;
import vo.MatchingVO;
import vo.MemberVO;
import vo.ReviewVO;

// 리뷰 작성 페이지로 이동
@WebServlet("/review/form")
public class ReviewGotoFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		
		RequestDispatcher disp = request.getRequestDispatcher("/member/member_mypage.jsp");
		disp.forward(request, response);
	}
}