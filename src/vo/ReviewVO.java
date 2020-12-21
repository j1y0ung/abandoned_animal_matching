package vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ReviewVO implements Serializable {
	private int		rev_idx;
	private String	rev_title;
	private String	rev_content;
	private String	rev_img;
	private String	rev_date;
	private String	mem_id; // 입양후기 작성자 아이디
	private String	mat_id; // 입양후기 대상 동물의 유기번호
	private String rev_titleImg; // 리뷰 리스트에 보일 이미지

	public ReviewVO() {
	}

	public ReviewVO(int rev_idx, String rev_title, String rev_content, String rev_img, String rev_date, String mem_id,
			String mat_id) {
		super();
		this.rev_idx = rev_idx;
		this.rev_title = rev_title;
		this.rev_content = rev_content;
		this.rev_img = rev_img;
		this.rev_date = rev_date;
		this.mem_id = mem_id;
		this.mat_id = mat_id;
	}

	public ReviewVO(int rev_idx, String rev_title, String rev_content, String rev_img, String rev_date, String mem_id,
			String mat_id, String rev_titleImg) {
		super();
		this.rev_idx = rev_idx;
		this.rev_title = rev_title;
		this.rev_content = rev_content;
		this.rev_img = rev_img;
		this.rev_date = rev_date;
		this.mem_id = mem_id;
		this.mat_id = mat_id;
		this.rev_titleImg = rev_titleImg;
	}

	public int getRev_idx() {
		return rev_idx;
	}

	public void setRev_idx(int rev_idx) {
		this.rev_idx = rev_idx;
	}

	public String getRev_title() {
		return rev_title;
	}

	public void setRev_title(String rev_title) {
		this.rev_title = rev_title;
	}

	public String getRev_content() {
		return rev_content;
	}

	public void setRev_content(String rev_content) {
		this.rev_content = rev_content;
	}

	public String getRev_img() {
		return rev_img;
	}

	public void setRev_img(String rev_img) {
		this.rev_img = rev_img;
	}

	public String getRev_date() {
		return rev_date;
	}

	public void setRev_date(String rev_date) {
		this.rev_date = rev_date;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMat_id() {
		return mat_id;
	}

	public void setMat_id(String mat_id) {
		this.mat_id = mat_id;
	}

	public String getRev_titleImg() {
		return rev_titleImg;
	}

	public void setRev_titleImg(String rev_titleImg) {
		this.rev_titleImg = rev_titleImg;
	}
} 