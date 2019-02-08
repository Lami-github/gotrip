package trade;

import java.sql.Timestamp;

public class TradeDataBean {
	private int trade_num;
	private String b_id;
	private String tr_id;
	private String trade_item;
	private int trade_count;
	private String del_state;
	private String invoice_num;
	private int trade_point;
	private String trade_sdate;
	private String trade_edate;
	private String standby;
	public int getTrade_num() {
		return trade_num;
	}
	public void setTrade_num(int trade_num) {
		this.trade_num = trade_num;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getTr_id() {
		return tr_id;
	}
	public void setTr_id(String tr_id) {
		this.tr_id = tr_id;
	}
	public String getTrade_item() {
		return trade_item;
	}
	public void setTrade_item(String trade_item) {
		this.trade_item = trade_item;
	}
	public int getTrade_count() {
		return trade_count;
	}
	public void setTrade_count(int trade_count) {
		this.trade_count = trade_count;
	}
	public String getDel_state() {
		return del_state;
	}
	public void setDel_state(String del_state) {
		this.del_state = del_state;
	}
	public String getInvoice_num() {
		return invoice_num;
	}
	public void setInvoice_num(String invoice_num) {
		this.invoice_num = invoice_num;
	}
	public int getTrade_point() {
		return trade_point;
	}
	public void setTrade_point(int trade_point) {
		this.trade_point = trade_point;
	}
	public String getTrade_sdate() {
		return trade_sdate;
	}
	public void setTrade_sdate(String trade_sdate) {
		this.trade_sdate = trade_sdate;
	}
	public String getTrade_edate() {
		return trade_edate;
	}
	public void setTrade_edate(String trade_edate) {
		this.trade_edate = trade_edate;
	}
	public String getStandby() {
		return standby;
	}
	public void setStandby(String standby) {
		this.standby = standby;
	}
	

	
	
}
