package model;

import java.util.Date;

public class Question { // 질문 게시글
	private int id; // 게시글 아이디--시퀀스로 1씩 증가.
	private String writer_id; //게시글 작성자  -> member 테이블의 mem_id 참조.
								// 지금은 userInfo의 userId 참조
	private String content; // 게시글 내용
	private String title; // 게시글 제목
	private int hits; // 게시글 조회수
	private Date date; // 게시글 작성 날짜
	private int total_reply; // 해당 게시글의 댓글 개수 
	private String secret; // 비밀글
	private String filename;

	public Question() { }
	
	public Question(int id, String writer_id, String title, String content,
			Date date, int hits, String secret, String filename) {
		super();
		this.id = id;
		this.writer_id = writer_id;
		this.title = title;
		this.content = content;
		this.date = date;
		this.hits = hits;
		this.secret = secret;
		this.filename = filename;
	}
	
	public Question(int id, String writer_id, String title, Date date, int hits,
			int total_reply, String secret, String filename) {
		super();
		this.id = id;
		this.writer_id = writer_id;
		this.title = title;
		this.date = date;
		this.hits = hits;
		this.total_reply = total_reply;
		this.secret = secret;
		this.filename = filename;
	}
	
	public Question(int id, String title, String content, String secret, String filename) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.secret = secret;
		this.filename = filename;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getTotal_reply() {
		return total_reply;
	}

	public void setTotal_reply(int total_reply) {
		this.total_reply = total_reply;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
