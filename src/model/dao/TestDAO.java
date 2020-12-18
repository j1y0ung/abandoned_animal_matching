package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.CatTest;
import model.DogTest;

public class TestDAO {
	private JDBCUtil jdbcUtil = null;
	
	public TestDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
	public List<DogTest> dogTestList() {

		List<DogTest> dogTestList = new ArrayList<DogTest>();
		String sql;
		try {
			sql = "SELECT dogQ, dogQ_1, dogQ_2, dogQ_3, dogQ_4, dogA " 
		+ "FROM (SELECT dogQ, dogQ_1, dogQ_2, dogQ_3, dogQ_4, dogA FROM dogtest ORDER BY dbms_random.random()) "
		+ "WHERE rownum <= 15";

			jdbcUtil.setSqlAndParameters(sql, null);

			ResultSet rs = jdbcUtil.executeQuery();

			while (rs.next()) {
				DogTest d = new DogTest(rs.getString("dogQ"), rs.getString("dogQ_1"), 
						rs.getString("dogQ_2"), rs.getString("dogQ_3"), rs.getString("dogQ_4"), rs.getString("dogA"));

				dogTestList.add(d);
			}
			return dogTestList;

		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}

		return null;

	}
	
	public List<CatTest> catTestList() {

		List<CatTest> catTestList = new ArrayList<CatTest>();
		String sql;
		try {
			sql = "SELECT catQ, catQ_1, catQ_2, catQ_3, catQ_4, catA " 
			+ "FROM (SELECT catQ, catQ_1, catQ_2, catQ_3, catQ_4, catA FROM cattest ORDER BY dbms_random.random()) "
			+ "WHERE rownum <= 15";

			jdbcUtil.setSqlAndParameters(sql, null);

			ResultSet rs = jdbcUtil.executeQuery();

			while (rs.next()) {
				CatTest c = new CatTest(rs.getString("catQ"), rs.getString("catQ_1"), 
						rs.getString("catQ_2"), rs.getString("catQ_3"), rs.getString("catQ_4"), rs.getString("catA"));

				catTestList.add(c);
			}
			
			return catTestList;

		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}

		return null;

	}
	
}
