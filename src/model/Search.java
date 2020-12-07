package model;

public class Search {

	private String keyword;
	private String region;
	private String state;
	
	public Search() { }		// 기본 생성자
	
	public Search(String keyword, String region, String state) {
		super();
		this.keyword = keyword;
		this.region = region;
		this.state = state;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
