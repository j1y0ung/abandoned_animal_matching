package vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MemberVO implements Serializable {
	private int		mem_idx;
	private String	mem_name;
	private String	mem_id;
	private String	mem_pwd;
	private String	mem_phone;
	private String	mem_email;
	private String	mem_regDate;		// 가입일
	private String	mem_membership;
	private String  inputStr;			// 멤버십 변경시 사용
	private String	mem_careAdmin;		// 보호소명
	private String	mem_isAdmin;		// 보호소 관리자 여부
	private String	mat_id;				// 입양 완료된 동물
	
	public MemberVO() {
		super();
	}
	
	// 회원등급만 변경시, 보호소 관리자 승인 거부시 사용
	public MemberVO(String mem_id, String inputStr) {
		super();
		this.mem_id = mem_id;
		this.inputStr = inputStr;
	}

	// 마이페이지에서 정보 수정시 사용
	public MemberVO(String mem_id, String mem_pwd, String mem_phone, String mem_email) {
		super();
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		this.mem_phone = mem_phone;
		this.mem_email = mem_email;
	}

	// 회원가입시 사용
	public MemberVO(int mem_idx, String mem_name, String mem_id, String mem_pwd, String mem_phone, String mem_email,
			String mem_careAdmin) {
		super();
		this.mem_idx = mem_idx;
		this.mem_name = mem_name;
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		this.mem_phone = mem_phone;
		this.mem_email = mem_email;
		this.mem_careAdmin = mem_careAdmin;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pwd() {
		return mem_pwd;
	}

	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}

	public String getMem_phone() {
		return mem_phone;
	}

	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_membership() {
		return mem_membership;
	}

	public void setMem_membership(String mem_membership) {
		this.mem_membership = mem_membership;
	}

	public int getMem_idx() {
		return mem_idx;
	}

	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}

	public String getInputStr() {
		return inputStr;
	}

	public void setInputStr(String inputStr) {
		this.inputStr = inputStr;
	}

	public String getMem_regDate() {
		return mem_regDate;
	}
	public void setMem_regDate(String mem_regDate) {
		this.mem_regDate = mem_regDate;
	}
	public String getMem_careAdmin() {
		return mem_careAdmin;
	}
	public void setMem_careAdmin(String mem_careAdmin) {
		this.mem_careAdmin = mem_careAdmin;
	}
	
}