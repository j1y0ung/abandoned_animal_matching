package action.matching;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.MatchingDAO;
import vo.MatchingVO;

// 입양신청 리스트 생성 작업 후 입양신청 목록 페이지로 이동
@WebServlet("/matching/list")
public class MatchingListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String code = request.getParameter("code");
		String careName = request.getParameter("careName");
		System.out.println("careName" + careName);
		
		if(code == null) {
			List<MatchingVO> list = MatchingDAO.getInstance().selectList();
			request.setAttribute("list", list);
			
			RequestDispatcher disp = request.getRequestDispatcher("/matching/matching_list.jsp");
			disp.forward(request, response);
		}
		else {
			List<MatchingVO> list = MatchingDAO.getInstance().careAdminList(careName);
			request.setAttribute("list", list);
			
			RequestDispatcher disp = request.getRequestDispatcher("/matching/matching_adminlist.jsp");
			disp.forward(request, response);
			
		}
	}
}