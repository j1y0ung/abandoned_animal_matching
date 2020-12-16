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
	private String	mem_membership;
	private String mem_passCat;
	private String mem_passDog;
	private String inputStr;
	
	public MemberVO() {
		super();
	}
	
	public MemberVO(String mem_id, String inputStr) {
		super();
		this.mem_id = mem_id;
		this.inputStr = inputStr;
	}

	public MemberVO(String mem_id, String mem_pwd, String mem_phone, String mem_email) {
		super();
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		this.mem_phone = mem_phone;
		this.mem_email = mem_email;
	}

	public MemberVO(int mem_idx, String mem_name, String mem_id, String mem_pwd, String mem_phone, String mem_email,
			String mem_membership) {
		super();
		this.mem_idx = mem_idx;
		this.mem_name = mem_name;
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		this.mem_phone = mem_phone;
		this.mem_email = mem_email;
		this.mem_membership = mem_membership;
	}

	public MemberVO(int mem_idx, String mem_name, String mem_id, String mem_pwd, String mem_phone, String mem_email,
			String mem_membership, String mem_passCat, String mem_passDog) {
		super();
		this.mem_idx = mem_idx;
		this.mem_name = mem_name;
		this.mem_id = mem_id;
		this.mem_pwd = mem_pwd;
		this.mem_phone = mem_phone;
		this.mem_email = mem_email;
		this.mem_membership = mem_membership;
		this.mem_passCat = mem_passCat;
		this.mem_passDog = mem_passDog;
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

	public String getMem_passCat() {
		return mem_passCat;
	}

	public void setMem_passCat(String mem_passCat) {
		this.mem_passCat = mem_passCat;
	}

	public String getMem_passDog() {
		return mem_passDog;
	}

	public void setMem_passDog(String mem_passDog) {
		this.mem_passDog = mem_passDog;
	}

	public String getInputStr() {
		return inputStr;
	}

	public void setInputStr(String inputStr) {
		this.inputStr = inputStr;
	}
}