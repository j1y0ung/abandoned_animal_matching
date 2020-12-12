package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 로그아웃 후 로그인페이지로 이동
@WebServlet("/member/logout")
public class LogoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().invalidate();

		RequestDispatcher disp = request.getRequestDispatcher("/member/member_login.jsp");
		disp.forward(request, response);
	}
}