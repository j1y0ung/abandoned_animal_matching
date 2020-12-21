package model.dao;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ApiSearching {
	public static void main(String[] args) throws IOException {

		/* URL */
		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic");
		/* Service Key */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=v5zbvLrI3Tfuq95DRRnQMikWPq20Y2m8Fjc3w923vEP6WB8YoFWkPAOR9zcX5BoPhAA4mDHyZtK%2BGq7CT0P0wQ%3D%3D"
				+ "&bgnde=20140601&endde=20201130&pageNo=5&numOfRows=10");

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());

		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}

		StringBuilder sb = new StringBuilder();
		String line;

		while ((line = rd.readLine()) != null) {
			sb.append(line);
			System.out.println(line);
		}

		System.out.println("success call api!");
		rd.close();
		conn.disconnect();
	}

	public String connectApiURL(String urlString) throws IOException {

		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json; charset=UTF-8;");
		conn.setRequestProperty("Accept-Charset", "UTF-8");

		System.out.println("Response code: " + conn.getResponseCode());

		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
		}

		StringBuilder sb = new StringBuilder();
		String line;

		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}

		rd.close();
		conn.disconnect();
		return sb.toString();

	}

	public List<Map<String, String>> getSearchList(String noticeNo, String searchKeyword,
			String data, String processState, String noticeSdt) throws Exception {
		
		List<Map<String, String>> returnList = new ArrayList<>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		
		try {
			
			builder = factory.newDocumentBuilder();
			
			try {
				
				Document document = builder.parse(new ByteArrayInputStream(data.getBytes()));
				NodeList itemList = document.getElementsByTagName("item");
				
				List<String> fields = Arrays.asList(
						"age","careAddr","careNm","careTel","chargeNm","colorCd","desertionNo","filename","happenDt","happenPlace","kindCd","neuterYn","noticeEdt","noticeNo","noticeSdt","officetel","orgNm","popfile","processState","sexCd","specialMark","weight");

				for (int i = 0; i < itemList.getLength(); i++) {

					Map<String, String> map = new HashMap<String, String>();
					Node node = itemList.item(i);

					if (node.getNodeType() == Node.ELEMENT_NODE) {

						Element element = (Element) node;

						// set data
						for (String field : fields) {
							NodeList innerNodeList = element.getElementsByTagName(field);

							if (innerNodeList.getLength() == 0) {
								map.put(field, "");
								continue;
							}

							String value = innerNodeList.item(0).getTextContent();

							if (field == "sexCd") {
								switch (value) {
								case "M":
									map.put("sexCd", "남아");
									break;
								case "F":
									map.put("sexCd", "여아");
									break;
								default:
									map.put("sexCd", "미상");
									break;
								}
							} else if (field == "kindCd") {
								if (value.contains("개")) {
									map.put("kind", "DOG");
								} else if (value.contains("고양이")) {
									map.put("kind", "CAT");
								} else {
									map.put("kind", "OTHER");
								}
								map.put("kindCd", value);
							} else {
								map.put(field, value);
							}
						}

						boolean isAdd = false;

						// category 
						if ((map.get("noticeNo").indexOf(noticeNo) > -1 || noticeNo.equals("전국")) 
								&& map.get("processState").indexOf(processState) > -1) {
							isAdd = true;
						} else {
							isAdd = false;
						}


						if (isAdd) {
							isAdd = false;

							// search
							for (String field : fields) {
								if (map.get(field).indexOf(searchKeyword) > -1) {
									isAdd = true;
								}
							}

							if (isAdd) {
								returnList.add(map);
							}
						}
					}
				} // end for

				System.out.println(" returnlist size >>> " + returnList.size());

				// sort
				Collections.sort(returnList, (o1, o2) -> {
					if (noticeSdt.equals("DESC")) 
						return new BigDecimal(o2.get("noticeSdt")).compareTo(new BigDecimal(o1.get("noticeSdt")));
					else
						return new BigDecimal(o1.get("noticeSdt")).compareTo(new BigDecimal(o2.get("noticeSdt")));
			    });

			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return returnList;

	}

} 