package Qna;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.*;

public class QnaDBBean {
	private static QnaDBBean instance = new QnaDBBean();
	
	public static QnaDBBean getInstance() { //***
		return instance;
	}
	
	private QnaDBBean() {
		
	}
	
	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	//writePro.jsp
	public void insertArticle(QnaDataBean article) throws Exception { 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int number = 0;

		try {
			conn = getConnection();
			
			
			 pstmt = conn.prepareStatement("insert into qna(q_num, q_subject, q_type,q_content, q_reg_date, q_readcount) values (qna_seq.NEXTVAL, ?, '결제',?, sysdate, 0)");
			 pstmt.setString(1, article.getQ_subject());
			 pstmt.setString(2, article.getQ_content());
			
			 
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
			
			
			pstmt = conn.prepareStatement("select count(*) from qna");
			
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
			pstmt = conn.prepareStatement("select  q_num, q_subject, q_content, q_reg_date, q_readcount from"
					+ "(select q_num, q_subject, q_content, q_reg_date, q_readcount, rownum r from qna order by q_num desc)"
					+ " where r >= ? and r <= ?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleList = new ArrayList(end);
				
				do {
					QnaDataBean article = new QnaDataBean();
					article.setQ_num(rs.getInt("q_num"));
					article.setQ_subject(rs.getString("q_subject"));
					article.setQ_content(rs.getString("q_content"));
					article.setQ_reg_date(rs.getString("q_reg_date"));
					article.setQ_readcount(rs.getInt("q_readcount"));
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
	public QnaDataBean getArticle(int q_num) throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QnaDataBean article = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update qna set q_readcount = q_readcount+1 where q_num = ?");
			pstmt.setInt(1, q_num);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select * from qna where q_num = ?");
			pstmt.setInt(1, q_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				article = new QnaDataBean();
				article.setQ_num(rs.getInt("q_num"));
				article.setQ_subject(rs.getString("q_subject"));
				article.setQ_content(rs.getString("q_content"));
				article.setQ_reg_date(rs.getString("q_reg_date"));
				article.setQ_readcount(rs.getInt("q_readcount"));
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
	public QnaDataBean updateGetArticle(int n_num) throws Exception { 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QnaDataBean article = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from qna where q_num = ?");
			pstmt.setInt(1, n_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				article = new QnaDataBean();
				article.setQ_num(rs.getInt("q_num"));
				article.setQ_subject(rs.getString("q_subject"));
				article.setQ_content(rs.getString("q_content"));
				article.setQ_reg_date(rs.getString("q_reg_date"));
				article.setQ_readcount(rs.getInt("q_readcount"));
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
	public void updateArticle(QnaDataBean article) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql="";
	
		
		try {
			conn = getConnection();

					sql = "update qna set q_subject=?, q_content=?";
					sql += "where q_num = ?";
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, article.getQ_subject());
					pstmt.setString(2, article.getQ_content());
					pstmt.setInt(3, article.getQ_num());
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
	public int deleteArticle(int q_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from qna where q_num=?");
			pstmt.setInt(1, q_num);
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
