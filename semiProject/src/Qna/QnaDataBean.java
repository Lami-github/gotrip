package Qna;

import java.sql.Timestamp;

public class QnaDataBean {
	private int q_num;
	private String q_subject;
	private String q_content;
	private String q_reg_date;
	private int q_readcount;
	public int getQ_num() {
		return q_num;
	}
	public void setQ_num(int q_num) {
		this.q_num = q_num;
	}
	public String getQ_subject() {
		return q_subject;
	}
	public void setQ_subject(String q_subject) {
		this.q_subject = q_subject;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public String getQ_reg_date() {
		return q_reg_date;
	}
	public void setQ_reg_date(String q_reg_date) {
		this.q_reg_date = q_reg_date;
	}
	public int getQ_readcount() {
		return q_readcount;
	}
	public void setQ_readcount(int q_readcount) {
		this.q_readcount = q_readcount;
	}
	
	
}

	