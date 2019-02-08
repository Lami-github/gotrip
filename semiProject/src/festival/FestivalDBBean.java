package festival;

import java.sql.*;
import javax.sql.*;

import buyer.BuyerDataBean;

import javax.naming.*;
import javax.servlet.http.HttpServlet;
import java.util.*;

public class FestivalDBBean{   
    private static FestivalDBBean instance = new FestivalDBBean();
   
    public static FestivalDBBean getInstance() {
        return instance;
    }
   
    private FestivalDBBean() {
    }
   
    private Connection getConnection() throws Exception {
    String jdbcDriver = "jdbc:apache:commons:dbcp:pool";         
        return DriverManager.getConnection(jdbcDriver);
    }
    
    
    
   
	// list.jsp : 페이징을 위해서 전체 DB에 입력된 행의수가 필요하다...!!!
	public int getArticleCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from festival");
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
	
	public int getArticleCount(int n, String searchKeyword) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String[] column_name = { "tr_subject", "tr_writer", "tr_content"};

		int x = 0;

		try {
			conn = getConnection();
				pstmt = conn.prepareStatement("select count (*) from traveler " + "where " + column_name[n] + " like '%"
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

	// list.jsp ==> Paging!!! DB로부터 여러행을 결과로 받는다.
	public List getArticles(int start, int end) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String[] photos;
		List articleList = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select f_num,f_subject,f_sdate,f_edate,f_loc,f_country,f_url,f_content,f_readcount,photo_id from"
					+ "(select f_num,f_subject,f_sdate,f_edate,f_loc,f_country,f_url,f_content,f_readcount,photo_id,rownum r from festival) where r >= ? and r <= ? ");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			

			if (rs.next()) {
				articleList = new ArrayList(end);
				
				do {
					pstmt = conn.prepareStatement("select img from photo where photo_id=? ");
					photos = rs.getString("photo_id").split(" ");
					pstmt.setInt(1, Integer.parseInt(photos[0]));
					System.out.println("photos[0]: " + photos[0]);
					rs2 = pstmt.executeQuery();
					if(rs2.next()) {
					FestivalDataBean article = new FestivalDataBean();
					article.setF_num(rs.getInt("f_num"));
					article.setF_subject(rs.getString("f_subject"));
					article.setF_sdate(rs.getString("f_sdate"));
					article.setF_edate(rs.getString("f_edate"));
					article.setF_loc(rs.getString("f_loc"));
					article.setF_country(rs.getString("f_country"));
					article.setF_url(rs.getString("f_url"));
					article.setF_content(rs.getString("f_content"));
					article.setF_readcount(rs.getInt("f_readcount"));
					article.setPhoto_id(rs.getString("photo_id"));
					article.setMain_img(rs2.getString("img"));
					System.out.println("main_img: "+rs2.getString("img"));
					

					articleList.add(article);
					}
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

	public List getArticles(int start, int end, int n, String searchKeyword) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;

		String[] column_name = { "tr_subject", "tr_writer", "tr_content"};

		try {
			conn = getConnection();

			String sql = "select tr_num,tr_subject,tr_writer,tr_reg_date from"
					+ "(select tr_num,tr_subject,tr_writer,tr_reg_date,tr_content, rownum r from traveler) "
					+ "where " + column_name[n] + " like '%" + searchKeyword + "%'  and r >= ? and r <= ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList(end);
				do {
					FestivalDataBean article = new FestivalDataBean();
					

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
	
	public FestivalDataBean getArticle(int f_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2=null;
		FestivalDataBean article = new FestivalDataBean();
		String[] photos;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update festival set f_readcount=f_readcount+1 where f_num=?");
			pstmt.setInt(1, f_num);
			pstmt.executeUpdate();
			conn.commit();

			String sql = "select f_subject,f_sdate,f_edate,f_loc,f_country,f_url,f_content,f_readcount,photo_id "
					+ "from festival where  f_num=? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, f_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					pstmt = conn.prepareStatement("select img from photo where photo_id=? ");
					photos = rs.getString("photo_id").split(" ");
					pstmt.setInt(1, Integer.parseInt(photos[0]));
					System.out.println("photos[0]: " + photos[0]);
					rs2 = pstmt.executeQuery();
					if(rs2.next()) {
					article.setF_num(f_num);
					article.setF_subject(rs.getString("f_subject"));
					article.setF_sdate(rs.getString("f_sdate"));
					article.setF_edate(rs.getString("f_edate"));
					article.setF_loc(rs.getString("f_loc"));
					article.setF_url(rs.getString("f_url"));
					article.setF_country(rs.getString("f_country"));
					article.setF_content(rs.getString("f_content"));
					article.setF_readcount(Integer.parseInt(rs.getString("f_readcount")));
					article.setPhoto_id(rs.getString("photo_id"));
					article.setMain_img(rs2.getString("img"));
					}
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

		return article;
	}

	public void insertArticle(FestivalDataBean article) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		String photo_id="";

		try {
			conn = getConnection();
			// 쿼리를 작성
			sql = "insert into festival(f_num,f_subject,f_sdate,f_edate,f_loc,f_country,f_url,f_content,photo_id) values(f_num.nextval,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getF_subject());
			pstmt.setString(2, article.getF_sdate());
			pstmt.setString(3, article.getF_edate());
			pstmt.setString(4, article.getF_loc());
			pstmt.setString(5, article.getF_country());
			pstmt.setString(6, article.getF_url());
			pstmt.setString(7, article.getF_content());
			pstmt.setString(8, article.getPhoto_id());
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

	public void deleteArticle(int f_num,String[] photos) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;

		try {
			conn = getConnection();
			// 쿼리를 작성
			for(int i=0; i<photos.length; i++) {
				pstmt = conn.prepareStatement("delete from photo where photo_id=?");
				pstmt.setString(1,photos[i]);
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