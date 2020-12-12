package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Question;

public class QuestionDAO {
	private JDBCUtil jdbcUtil = null;

	public QuestionDAO() {			
		jdbcUtil = new JDBCUtil();
	}

	/**
	 * Question 테이블에 새로운 행 생성 (PK 값은 Sequence를 이용하여 자동 생성)
	 */
	public Question create(Question que) throws SQLException {
		String sql = "INSERT INTO Question VALUES (que_id_seq.nextval, ?, ?, SYSDATE, 0, ?, ?, ?)";		
		Object[] param = new Object[] {que.getTitle(), que.getContent(), que.getWriter_id(), que.getSecret(), que.getFilename()};				
		jdbcUtil.setSqlAndParameters(sql, param);	

		String key[] = {"que_id"};// PK 컬럼의 이름     
		try {    
			jdbcUtil.executeUpdate(key); // insert 문 실행 
		   	ResultSet rs = jdbcUtil.getGeneratedKeys();
		   	if(rs.next()) {
		   		int generatedKey = rs.getInt(1);  // 생성된 PK 값 
		   		que.setId(generatedKey); 	// id필드에 저장
		   	}
		   	return que;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	
		}		
		return null;			
	}

	/**
	 * 기존의 질문 정보를 수정
	 */
	public int update(Question que) throws SQLException {
		String sql = "UPDATE Question "
					+ "SET title=?, content=?, secret=?, filename=? "
					+ "WHERE que_id=?";
		Object[] param = new Object[] {que.getTitle(), que.getContent(), que.getSecret(), que.getFilename(), que.getId()};				
		jdbcUtil.setSqlAndParameters(sql, param);
		try {				
			int result = jdbcUtil.executeUpdate();	
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	
		}		
		return 0;
	}

	/**
	 * 주어진 ID에 해당하는 질문 정보를 삭제
	 */
	public void remove(int que_id) throws SQLException {
		String sql = "DELETE FROM Reply WHERE que_id=?";	 
		String sql2 = "DELETE FROM Question WHERE que_id=?";	

		try {
			jdbcUtil.setSqlAndParameters(sql, new Object[] {que_id});
			jdbcUtil.executeUpdate();	
			jdbcUtil.setSqlAndParameters(sql2, new Object[] {que_id});
			jdbcUtil.executeUpdate();	

		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	
		}		
	}

	/**
	 * 주어진  ID에 해당하는 질문 정보를 데이터베이스에서 찾아 Question 도메인 클래스에 
	 * 저장하여 반환.
	 */
	public Question findQuestion(int que_id) throws SQLException {
        String sql = "SELECT title, content, dateTime, hits, writer_id, secret, filename "
        			+ "FROM Question "
        			+ "WHERE que_id=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {que_id});	
		Question que = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			if (rs.next()) {						
				que = new Question(		
					que_id,
					rs.getString("writer_id"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getDate("dateTime"),
					rs.getInt("hits"),
					rs.getString("secret"),
					rs.getString("filename"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		
		}
		return que;
	}

	/**
	 * 전체 질문 목록 정보를 검색하여 List에 저장 및 반환
	 */
	public List<Question> findQuestionList(int startIndex, int pageSize) throws SQLException {
        String sql = "SELECT * FROM ( "
        		   + "SELECT q.que_id, q.title, q.dateTime, q.hits, q.writer_id, q.secret, COUNT(r.que_id) AS total_reply, q.filename, ROW_NUMBER() OVER (ORDER BY q.que_id) NUM "
        		   + "FROM Question q LEFT OUTER JOIN Reply r ON q.que_id = r.que_id "
        		   + "GROUP BY q.que_id, q.title, q.datetime, q.hits, q.writer_id, q.secret, q.filename "
        		   + "ORDER BY q.que_id) "
        		   + "WHERE NUM BETWEEN ? AND ?";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {startIndex+1, startIndex+pageSize});

		try {
			ResultSet rs = jdbcUtil.executeQuery();					
			List<Question> queList = new ArrayList<Question>();
			while (rs.next()) {
				Question que = new Question(
						rs.getInt("que_id"),
						rs.getString("writer_id"),
						rs.getString("title"),
						rs.getDate("dateTime"),
						rs.getInt("hits"),
						rs.getInt("total_reply"),
						rs.getString("secret"),
						rs.getString("filename"));
				queList.add(que);
			}		
			return queList;					

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 주어진  검색어를 포함하는 질문 정보를 데이터베이스에서 찾아 Question 도메인 클래스에 
	 * 저장하여 반환.
	 */
	public List<Question> searchQuestion(String search, String categories, int startIndex, int pageSize) throws SQLException {
		String sql = "SELECT * FROM ( "
					+ "SELECT q.que_id, q.title, q.dateTime, q.hits, q.writer_id, q.secret, COUNT(r.que_id) AS total_reply, q.filename, ROW_NUMBER() OVER (ORDER BY q.que_id) NUM "
     		   		+ "FROM Question q LEFT OUTER JOIN Reply r ON q.que_id = r.que_id "
     		   		+ "WHERE q.title LIKE ? "
     		   		+ "GROUP BY q.que_id, q.title, q.datetime, q.hits, q.writer_id, q.secret, q.filename "
     		   		+ "ORDER BY q.que_id) "
     		   		+ "WHERE NUM BETWEEN ? AND ?";

		String sql2 = "SELECT * FROM ( "
				   + "SELECT q.que_id, q.title, q.dateTime, q.hits, q.writer_id, q.secret, COUNT(r.que_id) AS total_reply, q.filename, ROW_NUMBER() OVER (ORDER BY q.que_id) NUM "
	     		   + "FROM Question q LEFT OUTER JOIN Reply r ON q.que_id = r.que_id "
	     		   + "WHERE q.title LIKE ? OR q.content LIKE ? "
	     		   + "GROUP BY q.que_id, q.title, q.datetime, q.hits, q.writer_id, q.secret, q.filename "
	     		   + "ORDER BY q.que_id) "
				   + "WHERE NUM BETWEEN ? AND ?";


		if (categories.equals("1")) {
			jdbcUtil.setSqlAndParameters(sql, new Object[] {"%"+search+"%", startIndex+1, startIndex+pageSize});
		}
		else {
			jdbcUtil.setSqlAndParameters(sql2, new Object[] {"%"+search+"%", "%"+search+"%", startIndex+1, startIndex+pageSize});
		}	

		try {
			ResultSet rs = jdbcUtil.executeQuery();					
			List<Question> queList = new ArrayList<Question>();
			while (rs.next()) {
				Question que = new Question(
						rs.getInt("que_id"),
						rs.getString("writer_id"),
						rs.getString("title"),
						rs.getDate("dateTime"),
						rs.getInt("hits"),
						rs.getInt("total_reply"),
						rs.getString("secret"),
						rs.getString("filename"));
				queList.add(que);
			}		
			return queList;					

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	/**
	 * 조회수 증가.
	 */
	public int addHits(int que_id) throws SQLException {
		String sql = "UPDATE Question "
					+ "SET hits = hits + 1 "
					+ "WHERE que_id=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {que_id});	

		try {				
			int result = jdbcUtil.executeUpdate();	
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	
		}		
		return 0;
	}

	/**
	 * 특정 기준순으로 전체 질문 목록 정보를 검색하여 List에 저장 및 반환
	 */
	public List<Question> sortQuestionListBy(String standard, int startIndex, int pageSize) throws SQLException {
		String sql = "";

		if (standard.equals("orderOfDate")) {
			sql = "SELECT * FROM ( "
				+ "SELECT q.que_id, q.title, q.dateTime, q.hits, q.writer_id, q.secret, COUNT(r.que_id) AS total_reply, q.filename, ROW_NUMBER() OVER (ORDER BY q.dateTime DESC, q.que_id) NUM "
	     		+ "FROM Question q LEFT OUTER JOIN Reply r ON q.que_id = r.que_id "
	     		+ "GROUP BY q.que_id, q.title, q.datetime, q.hits, q.writer_id, q.secret, q.filename "
	     		+ "ORDER BY q.dateTime DESC, q.que_id) ";
		} else if (standard.equals("orderOfReply")) {
			sql = "SELECT * FROM ( "
				+ "SELECT q.que_id, q.title, q.dateTime, q.hits, q.writer_id, q.secret, COUNT(r.que_id) AS total_reply, q.filename, ROW_NUMBER() OVER (ORDER BY COUNT(r.que_id) DESC, q.que_id) NUM "
		    	+ "FROM Question q LEFT OUTER JOIN Reply r ON q.que_id = r.que_id "
		    	+ "GROUP BY q.que_id, q.title, q.datetime, q.hits, q.writer_id, q.secret, q.filename "
		     	+ "ORDER BY total_reply DESC, q.que_id) ";
		} else if (standard.equals("orderOfClick")) {
			sql = "SELECT * FROM ( "
				+ "SELECT q.que_id, q.title, q.dateTime, q.hits, q.writer_id, q.secret, COUNT(r.que_id) AS total_reply, q.filename, ROW_NUMBER() OVER (ORDER BY q.hits DESC, q.que_id) NUM "
			    + "FROM Question q LEFT OUTER JOIN Reply r ON q.que_id = r.que_id "
			    + "GROUP BY q.que_id, q.title, q.datetime, q.hits, q.writer_id, q.secret, q.filename "
			    + "ORDER BY q.hits DESC, q.que_id) ";
		}
		sql += "WHERE NUM BETWEEN ? AND ?";

		jdbcUtil.setSqlAndParameters(sql, new Object[] {startIndex+1, startIndex+pageSize});

		try {
			ResultSet rs = jdbcUtil.executeQuery();					
			List<Question> queList = new ArrayList<Question>();
			while (rs.next()) {
				Question que = new Question(
						rs.getInt("que_id"),
						rs.getString("writer_id"),
						rs.getString("title"),
						rs.getDate("dateTime"),
						rs.getInt("hits"),
						rs.getInt("total_reply"),
						rs.getString("secret"),
						rs.getString("filename"));
				queList.add(que);
			}		
			return queList;					

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	/**
	 * 현재 로그인한 사용자의 Question 리스트를 검색하여 List에 저장 및 반환
	 */
	public List<Question> findMyQuestionList(String currentId, int startIndex, int pageSize) throws SQLException {
        String sql = "SELECT * FROM ( "
        		   + "SELECT q.que_id, q.title, q.dateTime, q.hits, q.writer_id, q.secret, COUNT(r.que_id) AS total_reply, q.filename, ROW_NUMBER() OVER (ORDER BY q.que_id) NUM "
        		   + "FROM Question q LEFT OUTER JOIN Reply r ON q.que_id = r.que_id "
        		   + "WHERE q.writer_id = ? "
        		   + "GROUP BY q.que_id, q.title, q.datetime, q.hits, q.writer_id, q.secret, q.filename "
        		   + "ORDER BY q.que_id) "
        		   + "WHERE NUM BETWEEN ? AND ?";

        jdbcUtil.setSqlAndParameters(sql, new Object[] {currentId, startIndex+1, startIndex+pageSize});	

		try {
			ResultSet rs = jdbcUtil.executeQuery();					
			List<Question> queList = new ArrayList<Question>();
			while (rs.next()) {
				Question que = new Question(
						rs.getInt("que_id"),
						rs.getString("writer_id"),
						rs.getString("title"),
						rs.getDate("dateTime"),
						rs.getInt("hits"),
						rs.getInt("total_reply"),
						rs.getString("secret"),
						rs.getString("filename"));
				queList.add(que);
			}		
			return queList;					

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	/**
	 * 해당 Question의 첨부파일 삭제
	 */
	public void deleteFile(int que_id) throws SQLException {
		String sql = "UPDATE Question "
				+ "SET filename = null "
				+ "WHERE que_id=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {que_id});	

		try {				
			jdbcUtil.executeUpdate();	
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	
		}		
	}

	/**
	 * Question 테이블의 행의 개수 반환
	 */
	public int totalQuestion() throws SQLException {
        String sql = "SELECT COUNT(*) "
        			+ "FROM Question";
        jdbcUtil.setSqlAndParameters(sql, null);
        int sum = -1;
        try {
        	ResultSet rs = jdbcUtil.executeQuery();		
        	if (rs.next()) {
        		sum = rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		
		}
		return sum;
	}

	/**
	 * 특정 사용자가 쓴 게시글의 총 개수 반환
	 */
	public int totalMyQuestion(String currentId) throws SQLException {
        String sql = "SELECT COUNT(*) "
        			+ "FROM Question "
        			+ "WHERE writer_id = ?";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {currentId});
        int sum = -1;
        try {
        	ResultSet rs = jdbcUtil.executeQuery();		
        	if (rs.next()) {
        		sum = rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		
		}
		return sum;
	}

	/**
	 * 검색 결과 게시글의 총 개수 반환
	 */
	public int totalSearchQuestion(String search, String categories) throws SQLException {
        String sql = "SELECT COUNT(*) "
        			+ "FROM Question "
        			+ "WHERE title LIKE ?";
        String sql2 = "SELECT COUNT(*) "
    				+ "FROM Question "
    				+ "WHERE title LIKE ? OR content LIKE ?";
        if (categories.equals("1")) {
        	jdbcUtil.setSqlAndParameters(sql, new Object[] {"%"+search+"%"});
        } else {
        	jdbcUtil.setSqlAndParameters(sql2, new Object[] {"%"+search+"%", "%"+search+"%"});
        }
        int sum = -1;
        try {
        	ResultSet rs = jdbcUtil.executeQuery();		
        	if (rs.next()) {
        		sum = rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		
		}
		return sum;
	}
}