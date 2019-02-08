package trade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TradeDBBean {
	private static TradeDBBean instance = new TradeDBBean();

	// LogonDBBean m = LogonDBBean.getInstance();
	public static TradeDBBean getInstance() { // ***
		return instance;
	}

	private TradeDBBean() {
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

			pstmt = conn.prepareStatement("select count(*) from blacklist");
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

	
	public List getMembers(int start, int end) throws Exception { // ***
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		List memberList = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select trade_num,b_id, tr_id, del_state, trade_point, trade_sdate, trade_edate, standby"
							+ " from (select trade_num,b_id, tr_id, del_state, trade_point, trade_sdate, trade_edate, standby, rownum r "
							+ "from trade) where r >= ? and r<=?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				memberList = new ArrayList(end);
				do {
					TradeDataBean member = new TradeDataBean();
					member.setTrade_num(Integer.parseInt(rs.getString("trade_num")));
					member.setB_id(rs.getString("b_id"));
					member.setTr_id(rs.getString("tr_id"));
					member.setDel_state(rs.getString("del_state"));
					member.setTrade_point(Integer.parseInt(rs.getString("trade_point")));
					member.setTrade_sdate(rs.getString("trade_sdate"));
					member.setTrade_edate(rs.getString("trade_edate"));
					member.setStandby(rs.getString("standby"));

					memberList.add(member);
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
		return memberList;
	}

	
	public void updateMember(int trade_num) throws Exception { // ***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("update trade set standby='T' where trade_num = ?");
			pstmt.setInt(1, trade_num);
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

	// KM
	public void inputInvoice_Number(int trade_num, String invoice_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update trade set invoice_num=?, del_state='배송중' where trade_num=?");
			pstmt.setString(1, invoice_num);
			pstmt.setInt(2, trade_num);
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

	// KM
	public String submitItem(int trade_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String db = "";
		try {
            conn=getConnection();
            pstmt=conn.prepareStatement("update trade set del_state='배송완료' where trade_num=? ");
            pstmt.setInt(1, trade_num);
            pstmt.executeUpdate();
            
            pstmt=conn.prepareStatement("select tr_id,trade_point from trade where trade_num = ?");
            pstmt.setInt(1, trade_num);
            rs = pstmt.executeQuery();
            if(rs.next()) {
            	db += rs.getString("tr_id");
            	db += "/";
            	db += rs.getInt("trade_point")+" ";
            }
            
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {

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
		return db;
	}


	// KM
	  public void cancelTrade(int trade_num) throws Exception{
		   
		   Connection conn=null;
		   PreparedStatement pstmt=null;
		   ResultSet rs=null;
		   ResultSet rs2=null;
		   try {
			   conn=getConnection();
			   
			   pstmt=conn.prepareStatement("select trade_point,b_id,tr_id from trade where trade_num=?");
			   pstmt.setInt(1, trade_num);//여기서 아예 내츄럴 조인으로 
			   rs=pstmt.executeQuery();
			   if(rs.next()) {			  
			   pstmt=conn.prepareStatement("delete from trade where trade_num=?");
			   pstmt.setInt(1, trade_num);
			   pstmt.executeUpdate();	   			   			   
			   pstmt=conn.prepareStatement("update member set point=point+? where id=?");
			   pstmt.setInt(1, rs.getInt("trade_point"));
			   pstmt.setString(2, rs.getString("b_id"));
			   pstmt.executeUpdate();
			   pstmt=conn.prepareStatement("select * from member where id=?");
			   pstmt.setString(1, rs.getString("b_id"));
			   rs2=pstmt.executeQuery();
			   if(rs2.next()) {
			   /*pstmt=conn.prepareStatement("update (select after_point, point, id from point  natural join member  where id=?) set after_point=point+?");*/
			   pstmt=conn.prepareStatement("insert into point values(point_seq.NEXTVAL,?,SYSDATE,'거래취소',?,?)");
			   pstmt.setString(1, rs.getString("b_id"));
			   
			   pstmt.setInt(2, rs.getInt("trade_point"));
			   pstmt.setInt(3, rs2.getInt("point"));//위에 member 업데이트 먼저해서 여기서는 포인트만 가져온다.
			   pstmt.executeUpdate();
			   }
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
	  public int pointUpdate(String id, int point) throws Exception {
			Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        int check = -1;
	        String str = "";
	        int current_point = 0;
	        try {
	        	conn = getConnection();
	        	
	        	str = "select point from member where id = ?";
	        	pstmt = conn.prepareStatement(str);
	        	pstmt.setString(1, id);
	        	rs = pstmt.executeQuery();
			
	        	if(rs.next()) {
	        		current_point = rs.getInt("point");
	        	}
	        	
	          	str = "update member set point = point+? where id=?";
		       	pstmt = conn.prepareStatement(str);
			
		       	pstmt.setInt(1,point);
		       	pstmt.setString(2, id);
			
		       	check = pstmt.executeUpdate();
			
		       	if(check == 1 ) {
		       		str = "insert into point values(point_seq.NEXTVAL, ?, sysdate, '판매', ?, ?)";
		       		pstmt = conn.prepareStatement(str);
		       		pstmt.setString(1,id);
		       		pstmt.setInt(2,point);
		       		pstmt.setInt(3, current_point+point);
		       	
		       		check = pstmt.executeUpdate();
		       	}
	        }catch(Exception ex) {
	            ex.printStackTrace();
	        } finally {
	        	if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	        }
	        
	        return check;
		}
	   
}