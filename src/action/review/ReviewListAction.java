package action.review;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.media.sound.SoftSynthesizer;

import dao.MemberDAO;
import dao.ReviewDAO;
import util.Paging;
import vo.MemberVO;
import vo.ReviewVO;

// 입양후기 리스트 생성 작업 후 입양후기 목록 페이지로 이동
@WebServlet("/review/list")
public class ReviewListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// 페이징 코드
		String page = request.getParameter("page");
		int currentPage = 1; // 현재 페이지 번호(없으면 기본 1페이지)
		if( page != null && page.equals("") == false ) {
			currentPage = Integer.parseInt(page);
		}
		int pageSize = 10; // 한 화면에 보여질 항목 수(임의로 10개)

		// 전체 항목의 개수 (DB에서 count(*)로 조회)
		int totalSize = ReviewDAO.getInstance().selectCount();

		// util 패키지에 Paging 클래스 생성
		Paging paging = new Paging( pageSize, totalSize, currentPage );
		// 생성자에서 3개의 값을 가지고 calc() 메서드를 수행하여 모든 멤버변수의 값이 만들어졌다.
//		System.out.println(paging);

		// startNo, endNo를 가지고 쿼리문을 수행해야 하는데, 파라미터가 여러개라서 HashMap 사용
		HashMap<String, String> map = new HashMap<>();
		map.put("startNo", paging.getStartNo() + ""); // int를 문자열로 만듦
		map.put("endNo", paging.getEndNo() + "");

		// 기존 select() 메서드가 아닌 map을 파라미터로 전달받는 메서드로 오버로딩
		List<ReviewVO> list = ReviewDAO.getInstance().select(map);
		// list에는 필요한 개수만큼의 목록이 만들어짐.

		// request에 paging 객체를 넣어두면
		// jsp에서 페이지의 정보를 알 수 있으니, 페이지관련 태그를 추가할 수 있다.
		request.setAttribute("paging", paging);
		request.setAttribute("list", list);
		
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		if (mem_id != null) {
			MemberVO vo = MemberDAO.getInstance().selectId(mem_id);
			session.setAttribute("membership", vo.getMem_membership());		
		} else {
			session.setAttribute("membership", "비회원");
		}

		RequestDispatcher disp = request.getRequestDispatcher("/review/review_list.jsp");
		disp.forward(request, response);
	}
}