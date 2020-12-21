package controller.test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.DogTest;
import dao.TestDAO;

public class DogTestFormController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		TestDAO dao = new TestDAO();
		// db에서 강아지 시험 문제 + 선택지 + 정답 랜덤으로 15개 가지고 옴.
		List<DogTest> dogTestList = dao.dogTestList();
		request.setAttribute("dogTestList", dogTestList);
	
		return "/test/dogForm.jsp";
	}
}
