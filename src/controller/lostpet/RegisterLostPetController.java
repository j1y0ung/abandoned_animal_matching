package controller.lostpet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.LostAnimal;
import model.dao.LostAnimalDAO;

public class RegisterLostPetController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterLostPetController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	LostAnimal lostPet = new LostAnimal(
		request.getParameter("animalType"),
		request.getParameter("ownerName"),
		request.getParameter("ownerPhone"),
		request.getParameter("animalSpecies"),
		Integer.parseInt(request.getParameter("animalAge")),
		request.getParameter("animalGender"),
		request.getParameter("region"));
		
        log.debug("Create LostPet : {}", lostPet);
		try {
			LostAnimalDAO dao = LostAnimalDAO.getInstance();
			dao.createNewLostAnimal(lostPet.getAnimalType(), lostPet.getOwnerName(), lostPet.getOwnerPhone(),
					lostPet.getAnimalSpecies(), lostPet.getAnimalAge(), lostPet.getAnimalGender(), lostPet.getRegion());
			return "/lostpet/registerCompelete.jsp";
	        
		} catch (Exception e) {
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("lostPet", lostPet);
			return "/lostpet/lostpetRegisterForm.jsp";
		}
    }
}