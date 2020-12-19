package action.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

// 회원 추가 작업 - 파라미터 받아서 회원 리스트로 넘김
@WebServlet("/member/insert")
public class MemberInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String careAdmin = request.getParameter("careAdmin");
		
		if(careAdmin.equals("")) {
			careAdmin = "X";
			System.out.println("보호소관리자 아님: " + careAdmin);
			MemberVO vo = new MemberVO(0, name, id, pwd, phone, email, careAdmin);
			MemberDAO.getInstance().insert( vo );
		}
		else {
			System.out.println("보호소 관리자임: " + careAdmin);
			MemberVO vo = new MemberVO(0, name, id, pwd, phone, email, careAdmin);
			MemberDAO.getInstance().insert( vo );
		}


		response.sendRedirect("/member/member_login.jsp");
	}
} 