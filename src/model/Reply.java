package model;

import java.util.Date;

public class Reply {
	private int re_id;
	private int que_id; // 게시글 id
	private String writer_id; // 댓글 작성자 id
	private Date reg_date; // 댓글 작성 날짜
	private String content; // 댓글 내용
	private int parent_re_id; // 댓글의 부모 re_id -> 대댓글 기능
	
	public Reply() { };
	
	public Reply(int re_id, int que_id, String writer_id, Date reg_date,
				String content, int parent_re_id) {
		super();
		this.re_id = re_id;
		this.que_id = que_id;
		this.writer_id = writer_id;
		this.reg_date = reg_date;
		this.content = content;
		this.parent_re_id = parent_re_id;
	}
	
	public Reply(int re_id, String content) {
		super();
		this.re_id = re_id;
		this.content = content;
	}
	
	public int getRe_id() {
		return re_id;
	}
	public void setRe_id(int re_id) {
		this.re_id = re_id;
	}
	public int getQue_id() {
		return que_id;
	}
	public void setQue_id(int que_id) {
		this.que_id = que_id;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getParent_re_id() {
		return parent_re_id;
	}
	public void setParent_re_id(int parent_re_id) {
		this.parent_re_id = parent_re_id;
	}
}
