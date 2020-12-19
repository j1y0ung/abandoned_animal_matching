package model;

public class CatTest {

	String catQ; // 고양이 문제
	String catQ_1; // 고양이 문제 선지1
	String catQ_2; // 고양이 문제 선지2
	String catQ_3; // 고양이 문제 선지3
	String catQ_4; // 고양이 문제 선지4
	String catA; // 해당 문제 정답
	
	public CatTest() {
		super();
	}

	public CatTest(String catQ, String catQ_1, String catQ_2, String catQ_3, String catQ_4, String catA) {
		super();
		this.catQ = catQ;
		this.catQ_1 = catQ_1;
		this.catQ_2 = catQ_2;
		this.catQ_3 = catQ_3;
		this.catQ_4 = catQ_4;
		this.catA = catA;
	}

	public String getCatQ() {
		return catQ;
	}

	public void setCatQ(String catQ) {
		this.catQ = catQ;
	}

	public String getCatQ_1() {
		return catQ_1;
	}

	public void setCatQ_1(String catQ_1) {
		this.catQ_1 = catQ_1;
	}

	public String getCatQ_2() {
		return catQ_2;
	}

	public void setCatQ_2(String catQ_2) {
		this.catQ_2 = catQ_2;
	}

	public String getCatQ_3() {
		return catQ_3;
	}

	public void setCatQ_3(String catQ_3) {
		this.catQ_3 = catQ_3;
	}

	public String getCatQ_4() {
		return catQ_4;
	}

	public void setCatQ_4(String catQ_4) {
		this.catQ_4 = catQ_4;
	}

	public String getCatA() {
		return catA;
	}

	public void setCatA(String catA) {
		this.catA = catA;
	}

}
