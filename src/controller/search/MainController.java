package controller.search;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dao.ApiSearching;

public class MainController implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			String searchKeyword = request.getParameter("searchKeyword") == null ? "" : request.getParameter("searchKeyword");
			String noticeSdt = request.getParameter("noticeSdt") == null ? "DESC" : request.getParameter("noticeSdt");
			String processState = request.getParameter("processState") == null ? "보호중" : request.getParameter("processState");
			String noticeNo = request.getParameter("noticeNo") == null ? "전국" : request.getParameter("noticeNo");
			
			ApiSearching api = new ApiSearching();
			//String data = api.connectApiURL();
			
			
			  StringBuilder urlBuilder = new StringBuilder(
			  "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic"
			  );
			  
			  urlBuilder.append("?" + URLEncoder.encode("ServiceKey",
			  "UTF-8") +
			  "=v5zbvLrI3Tfuq95DRRnQMikWPq20Y2m8Fjc3w923vEP6WB8YoFWkPAOR9zcX5BoPhAA4mDHyZtK%2BGq7CT0P0wQ%3D%3D&numOfRows=50"
			  );
			
			String urlString = urlBuilder.toString();
			String data = api.connectApiURL(urlString);
			List<Map<String, String>> list = api.getSearchList(noticeNo, searchKeyword, data, processState, noticeSdt);
			
			System.out.println(" get list success!");
			
			request.setAttribute("list", list);
			request.setAttribute("searchKeyword", searchKeyword);
			
			return "/search/final_search.jsp";
	}
}
