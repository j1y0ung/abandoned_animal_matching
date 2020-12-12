package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Search;
import model.SearchingDTO;

public class SearchingDAO {

	private static JDBCUtil jdbcUtil = null;
	private static SearchingDTO dto = new SearchingDTO();

	public SearchingDAO() {
		jdbcUtil = new JDBCUtil();
	}

	public static List<Search> searchingData(String searchType, String searchText) {

		List<Search> searchList = new ArrayList<Search>();
		String sql = "";
		try {
			if (searchText.equals("")) {
				sql = "SELECT * FROM SEARCH";
				jdbcUtil.setSqlAndParameters(sql, new Object[] {});
			} else {
				sql = "SELECT keyword, region, state " + "FROM Search ";
				sql += "WHERE " + searchType + " like '%' ||  ?   || '%'";
				jdbcUtil.setSqlAndParameters(sql, new Object[] { searchText });
			}

			ResultSet rs = jdbcUtil.executeQuery();

			while (rs.next()) {
				Search s = new Search();

				s.setKeyword(rs.getString("keyword"));
				s.setRegion(rs.getString("region"));
				s.setState(rs.getString("state"));

				searchList.add(s);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}

		return searchList;

	}

	public static List<Search> searchingResultBykeyword(String keyword) {

		System.out.println(" SearchingDAO . searchingResultBykeyword " + keyword);
		String sql = "SELECT keyword, region, state " + "FROM Search " + "WHERE keyword like '%' ||  ?   || '%'";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { keyword });

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Search> searchList = new ArrayList<Search>();

			while (rs.next()) {
				Search s = new Search();

				s.setKeyword(rs.getString("keyword"));
				s.setRegion(rs.getString("region"));
				s.setState(rs.getString("state"));

				searchList.add(s);
			}
			return searchList;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public static Search searchingResultByRegion(String region) {

		String sql = "SELECT keyword, region, state " + "FROM Search " + "WHERE region=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { region });

		try {
			ResultSet rs = jdbcUtil.executeQuery();

			while (rs.next()) {
				Search s = new Search(rs.getString("keyword"), rs.getString("region"), rs.getString("state"));
				return s;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public static Search searchingResultByState(String state) {

		String sql = "SELECT keyword, region, state " + "FROM Search " + "WHERE state=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { state });

		try {
			ResultSet rs = jdbcUtil.executeQuery();

			while (rs.next()) {
				Search s = new Search(rs.getString("keyword"), rs.getString("region"), rs.getString("state"));
				return s;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
}