package controller.shelter;

import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Shelter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.xmlpull.v1.XmlPullParser;
//import org.xmlpull.v1.XmlPullParserFactory;

import controller.Controller;

import java.io.BufferedReader;
//         수정중 !!
public class ShelterAPIController implements Controller {
	private static final Logger logger = LoggerFactory.getLogger(ShelterAPIController.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String careNm = request.getParameter("careNm");
    	String careAddr = request.getParameter("careAddr");
        StringBuilder urlBuilder = new StringBuilder("http://openapi.animal.go.kr/openapi/service/rest/animalShelterSrvc/shelterInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=HbM57h9b65o6N5ZgQKu0EQFN627NiWx6KrFAmK3diIrALrTzWqoJdH4243ZW%2Fw81P3CsfVwBvEbvohTeCT3jlw%3D%3D"); /*Service Key*/
        //urlBuilder.append("&" + URLEncoder.encode("care_reg_no","UTF-8") + "=" + URLEncoder.encode("326999201900001", "UTF-8")); /*보호센터등록번호*/
        urlBuilder.append("&" + URLEncoder.encode("care_nm","UTF-8") + "=" + URLEncoder.encode(careNm, "UTF-8")); /*동물보호센터명*/
        
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        String data="";
        String line;
        while ((line = rd.readLine()) != null) {
            data += line;
        }
        rd.close();
        conn.disconnect();
        
        String tagType = "";
//        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
//        XmlPullParser parser = factory.newPullParser();
//        Shelter st = null;
//        try {
//	        parser.setInput(new StringReader(data));
//	        int eventType = parser.getEventType();
//	        while (eventType != XmlPullParser.END_DOCUMENT) {
//	        	switch(eventType) {
//		        	case XmlPullParser.END_DOCUMENT:
//		        		break;
//		        	case XmlPullParser.START_DOCUMENT:
//		        		break;
//		        	case XmlPullParser.START_TAG:
//		        		String tag = parser.getName();
//		        		if (tag.equals("careAddr")) {
//		        			tagType = "careAddr";
//		        		} else if (tag.equals("careNm")) {
//		        			tagType = "careNm";
//		        		} else if (tag.equals("careTel")) {
//		        			tagType = "careTel";
//		        		} else if (tag.equals("closeDay")) {
//		        			tagType = "closeDay";
//		        		} else if (tag.equals("lat")) {
//		        			tagType = "lat";
//		        		} else if (tag.equals("lng")) {
//		        			tagType = "lng";
//		        		} else if (tag.equals("saveTrgtAnimal")) {
//		        			tagType = "saveTrgtAnimal";
//		        		} else if (tag.equals("vetPersonCnt")) {
//		        			tagType = "vetPersonCnt";
//		        		} else if (tag.equals("weekOprStime")) {
//		        			tagType = "weekOprStime";
//		        		} else if (tag.equals("weekOprEtime")) {
//		        			tagType = "weekOprEtime";
//		        		}
//		        		break;
//		        	case XmlPullParser.END_TAG:
//		        		break;
//		        	case XmlPullParser.TEXT:
//		        		switch (tagType) {
//		        			case "careAddr":
//		        				if (careAddr.equals(parser.getText())) {
//		        					st = new Shelter();
//		        					st.setCareAddr(parser.getText());
//		        				}
//		        				break;
//		        			case "careNm":
//		        				st.setCareNm(parser.getText());
//		        				break;
//		        			case "careTel":
//		        				st.setCareTel(parser.getText());
//		        				break;
//		        			case "closeDay":
//		        				st.setCloseDay(parser.getText());
//		        				break;
//		        			case "lat":
//		        				st.setLat(Double.parseDouble(parser.getText()));
//		        				break;
//		        			case "lng":
//		        				st.setLng(Double.parseDouble(parser.getText()));
//		        				break;
//		        			case "saveTrgtAnimal":
//		        				st.setSaveTrgtAnimal(parser.getText());
//		        				break;
//		        			case "vetPersonCnt":
//		        				st.setVetPersonCnt(Integer.parseInt(parser.getText()));
//		        				break;
//		        			case "weekOprStime":
//		        				st.setWeekOprStime(parser.getText());
//		        				break;
//		        			case "weekOprEtime":
//		        				st.setWeekOprEtime(parser.getText());
//		        				break;	
//		        		}
//		        	tagType = "";
//		        	break;
//	        	}
//	        	eventType = parser.next();
//	        }
//        } catch (Exception e) { e.printStackTrace(); }
//        if (st != null) {request.setAttribute("st", st);}
        return "/shelter/info.jsp";
    }
}