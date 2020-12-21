package action.matching;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import dao.MatchingDAO;
import vo.MatchingVO;

//고양이 매칭작업 후 매칭 결과 페이지로 이동
@WebServlet("/matching/cat")
@SuppressWarnings("serial")
public class MatchingCatAction extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private static final String apiUrl = "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?"
         + "serviceKey=ibs9iVONolT%2Fm5HR0KsxOs1MYb9VTfdRbweoFbPtO7J6%2FqaSsRE5Q7UltYPiHL45VsdtQo71O%2FUtTWdK4ZJnnA%3D%3D"
         + "&bgnde=20140601&";
   
   public MatchingCatAction() {
      super();
   }

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      
      String lightColor[] = {"노르웨이숲", "렉돌", "먼치킨", "샴", "스코티시", "스핑크스", "아비시니안", "터키시", "페르시안", "한국"};
      String darkColor[] = {"러시안", "메인쿤", "믹스", "뱅갈", "브리티시", "사바나", "샴", "스코티시", "아메리칸", "아비시니안", "한국"};
      
      String longHair[] = {"노르웨이숲", "렉돌", "메인쿤", "스코티시", "터키시", "페르시안"};
      String shortHair[] = {"러시안", "먼치킨", "믹스", "뱅갈", "브리티시", "사바나", "샴", "스코티시", "스핑크스", "아메리칸", "아비시니안", "한국"};
      
      String color = request.getParameter("color");
      String hair = request.getParameter("hair");
      String size = request.getParameter("size");
      String sex = request.getParameter("sex");
      String neuter = request.getParameter("neuter");
      System.out.println("선택한 값들: hair:" + hair + "/ size: " + size 
            + "/ color: " + color + "/ sex: " + sex + "/ neuter: " + neuter);
      
      SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd");
      String currentTime = dateFormat.format (System.currentTimeMillis());
//      System.out.println("현재시간: " + currentTime);
      
      // 파싱할 최종 url
      String url = apiUrl + "endde=" + currentTime + "&upkind=422400&state=protect&pageNo=1&numOfRows=5000&" + "neuter_yn=" + neuter;
      
      //------------- 품종 거르기 ---------------
      List selectkind = new ArrayList();
      if(hair.equals("l")) {
         System.out.println("장모종: ");
         for(int i = 0; i < 6; i++) {
        	 selectkind.add(longHair[i]);
            System.out.print(longHair[i] + "/");
         }
         System.out.println("추가됨");
         
         if(color.equals("l")) {
            System.out.println("밝은색 고양이: ");
            // 장모종 중 밝은색 고양이 삭제
            for(int i = 0; i < 10; i++) {
               if(selectkind.contains(darkColor[i])) {
                  System.out.println(darkColor[i] + "/");
                  selectkind.remove(darkColor[i]);
               }
            }
            System.out.println("삭제됨");
         }
         else if(color.equals("d")) {
            // 장모종 중 어두운색 고양이 삭제
            for(int i = 0; i < 11; i++) {
               if(selectkind.contains(lightColor[i])) {
                  System.out.println(lightColor[i] + "/");
                  selectkind.remove(lightColor[i]);
               }
            }
            System.out.println("삭제됨");
         }
      }
      else if(hair.equals("s")) {
         System.out.println("단모종: ");
         for(int i = 0; i < 12; i++) {
        	 selectkind.add(shortHair[i]);
            System.out.print(shortHair[i] + "/");
         }
         System.out.println("추가됨");
         
         if(color.equals("l")) {
            System.out.println("밝은 색 고양이: ");
            // 단모종 중 어두운 색 고양이 삭제
            for(int i = 0; i < 10; i++) {
               if(selectkind.contains(darkColor[i])) {
                  System.out.println(darkColor[i] + "/");
                  selectkind.remove(darkColor[i]);
               }
            }
            System.out.println("삭제됨");
         }
         else if(color.equals("d")) {
            System.out.println("어두운 색 고양이: ");
            // 단모종 중 밝은 색 고양이 삭제
            for(int i = 0; i < 11; i++) {
               if(selectkind.contains(lightColor[i])) {
                  System.out.println(lightColor[i] + "/");
                  selectkind.remove(lightColor[i]);
               }
            }
            System.out.println("삭제됨");
         }
      }
      System.out.println(selectkind); // 매칭으로 걸러지고 남은 품종들 콘솔 출력
      
      HttpSession session = request.getSession();
      // ------------------------------------------

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
           printDomTree(document); // 파싱된 값 확인용
         } catch (Exception ex) {
             throw new ServletException("XML parsing error!");
         } finally {
//            content.close();
         }            
     
         NodeList itemList = document.getElementsByTagName("item");
         List<MatchingVO> matchingList = new ArrayList<MatchingVO>(itemList.getLength());   
         
         int k = 0;
         for (int i = 0; i < itemList.getLength(); i++) {
            Element item = (Element)itemList.item(i);
            String age = null, careAddr = null, careNm = null, careTel = null, colorCd = null, desertionNo = null,
					kindCd = null, popfile = null, sexCd = null, specialMark = null, weight = null;
			String rslt_age = null, rslt_careAddr = null, rslt_careNm = null, rslt_careTel = null, rslt_colorCd = null, rslt_desertionNo = null,
					rslt_kindCd = null, rslt_popfile = null, rslt_sexCd = null, rslt_specialMark = null, rslt_weight = null;
            
            for (Node ch = item.getFirstChild(); ch != null; ch = ch.getNextSibling()) {
               String nodeName = ch.getNodeName();
               String text = ch.getTextContent();
               
               switch (nodeName) {
                  case "age": // 나이
                	  age = text;
//						System.out.println("age: " + age);
                     break;
                  case "careAddr": // 보호소 주소
                	  careAddr = text;
//						System.out.println("careAddr: " + careAddr);
                     break;
                  case "careNm": // 보호소명
                	  careNm = text;
//						System.out.println("careNm: " + careNm);
                     break;
                  case "careTel": // 보호소 전화번호
                	  careTel = text;
//						System.out.println("careTel: " + careTel);
                     break;
                  case "colorCd": // 색상
                	  colorCd = text;
                     break;
                  case "desertionNo": // 유기번호
                	  desertionNo = text;
//						System.out.println("desertionNo: " + desertionNo);
                     break;
                  case "kindCd": // 품종
                     String rslt = text.substring(5, text.length());
						for(int j = 0; j < selectkind.size(); j++) {
							if (rslt.contains(selectkind.get(j).toString())) {
								kindCd = text;
							}
						}
//						System.out.println("kindCd: " + kindCd);
//                     if (rslt.contains("노르웨이"))
//                        matching.setMat_kind("노르웨이 숲");
//                     else if (rslt.contains("랙돌"))
//                        matching.setMat_kind("렉돌");
//                     else if (rslt.contains("스코티쉬"))
//                        matching.setMat_kind("스코티시 폴드");
//                     else if (rslt.contains("터키쉬 반"))
//                        matching.setMat_kind("터키시 반");
//                     else if (rslt.contains("터키쉬 앙고라"))
//                        matching.setMat_kind("터키시 앙고라");
//                     else if (rslt.contains("친칠라"))
//                        matching.setMat_kind("페르시안 친칠라");
//                     else if (rslt.contains("러시안"))
//                        matching.setMat_kind("러시안 블루");
//                     else if (rslt.contains("믹스"))
//                        matching.setMat_kind("믹스묘");
//                     else if (rslt.contains("브리티"))
//                        matching.setMat_kind("브리티시 숏헤어");
//                     else if (rslt.contains("아메리칸"))
//                        matching.setMat_kind("아메리칸 숏헤어");
//                     else
//                        matching.setMat_kind(text);
                     break;
                  case "popfile": // 사진
                	  popfile = text;
//						System.out.println("popfile: " + popfile);
                     break;
                  case "sexCd": // 성별
                	  if (text.contains(sex)) {
							sexCd = text;
						}
//						System.out.println("sexCd: " + sexCd);
                     break;
                  case "specialMark": // 특이사항
                	  specialMark = text;
//						System.out.println("specialMark: " + specialMark);
                     break;
                  case "weight": // 몸무게
                	  String wei = text.substring(0, text.length()-4);
						wei = wei.replace(',', '.');
						String temp = wei.substring(wei.length()-1);
						if (temp.equals(".")) {
							wei = wei.substring(0, wei.length()-1);
						}
						double num;
						if (!wei.equals("")) {
							num = Double.parseDouble(wei);
							
							if (size.equals("s")) {
								if (num < 10.00) {
									weight = Double.toString(num);
								}
							}
							else if(size.equals("l")) {
								if (num >= 10.00) {
									weight = Double.toString(num);
								}
							}
						}
						else {
							if (size.equals("s")) {
								weight = "?";
							}
						}
//						System.out.println("weight: " + weight);
                     break;
               }            
            }         
            if (age != null && careAddr != null&& careNm != null&& careTel != null&& colorCd != null&& desertionNo != null&&
					kindCd != null&& popfile != null&& sexCd != null&& specialMark != null&& weight != null) {
				System.out.println("매칭됨##");
				rslt_age = age; rslt_careAddr = careAddr; rslt_careNm = careNm; rslt_careTel = careTel; rslt_colorCd = colorCd; rslt_desertionNo = desertionNo;
						rslt_kindCd = kindCd; rslt_popfile = popfile; rslt_sexCd = sexCd; rslt_specialMark = specialMark; rslt_weight = weight;
				System.out.println("매칭된값: k:" + k + "/ desertionNo: " + rslt_desertionNo + "/ kindCd: " + rslt_kindCd +
						"/ sexCd: " + rslt_sexCd + "/ age: " + rslt_age + "/ colorCd: " + rslt_colorCd + "/ weight: " + rslt_weight+ "/ specialMark: " + rslt_specialMark
						+ "/ popfile: " + rslt_popfile+ "/ careNm: " + rslt_careNm+ "/ careAddr: " + rslt_careAddr+ "/ careTel: " + rslt_careTel + "\n");
				MatchingVO matching = new MatchingVO(k++, desertionNo, kindCd, sexCd, age, colorCd, weight, specialMark, popfile, careNm, careAddr, careTel);
				matchingList.add(matching);
			}
         }
			String mem_id = (String) session.getAttribute("mem_id");
			String exist = "n";
			MatchingVO mvo = MatchingDAO.getInstance().selectOne(mem_id);
			if (mvo != null) {
				exist = "y";
			}
			
		 // 기존에 입양신청 내역있는지 체크 -> 있을 경우 신청 불가
	      request.setAttribute("exist", exist);
         // matchingList의 참조를 result.jsp로 전달
          request.setAttribute("matchingList", matchingList);   
//          System.out.println("matchingList: " + matchingList);
          request.getRequestDispatcher("/matching/matching_result_cat.jsp").forward(request, response);
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