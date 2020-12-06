package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Reply;

public class ReplyDAO {
	private JDBCUtil jdbcUtil = null;
	
	public ReplyDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
	/**
	 * Question 테이블에 새로운 행 생성 (PK 값은 Sequence를 이용하여 자동 생성)
	 */
	public Reply create(Reply reply) throws SQLException {
		String sql = "INSERT INTO Reply VALUES (re_id_seq.nextval, ?, ?, SYSDATE, ?, ?)";		
		Object[] param = new Object[] {reply.getQue_id(), reply.getWriter_id(), reply.getContent(),
										reply.getParent_re_id()};				
		jdbcUtil.setSqlAndParameters(sql, param);	
						
		String key[] = {"re_id"};// PK 컬럼의 이름     
		try {    
			jdbcUtil.executeUpdate(key); // insert 문 실행 
		   	ResultSet rs = jdbcUtil.getGeneratedKeys();
		   	if(rs.next()) {
		   		int generatedKey = rs.getInt(1);  // 생성된 PK 값 
		   		reply.setRe_id(generatedKey); 	// id필드에 저장
		   	}
		   	return reply;
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
	 * 기존의 reply 정보를 수정
	 */
	public int update(Reply reply) throws SQLException {
		String sql = "UPDATE Reply "
					+ "SET content=? "
					+ "WHERE re_id=?";
		Object[] param = new Object[] {reply.getContent(), reply.getRe_id()};				
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
	 * 주어진 ID에 해당하는 reply 정보를 삭제.+ 해당 re_id를 parent_re_id로 갖고 있는 대댓글도 삭제
	 */
	public void remove(int re_id) throws SQLException {
		String sql = "DELETE FROM Reply WHERE parent_re_id=?";
		String sql2 = "DELETE FROM Reply WHERE re_id=?";	

		try {			
			jdbcUtil.setSqlAndParameters(sql, new Object[] {re_id});	
			jdbcUtil.executeUpdate();
			jdbcUtil.setSqlAndParameters(sql2, new Object[] {re_id});	
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
	 * 해당 que_id의 게시글에 등록된 천번째 댓글들의 목록 정보를 검색하여 List에 저장 및 반환
	 */
	public List<Reply> findReplyList(int que_id) throws SQLException {
        String sql = "SELECT re_id, que_id, writer_id, reg_date, content, parent_re_id "
        		   + "FROM Reply "
        		   + "WHERE que_id = ? "
        		   + "ORDER BY re_id";   
        Object[] param = new Object[] {que_id};	
		jdbcUtil.setSqlAndParameters(sql, param);	
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();					
			List<Reply> replyList = new ArrayList<Reply>();
			while (rs.next()) {
				Reply reply = new Reply(
						rs.getInt("re_id"),
						rs.getInt("que_id"),
						rs.getString("writer_id"),
						rs.getDate("reg_date"),
						rs.getString("content"),
						rs.getInt("parent_re_id"));
				replyList.add(reply);
			}		
			return replyList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
}
