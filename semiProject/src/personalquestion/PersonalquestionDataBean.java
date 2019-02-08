package personalquestion;

import java.sql.Timestamp;

public class PersonalquestionDataBean {
	private int pq_num;
	private String pq_type;
	private String pq_subject;
	private String writer;
	private String pq_reg_date;
	private String pq_content;
	private int ref;
	private int re_step;
	private int re_level;
	private String search;
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getPq_num() {
		return pq_num;
	}
	public void setPq_num(int pq_num) {
		this.pq_num = pq_num;
	}
	public String getPq_type() {
		return pq_type;
	}
	public void setPq_type(String pq_type) {
		this.pq_type = pq_type;
	}
	public String getPq_subject() {
		return pq_subject;
	}
	public void setPq_subject(String pq_subject) {
		this.pq_subject = pq_subject;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPq_reg_date() {
		return pq_reg_date;
	}
	public void setPq_reg_date(String pq_reg_date) {
		this.pq_reg_date = pq_reg_date;
	}
	public String getPq_content() {
		return pq_content;
	}
	public void setPq_content(String pq_content) {
		this.pq_content = pq_content;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	

}
