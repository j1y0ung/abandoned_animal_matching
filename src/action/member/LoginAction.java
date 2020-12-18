package action.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.member.MemberSessionUtils;
import dao.MemberDAO;
import vo.MemberVO;

@WebServlet("/member/login")
public class LoginAction extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberVO vo = MemberDAO.getInstance().selectId(id);
		
		String param 		= ""; // param의 값
		String resultStr 	= ""; // 전송될 json 문자열
		

		if( vo == null || vo.getMem_id().equals(id) == false ) {
			param = "no_id";
		}

		else if( vo.getMem_pwd().equals(pwd) == false ) {
			param = "no_pwd";
		}
		else {
			param = "clear";
			HttpSession session = request.getSession();

			session.setAttribute(MemberSessionUtils.MEMBER_SESSION_KEY, id);
			session.setAttribute("membership", vo.getMem_membership());
		}

		resultStr = String.format("[{'param':'%s'}]", param);
		response.setContentType("text/plain; charset=utf-8");
		response.getWriter().println( resultStr );
	}
}