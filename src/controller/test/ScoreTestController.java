package controller.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.member.MemberSessionUtils;
//import dao.MemberDAO;

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
		//Ã¤Á¡
		for (String answer : answers) {
			if (answer.equals("1")) {score = score + 5;}
		}
		
		String currentId = MemberSessionUtils.getLoginMemberId(request.getSession());
		
		
		if (score >= 90) {
			//MemberDAO.getInstance().upgradeMembership(currentId);
		}
		request.setAttribute("score", score);
		return "/test/result.jsp";
	}
}
