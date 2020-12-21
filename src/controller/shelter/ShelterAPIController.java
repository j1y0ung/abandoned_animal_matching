package controller.shelter;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Shelter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class ShelterAPIController implements Controller {
	private static final Logger logger = LoggerFactory.getLogger(ShelterAPIController.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String careNm = request.getParameter("careNm");
    	String careAddr = request.getParameter("careAddr");

    	// 동물보호센터 정보 조회서비스 API 에서 보호소 정보 가지고 옴.
    	StringBuilder urlBuilder = new StringBuilder("http://openapi.animal.go.kr/openapi/service/rest/animalShelterSrvc/shelterInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=HbM57h9b65o6N5ZgQKu0EQFN627NiWx6KrFAmK3diIrALrTzWqoJdH4243ZW%2Fw81P3CsfVwBvEbvohTeCT3jlw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("care_nm","UTF-8") + "=" + URLEncoder.encode(careNm, "UTF-8")); /*동물보호센터명*/
        try {
	        String url = urlBuilder.toString();
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(url);
	        
	        doc.getDocumentElement().normalize();
	        System.out.println("Root Element : "+ doc.getDocumentElement().getNodeName());
	        
	        Shelter st = null;
	        NodeList nodeList = doc.getElementsByTagName("item");
	        for(int temp =0; temp<nodeList.getLength(); temp++) {
	        	Node nNode = nodeList.item(temp);
	        	 if(nNode.getNodeType()==Node.ELEMENT_NODE) {
	        		 Element element = (Element) nNode;
	        		 if (!getTagValue("careAddr", element).equals(careAddr)) {
	        			 continue;
	        		 }
	        		 st = new Shelter();
	        		 st.setCareNm(careNm);
	        		 st.setCareAddr(careAddr);
	        		 if (getTagValue("saveTrgtAnimal", element) != null) {
	        			 st.setSaveTrgtAnimal(getTagValue("saveTrgtAnimal", element));
	        		 }
	        		 if (getTagValue("lat", element) != null) {
	        			 st.setLat(Double.valueOf(getTagValue("lat", element)));
	        		 }
	        		 if (getTagValue("lng", element) != null) {
	        			 st.setLng(Double.valueOf(getTagValue("lng", element)));
	        		 }
	        		 if (getTagValue("weekOprStime", element) != null) {
	        			 st.setWeekOprStime(getTagValue("weekOprStime", element));
	        		 }
	        		 if (getTagValue("weekOprEtime", element) != null) {
	        			 st.setWeekOprEtime(getTagValue("weekOprEtime", element));
	        		 }
	        		 if (getTagValue("weekendOprStime", element) != null) {
	        			 st.setWeekendOprStime(getTagValue("weekendOprStime", element));
	        		 }
	        		 if (getTagValue("weekendOprEtime", element) != null) {
	        			 st.setWeekendOprEtime(getTagValue("weekendOprEtime", element));
	        		 }
	        		 if (getTagValue("closeDay", element) != null) {
	        			 st.setCloseDay(getTagValue("closeDay", element));
	        		 }
	        		 if (getTagValue("vetPersonCnt", element) != null) {
	        			 st.setVetPersonCnt(Integer.parseInt(getTagValue("vetPersonCnt", element)));
	        		 }
	        		 if (getTagValue("careTel", element) != null) {
	        			 st.setCareTel(getTagValue("careTel", element));
	        		 }
	        	 }
	        }
	        System.out.println(st);
	        request.setAttribute("st", st);
        }
        catch (Exception e) {
        	e.printStackTrace();
	    }
        return "/shelter/shelter_info.jsp";
	}
	private static String getTagValue(String tag, Element ele) {
		try {
			NodeList nodeList = ele.getElementsByTagName(tag).item(0).getChildNodes();
			Node nValue = (Node) nodeList.item(0);
			if(nValue == null) {
				return null;
			}
			return nValue.getNodeValue();
		} catch (Exception e) {return null;}
	}
}