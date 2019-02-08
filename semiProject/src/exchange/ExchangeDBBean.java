package exchange;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;



public class ExchangeDBBean {
	private static ExchangeDBBean instance = new ExchangeDBBean();

	// LogonDBBean m = LogonDBBean.getInstance();
	public static ExchangeDBBean getInstance() { //***
		return instance;
	}

	private ExchangeDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	public int getArticleCount() throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from exchange");
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

	public List getArticles(int start, int end) throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		List articleList = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select ex_num, ex_subject, ex_writer,bankname,ac_number,ac_holder,ex_point,ex_reg_date,ex_status"
							+ " from (select ex_num, ex_subject, ex_writer,bankname,ac_number,ac_holder,ex_point,ex_reg_date,ex_status,rownum r "
							+ "from exchange) where r >= ? and r<=?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList(end);
				
				do {
					ExchangeDataBean article = new ExchangeDataBean();
					
					article.setEx_num(rs.getInt("ex_num"));
					article.setEx_subject(rs.getString("ex_subject"));
					article.setEx_writer(rs.getString("ex_writer"));
					article.setBankname(rs.getString("bankname"));
					article.setAc_number(rs.getString("ac_number"));
					article.setAc_holder(rs.getString("ac_holder"));
					article.setEx_point(rs.getInt("ex_point"));
					article.setEx_reg_date(rs.getString("ex_reg_date"));
					article.setEx_status(rs.getString("ex_status"));

					articleList.add(article);
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
		return articleList;
	}


	
	public ExchangeDataBean getArticle(int ex_num) throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ExchangeDataBean article = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select ex_num, ex_subject, ex_writer,bankname,ac_number,ac_holder,ex_point,ex_reg_date,ex_status"
							+ " from exchange where ex_num = ?");
			pstmt.setInt(1, ex_num);
			rs = pstmt.executeQuery();
			article = new ExchangeDataBean();
			if (rs.next()) {
				article.setEx_num(rs.getInt("ex_num"));
				article.setEx_subject(rs.getString("ex_subject"));
				article.setEx_writer(rs.getString("ex_writer"));
				article.setBankname(rs.getString("bankname"));
				article.setAc_number(rs.getString("ac_number"));
				article.setAc_holder(rs.getString("ac_holder"));
				article.setEx_point(rs.getInt("ex_point"));
				article.setEx_reg_date(rs.getString("ex_reg_date"));
				article.setEx_status(rs.getString("ex_status"));

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
		return article;
	}
	
	public void updateMember(int ex_num) throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbpasswd = "";
		String sql = "";
		int x = -1;
		try {
			conn = getConnection();

				pstmt = conn.prepareStatement("update exchange set ex_status='환전완료' where ex_num = ?");
				pstmt.setInt(1, ex_num);
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


}
