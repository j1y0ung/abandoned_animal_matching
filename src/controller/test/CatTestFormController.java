package controller.test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.CatTest;
import dao.TestDAO;

public class CatTestFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		TestDAO dao = new TestDAO();
		// db에서 고양이 시험 문제 + 선택지 + 정답 랜덤으로 15개 가지고 옴.
		List<CatTest> catTestList = dao.catTestList();
		request.setAttribute("catTestList", catTestList);
	
		return "/test/catForm.jsp";
	}
}