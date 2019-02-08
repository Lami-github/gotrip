package tripreview;

import java.sql.Timestamp;

public class TripreviewDataBean {
	private int t_num;
	private String t_subject;
	private String t_writer;
	private String t_reg_date;
	private String t_content;
	private int t_readcount;
	private String photo_id;
	private String t_htag;
	private String imagePath;
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public int getT_num() {
		return t_num;
	}
	public void setT_num(int t_num) {
		this.t_num = t_num;
	}
	public String getT_subject() {
		return t_subject;
	}
	public void setT_subject(String t_subject) {
		this.t_subject = t_subject;
	}
	public String getT_writer() {
		return t_writer;
	}
	public void setT_writer(String t_writer) {
		this.t_writer = t_writer;
	}
	public String getT_reg_date() {
		return t_reg_date;
	}
	public void setT_reg_date(String t_reg_date) {
		this.t_reg_date = t_reg_date;
	}
	public String getT_content() {
		return t_content;
	}
	public void setT_content(String t_content) {
		this.t_content = t_content;
	}
	public int getT_readcount() {
		return t_readcount;
	}
	public void setT_readcount(int t_readcount) {
		this.t_readcount = t_readcount;
	}
	public String getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(String photo_id) {
		this.photo_id = photo_id;
	}
	public String getT_htag() {
		return t_htag;
	}
	public void setT_htag(String t_htag) {
		this.t_htag = t_htag;
	}
	
	
}
