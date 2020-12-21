package action.matching;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MatchingDAO;
import vo.MatchingVO;

// 입양 신청 상태 업데이트
@WebServlet("/matching/update")
public class MatchingUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("들어옴");
		String mat_id = request.getParameter("mat_id");
		String mem_id = request.getParameter("mem_id");

		MatchingVO vo = new MatchingVO(mat_id, mem_id);
		int res = MatchingDAO.getInstance().update( vo );
		
		//json 반환
		String result = String.format("[{'res':'%d'},{'id':'%s'}]", res, mem_id);
		response.getWriter().println(result);
	}
}
