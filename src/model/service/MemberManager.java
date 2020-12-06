package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Question;
import model.Reply;
import model.dao.QuestionDAO;
import model.dao.ReplyDAO;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * UserDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
 */
public class MemberManager {
	private static MemberManager memberMan = new MemberManager();
	private QuestionDAO queDAO;
	private ReplyDAO replyDAO;

	private MemberManager() {
		try {
			queDAO = new QuestionDAO();
			replyDAO = new ReplyDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static MemberManager getInstance() {
		return memberMan;
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
	// 게시글 + 댓글 같이 삭제
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