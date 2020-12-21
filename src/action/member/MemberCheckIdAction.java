package action.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

// 회원가입 중 아이디 중복체크 작업
@WebServlet("/member/checkId")
public class MemberCheckIdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		MemberVO vo = MemberDAO.getInstance().selectId(id); 
		String res = "no"; //회원가입 불가

		if(vo == null) { //null = 조회안됨
			res="yes"; //회원가입 가능
		}

		response.setContentType("text/plain;charset=utf-8"); 
		String resultStr = String.format("[{'result':'%s'},{'id':'%s'}]", res, id );
		response.getWriter().println(resultStr); //응답 페이지에 내용 쓰기
	}
}