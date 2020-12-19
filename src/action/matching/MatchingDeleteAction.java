package action.matching;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MatchingDAO;
import vo.MatchingVO;

// 입양 신청내역 삭제 작업
@WebServlet("/matching/delete")
public class MatchingDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String mem_id = request.getParameter("mem_id");
		String mat_id = request.getParameter("mat_id");
		MatchingVO vo = new MatchingVO(mat_id, mem_id);
		int res = MatchingDAO.getInstance().delete(vo); //1이면 성공, 0이면 실패
		System.out.println("res: " + res);

		//json 반환
		String result = String.format("[{'res':'%d'},{'id':'%s'}]", res, mem_id);
		response.getWriter().println(result);
	}
}