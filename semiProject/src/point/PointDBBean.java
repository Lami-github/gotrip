package point;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import blacklist.BlacklistDataBean;

public class PointDBBean {
	private static PointDBBean instance = new PointDBBean();

	// LogonDBBean m = LogonDBBean.getInstance();
	public static PointDBBean getInstance() { // ***
		return instance;
	}

	private PointDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	public int getMemberCount() throws Exception { // ***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from point where type ='결제' or type='환전'");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
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
		return x;
	}

	public int getMemberCount(int n, String searchKeyword) throws Exception { // ***

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String[] column_name = { "id", "update_date" };

		int x = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count (*) from point " + "where " + column_name[n] + " like '%"
					+ searchKeyword + "%' and(type ='결제' or type='환전')");

			rs = pstmt.executeQuery();

			if (rs.next())
				x = rs.getInt(1);
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
		return x;
	}

	public List getMembers(int start, int end) throws Exception { // ***
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		List pointList = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select num,id, update_date, update_point,type from (select num,id, update_date, update_point,type,rownum r from point) "
							+ "where r >= ? and r<=? and (type='환전' or type='결제')");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				pointList = new ArrayList(end);

				do {

					PointDataBean point = new PointDataBean();
					point.setNum(rs.getInt("num"));
					point.setId(rs.getString("id"));
					point.setUpdate_date(rs.getString("update_date"));
					point.setUpdate_point(rs.getInt("update_point"));
					point.setType(rs.getString("type"));

					pointList.add(point);
				} while (rs.next());
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
		return pointList;
	}


	public List getMembers(int start, int end, int n, String searchKeyword) throws Exception { // ***
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		List pointList = null;

		String[] column_name = { "id", "update_date" };

		try {
			conn = getConnection();

			String sql = "select num, id, update_point, type, update_date from"
					+ "(select num,id, update_date, update_point,type,rownum r from point) " + "where " + column_name[n]
					+ " like '%" + searchKeyword + "%'  and " + "r >= ? and r <= ? and (type='환전' or type='결제')";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			do {
				PointDataBean member = new PointDataBean();

				member.setNum(rs.getInt("num"));
				member.setId(rs.getString("id"));
				member.setUpdate_point(rs.getInt("update_point"));
				member.setType(rs.getString("type"));
				member.setUpdate_date(rs.getString("update_date"));

				pointList.add(member);
			} while (rs.next());

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

		return pointList;
	}


	public void UpdatePoint(PointDataBean member, String check) throws Exception { // ***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int current_point = 0;
		int update_point = 0;
		int after_point = 0;
		String type = "";
		String id = "";

		try {
			conn = getConnection();

			if (check.equals("insert")) {
				pstmt = conn.prepareStatement("select point from member where id = ?");
				pstmt.setString(1, member.getId());
				rs = pstmt.executeQuery();
				if (rs.next()) {
					current_point = rs.getInt("point");
				}
				type = member.getType();
				if (type.equals("결제")) {
					after_point = current_point + member.getUpdate_point();
					pstmt = conn.prepareStatement("insert into point values(point_seq.NEXTVAL,?,?,?,?,?)");
					pstmt.setString(1, member.getId());
					pstmt.setString(2, member.getUpdate_date());
					pstmt.setString(3, member.getType());
					pstmt.setInt(4, member.getUpdate_point());
					pstmt.setInt(5, after_point);
					pstmt.executeUpdate();

					pstmt = conn.prepareStatement("update member set point=? where id=?");
					pstmt.setInt(1, after_point);
					pstmt.setString(2, member.getId());
					pstmt.executeUpdate();
				} else if (type.equals("환전")) {
					after_point = current_point - member.getUpdate_point();
					pstmt = conn.prepareStatement("insert into point values(point_seq.NEXTVAL,?,?,?,?,?)");
					pstmt.setString(1, member.getId());
					pstmt.setString(2, member.getUpdate_date());
					pstmt.setString(3, member.getType());
					pstmt.setInt(4, member.getUpdate_point());
					pstmt.setInt(5, current_point - member.getUpdate_point());
					pstmt.executeUpdate();

					pstmt = conn.prepareStatement("update member set point=? where id=?");
					pstmt.setInt(1, after_point);
					pstmt.setString(2, member.getId());
					pstmt.executeUpdate();
				}
			} else {
				pstmt = conn.prepareStatement("select id,type,update_point from point where num=?");
				pstmt.setInt(1, member.getNum());
				rs = pstmt.executeQuery();
				if (rs.next()) {
					type = rs.getString("type");
					id = rs.getString("id");
					update_point = rs.getInt("update_point");
				}
				pstmt = conn.prepareStatement("select point from member where id = ?");
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					current_point = rs.getInt("point");
				}
				System.out.println(type);
				if (type.equals("결제")) {
					after_point = current_point - update_point;
					System.out.println(after_point);
					pstmt = conn.prepareStatement("update member set point=? where id=?");
					pstmt.setInt(1, after_point);
					pstmt.setString(2, id);
					pstmt.executeUpdate();
				} else if (type.equals("환전")) {
					after_point = current_point + update_point;
					pstmt = conn.prepareStatement("update member set point=? where id=?");
					pstmt.setInt(1, after_point);
					pstmt.setString(2, id);
					pstmt.executeUpdate();
				}
				pstmt = conn.prepareStatement("delete point where num=?");
				pstmt.setInt(1, member.getNum());
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

	//KM
	 public void updatePoint(String id) throws Exception{
		   Connection conn=null;
		   PreparedStatement pstmt = null;
		   ResultSet rs = null;
		   ResultSet rs2=null;
		   int x=0;
		   try {
			   
			   conn=getConnection();
			   pstmt=conn.prepareStatement("select trade_num,trade_point from trade where tr_id=? and sysdate >=trade_sdate+7 and standby='f'");
			   pstmt.setString(1, id);
			   rs=pstmt.executeQuery();
			 if(rs.next()) {  
			   pstmt=conn.prepareStatement("update member set point=point+?");
			   pstmt.setInt(1, rs.getInt("trade_point"));//where trade_edate between trunc(trade_edate) and trunc(trade_edate)+30;
			   pstmt.executeUpdate();
			   x=1;
		if(x==1) {
			pstmt=conn.prepareStatement("select point from member where id=?");
			pstmt.setString(1, id);
			rs2=pstmt.executeQuery();
		if(rs2.next()) {	
			pstmt=conn.prepareStatement("insert into point values(point_seq.NEXTVAL,?,sysdate,'판매',?,?)");
			pstmt.setString(1, id);
			pstmt.setInt(2, rs.getInt("trade_point"));
			pstmt.setInt(3, rs2.getInt("point"));
			pstmt.executeUpdate();
			
			pstmt=conn.prepareStatement("delete from trade where trade_num=?");
			pstmt.setInt(1, rs.getInt("trade_num"));
			pstmt.executeUpdate();
		}}
			 }
		   }
		   
		   catch(Exception ex) {
				ex.printStackTrace();
				
				
			}finally {
				if(rs!=null)try {rs.close();}catch(SQLException ex) {}
				if(rs2!=null)try {rs2.close();}catch(SQLException ex) {}
				if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
				if(conn!=null)try {conn.close();}catch(SQLException ex) {}
			}

			}
	   public void updatePoint1(String id) throws Exception{
		   Connection conn=null;
		   PreparedStatement pstmt=null;
		   ResultSet rs = null;
		   ResultSet rs2 = null;
		   int x=0;
		   try {
			   conn=getConnection();
			   pstmt=conn.prepareStatement("select trade_num,trade_point from trade where tr_id=? and del_state='배송완료' and standby='f'");
			   pstmt.setString(1, id);
			   rs=pstmt.executeQuery();
			 if(rs.next()) {  
			   pstmt=conn.prepareStatement("update member set point=point+?");
			   pstmt.setInt(1, rs.getInt("trade_point"));
			   pstmt.executeUpdate();
			   x=1;
			   if(x==1) {
					pstmt=conn.prepareStatement("select point from member where id=?");
					pstmt.setString(1, id);
					rs2=pstmt.executeQuery();
					if(rs2.next()) {	
						pstmt=conn.prepareStatement("insert into point values(point_seq.NEXTVAL,?,sysdate,'판매',?,?)");
						pstmt.setString(1, id);
						pstmt.setInt(2, rs.getInt("trade_point"));
						pstmt.setInt(3, rs2.getInt("point"));
						pstmt.executeUpdate();
			  pstmt=conn.prepareStatement("delete from trade where trade_num=?");
			  pstmt.setInt(1, rs.getInt("trade_num"));
			  pstmt.executeUpdate();
		  }}
			 }
		   }catch(Exception ex) {
				ex.printStackTrace();
				
				
			}finally {
				if(rs!=null)try {rs.close();}catch(SQLException ex) {}
				if(rs2!=null)try {rs2.close();}catch(SQLException ex) {}
				if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
				if(conn!=null)try {conn.close();}catch(SQLException ex) {}
			}
		   
			
		   
		   
	   }
	   

}
