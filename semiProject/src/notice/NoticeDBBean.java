package notice;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.*;

public class NoticeDBBean {
	private static NoticeDBBean instance = new NoticeDBBean();
	
	public static NoticeDBBean getInstance() { //***
		return instance;
	}
	
	private NoticeDBBean() {
		
	}
	
	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	//writePro.jsp
	public void insertArticle(NoticeDataBean article) throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int number = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select max(n_num) from notice");
			rs = pstmt.executeQuery();
			
			 pstmt = conn.prepareStatement("insert into notice(n_num, n_subject, n_content, n_reg_date, n_readcount) values (notice_seq.NEXTVAL, ?, ?, ?, ?)");
			 pstmt.setString(1, article.getN_subject());
			 pstmt.setString(2, article.getN_content());
			 pstmt.setTimestamp(3, article.getN_reg_date());
			 pstmt.setInt(4, article.getN_readcount());
			 pstmt.executeUpdate(); 
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(rs !=null) {
				try {
					rs.close();
				} catch(SQLException ex) {}
			}
			
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch(SQLException ex) {}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException ex) {}
			}
		}
	}
	
	
	public int getArticleCount() throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int x = 0;
		
		try {
			conn = getConnection();
			
			
			pstmt = conn.prepareStatement("select count(*) from notice");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch(SQLException ex) {}
			}
			
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch(SQLException ex) {}
			}
			
			if(conn!=null) {
				try {
					pstmt.close();
				} catch(SQLException ex) {}
			}
		}
		return x;
	}
	
	
	public List getArticles(int start, int end) throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select  n_num, n_subject, n_content, n_reg_date, n_readcount from"
					+ "(select n_num, n_subject, n_content, n_reg_date, n_readcount, rownum r from notice order by n_num desc)"
					+ " where r >= ? and r <= ?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleList = new ArrayList(end);
				
				do {
					NoticeDataBean article = new NoticeDataBean();
					article.setN_num(rs.getInt("n_num"));
					article.setN_subject(rs.getString("n_subject"));
					article.setN_content(rs.getString("n_content"));
					article.setN_reg_date(rs.getTimestamp("n_reg_date"));
					article.setN_readcount(rs.getInt("n_readcount"));
					articleList.add(article);
					
				} while(rs.next());
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch(SQLException ex) {}
			}
			
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch(SQLException ex) {}
			}
			
			if(conn!=null) {
				try {
					conn.close();
				} catch(SQLException ex) {}
			}
		}
		return articleList;
	}
	
	//read.jsp: DB로부터 한줄의 데이터를 가져온다.
	public NoticeDataBean getArticle(int n_num) throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeDataBean article = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update notice set n_readcount = n_readcount+1 where n_num = ?");
			pstmt.setInt(1, n_num);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select * from notice where n_num = ?");
			pstmt.setInt(1, n_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				article = new NoticeDataBean();
				article.setN_num(rs.getInt("n_num"));
				article.setN_subject(rs.getString("n_subject"));
				article.setN_content(rs.getString("n_content"));
				article.setN_reg_date(rs.getTimestamp("n_reg_date"));
				article.setN_readcount(rs.getInt("n_readcount"));
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
			
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch(SQLException ex) {}
			}
			
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch(SQLException ex) {}
			}
			
			if(conn!=null) {
				try {
					conn.close();
				} catch(SQLException ex) {}
			}
		}
		return article;	
	}
	
	//updateFrom.jsp: 수정폼에 한줄의 데이터를 가져올 때.
	public NoticeDataBean updateGetArticle(int n_num) throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeDataBean article = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from notice where n_num = ?");
			pstmt.setInt(1, n_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				article = new NoticeDataBean();
				article.setN_num(rs.getInt("n_num"));
				article.setN_subject(rs.getString("n_subject"));
				article.setN_content(rs.getString("n_content"));
				article.setN_reg_date(rs.getTimestamp("n_reg_date"));
				article.setN_readcount(rs.getInt("n_readcount"));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch(SQLException ex) {}
			}
			
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch(SQLException ex) {}
			}
			
			if(conn!=null) {
				try {
					conn.close();
				} catch(SQLException ex) {}
			}
		}
		return article;
	}
	
	//updatePro.jsp: 실제 데이터를 수정하는 메소드
	public void updateArticle(NoticeDataBean article) throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql="";
	
		
		try {
			conn = getConnection();

					sql = "update notice set n_subject=?, n_content=?";
					sql += "where n_num = ?";
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, article.getN_subject());
					pstmt.setString(2, article.getN_content());
					
					
					pstmt.setInt(3, article.getN_num());
					pstmt.executeUpdate();

		} catch(Exception ex) {
			ex.printStackTrace();
			
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch(SQLException ex) {}
			}
			
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch(SQLException ex) {}
			}
			
			if(conn!=null) {
				try {
					conn.close();
				} catch(SQLException ex) {}
			}
		}

	}
	
	//deleteFrom.jsp: 실제 데이터를 삭제하는 메소드
	public int deleteArticle(int n_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from notice where n_num=?");
			pstmt.setInt(1, n_num);
			pstmt.executeUpdate();

		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch(SQLException ex) {}
			}
			
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch(SQLException ex) {}
			}
			
			if(conn!=null) {
				try {
					conn.close();
				} catch(SQLException ex) {}
			}
		}
		return x;
	}
	
	
}
