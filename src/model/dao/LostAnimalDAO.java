package model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.LostAnimal;

public class LostAnimalDAO {
	
	private static JDBCUtil jdbcUtil = null;
	
	private static LostAnimalDAO lostAnimalDao = new LostAnimalDAO();
	
	public static LostAnimalDAO getInstance() {
	       return lostAnimalDao;
	}
	
	public LostAnimalDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
	public void createNewLostAnimal(String animalType, String ownername, String ownerPhone, String animalSpecies, int animalAge,
			String animalGender, String region) throws SQLException {//항목추가

		ResultSet rs = null;
		String progress = "접수완료";
		
		String query =  "INSERT INTO LOSTANIMAL VALUES (la_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";

		Object[] param = new Object[] {animalType, ownername, ownerPhone, animalSpecies, animalAge, animalGender, progress, region};
		jdbcUtil.setSqlAndParameters(query, param);
		
		try {	
			rs = jdbcUtil.executeQuery();

		} catch (Exception ex) { ex.printStackTrace();}
			finally {									
				jdbcUtil.close();
			}
	}
	
	public void deleteLostAnimal(int receiptNum) throws SQLException {//항목삭제
		ResultSet rs = null;

		try {	
			String query =  "DELETE FROM lostanimal "
					  + "WHERE receiptNum=?";
			
			Object[] param = new Object[] {receiptNum}; 
			jdbcUtil.setSqlAndParameters(query, param);
			
			rs = jdbcUtil.executeQuery();
			
		} catch (Exception ex) { ex.printStackTrace();}
			finally 
			{									
				jdbcUtil.close();
			}
	}
	
	public List<LostAnimal> LostAnimalList() throws SQLException {//전체리스트가져오기
		
		ArrayList<LostAnimal> list = new ArrayList<>();

		ResultSet rs = null;
		
		String query =  "SELECT receiptNum, animalType, ownername, ownerPhone, animalSpecies, animalAge, animalGender, progress, region"
				+ " FROM LOSTANIMAL";
		
		jdbcUtil.setSqlAndParameters(query, null);
		
		try {	
			rs = jdbcUtil.executeQuery();
			
			while (rs.next()) {
				int receiptNum = rs.getInt("receiptNum");
				String animalType = rs.getString("animalType");
				String ownername = rs.getString("ownername");
				String ownerPhone = rs.getString("ownerPhone");
				String animalSpecies = rs.getString("animalSpecies");
				int animalAge = rs.getInt("animalAge");
				String animalGender = rs.getString("animalGender");
				String progress = rs.getString("progress");
				String region = rs.getString("region");
				
				LostAnimal la = new LostAnimal(receiptNum, animalType, ownername, ownerPhone, animalSpecies, animalAge, animalGender, progress, region);
				list.add(la);
			}
			return list;
		} catch (Exception ex) { ex.printStackTrace();}
			finally {									
				jdbcUtil.close();
			}
		return null;
	}
	

}
