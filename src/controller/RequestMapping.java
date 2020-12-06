package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.question.*;
import controller.reply.*;
import controller.test.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	
        // question - request URI
        mappings.put("/question/create/form", new ForwardController("/question/creationForm.jsp"));
        mappings.put("/question/list", new ListQuestionController());
        mappings.put("/question/view", new ViewQuestionController());
        mappings.put("/question/create", new CreateQuestionController());
        mappings.put("/question/update", new UpdateQuestionController());
        mappings.put("/question/delete", new DeleteQuestionController());
        mappings.put("/question/search", new SearchQuestionController());
        mappings.put("/question/downloadfile", new DownloadFileController());
        // reply - request URI
        mappings.put("/reply/create", new CreateReplyController());
        mappings.put("/reply/delete", new DeleteReplyController());
        mappings.put("/reply/update", new UpdateReplyController());
        // test - request URI
        mappings.put("/test/type/form", new ForwardController("/test/typeForm.jsp"));
        mappings.put("/test/dog/form", new ForwardController("/test/dogForm.jsp"));
        mappings.put("/test/cat/form", new ForwardController("/test/catForm.jsp"));
        mappings.put("/test/score", new ScoreTestController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
        return mappings.get(uri);
    }
}
