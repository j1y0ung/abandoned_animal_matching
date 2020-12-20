package vo;

import java.io.Serializable;
import java.util.Date;
@SuppressWarnings("serial")

public class TestVO implements Serializable {
	private String mem_id;
	private String passCat;			// 고양이 시험 통과 여부
	private String passDog;			// 강아지 시험 통과 여부
	private Date catFailDate;		// 고양이 시험 탈락일
	private Date dogFailDate;		// 강아지 시험 탈락일
	private int catFailNum;			// 고양이 시험 불합격 횟수
	private int dogFailNum;			// 강아지 시험 불합격 횟수
	private Date inputDate;				// 시험 탈락일 변경시 사용
	private String inputStr;				// 시험 탈락/합격 변경시 사용
	
	public TestVO() {
		super();
	}

	public TestVO(String mem_id, Date inputDate) {
		super();
		this.mem_id = mem_id;
		this.inputDate = inputDate;
	}

	public TestVO(String mem_id, String inputStr) {
		super();
		this.mem_id = mem_id;
		this.inputStr = inputStr;
	}

	public TestVO(String mem_id) {
		super();
		this.mem_id = mem_id;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getPassCat() {
		return passCat;
	}

	public void setPassCat(String passCat) {
		this.passCat = passCat;
	}

	public String getPassDog() {
		return passDog;
	}

	public void setPassDog(String passDog) {
		this.passDog = passDog;
	}

	public Date getCatFailDate() {
		return catFailDate;
	}

	public void setCatFailDate(Date catFailDate) {
		this.catFailDate = catFailDate;
	}

	public Date getDogFailDate() {
		return dogFailDate;
	}

	public void setDogFailDate(Date dogFailDate) {
		this.dogFailDate = dogFailDate;
	}

	public int getCatFailNum() {
		return catFailNum;
	}

	public void setCatFailNum(int catFailNum) {
		this.catFailNum = catFailNum;
	}

	public int getDogFailNum() {
		return dogFailNum;
	}

	public void setDogFailNum(int dogFailNum) {
		this.dogFailNum = dogFailNum;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public String getInputStr() {
		return inputStr;
	}

	public void setInputStr(String inputStr) {
		this.inputStr = inputStr;
	}
	
}
