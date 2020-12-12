package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.question.*;
import controller.reply.*;
import controller.test.*;
import controller.lostpet.*;
import controller.search.*;
import controller.shelter.ShelterAPIController;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 각 uri에 대응되는 controller 객체를 생성 및 저장
        mappings.put("/", new ForwardController("/main/mainPage.jsp"));

        // question 관련 request URI 추가
        mappings.put("/question/create/form", new ForwardController("/question/creationForm.jsp"));
        mappings.put("/question/list", new ListQuestionController());
        mappings.put("/question/view", new ViewQuestionController());
        mappings.put("/question/create", new CreateQuestionController());
        mappings.put("/question/update", new UpdateQuestionController());
        mappings.put("/question/delete", new DeleteQuestionController());
        mappings.put("/question/search", new SearchQuestionController());
        mappings.put("/question/downloadfile", new DownloadFileController());
        // reply 관련 request URI 추가
        mappings.put("/reply/create", new CreateReplyController());
        mappings.put("/reply/delete", new DeleteReplyController());
        mappings.put("/reply/update", new UpdateReplyController());
        // 입양 테스트 관련 request URI 추가
        mappings.put("/test/type/form", new ForwardController("/test/typeForm.jsp"));
        mappings.put("/test/dog/form", new ForwardController("/test/dogForm.jsp"));
        mappings.put("/test/cat/form", new ForwardController("/test/catForm.jsp"));
        mappings.put("/test/score", new ScoreTestController());
        // 실종동물
        mappings.put("/lostpet/register/form", new ForwardController("/lostpet/lostpetRegisterForm.jsp"));
        mappings.put("/lostpet/register/complete", new ForwardController("/lostpet/registerCompelete.jsp"));
        mappings.put("/lostpet/list", new ListLostPetController());
        mappings.put("/lostpet/register", new RegisterLostPetController());
        
		// 검색
		mappings.put("/search/main", new ForwardController("/search/final_search.jsp"));
		mappings.put("/searching", new SearchingController());

		mappings.put("/search", new ForwardController("/search/final_detail.jsp"));
		mappings.put("/searching/result", new SearchingController());

		// sample
		mappings.put("/test/main", new MainController());
        
		// shelter
		mappings.put("/shelter/info", new ShelterAPIController());
		
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}
