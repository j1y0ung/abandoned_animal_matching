package action.matching;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MatchingDAO;
import vo.MatchingVO;

//입양신청(매칭테이블에 insert) 후 메인페이지로 이동
@WebServlet("/matching/insert")
public class MatchingInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String mat_id = request.getParameter("mat_id");
		String mat_kind = request.getParameter("mat_kind");
		String mat_sex = request.getParameter("mat_sex");
		String mat_age = request.getParameter("mat_age");
		String mat_color = request.getParameter("mat_color");
		String mat_size = request.getParameter("mat_size");
		String mat_detail = request.getParameter("mat_detail");
		String mat_img = request.getParameter("mat_img");
		String mat_careName = request.getParameter("mat_careName");
		String mat_careAddress = request.getParameter("mat_careAddress");
		String mat_tel = request.getParameter("mat_tel");

		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");

		System.out.println("파라미터값: " + mat_id + "/" + mat_kind +"/" + mat_sex +"/" + mat_age + "/" +mat_color + "/" +mat_size + "/" +mat_detail +
				"/" +mat_img + "/" +mat_careName +"/" + mat_careAddress +"/" + mat_tel + "/" + mem_id);

		MatchingVO vo = new MatchingVO(0, mat_id, mat_kind, mat_sex, mat_age, mat_color, mat_size, mat_detail,
								mat_img, mat_careName, mat_careAddress, mat_tel, mem_id);
		int res = MatchingDAO.getInstance().insert( vo ); // 1: 성공, 0: 실패
		System.out.println("res: " + res);
		session.setAttribute("matvo", vo);

//		response.sendRedirect("/main/mainPage.jsp");
		RequestDispatcher disp = request.getRequestDispatcher("/main/mainPage.jsp");
		disp.forward(request, response);
	}
} 