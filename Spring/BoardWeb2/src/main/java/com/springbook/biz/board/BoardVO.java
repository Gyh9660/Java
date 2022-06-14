package com.springbook.biz.board;

import java.sql.Date;

import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
<<<<<<< HEAD
	
	private int seq; 
	private String title; 
	private String writer; 
	private String content; 
	private Date regdate; 
=======
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date reg_date;
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
	private int cnt;
	private String searchCondition;
	private String searchKeyword;
	private MultipartFile uploadFile;
<<<<<<< HEAD
	
	//getter , setter
	
=======
	//getter, setter
	
	public int getSeq() {
		return seq;
	}
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
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
<<<<<<< HEAD
	public int getSeq() {
		return seq;
	}
=======
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
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
<<<<<<< HEAD
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
=======
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
<<<<<<< HEAD
	} 
	
	@Override
	public String toString () {	//°´Ã¼ ÀÚÃ¼¸¦ Ãâ·Â½Ã °´Ã¼ÀÇ ÁÖ¼Ò¸¦ Ãâ·Â ÇÏ´Â °ÍÀÌ ¾Æ´Ï¶ó 
								  // °´Ã¼ÀÇ ¸Þ¸ð¸®ÀÇ °ªÀ» Ãâ·Â 
		
		return "BoardVO [seq = " + seq + ", title = " + title + ", writer = " + writer +
				" , content = " + content + " , regdate = " + regdate + " , cnt = " + 
				cnt + "]" ; 
	}
	
=======
	}
	
	@Override
	public String toString() { //ê°ì²´ ?žì²´ë?? ì¶œë ¥?‹œ ê°ì²´?˜ ì£¼ì†Œë¥? ì¶œë ¥?•˜?Š” ê²ƒì´?•„?‹ˆ?¼ ê°ì²´?˜ ë©”ëª¨ë¦¬ì˜ ê°’ë“¤?„ ì¶œë ¥
		
		return "BoardVO [seq = " + seq + ", title = " +title + ", writer = "+writer+", content = "+content+", reg_date = "+reg_date+", cnt = " +cnt + "]";
	}
>>>>>>> 9e0d4adb58faea260cdc14d29e5db0017df7b0c2
	
}
