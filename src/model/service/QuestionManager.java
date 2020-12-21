package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Question;
import model.Reply;
import model.dao.QuestionDAO;
import model.dao.ReplyDAO;

public class QuestionManager {
	private static QuestionManager queMan = new QuestionManager();
	private QuestionDAO queDAO;
	private ReplyDAO replyDAO;

	private QuestionManager() {
		try {
			queDAO = new QuestionDAO();
			replyDAO = new ReplyDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static QuestionManager getInstance() {
		return queMan;
	}
	
	public Question createQuestion(Question que) throws SQLException {
		return queDAO.create(que);
	}
	
	public Reply createReply(Reply reply) throws SQLException {
		return replyDAO.create(reply);		
	}
	
	public int updateQuestion(Question que) throws SQLException {
		return queDAO.update(que);				
	}
	
	public int updateReply(Reply reply) throws SQLException {
		return replyDAO.update(reply);				
	}
	
	public List<Question> findQuestionList(int startIndex, int pageSize) throws SQLException {
		return queDAO.findQuestionList(startIndex, pageSize);
	}
	public List<Question> sortQuestionListBy(String standard, int startIndex, int pageSize) throws SQLException {
		return queDAO.sortQuestionListBy(standard, startIndex, pageSize);
	}
	public List<Question> searchQuestion(String search, String categories, int startIndex, int pageSize) throws SQLException {
		return queDAO.searchQuestion(search, categories, startIndex, pageSize);
	}
	
	public List<Reply> findReplyList(int que_id) throws SQLException {
		return replyDAO.findReplyList(que_id);
	}
	
	public int addQuestionHits(int que_id) throws SQLException {
		return queDAO.addHits(que_id);
	}

	public Question findQuestion(int que_id) throws SQLException {
		return queDAO.findQuestion(que_id);
	}
	public List<Question> findMyQuestionList(String currentId, int startIndex, int pageSize) throws SQLException {
		return queDAO.findMyQuestionList(currentId, startIndex, pageSize);
	}

	public void deleteQuestion(int que_id) throws SQLException {
		queDAO.remove(que_id);
	}
	public void deleteFile(int que_id) throws SQLException {
		queDAO.deleteFile(que_id);
	}
	public void deleteReply(int re_id) throws SQLException {
		replyDAO.remove(re_id);
	}

	public int totalQuestion() throws SQLException {
		return queDAO.totalQuestion();
	}
	public int totalMyQuestion(String currentId) throws SQLException {
		return queDAO.totalMyQuestion(currentId);
	}
	public int totalSearchQuestion(String search, String categories) throws SQLException {
		return queDAO.totalSearchQuestion(search, categories);
	}
}