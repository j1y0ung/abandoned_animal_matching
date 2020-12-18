package controller.test;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.member.MemberSessionUtils;
import dao.MemberDAO;
import vo.MemberVO;

public class ScoreTestController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] mentalAnswers = {request.getParameter("test1"), request.getParameter("test2"), request.getParameter("test3"),
				request.getParameter("test4"), request.getParameter("test5")};
		
		String[] randomQAnswers = {request.getParameter("test6_@i"), request.getParameter("test7_@i"), request.getParameter("test8_@i"), request.getParameter("test9_@i"),
				request.getParameter("test10_@i"), request.getParameter("test11_@i"), request.getParameter("test12_@i"), request.getParameter("test13_@i"), request.getParameter("test14_@i"),
				request.getParameter("test15_@i"), request.getParameter("test16_@i"), request.getParameter("test17_@i"), request.getParameter("test18_@i"),
				request.getParameter("test19_@i"), request.getParameter("test20_@i")};
		
		String[] rightAnswers = {request.getParameter("answer6_@i"), request.getParameter("answer7_@i"), request.getParameter("answer8_@i"), request.getParameter("answer9_@i"),
				request.getParameter("answer10_@i"), request.getParameter("answer11_@i"), request.getParameter("answer12_@i"), request.getParameter("answer13_@i"), request.getParameter("answer14_@i"),
				request.getParameter("answer15_@i"), request.getParameter("answer16_@i"), request.getParameter("answer17_@i"), request.getParameter("answer18_@i"),
				request.getParameter("answer19_@i"), request.getParameter("answer20_@i")};

		int score = 0;	
		
		for (String answer : mentalAnswers) {
			if (answer != null && answer.equals("1")) {score = score + 5;}
		}
		
		for (int i = 0; i < 15; i++) {
			if (randomQAnswers[i] != null && randomQAnswers[i].equals(rightAnswers[i])) {
				score = score + 5;
			}
		}
		String currentId = MemberSessionUtils.getLoginMemberId(request.getSession());
		
		//----------시험 통과자 회원등급 변경하는 부분-----------
		String testType = request.getParameter("testKind"); // 통과한 시험 종류
		String updateMembership = null;
		int checkCat = MemberDAO.getInstance().selectPassCat(currentId);
		int checkDog = MemberDAO.getInstance().selectPassDog(currentId);
		System.out.println("현재 응시한 시험 종류: " + testType);
		System.out.println("고양이 시험: " + checkCat + "/ 강아지 시험: " + checkDog);
		System.out.println("내 시험점수: " + score);
		MemberVO vo;
		
		if (score >= 90) {
			System.out.println("90점 이상");
			if(testType.equals("cat")) { // 고양이 시험 통과자
				if(checkDog == 1) {
					updateMembership = "댕냥마스터";
				}
				else {
					updateMembership = "예비집사";
				}
				vo = new MemberVO(currentId, "y");
				MemberDAO.getInstance().updatePassCat( vo );
			}
			else { // 강아지 시험 통과자
				if(checkCat == 1) {
					updateMembership = "댕냥마스터";
				}
				else {
					updateMembership = "예비견주";
				}
				vo = new MemberVO(currentId, "y");
				MemberDAO.getInstance().updatePassDog( vo );
			}
			vo = new MemberVO(currentId, updateMembership);
			int res = MemberDAO.getInstance().updateManager( vo ); //1이면 성공, 0이면 실패
			HttpSession session = request.getSession();
			if (res == 1) {session.setAttribute("membership", updateMembership);}
			System.out.println("res = " + res);
			//-------------------------------------------------------------
		} else { // 시험 불합격했을 경우
			System.out.println("90점 미만 불합격");
			Date time = new Date();
			vo = new MemberVO(currentId, time);
			System.out.println(currentId + "\n" + time);
			if(testType.equals("cat")) { // 고양이 시험 불합격자
				MemberDAO.getInstance().updateCatFail( vo );
			}
			else { // 강아지 시험 불합격자
				MemberDAO.getInstance().updateDogFail( vo );
			}
		}
		request.setAttribute("score", score);
		return "/test/result.jsp";
	}
}
