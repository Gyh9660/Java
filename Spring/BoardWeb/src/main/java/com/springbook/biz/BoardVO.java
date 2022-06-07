package com.springbook.biz;

import java.sql.Date;

public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date reg_date;
	private int cnt;
	
	//getter, setter
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() { //객체 자체를 출력시 객체의 주소를 출력하는 것이아니라 객체의 메모리의 값들을 출력
		
		return "BoardVO [seq = " + seq + ", title = " +title + ", writer = "+writer+", content = "+content+", reg_date = "+reg_date+", cnt = " +cnt + "]";
	}
	
}
