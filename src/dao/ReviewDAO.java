package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import action.review.ReviewViewAction;
import service.MyBatisConnector;
import vo.ReviewVO;

public class ReviewDAO {
	//--------------------------------------- 싱글톤패턴
	private static ReviewDAO single = null;
	public static ReviewDAO getInstance() {
		if(single == null)
			single = new ReviewDAO();
		return single;
	}
	// ----------------------------------
	SqlSessionFactory factory = null;

	public ReviewDAO() {
		// 객체 생성 시 커넥터에서 factory 전달 받음
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public List<ReviewVO> select(HashMap<String, String> map) {
		List<ReviewVO> list = null;

		SqlSession sqlSession = factory.openSession();

		list = sqlSession.selectList("review_list_page", map);
		sqlSession.close();

		return list;
	}

	public int insert(ReviewVO vo) {
		int res = 0;

		SqlSession sqlSession = factory.openSession();
		res = sqlSession.insert("review.review_insert", vo);

		sqlSession.commit();
		sqlSession.close();

		return res;
	}

	public ReviewVO selectOne(int r_idx) {
		ReviewVO vo = null;

		SqlSession sqlSesson = factory.openSession();
		vo = sqlSesson.selectOne("review.review_list_one", r_idx);

		sqlSesson.close();

		return vo;
	}

	public int delete(int r_idx) {
		int res = 0;

		SqlSession sqlSession=factory.openSession();
		res = sqlSession.delete("review.review_delete", r_idx);

		sqlSession.commit();
		sqlSession.close();

		return res;
	}

	public int selectCount() {
		SqlSession sqlSession = factory.openSession();

		int count = (int)sqlSession.selectOne("review_count");
		sqlSession.close();

		return count;
	}
} 