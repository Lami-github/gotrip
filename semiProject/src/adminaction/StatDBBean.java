package adminaction;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StatDBBean {

	private static StatDBBean instance = new StatDBBean();

	// LogonDBBean m = LogonDBBean.getInstance();
	public static StatDBBean getInstance() {
		return instance;
	}

	private StatDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	public void visitorcount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");

		
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from visitor_stat where v_date = ?");

			pstmt.setString(1, date.format(today));

			rs = pstmt.executeQuery();

			if (rs.next()) {
				pstmt = conn.prepareStatement("update visitor_stat set v_count=v_count+1 where v_date = ? ");

				pstmt.setString(1,date.format(today));

				pstmt.executeUpdate();
			} else {
				pstmt = conn.prepareStatement("insert into visitor_stat values(?,1)");

				pstmt.setString(1,date.format(today));

				pstmt.executeUpdate();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}
	
	
	public ArrayList getvisitorcount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StatDataBean sdb= null;
		ArrayList daylist = new ArrayList();
		int count = 0;
		String sql = "";
		
		try {
			conn = getConnection();
			
			sql = "select v_date,v_count from visitor_stat order by v_date desc";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				sdb = new StatDataBean();
				String d = rs.getString("v_date").split(" ")[0];
				String a = d.split("-")[1] + "/" + d.split("-")[2];
				
				sdb.setV_date(a);
				sdb.setV_count(rs.getInt("v_count"));
				
				daylist.add(sdb);
				count++;
				
				if(count == 11) {
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return daylist;
	}
	
	public void Writecount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from board_stat where bo_date = ?");

			pstmt.setString(1, date.format(today));

			rs = pstmt.executeQuery();

			if (rs.next()) {
				pstmt = conn.prepareStatement("update board_stat set bo_count =bo_count +1 where bo_date = ? ");

				pstmt.setString(1, date.format(today));

				pstmt.executeUpdate();
			} else {
				pstmt = conn.prepareStatement("insert into board_stat values(?,1)");

				pstmt.setString(1, date.format(today));

				pstmt.executeUpdate();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		
	}
	
	public ArrayList getWritecount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StatDataBean sdb= null;
		ArrayList daylist = new ArrayList();
		int count = 0;
		String sql = "";
		
		try {
			conn = getConnection();

			sql = "select bo_date,bo_count from board_stat order by bo_date desc";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				sdb = new StatDataBean();
				String d = rs.getString("bo_date").split(" ")[0];
				String a = d.split("-")[1] + "/" + d.split("-")[2];
				
				sdb.setV_date(a);
				sdb.setV_count(rs.getInt("bo_count"));
				
				daylist.add(sdb);
				count++;
				
				if(count == 11) {
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return daylist;
	}
	
	public void tradeCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from trade_stat where t_date = ?");

			pstmt.setString(1, date.format(today));

			rs = pstmt.executeQuery();

			if (rs.next()) {
				pstmt = conn.prepareStatement("update trade_stat set t_request =t_request +1 where t_date = ? ");

				pstmt.setString(1, date.format(today));

				pstmt.executeUpdate();
			} else {
				pstmt = conn.prepareStatement("insert into trade_stat values(?,1,0)");

				pstmt.setString(1, date.format(today));

				pstmt.executeUpdate();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}
	
	public void successtradeCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("update trade_stat set t_succeed=t_succeed+1 where t_date = ?");

			pstmt.setString(1, date.format(today));

			pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}
	
	
	public String getAlltradeCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		int total = 0;
		int succeed = 0;
		String split = "";
		
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select t_request from trade_stat");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				total += rs.getInt(1);
			}
			
			pstmt = conn.prepareStatement("select t_succeed from trade_stat");

				rs = pstmt.executeQuery();

			while(rs.next()) {
					succeed += rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		split = total + "/" + succeed;
		
		return split;
	}
	
	public ArrayList getTradeCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList daylist = new ArrayList();
		StatDataBean sdb = null;
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		int avg = 0;
		
		int count = 0;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from trade_stat order by t_date");
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				sdb = new StatDataBean();
				String d = rs.getString("t_date").split(" ")[0];
				String a = d.split("-")[1] + "/" + d.split("-")[2];
				
				avg = (int) ((((double)rs.getInt("t_succeed"))/((double)rs.getInt("t_request")))*100.0);
				
				System.out.println(a + " / " + avg);
				sdb.setV_date(a);
				sdb.setV_count(avg);
				
				daylist.add(sdb);
				count++;
				if (count == 11) {
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return daylist;
	}
	
	
	public void UpdatepaymentCH(int chprice) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from point_stat where p_date =?");

			pstmt.setString(1, date.format(today));

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pstmt = conn.prepareStatement("update point_stat set chcount=chcount+1, chprice=chprice+? where p_date = ?");
				
				pstmt.setInt(1, chprice);
				pstmt.setString(2, date.format(today));
				
				pstmt.executeUpdate();
			}else {
				pstmt = conn.prepareStatement("insert into point_stat values(?,1,0,?,0)");
				
				pstmt.setString(1, date.format(today));
				pstmt.setInt(2, chprice);
				
				pstmt.executeUpdate();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}
	
	public void UpdatepaymentEX(int exprice) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from point_stat where p_date =?");

			pstmt.setString(1, date.format(today));

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pstmt = conn.prepareStatement("update point_stat set excount=excount+1, exprice=exprice+? where p_date = ?");
				
				pstmt.setInt(1, exprice );
				pstmt.setString(2, date.format(today));
				
				pstmt.executeUpdate();
			}else {
				pstmt = conn.prepareStatement("insert into point_stat values(?,0,1,0,?)");
				
				pstmt.setString(1, date.format(today));
				pstmt.setInt(2, exprice);
				
				pstmt.executeUpdate();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}
	
	public ArrayList getpaymentStat() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList daylist = new ArrayList();
		PointStatDataBean psdb = null;
		int count = 0;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from point_stat");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				psdb = new PointStatDataBean();
				String d = rs.getString("p_date").split(" ")[0];
				String a = d.split("-")[1] + "/" + d.split("-")[2];
				
				psdb.setP_date(a);
				psdb.setChcount(rs.getInt("chcount"));
				psdb.setChprice(rs.getInt("chprice"));
				psdb.setExcount(rs.getInt("excount"));
				psdb.setExprice(rs.getInt("exprice"));
				
				daylist.add(psdb);
				count++;
				if (count == 3) {
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return daylist;
	}
}