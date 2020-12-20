package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.MemberVO;

public class MemberDAO {
	//--------------------------------------- 싱글톤패턴
	static MemberDAO single = null;
	public static MemberDAO getInstance() {
		if(single==null) 
			single = new MemberDAO();
		return single;
	}
	//---------------------------------
	SqlSessionFactory factory = null;
	
	public MemberDAO() {
		//객체 생성 시 커넥터에서 factory 전달받음
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//회원 목록 조회용
	public List<MemberVO> selectList(){
		List<MemberVO> list = null;
		
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("member.member_list");
		
		sqlSession.close();
		return list;
	}
	
	//보호소 관리자 신청자 목록 조회용
	public List<MemberVO> selectAdmin(){
		List<MemberVO> list = null;
		
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("member.member_careAdmin");
		
		sqlSession.close();
		return list;
	}
	
	public int insert(MemberVO vo) {
		int res = 0;
		
		SqlSession sqlSession = factory.openSession();
		res = sqlSession.insert("member.member_insert", vo);
		
		//내용 변경 갱신하기
		sqlSession.commit();
		sqlSession.close();
		
		return res;
	}
	
	public int update(MemberVO vo) {
		int res = 0;
		
		SqlSession sqlSession = factory.openSession();
		res = sqlSession.update("member.member_update", vo);
		
		//내용 변경 갱신하기
		sqlSession.commit();
		sqlSession.close();
		
		return res;
	}
	
	public int updateManager(MemberVO vo) {
		int res = 0;
		
		SqlSession sqlSession = factory.openSession();
		res = sqlSession.update("member.member_update_manager", vo);
		
		//내용 변경 갱신하기
		sqlSession.commit();
		sqlSession.close();
		
		return res;
	}
	
	public int updateCareAdmin(MemberVO vo) {
		int res = 0;
		
		SqlSession sqlSession = factory.openSession();
		res = sqlSession.update("member.member_careadmin_update", vo);
		
		//내용 변경 갱신하기
		sqlSession.commit();
		sqlSession.close();
		
		return res;
	}
	
	public int updateIsAdmin(MemberVO vo) {
		int res = 0;
		
		SqlSession sqlSession = factory.openSession();
		res = sqlSession.update("member.member_isadmin_update", vo);
		
		//내용 변경 갱신하기
		sqlSession.commit();
		sqlSession.close();
		
		return res;
	}
	
	public MemberVO selectId( String mem_id ) {
		MemberVO vo = null;
		
		SqlSession sqlSession = factory.openSession();
		//selectList()와는 다르게 하나의 객체만을 반환받는 메서드
		vo = sqlSession.selectOne("member.member_one", mem_id);
		
		sqlSession.close();
		
		return vo;
	}
	
	public int delete(String mem_id) {
		int res = 0;
		
		SqlSession sqlSession = factory.openSession();
		res=sqlSession.delete("member.member_delete", mem_id);
		
		sqlSession.commit();
		sqlSession.close();
		
		return res;
	}
	
}