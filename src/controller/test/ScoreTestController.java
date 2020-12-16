package controller.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.MemberSessionUtils;
import dao.MemberDAO;
import vo.MemberVO;

public class ScoreTestController implements Controller {
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] answers = {request.getParameter("test1"), request.getParameter("test2"), request.getParameter("test3"),
				request.getParameter("test4"), request.getParameter("test5"), request.getParameter("test6"),
				request.getParameter("test7"), request.getParameter("test8"), request.getParameter("test9"),
				request.getParameter("test10"), request.getParameter("test11"), request.getParameter("test12"),
				request.getParameter("test13"), request.getParameter("test14"), request.getParameter("test15"),
				request.getParameter("test16"), request.getParameter("test17"), request.getParameter("test18"),
				request.getParameter("test19"), request.getParameter("test20")};
		
		int score = 0;	
		//ä��
		for (String answer : answers) {
			if (answer != null && answer.equals("1")) {score = score + 5;}
		}
		String currentId = MemberSessionUtils.getLoginMemberId(request.getSession());
		
		//----------시험 통과자 회원등급 변경하는 부분-----------
		String passTest = request.getParameter("testKind"); // 통과한 시험 종류
		String updateMembership = null;
		int checkCat = MemberDAO.getInstance().selectPassCat(currentId);
		int checkDog = MemberDAO.getInstance().selectPassDog(currentId);
		System.out.println("현재 통과한 시험 종류: " + passTest);
		System.out.println("고양이 시험: " + checkCat + "/ 강아지 시험: " + checkDog);
		System.out.println("내 시험점수: " + score);
		MemberVO vo;
		
		if (score >= 90) {
			System.out.println("90점 이상");
			if(passTest.equals("cat")) { // 고양이 시험 통과자
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
		}
		vo = new MemberVO(currentId, updateMembership);
		int res = MemberDAO.getInstance().updateManager( vo ); //1이면 성공, 0이면 실패
		System.out.println("res = " + res);
		//-------------------------------------------------------------
		
		request.setAttribute("score", score);
		return "/test/result.jsp";
	}
}
