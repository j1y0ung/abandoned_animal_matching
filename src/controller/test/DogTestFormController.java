package controller.test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.DogTest;
import model.dao.TestDAO;

public class DogTestFormController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		TestDAO dao = new TestDAO();
		List<DogTest> dogTestList = dao.dogTestList();
		request.setAttribute("dogTestList", dogTestList);
	
		return "/test/dogForm.jsp";
	}
}
