package controller.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.MemberSessionUtils;
import dao.MemberDAO;
import vo.MemberVO;

public class TestTypeController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(TestTypeController.class);
	
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		if (MemberSessionUtils.hasLogined(request.getSession())) {
			String currentId = MemberSessionUtils.getLoginMemberId(request.getSession());
			String membership = MemberSessionUtils.getMembership(request.getSession());
			MemberVO vo = MemberDAO.getInstance().selectId(currentId);
			
			Date catFailDate = vo.getMem_catFailDate();
			int catFailNum = vo.getMem_catFailNum();
			Date dogFailDate = vo.getMem_dogFailDate();
			int dogFailNum = vo.getMem_dogFailNum();
			String catTimeFinish = "n";
			String dogTimeFinish = "n";
			Date currentDate = new Date();
			
			if (catFailDate != null) {
				System.out.println(catFailDate);
				if (catFailNum == 1) { // 한 번 떨어지고 재응시의 경우
					if (currentDate.getDate() - catFailDate.getDate() >= 1) { // 첫 응시일로부터 24시간이 지났을 경우
						catTimeFinish = "y";
					}
				} else if (catFailNum > 1) { // n번째 재응시일 경우
					System.out.println(currentDate.getMonth() - catFailDate.getMonth());
					// 마지막 응시일 기준으로 2번째 재응시의 경우 -> 3개월 후, 3번째 재응시의 경우 -> 6개월 후, n번째 재응시의 경우 -> (n-1)*3 개월 후에 응시 가능
					if (currentDate.getMonth() - catFailDate.getMonth() >= (catFailNum-1)*3) {
						System.out.println(currentDate.getMonth() - catFailDate.getMonth());
						catTimeFinish = "y";
					}
				}
			}
			if (dogFailDate != null) {
				System.out.println(dogFailDate);
				if (dogFailNum == 1) { // 한 번 떨어지고 재응시의 경우
					if (currentDate.getDate() - dogFailDate.getDate() >= 1) { // 첫 응시일로부터 24시간이 지났을 경우
						dogTimeFinish = "y";
					}
				} else if (dogFailNum > 1) { // n번째 재응시일 경우
					System.out.println(currentDate.getMonth() - dogFailDate.getMonth());
					// 마지막 응시일 기준으로 2번째 재응시의 경우 -> 3개월 후, 3번째 재응시의 경우 -> 6개월 후, n번째 재응시의 경우 -> (n-1)*3 개월 후에 응시 가능
					if (currentDate.getMonth() - dogFailDate.getMonth() >= (dogFailNum-1)*3) {
						System.out.println(currentDate.getMonth() - dogFailDate.getMonth());
						dogTimeFinish = "y";
					}
				}
			}
			request.setAttribute("catFailNum", catFailNum);
			request.setAttribute("dogFailNum", dogFailNum);
			request.setAttribute("catTimeFinish", catTimeFinish);
			request.setAttribute("dogTimeFinish", dogTimeFinish);
			request.setAttribute("membership", membership);
			System.out.println("고양이시험 불합격 횟수: " + catFailNum);
			System.out.println("강아지시험 불합격 횟수: " + dogFailNum);

		} else {
			request.setAttribute("membership", "비회원");
		}
		
		return "/test/typeForm.jsp";
	}
}
