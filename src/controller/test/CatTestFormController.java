package controller.test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.CatTest;
import model.dao.TestDAO;

public class CatTestFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		TestDAO dao = new TestDAO();
		List<CatTest> catTestList = dao.catTestList();
		request.setAttribute("catTestList", catTestList);
	
		return "/test/catForm.jsp";
	}
}