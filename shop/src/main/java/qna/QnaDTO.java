package qna;

import java.sql.Timestamp;

public class QnaDTO {
	private int q_id;
	private String u_id;
	private String subject;
	private String content;
	private Timestamp inputdate;
	private int readcount;
	private int masterid;
	private int replaynum;
	private int step;
	
	public int getQ_id() {
		return q_id;
	}
	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getInputdate() {
		return inputdate;
	}
	public void setInputdate(Timestamp inputdate) {
		this.inputdate = inputdate;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getMasterid() {
		return masterid;
	}
	public void setMasterid(int masterid) {
		this.masterid = masterid;
	}
	public int getReplaynum() {
		return replaynum;
	}
	public void setReplaynum(int replaynum) {
		this.replaynum = replaynum;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	
	
}
