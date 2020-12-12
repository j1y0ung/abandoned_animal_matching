package controller.lostpet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.LostAnimal;
import model.dao.LostAnimalDAO;

public class ListLostPetController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub				

		LostAnimalDAO dao = LostAnimalDAO.getInstance();
		List<LostAnimal> lostPetList = dao.LostAnimalList();
		request.setAttribute("lostPetList", lostPetList);	
		
		return "/lostpet/lostpetList.jsp";        
	}
	

}
