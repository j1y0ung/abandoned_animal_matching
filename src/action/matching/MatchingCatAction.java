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

import vo.MatchingSelectVO;
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
      
      String lightColor[] = {"노르웨이숲", "렉돌", "먼치킨", "샴", "스코티시 폴드", "스핑크스", "아비시니안", "터키시 반", "터키시 앙고라", "페르시안", "페르시안 친칠라", "한국 고양이"};
      String darkColor[] = {"러시안 블루", "메인쿤", "믹스", "뱅갈", "브리티시 숏헤어", "사바나", "샴", "스코티시 폴드", "아메리칸 숏헤어", "아비시니안", "한국 고양이"};
      
      String longHair[] = {"노르웨이숲", "렉돌", "메인쿤", "스코티시 폴드", "터키시 앙고라", "터키시 반", "페르시안", "페르시안 친칠라"};
      String shortHair[] = {"러시안 블루", "먼치킨", "믹스", "뱅갈", "브리티시 숏헤어", "사바나", "샴", "스코티시 폴드", "스핑크스", "아메리칸 숏헤어", "아비시니안", "한국 고양이"};
      
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
      String url = apiUrl + "endde=" + currentTime + "&upkind=422400&state=protect&pageNo=1&numOfRows=1000&" + "neuter_yn=" + neuter;
      
      MatchingSelectVO matchingSelect = new MatchingSelectVO();
      matchingSelect.setSize(size);
      matchingSelect.setColor(color);
      matchingSelect.setSex(sex);
      
      //------------- 매칭 코드---------------
      if(hair.equals("l")) {
         System.out.println("장모종: ");
         for(int i = 0; i < 8; i++) {
            matchingSelect.getKind().add(longHair[i]);
            System.out.print(longHair[i] + "/");
         }
         System.out.println("추가됨");
         
         if(color.equals("l")) {
            System.out.println("밝은색 고양이: ");
            // 장모종 중 밝은색 고양이 삭제
            for(int i = 0; i < 11; i++) {
               if(matchingSelect.getKind().contains(darkColor[i])) {
                  System.out.println(darkColor[i] + "/");
                  matchingSelect.getKind().remove(darkColor[i]);
               }
            }
            System.out.println("삭제됨");
         }
         else if(color.equals("d")) {
            // 장모종 중 어두운색 고양이 삭제
            for(int i = 0; i < 12; i++) {
               if(matchingSelect.getKind().contains(lightColor[i])) {
                  System.out.println(lightColor[i] + "/");
                  matchingSelect.getKind().remove(lightColor[i]);
               }
            }
            System.out.println("삭제됨");
         }
      }
      else if(hair.equals("s")) {
         System.out.println("단모종: ");
         for(int i = 0; i < 12; i++) {
            matchingSelect.getKind().add(shortHair[i]);
            System.out.print(shortHair[i] + "/");
         }
         System.out.println("추가됨");
         
         if(color.equals("l")) {
            System.out.println("밝은 색 고양이: ");
            // 단모종 중 어두운 색 고양이 삭제
            for(int i = 0; i < 11; i++) {
               if(matchingSelect.getKind().contains(darkColor[i])) {
                  System.out.println(darkColor[i] + "/");
                  matchingSelect.getKind().remove(darkColor[i]);
               }
            }
            System.out.println("삭제됨");
         }
         else if(color.equals("d")) {
            System.out.println("어두운 색 고양이: ");
            // 단모종 중 밝은 색 고양이 삭제
            for(int i = 0; i < 12; i++) {
               if(matchingSelect.getKind().contains(lightColor[i])) {
                  System.out.println(lightColor[i] + "/");
                  matchingSelect.getKind().remove(lightColor[i]);
               }
            }
            System.out.println("삭제됨");
         }
      }
      System.out.println(matchingSelect.getKind()); // 매칭으로 걸러지고 남은 품종들 콘솔 출력
      
      HttpSession session = request.getSession();
      session.setAttribute("selected", matchingSelect);
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
//           printDomTree(document); // 파싱된 값 확인용
         } catch (Exception ex) {
             throw new ServletException("XML parsing error!");
         } finally {
//            content.close();
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
                     String rslt = text.substring(5, text.length());
                     if (rslt.contains("노르웨이"))
                        matching.setMat_kind("노르웨이 숲");
                     else if (rslt.contains("랙돌"))
                        matching.setMat_kind("렉돌");
                     else if (rslt.contains("스코티쉬"))
                        matching.setMat_kind("스코티시 폴드");
                     else if (rslt.contains("터키쉬 반"))
                        matching.setMat_kind("터키시 반");
                     else if (rslt.contains("터키쉬 앙고라"))
                        matching.setMat_kind("터키시 앙고라");
                     else if (rslt.contains("친칠라"))
                        matching.setMat_kind("페르시안 친칠라");
                     else if (rslt.contains("러시안"))
                        matching.setMat_kind("러시안 블루");
                     else if (rslt.contains("믹스"))
                        matching.setMat_kind("믹스묘");
                     else if (rslt.contains("브리티"))
                        matching.setMat_kind("브리티시 숏헤어");
                     else if (rslt.contains("아메리칸"))
                        matching.setMat_kind("아메리칸 숏헤어");
                     else
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