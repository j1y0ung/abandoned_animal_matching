package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

// 회원 정보 업데이트
@WebServlet("/member/update")
public class MemberUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String updateCode = request.getParameter("updateCode");
		System.out.println("updateCode=" + updateCode);
		
		if (updateCode.equals("personal")) { // 개인회원이 회원정보 수정할 경우
			String mem_id = request.getParameter("mem_id");
			String mem_newPwd = request.getParameter("mem_newPwd");
			String mem_phone = request.getParameter("mem_phone");
			String mem_email = request.getParameter("mem_email");
			
			MemberVO vo = new MemberVO(mem_id, mem_newPwd, mem_phone, mem_email);
			MemberDAO.getInstance().update( vo );
			
			RequestDispatcher disp = request.getRequestDispatcher("/main/mainPage.jsp");
			disp.forward(request, response);
		}
		else if (updateCode.equals("manager")) { // 관리자가 회원목록에서 등급 수정할 경우
			String mem_id = request.getParameter("mem_id");
			String mem_membership = request.getParameter("mem_membership");
			
			MemberVO vo = new MemberVO(mem_id, mem_membership);
			int res = MemberDAO.getInstance().updateManager( vo ); //1이면 성공, 0이면 실패
			System.out.println("res: " + res);
			
			//json 반환
			String result = String.format("[{'res':'%d'},{'id':'%s'}]", res, mem_id);
			response.getWriter().println(result);
		}
	}
}
