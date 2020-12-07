package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.search.*;

public class RequestMapping {
	private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

	private Map<String, Controller> mappings = new HashMap<String, Controller>();

	public void initMapping() {
		mappings.put("/main", new ForwardController("/search/final_search.jsp"));
		mappings.put("/searching", new SearchingController());
		
		mappings.put("/search", new ForwardController("/search/final_detail.jsp"));
		mappings.put("/searching/result", new SearchingController());

		mappings.put("/test/main", new MainController());

		logger.info("Initialized Request Mapping!");
	}

	public Controller findController(String uri) {
		return mappings.get(uri);
	}
}