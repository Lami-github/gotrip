package ad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import point.PointDataBean;



public class AdDBBean {
	private static AdDBBean instance = new AdDBBean();

	// LogonDBBean m = LogonDBBean.getInstance();
	public static AdDBBean getInstance() { //***
		return instance;
	}

	private AdDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	public int getAdCount() throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from ad");
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

	public List getAds(int start, int end) throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		List adList = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select ad_id,ad_loc, photo_id, ad_sdate, ad_edate, ad_company, ad_price"
							+ " from (select ad_id,ad_loc, photo_id, ad_sdate, ad_edate, ad_company, ad_price,rownum r "
							+ "from ad) where r >= ? and r<=?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				adList = new ArrayList(end);
				do {
					AdDataBean ad = new AdDataBean();
					ad.setAd_id(rs.getInt("ad_id"));
					ad.setAd_loc(rs.getString("ad_loc"));
					ad.setPhoto_id(rs.getInt("photo_id"));
					ad.setAd_sdate(rs.getString("ad_sdate"));
					ad.setAd_edate(rs.getString("ad_edate"));
					ad.setAd_company(rs.getString("ad_company"));
					ad.setAd_price(rs.getString("ad_price"));
					

					adList.add(ad);
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
		return adList;
	}

	// modifyPro.jsp

	public int getAdCount(int n, String searchKeyword) throws Exception { //***

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String[] column_name = { "ad_loc", "ad_company", "ad_sdate", "ad_edate" };

		int x = 0;

		try {
			conn = getConnection();
				pstmt = conn.prepareStatement("select count (*) from ad " + "where " + column_name[n] + " like '%"
						+ searchKeyword + "%'");

			
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

	public List getAds(int start, int end, int n, String searchKeyword) throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		List adList = null;

		String[] column_name = { "ad_loc", "ad_company", "ad_sdate", "ad_edate" };

		try {
			conn = getConnection();

			String sql = "select ad_id,ad_loc, photo_id, ad_sdate, ad_edate, ad_company, ad_price" + 
					" from (select ad_id,ad_loc, photo_id, ad_sdate, ad_edate, ad_company, ad_price, rownum r "
					+ "from ad) where " + column_name[n] + " like '%" + searchKeyword + "%'  and r >= ? and r <= ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				adList=new ArrayList(end);
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				do {
				AdDataBean ad = new AdDataBean();
				System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbb");
				ad.setAd_id(rs.getInt("ad_id"));
				System.out.println(rs.getInt("ad_id"));
				ad.setAd_loc(rs.getString("ad_loc"));
				System.out.println(rs.getString("ad_loc"));
				ad.setPhoto_id(rs.getInt("photo_id"));
				ad.setAd_sdate(rs.getString("ad_sdate"));
				ad.setAd_edate(rs.getString("ad_edate"));
				ad.setAd_company(rs.getString("ad_company"));
				ad.setAd_price(rs.getString("ad_price"));
				adList.add(ad);
				}while(rs.next());

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

		return adList;
	}
	
	
	
	public void UpdateAd(AdDataBean member,String check) throws Exception { //***
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	     
	      
	      try {
	         conn = getConnection();
	        
	         if (check.equals("insert")) {
					pstmt = conn.prepareStatement("insert into ad(ad_id,ad_loc,ad_sdate,ad_edate,ad_company,ad_price) "
							+ "values(ad_num.NEXTVAL,?,?,?,?,?)");
					pstmt.setString(1, member.getAd_loc());
					pstmt.setString(2, member.getAd_sdate());
					pstmt.setString(3, member.getAd_edate());
					pstmt.setString(4, member.getAd_company());
					pstmt.setString(5, member.getAd_price());
					pstmt.executeUpdate();
		
			
	         }
	         else {
	  
	            pstmt = conn.prepareStatement("delete ad where ad_id=?");
	            pstmt.setInt(1, member.getAd_id());
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


}
