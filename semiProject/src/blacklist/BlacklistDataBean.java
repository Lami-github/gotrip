package blacklist;

import java.sql.Timestamp;

public class BlacklistDataBean {
	private int bl_num;
	private String writer;
	private String reporter;
	private String bl_subject;
	private String bl_reg_date;
	private int board_id;
	private int re_num;
	private int re_comment;
	private int bl_readcount;
	private String report_status;
	private String bl_type;
	
	
	public String getBl_type() {
		return bl_type;
	}
	public void setBl_type(String bl_type) {
		this.bl_type = bl_type;
	}
	public String getReport_status() {
		return report_status;
	}
	public void setReport_status(String report_status) {
		this.report_status = report_status;
	}
	public int getBl_num() {
		return bl_num;
	}
	public void setBl_num(int bl_num) {
		this.bl_num = bl_num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getBl_subject() {
		return bl_subject;
	}
	public void setBl_subject(String bl_subject) {
		this.bl_subject = bl_subject;
	}
	public String getBl_reg_date() {
		return bl_reg_date;
	}
	public void setBl_reg_date(String bl_reg_date) {
		this.bl_reg_date = bl_reg_date;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public int getRe_num() {
		return re_num;
	}
	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}
	public int getRe_comment() {
		return re_comment;
	}
	public void setRe_comment(int re_comment) {
		this.re_comment = re_comment;
	}
	public int getBl_readcount() {
		return bl_readcount;
	}
	public void setBl_readcount(int bl_readcount) {
		this.bl_readcount = bl_readcount;
	}

	
	
	
	
	
	

}
