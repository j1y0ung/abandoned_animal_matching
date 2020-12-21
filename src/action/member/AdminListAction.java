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

// 보호소 관리자 신청자 목록 생성 작업
@WebServlet("/admin/list")
public class AdminListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MemberVO> list = MemberDAO.getInstance().selectAdmin();
		request.setAttribute("list", list);

		RequestDispatcher disp = request.getRequestDispatcher("/member/member_adminlist.jsp");
		disp.forward(request, response);
	}
} 