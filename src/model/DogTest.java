package model;

public class DogTest {
	
	String dogQ; // 강아지 문제
	String dogQ_1; // 강아지 문제 선지1
	String dogQ_2; // 강아지 문제 선지2
	String dogQ_3; // 강아지 문제 선지3
	String dogQ_4; // 강아지 문제 선지4
	String dogA; // 강아지 문제 정답	
	
	public DogTest() {
		super();
	}

	public DogTest(String dogQ, String dogQ_1, String dogQ_2, String dogQ_3, String dogQ_4, String dogA) {
		super();
		this.dogQ = dogQ;
		this.dogQ_1 = dogQ_1;
		this.dogQ_2 = dogQ_2;
		this.dogQ_3 = dogQ_3;
		this.dogQ_4 = dogQ_4;
		this.dogA = dogA;
	}

	public String getDogQ() {
		return dogQ;
	}
	public void setDogQ(String dogQ) {
		this.dogQ = dogQ;
	}
	public String getDogQ_1() {
		return dogQ_1;
	}
	public void setDogQ_1(String dogQ_1) {
		this.dogQ_1 = dogQ_1;
	}
	public String getDogQ_2() {
		return dogQ_2;
	}
	public void setDogQ_2(String dogQ_2) {
		this.dogQ_2 = dogQ_2;
	}
	public String getDogQ_3() {
		return dogQ_3;
	}
	public void setDogQ_3(String dogQ_3) {
		this.dogQ_3 = dogQ_3;
	}
	public String getDogQ_4() {
		return dogQ_4;
	}
	public void setDogQ_4(String dogQ_4) {
		this.dogQ_4 = dogQ_4;
	}

	public String getDogA() {
		return dogA;
	}

	public void setDogA(String dogA) {
		this.dogA = dogA;
	}

}
