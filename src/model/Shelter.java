package model;

public class Shelter {
	private String careAddr; // 소재지도로명주소
	private String careNm; // 동물보호센터명
	private String careTel; // 전화번호
	private String closeDay; // 휴무일
	private double lat; // 위도
	private double lng; // 경도
	private String saveTrgtAnimal; // 구조대상동물
	private int vetPersonCnt; // 수의사인원수
	private String weekOprStime; // 평일운영시작시각
	private String weekOprEtime; // 평일운영종료시각
	private String weekendOprStime; // 주말운영시작시각
	private String weekendOprEtime; // 주말운영종료시각
	public Shelter() {}
	public Shelter(String careAddr, String careNm, String careTel, String closeDay, double lat, double lng,
			String saveTrgtAnimal, int vetPersonCnt, String weekOprStime, String weekOprEtime, 
			String weekendOprStime, String weekendOprEtime) {
		super();
		this.careAddr = careAddr;
		this.careNm = careNm;
		this.careTel = careTel;
		this.closeDay = closeDay;
		this.lat = lat;
		this.lng = lng;
		this.saveTrgtAnimal = saveTrgtAnimal;
		this.vetPersonCnt = vetPersonCnt;
		this.weekOprStime = weekOprStime;
		this.weekOprEtime = weekOprEtime;
		this.weekendOprStime = weekendOprStime;
		this.weekendOprEtime = weekendOprEtime;
	}

	public String getCareAddr() {
		return careAddr;
	}

	public void setCareAddr(String careAddr) {
		this.careAddr = careAddr;
	}

	public String getCareNm() {
		return careNm;
	}

	public void setCareNm(String careNm) {
		this.careNm = careNm;
	}

	public String getCareTel() {
		return careTel;
	}

	public void setCareTel(String careTel) {
		this.careTel = careTel;
	}

	public String getCloseDay() {
		return closeDay;
	}

	public void setCloseDay(String closeDay) {
		this.closeDay = closeDay;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getSaveTrgtAnimal() {
		return saveTrgtAnimal;
	}

	public void setSaveTrgtAnimal(String saveTrgtAnimal) {
		this.saveTrgtAnimal = saveTrgtAnimal;
	}

	public int getVetPersonCnt() {
		return vetPersonCnt;
	}

	public void setVetPersonCnt(int vetPersonCnt) {
		this.vetPersonCnt = vetPersonCnt;
	}

	public String getWeekOprStime() {
		return weekOprStime;
	}

	public void setWeekOprStime(String weekOprStime) {
		this.weekOprStime = weekOprStime;
	}

	public String getWeekOprEtime() {
		return weekOprEtime;
	}

	public void setWeekOprEtime(String weekOprEtime) {
		this.weekOprEtime = weekOprEtime;
	}

	public String getWeekendOprStime() {
		return weekendOprStime;
	}
	public void setWeekendOprStime(String weekendOprStime) {
		this.weekendOprStime = weekendOprStime;
	}
	public String getWeekendOprEtime() {
		return weekendOprEtime;
	}
	public void setWeekendOprEtime(String weekendOprEtime) {
		this.weekendOprEtime = weekendOprEtime;
	}
	@Override
	public String toString() {
		return "Shelter [careAddr=" + careAddr + ",\n careNm=" + careNm + ",\n careTel=" + careTel + ",\n closeDay="
				+ closeDay + ",\n lat=" + lat + ",\n lng=" + lng + ",\n saveTrgtAnimal=" + saveTrgtAnimal + ",\n vetPersonCnt="
				+ vetPersonCnt + ",\n weekOprStime=" + weekOprStime + ",\n weekOprEtime=" + weekOprEtime + "]";
	}
	
}
