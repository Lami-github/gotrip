package ad;

import java.sql.Timestamp;

public class AdDataBean {
	private int ad_id;
	private String ad_loc;
	private int photo_id;
	private String ad_sdate;
	private String ad_edate;
	private String ad_company;
	private String ad_price;
	public int getAd_id() {
		return ad_id;
	}
	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
	public String getAd_loc() {
		return ad_loc;
	}
	public void setAd_loc(String ad_loc) {
		this.ad_loc = ad_loc;
	}
	public int getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
	}
	public String getAd_sdate() {
		return ad_sdate;
	}
	public void setAd_sdate(String ad_sdate) {
		this.ad_sdate = ad_sdate;
	}
	public String getAd_edate() {
		return ad_edate;
	}
	public void setAd_edate(String ad_edate) {
		this.ad_edate = ad_edate;
	}
	public String getAd_company() {
		return ad_company;
	}
	public void setAd_company(String ad_company) {
		this.ad_company = ad_company;
	}
	public String getAd_price() {
		return ad_price;
	}
	public void setAd_price(String ad_price) {
		this.ad_price = ad_price;
	}
	
	
}
