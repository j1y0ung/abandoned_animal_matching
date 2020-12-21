package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.CatTest;
import model.DogTest;
import service.MyBatisConnector;
import vo.TestVO;

public class TestDAO {
	//--------------------------------------- 싱글톤패턴
	static TestDAO single = null;
	public static TestDAO getInstance() {
		if(single==null) 
			single = new TestDAO();
		return single;
	}
	//---------------------------------
	SqlSessionFactory factory = null;
	
	public TestDAO() {
		//객체 생성 시 커넥터에서 factory 전달받음
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	public int insert(TestVO vo) {
		int res = 0;
		
		SqlSession sqlSession = factory.openSession();
		res = sqlSession.insert("test.test_insert", vo);
		
		//내용 변경 갱신하기
		sqlSession.commit();
		sqlSession.close();
		
		return res;
	}
	
	public TestVO selectId( String mem_id ) {
		TestVO vo = null;
		
		SqlSession sqlSession = factory.openSession();
		vo = sqlSession.selectOne("test.test_one", mem_id);
		
		sqlSession.close();
		
		return vo;
	}
	
	public int selectPassCat( String mem_id ) {
		String res = null;
		
		SqlSession sqlSession = factory.openSession();
		res = sqlSession.selectOne("test.test_selectPassCat", mem_id);
		
		sqlSession.close();
		if(res.equals("y")) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public int selectPassDog( String mem_id ) {
		String res = null;
		
		SqlSession sqlSession = factory.openSession();
		res = sqlSession.selectOne("test.test_selectPassDog", mem_id);
		
		sqlSession.close();
		if(res.equals("y")) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public int updatePassCat(TestVO vo) {
		int res = 0;
		
		SqlSession sqlSession = factory.openSession();
		res = sqlSession.update("test.test_update_passCat", vo);
		
		//내용 변경 갱신하기
		sqlSession.commit();
		sqlSession.close();
		
		return res;
	}
	
	public int updatePassDog(TestVO vo) {
		int res = 0;
		
		SqlSession sqlSession = factory.openSession();
		res = sqlSession.update("test.test_update_passDog", vo);
		
		//내용 변경 갱신하기
		sqlSession.commit();
		sqlSession.close();
		
		return res;
	}
	
	public int updateCatFail(TestVO vo) {
		int res = 0;
		
		SqlSession sqlSession = factory.openSession();
		res = sqlSession.update("test.test_update_catFail", vo);
		
		//내용 변경 갱신하기
		sqlSession.commit();
		sqlSession.close();
		
		return res;
	}
	
	public int updateDogFail(TestVO vo) {
		int res = 0;
		
		SqlSession sqlSession = factory.openSession();
		res = sqlSession.update("test.test_update_dogFail", vo);
		
		//내용 변경 갱신하기
		sqlSession.commit();
		sqlSession.close();
		
		return res;
	}
	
	// dogtest테이블에서 강아지 시험문제, 선지4개, 정답 합쳐서 총 15개 무작위로 반환
	public List<DogTest> dogTestList(){
		List<DogTest> list = null;
		
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("test.test_select_dogTestList");
		
		sqlSession.close();
		return list;
	}
	
	// cattest테이블에서 고양이 시험문제, 선지4개, 정답 합쳐서 총 15개 무작위로 반환
	public List<CatTest> catTestList(){
		List<CatTest> list = null;
		
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("test.test_select_catTestList");
		
		sqlSession.close();
		return list;
	}
}
