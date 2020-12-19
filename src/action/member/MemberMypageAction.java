package action.member;

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

// 해당 회원 아이디로 정보 가져와서 마이페이지로 이동
@WebServlet("/member/mypage")
public class MemberMypageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		
		MemberVO vo = MemberDAO.getInstance().selectId(mem_id);
		MatchingVO matvo = MatchingDAO.getInstance().selectOne(mem_id);
		request.setAttribute("vo", vo);
		request.setAttribute("matvo", matvo);
		
		RequestDispatcher disp = request.getRequestDispatcher("/member/member_mypage.jsp");
		disp.forward(request, response);
	}
}
