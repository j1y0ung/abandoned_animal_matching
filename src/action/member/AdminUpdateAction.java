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

// 보호소 관리자 관련 정보 수정 처리
@WebServlet("/admin/update")
public class AdminUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String updateCode = (String)request.getParameter("updateCode");
		String mem_id = request.getParameter("mem_id");
		int res = 0;
		
		if(updateCode == "1") { // 승인 거부
			String mem_careAdmin = "X";
				
			MemberVO vo = new MemberVO(mem_id, mem_careAdmin);
			res = MemberDAO.getInstance().updateCareAdmin( vo ); //1이면 성공, 0이면 실패
			System.out.println("res: " + res);
		}
		else { // 승인
			String mem_isAdmin = "y";
			String mem_membership = "보호소관리자";
			
			MemberVO vo = new MemberVO(mem_id, mem_isAdmin);
			res = MemberDAO.getInstance().updateIsAdmin( vo ); //1이면 성공, 0이면 실패
			vo = new MemberVO(mem_id, mem_membership);
			MemberDAO.getInstance().updateManager( vo ); //1이면 성공, 0이면 실패
			
			System.out.println("res: " + res);
		}
		//json 반환
		String result = String.format("[{'res':'%d'},{'id':'%s'}]", res, mem_id);
		response.getWriter().println(result);
	}
}
