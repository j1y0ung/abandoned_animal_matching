package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.MatchingVO;
import vo.MemberVO;
import vo.ReviewVO;

// 수정중
public class MatchingDAO {
	//--------------------------------------- 싱글톤패턴
	static MatchingDAO single = null;
	public static MatchingDAO getInstance() {
		if(single==null) 
			single = new MatchingDAO();
		return single;
	}
	//---------------------------------
	SqlSessionFactory factory = null;
	
	public MatchingDAO() {
		//객체 생성 시 커넥터에서 factory 전달받음
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	// 목록 조회
	public List<MatchingVO> selectList(){
		List<MatchingVO> list = null;

		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("matching.matching_list");

		sqlSession.close();
		return list;
	}
	
	public List<MatchingVO> careAdminList(String careName){
		List<MatchingVO> list = null;
		
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("matching.matching_admin_list", careName);
		
		sqlSession.close();
		return list;
	}
	
	public MatchingVO selectOne(String mem_id) {
		MatchingVO vo = null;

		SqlSession sqlSesson = factory.openSession();
		vo = sqlSesson.selectOne("matching.matching_list_one", mem_id);

		sqlSesson.close();

		return vo;
	}
	
	public int insert(MatchingVO vo) {
		int res = 0;
		
		SqlSession sqlSession = factory.openSession();
		res = sqlSession.insert("matching.matching_insert", vo);
		
		// 내용 변경 갱신
		sqlSession.commit();
		sqlSession.close();
		
		return res;
	}
	
//	public MatchingVO selectId( String mem_id ) {
//		MatchingVO vo = null;
//		
//		SqlSession sqlSession = factory.openSession();
//		//selectList()와는 다르게 하나의 객체만을 반환받는 메서드
//		vo = sqlSession.selectOne("member_one", mem_id);
//		
//		sqlSession.close();
//		
//		return vo;
//	}
//	
	public int delete(MatchingVO vo) {
		int res = 0;
		
		SqlSession sqlSession = factory.openSession();
		res=sqlSession.delete("matching.matching_delete", vo);
		
		sqlSession.commit();
		sqlSession.close();
		
		return res;
	}
	
	public int update(MatchingVO vo) {
		int res = 0;
		
		SqlSession sqlSession = factory.openSession();
		res = sqlSession.update("matching.matching_update", vo);
		
		//내용 변경 갱신하기
		sqlSession.commit();
		sqlSession.close();
		
		return res;
	}
}
