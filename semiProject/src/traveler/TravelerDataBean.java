package traveler;

import java.sql.Timestamp;

public class TravelerDataBean {
	private int tr_num;
	private String tr_writer;
	private String tr_subject;
	private String tr_reg_date;
	private String begin_country;
	private String arrived_country;
	private String begin_day;
	private String arrived_day;
	private int limit_money;
	private String tr_content;
	private int tr_readcount;
	private String photo_id;
	private String imgPath;
	
	
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public int getTr_num() {
		return tr_num;
	}
	public void setTr_num(int tr_num) {
		this.tr_num = tr_num;
	}
	public String getTr_writer() {
		return tr_writer;
	}
	public void setTr_writer(String tr_writer) {
		this.tr_writer = tr_writer;
	}
	public String getTr_subject() {
		return tr_subject;
	}
	public void setTr_subject(String tr_subject) {
		this.tr_subject = tr_subject;
	}
	public String getTr_reg_date() {
		return tr_reg_date;
	}
	public void setTr_reg_date(String tr_reg_date) {
		this.tr_reg_date = tr_reg_date;
	}
	public String getBegin_country() {
		return begin_country;
	}
	public void setBegin_country(String begin_country) {
		this.begin_country = begin_country;
	}
	public String getArrived_country() {
		return arrived_country;
	}
	public void setArrived_country(String arrived_country) {
		this.arrived_country = arrived_country;
	}
	public String getBegin_day() {
		return begin_day;
	}
	public void setBegin_day(String begin_day) {
		this.begin_day = begin_day;
	}
	public String getArrived_day() {
		return arrived_day;
	}
	public void setArrived_day(String arrived_day) {
		this.arrived_day = arrived_day;
	}
	public int getLimit_money() {
		return limit_money;
	}
	public void setLimit_money(int limit_money) {
		this.limit_money = limit_money;
	}
	public String getTr_content() {
		return tr_content;
	}
	public void setTr_content(String tr_content) {
		this.tr_content = tr_content;
	}
	public int getTr_readcount() {
		return tr_readcount;
	}
	public void setTr_readcount(int tr_readcount) {
		this.tr_readcount = tr_readcount;
	}
	public String getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(String photo_id) {
		this.photo_id = photo_id;
	}
	
	
	

}
