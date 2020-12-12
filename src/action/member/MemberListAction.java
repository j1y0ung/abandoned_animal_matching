package action.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

// 회원 목록 생성 작업 후 회원목록페이지로 이동
@WebServlet("/member/list")
public class MemberListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MemberVO> list = MemberDAO.getInstance().selectList();

		request.setAttribute("list", list);

		RequestDispatcher disp = request.getRequestDispatcher("/member/member_list.jsp");
		disp.forward(request, response);
	}
} 