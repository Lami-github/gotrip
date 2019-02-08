package buyer;

import java.sql.Timestamp;

public class BuyerDataBean {
	private int b_num;
	private String b_writer;
	private String b_subject;
	private String b_country;
	private String b_item; 
	private int b_count;
	private int b_price;
	private String b_reg_date;
	private String b_content;
	private int b_readcount;
	private String photo_id;
	private String firstImagePath;
	
	public String getFirstImagePath() {
		return firstImagePath;
	}
	public void setFirstImagePath(String firstImagePath) {
		this.firstImagePath = firstImagePath;
	}
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public String getB_subject() {
		return b_subject;
	}
	public void setB_subject(String b_subject) {
		this.b_subject = b_subject;
	}
	public String getB_country() {
		return b_country;
	}
	public void setB_country(String b_country) {
		this.b_country = b_country;
	}
	public String getB_item() {
		return b_item;
	}
	public void setB_item(String b_item) {
		this.b_item = b_item;
	}
	public int getB_count() {
		return b_count;
	}
	public void setB_count(int b_count) {
		this.b_count = b_count;
	}
	public int getB_price() {
		return b_price;
	}
	public void setB_price(int b_price) {
		this.b_price = b_price;
	}
	public String getB_reg_date() {
		return b_reg_date;
	}
	public void setB_reg_date(String b_reg_date) {
		this.b_reg_date = b_reg_date;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public int getB_readcount() {
		return b_readcount;
	}
	public void setB_readcount(int b_readcount) {
		this.b_readcount = b_readcount;
	}
	public String getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(String photo_id) {
		this.photo_id = photo_id;
	}
	
	
	

}
