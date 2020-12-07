package model.dao;

import java.util.List;

import model.Search;

public class SearchingDTO {

	private String searchKeyword = null;
	private String selectRegion = null;
	private String selectState = null;
	private List<Search> searchList = null;
	
	public String getSearchKeyword() {
		return searchKeyword;
	}
	
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
	public String getSelectRegion() {
		return selectRegion;
	}
	
	public void setSelectRegion(String selectRegion) {
		this.selectRegion = selectRegion;
	}
	public String getSelectState() {
		return selectState;
	}
	
	public void setSelectState(String selectState) {
		this.selectState = selectState;
	}

	public List<Search> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<Search> searchList) {
		this.searchList = searchList;
	}
	
}