package point;

import java.sql.Timestamp;

public class PointDataBean {
	private int num;
	private String id;
	private String update_date;
	private String type;
	private int update_point;
	private int after_point;
	
	
	public int getAfter_point() {
		return after_point;
	}
	public void setAfter_point(int after_point) {
		this.after_point = after_point;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getUpdate_point() {
		return update_point;
	}
	public void setUpdate_point(int update_point) {
		this.update_point = update_point;
	}
	
	
	
}
