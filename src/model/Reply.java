package model;

import java.util.Date;

public class Reply {
	private int re_id; // 답변 아이디(식별자-시퀀스)
	private int que_id; // 질문글 아이디
	private String writer_id; // 답변 작성자 아이디ㄴㄴ
	private Date reg_date; // 코멘트 작성날짜
	private String content; // 코멘트 내용
	private int parent_re_id; // 코멘트의 부모코멘트->대댓글 기능
	
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
