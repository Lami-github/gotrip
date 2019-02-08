package exchange;

import java.sql.Timestamp;

public class ExchangeDataBean {
	private int ex_num;
	private String ex_subject;
	private String ex_writer;
	private String bankname;
	private String ac_number;
	private String ac_holder;
	private int ex_point;
	private String ex_reg_date;
	private String ex_status;
	
	
	public int getEx_num() {
		return ex_num;
	}
	public void setEx_num(int ex_num) {
		this.ex_num = ex_num;
	}
	public String getEx_subject() {
		return ex_subject;
	}
	public void setEx_subject(String ex_subject) {
		this.ex_subject = ex_subject;
	}
	public String getEx_writer() {
		return ex_writer;
	}
	public void setEx_writer(String ex_writer) {
		this.ex_writer = ex_writer;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getAc_number() {
		return ac_number;
	}
	public void setAc_number(String ac_number) {
		this.ac_number = ac_number;
	}
	public String getAc_holder() {
		return ac_holder;
	}
	public void setAc_holder(String ac_holder) {
		this.ac_holder = ac_holder;
	}
	public int getEx_point() {
		return ex_point;
	}
	public void setEx_point(int ex_point) {
		this.ex_point = ex_point;
	}
	public String getEx_reg_date() {
		return ex_reg_date;
	}
	public void setEx_reg_date(String ex_re_date) {
		this.ex_reg_date = ex_re_date;
	}
	public String getEx_status() {
		return ex_status;
	}
	public void setEx_status(String ex_status) {
		this.ex_status = ex_status;
	}
	


}
