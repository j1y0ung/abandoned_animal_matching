package vo;

import java.io.Serializable;
@SuppressWarnings("serial")
public class MatchingVO implements Serializable {
	private int		mat_idx;
	private String	mat_id;			// 유기번호
	private String	mat_kind;		// 품종
	private String	mat_sex;		// 성별
	private String	mat_age;		// 나이
	private String	mat_color;		// 색상
	private String	mat_size;		// 크기(몸무게)
	private String	mat_detail;		// 특이사항
	private String	mat_img;		// 이미지
	private String	mat_careName;	// 보호소명
	private String	mat_careAddress;// 보호소 주소
	private String	mat_tel;		// 보호소 전화번호
	private String	mem_id;
	private String	mat_date;
	private String	mat_state;
	
	public MatchingVO() {
		super();
	}

	public MatchingVO(int mat_idx) {
		super();
		this.mat_idx = mat_idx;
	}
	
	public MatchingVO(String mat_id, String mem_id) {
		super();
		this.mat_id = mat_id;
		this.mem_id = mem_id;
	}

	public MatchingVO(int mat_idx, String mat_id, String mat_kind, String mat_sex, String mat_age, String mat_color,
			String mat_size, String mat_detail, String mat_img, String mat_careName, String mat_careAddress,
			String mat_tel, String mem_id) {
		super();
		this.mat_idx = mat_idx;
		this.mat_id = mat_id;
		this.mat_kind = mat_kind;
		this.mat_sex = mat_sex;
		this.mat_age = mat_age;
		this.mat_color = mat_color;
		this.mat_size = mat_size;
		this.mat_detail = mat_detail;
		this.mat_img = mat_img;
		this.mat_careName = mat_careName;
		this.mat_careAddress = mat_careAddress;
		this.mat_tel = mat_tel;
		this.mem_id = mem_id;
	}

	public MatchingVO(int mat_idx, String mat_id, String mat_kind, String mat_sex, String mat_age, String mat_color,
			String mat_size, String mat_detail, String mat_img, String mat_careName, String mat_careAddress,
			String mat_tel, String mem_id, String mat_date) {
		super();
		this.mat_idx = mat_idx;
		this.mat_id = mat_id;
		this.mat_kind = mat_kind;
		this.mat_sex = mat_sex;
		this.mat_age = mat_age;
		this.mat_color = mat_color;
		this.mat_size = mat_size;
		this.mat_detail = mat_detail;
		this.mat_img = mat_img;
		this.mat_careName = mat_careName;
		this.mat_careAddress = mat_careAddress;
		this.mat_tel = mat_tel;
		this.mem_id = mem_id;
		this.mat_date = mat_date;
	}
	
	public MatchingVO(int mat_idx, String mat_id, String mat_kind, String mat_sex, String mat_age, String mat_color,
			String mat_size, String mat_detail, String mat_img, String mat_careName, String mat_careAddress,
			String mat_tel, String mem_id, String mat_date, String mat_state) {
		super();
		this.mat_idx = mat_idx;
		this.mat_id = mat_id;
		this.mat_kind = mat_kind;
		this.mat_sex = mat_sex;
		this.mat_age = mat_age;
		this.mat_color = mat_color;
		this.mat_size = mat_size;
		this.mat_detail = mat_detail;
		this.mat_img = mat_img;
		this.mat_careName = mat_careName;
		this.mat_careAddress = mat_careAddress;
		this.mat_tel = mat_tel;
		this.mem_id = mem_id;
		this.mat_date = mat_date;
		this.mat_state = mat_state;
	}
	
	public MatchingVO(int mat_idx, String mat_id, String mat_kind, String mat_sex, String mat_age, String mat_color,
			String mat_size, String mat_detail, String mat_img, String mat_careName, String mat_careAddress,
			String mat_tel) {
		super();
		this.mat_idx = mat_idx;
		this.mat_id = mat_id;
		this.mat_kind = mat_kind;
		this.mat_sex = mat_sex;
		this.mat_age = mat_age;
		this.mat_color = mat_color;
		this.mat_size = mat_size;
		this.mat_detail = mat_detail;
		this.mat_img = mat_img;
		this.mat_careName = mat_careName;
		this.mat_careAddress = mat_careAddress;
		this.mat_tel = mat_tel;
	}

	public int getMat_idx() {
		return mat_idx;
	}

	public void setMat_idx(int mat_idx) {
		this.mat_idx = mat_idx;
	}

	public String getMat_id() {
		return mat_id;
	}

	public void setMat_id(String mat_id) {
		this.mat_id = mat_id;
	}

	public String getMat_kind() {
		return mat_kind;
	}

	public void setMat_kind(String mat_kind) {
		this.mat_kind = mat_kind;
	}

	public String getMat_sex() {
		return mat_sex;
	}

	public void setMat_sex(String mat_sex) {
		this.mat_sex = mat_sex;
	}

	public String getMat_age() {
		return mat_age;
	}

	public void setMat_age(String mat_age) {
		this.mat_age = mat_age;
	}

	public String getMat_color() {
		return mat_color;
	}

	public void setMat_color(String mat_color) {
		this.mat_color = mat_color;
	}

	public String getMat_size() {
		return mat_size;
	}

	public void setMat_size(String mat_size) {
		this.mat_size = mat_size;
	}

	public String getMat_detail() {
		return mat_detail;
	}

	public void setMat_detail(String mat_detail) {
		this.mat_detail = mat_detail;
	}

	public String getMat_img() {
		return mat_img;
	}

	public void setMat_img(String mat_img) {
		this.mat_img = mat_img;
	}

	public String getMat_careName() {
		return mat_careName;
	}

	public void setMat_careName(String mat_careName) {
		this.mat_careName = mat_careName;
	}

	public String getMat_careAddress() {
		return mat_careAddress;
	}

	public void setMat_careAddress(String mat_careAddress) {
		this.mat_careAddress = mat_careAddress;
	}

	public String getMat_tel() {
		return mat_tel;
	}

	public void setMat_tel(String mat_tel) {
		this.mat_tel = mat_tel;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMat_date() {
		return mat_date;
	}

	public void setMat_date(String mat_date) {
		this.mat_date = mat_date;
	}
	
	public String getMat_state() {
		return mat_state;
	}

	public void setMat_state(String mat_state) {
		this.mat_state = mat_state;
	}

	@Override
	public String toString() {
		return "MatchingVO [mat_idx=" + mat_idx + ", mat_id=" + mat_id + ", mat_kind=" + mat_kind + ", mat_sex="
				+ mat_sex + ", mat_age=" + mat_age + ", mat_color=" + mat_color + ", mat_size=" + mat_size
				+ ", mat_detail=" + mat_detail + ", mat_img=" + mat_img + ", mat_careName=" + mat_careName
				+ ", mat_careAddress=" + mat_careAddress + ", mat_tel=" + mat_tel + ", mem_id=" + mem_id + ", mat_date="
				+ mat_date + ", mat_state=" + mat_state + "]\n";
	}
}
