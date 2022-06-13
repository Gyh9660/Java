package com.springbook.biz.board;

import java.sql.Date;

import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date reg_date;
	private int cnt;
	private String searchCondition;
	private String searchKeyword;
	private MultipartFile uploadFile;
	//getter, setter
	
	public int getSeq() {
		return seq;
	}
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
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
	public String toString() { //ê°ì²´ ?ì²´ë?? ì¶œë ¥?‹œ ê°ì²´?˜ ì£¼ì†Œë¥? ì¶œë ¥?•˜?Š” ê²ƒì´?•„?‹ˆ?¼ ê°ì²´?˜ ë©”ëª¨ë¦¬ì˜ ê°’ë“¤?„ ì¶œë ¥
		
		return "BoardVO [seq = " + seq + ", title = " +title + ", writer = "+writer+", content = "+content+", reg_date = "+reg_date+", cnt = " +cnt + "]";
	}
	
}
