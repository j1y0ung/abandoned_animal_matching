package action.matching;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.*;
import org.w3c.dom.*;
import org.w3c.dom.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.servlet.http.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import vo.MatchingSelectVO;
import vo.MatchingVO;

// 강아지 매칭작업 후 매칭 결과 페이지로 이동
@WebServlet("/matching/dog")
@SuppressWarnings("serial")
public class MatchingDogAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String apiUrl = "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?"
			+ "serviceKey=ibs9iVONolT%2Fm5HR0KsxOs1MYb9VTfdRbweoFbPtO7J6%2FqaSsRE5Q7UltYPiHL45VsdtQo71O%2FUtTWdK4ZJnnA%3D%3D"
			+ "&bgnde=20140601&";
	
	public MatchingDogAction() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String hairLess[] = {"믹스견", "푸들", "비숑 프리제", "말티즈", "이탈리안 그레이 하운드", "요크셔 테리어", "시츄", "슈나우져"};
		String hairMany[] = {"포메라니안", "믹스견", "스피츠", "리트리버", "사모예드", "치와와", "코카 스파니엘", "닥스훈트"};
		String smallHouse[] = {"포메라니안", "푸들", "비숑 프리제", "말티즈", "요크셔 테리어", "시츄", "치와와", "닥스훈트", "스피츠", "슈나우져"};
		String largeHouse[] = {"리트리버", "사모예드", "코카 스파니엘", "이탈리안 그레이 하운드"};
		String highIntelli[] = {"푸들", "리트리버", "슈나우져", "코카 스파니엘", "포메라니안"};
		String lowIntelli[] = {"비숑 프리제", "말티즈", "이탈리안 그레이 하운드", "요크셔 테리어", "시츄", "믹스견", "스피츠", "치와와", "닥스훈트", "사모예드"};
		
		String hair = request.getParameter("hair");
		String size = request.getParameter("size");
		String environment = request.getParameter("environment");
		String intelligence = request.getParameter("intelligence");
		String color = request.getParameter("color");
		String sex = request.getParameter("sex");
		String neuter = request.getParameter("neuter");
		System.out.println("선택한 값들: hair:" + hair + "/ size: " + size + "/ environment: " + environment +
						"/ intelligence: " + intelligence + "/ color: " + color + "/ sex: " + sex + "/ neuter: " + neuter);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd");
		String currentTime = dateFormat.format (System.currentTimeMillis());
//		System.out.println("현재시간: " + currentTime);
		
		// 파싱할 최종 url
		String url = apiUrl + "endde=" + currentTime + "&upkind=417000&state=protect&pageNo=1&numOfRows=1000&" + "neuter_yn=" + neuter;
		
		MatchingSelectVO matchingSelect = new MatchingSelectVO();
		matchingSelect.setSize(size);
		matchingSelect.setColor(color);
		matchingSelect.setSex(sex);
		
		//------------- 매칭 코드---------------
		if(hair.equals("l")) {
			System.out.println("털빠짐 적음 리스트: ");
			for(int i = 0; i < 7; i++) {
				matchingSelect.getKind().add(hairLess[i]);
				System.out.print(hairLess[i] + "/");
			}
			System.out.println("추가됨");
			
			if(environment.equals("s")) {
				System.out.println("주거환경 좁음");
				// 털빠짐 적은 견종 중에서 넓은집에서 사는 종 삭제
				for(int i = 0; i < 4; i++) {
					if(matchingSelect.getKind().contains(largeHouse[i])) {
						System.out.println(largeHouse[i] + "/");
						matchingSelect.getKind().remove(largeHouse[i]);
					}
				}
				System.out.println("삭제됨");
				
				if(intelligence.equals("l")) {
					System.out.println("지능 낮음");
					// 털빠짐 적고 좁은집에서 사는 종 중에서 지능 높은 종 삭제
					for(int i = 0; i < 5; i++) {
						if(matchingSelect.getKind().contains(highIntelli[i])) {
							System.out.println(highIntelli[i] + "/");
							matchingSelect.getKind().remove(highIntelli[i]);
						}
					}
					System.out.println("삭제됨");
				}
				else if(intelligence.equals("h")) {
					System.out.println("지능 높음");
					// 털빠짐 적고 좁은집에서 사는 종 중에서 지능 낮은 종 삭제
					for(int i = 0; i < 10; i++) {
						if(matchingSelect.getKind().contains(lowIntelli[i])) {
							System.out.println(lowIntelli[i] + "/");
							matchingSelect.getKind().remove(lowIntelli[i]);
						}
					}
					System.out.println("삭제됨");
				}
			}
			else if(environment.equals("l")) {
				System.out.println("주거환경 넓음"); // 걸러낼 필요 없음
				
				if(intelligence.equals("l")) {
					System.out.println("지능 낮음");
					// 털빠짐 적고 넓은집에서 사는 종 중에서 지능 높은 종 삭제
					for(int i = 0; i < 5; i++) {
						if(matchingSelect.getKind().contains(highIntelli[i])) {
							System.out.println(highIntelli[i] + "/");
							matchingSelect.getKind().remove(highIntelli[i]);
						}
					}
					System.out.println("삭제됨");
				}
				else if(intelligence.equals("h")) {
					System.out.println("지능 높음");
					// 털빠짐 적고 넓은집에서 사는 종 중에서 지능 낮은 종 삭제
					for(int i = 0; i < 10; i++) {
						if(matchingSelect.getKind().contains(lowIntelli[i])) {
							System.out.println(lowIntelli[i] + "/");
							matchingSelect.getKind().remove(lowIntelli[i]);
						}
					}
					System.out.println("삭제됨");
				}
			}
		}
		else if(hair.equals("m")) {
			System.out.println("털빠짐 많음 리스트: ");
			for(int i = 0; i < 8; i++) {
				matchingSelect.getKind().add(hairMany[i]);
				System.out.print(hairMany[i] + "/");
			}
			System.out.println("추가됨");
			
			if(environment.equals("s")) {
				System.out.println("주거환경 좁음");
				// 털빠짐 많은 견종 중에서 넓은집에서 사는 종 삭제
				for(int i = 0; i < 4; i++) {
					if(matchingSelect.getKind().contains(largeHouse[i])) {
						matchingSelect.getKind().remove(largeHouse[i]);
						System.out.print(largeHouse[i] + "/");
					}
				}
				System.out.println("삭제됨");
				
				if(intelligence.equals("l")) {
					System.out.println("지능 낮음");
					// 털빠짐 많고 좁은집에서 사는 종 중에서 지능 높은 종 삭제
					for(int i = 0; i < 5; i++) {
						if(matchingSelect.getKind().contains(highIntelli[i])) {
							matchingSelect.getKind().remove(highIntelli[i]);
							System.out.print(highIntelli[i] + "/");
						}
					}
					System.out.println("삭제됨");
				}
				else if(intelligence.equals("h")) {
					System.out.println("지능 높음");
					// 털빠짐 많고 좁은집에서 사는 종 중에서 지능 낮은 종 삭제
					for(int i = 0; i < 10; i++) {
						if(matchingSelect.getKind().contains(lowIntelli[i])) {
							matchingSelect.getKind().remove(lowIntelli[i]);
							System.out.print(lowIntelli[i] + "/");
						}
					}
					System.out.println("삭제됨");
				}
			}
			else if(environment.equals("l")) {
				System.out.println("주거환경 넓음"); // 걸러낼 필요 없음
				
				if(intelligence.equals("l")) {
					System.out.println("지능 낮음");
					// 털빠짐 많고 넓은집에서 사는 종 중에서 지능 높은 종 삭제
					for(int i = 0; i < 5; i++) {
						if(matchingSelect.getKind().contains(highIntelli[i])) {
							matchingSelect.getKind().remove(highIntelli[i]);
							System.out.print(highIntelli[i] + "/");
						}
					}
					System.out.println("삭제됨");
				}
				else if(intelligence.equals("h")) {
					System.out.println("지능 높음");
					// 털빠짐 많고 넓은집에서 사는 종 중에서 지능 낮은 종 삭제
					for(int i = 0; i < 10; i++) {
						if(matchingSelect.getKind().contains(lowIntelli[i])) {
							matchingSelect.getKind().remove(lowIntelli[i]);
							System.out.print(lowIntelli[i] + "/");
						}
					}
					System.out.println("삭제됨");
				}
			}
		}
		System.out.println(matchingSelect.getKind()); // 매칭으로 걸러지고 남은 품종들 콘솔 출력
		
		HttpSession session = request.getSession();
		session.setAttribute("selected", matchingSelect);
		//------------------------------------------
		
		Document document = null;
		
		HttpClient httpClient = HttpClients.createDefault();
        HttpGet getRequest = new HttpGet(url);
        HttpResponse resp = httpClient.execute(getRequest);
        System.out.println("----------------------------------------");
        System.out.println(resp.getStatusLine());
        System.out.println("----------------------------------------");
		HttpEntity entity = resp.getEntity();
		
        if (entity != null) {
            InputStream content = entity.getContent();
            try {
            	// DOM parsing 수행
            	System.out.println("***** Parsed by DOM *****");
            	
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        		factory.setIgnoringElementContentWhitespace(true);		
        		
        		DocumentBuilder builder = factory.newDocumentBuilder();
        		document = builder.parse(content);
        		
        		System.out.println("Response Message Body:");
//        		printDomTree(document); // 파싱된 값 확인용
            } catch (Exception ex) {
                throw new ServletException("XML parsing error!");
            } finally {
//            	content.close();
            }            
        
			NodeList itemList = document.getElementsByTagName("item");
			List<MatchingVO> matchingList = new ArrayList<MatchingVO>(itemList.getLength());	
			
			for (int i = 0; i < itemList.getLength(); i++) {
				Element item = (Element)itemList.item(i);
				MatchingVO matching = new MatchingVO(i+1);
				
				for (Node ch = item.getFirstChild(); ch != null; ch = ch.getNextSibling()) {
					String nodeName = ch.getNodeName();
					String text = ch.getTextContent();
					
					switch (nodeName) {
						case "age": // 나이
							matching.setMat_age(text);
							break;
						case "careAddr": // 보호소 주소
							matching.setMat_careAddress(text);
							break;
						case "careNm": // 보호소명
							matching.setMat_careName(text);
							break;
						case "careTel": // 보호소 전화번호
							matching.setMat_tel(text);
							break;
						case "colorCd": // 색상
							matching.setMat_color(text);
							break;
						case "desertionNo": // 유기번호
							matching.setMat_id(text);
							break;
						case "kindCd": // 품종
							String rslt = text.substring(4, text.length());
							matching.setMat_kind(text);
							break;
						case "popfile": // 사진
							matching.setMat_img(text);
							break;
						case "sexCd": // 성별
							matching.setMat_sex(text);
							break;
						case "specialMark": // 특이사항
							matching.setMat_detail(text);
							break;
						case "weight": // 몸무게
							matching.setMat_size(text);
							break;
					}				
				}			
				matchingList.add(matching);
			}
			
			// matchingList의 참조를 result.jsp로 전달
	 		request.setAttribute("matchingList", matchingList);	
//	 		System.out.println("matchingList: " + matchingList);
	 		request.getRequestDispatcher("/matching/matching_result.jsp").forward(request, response);
        } 
	}
	
	public void printDomTree(Document doc) throws Exception {
		// 변환기 생성
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();

		// 출력 포맷 설정: XML 선언과 문서 유형 선언 내용 설정하기 
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "");

		// DOMSource 객체 생성
		DOMSource source = new DOMSource(doc);

		// StreamResult 객체 생성
		StreamResult result =  new StreamResult(System.out);

		transformer.transform(source, result);
	}	
}