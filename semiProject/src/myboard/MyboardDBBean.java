package myboard;

import java.sql.*;
import java.util.*;
import myboard.*;

public class MyboardDBBean {
	private static MyboardDBBean instance = new MyboardDBBean();

	public static MyboardDBBean getInstance() {
		return instance;
	}

	private MyboardDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	public int allGetArticleCount(String id) throws Exception {
		 Connection conn = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     String str = "";
	     int count=0;

	     try {
	         conn = getConnection();
	         str = "select count(*) from tripreview where t_writer='"+id+"'";
	         pstmt = conn.prepareStatement(str);
	         rs = pstmt.executeQuery();
	         if (rs.next()) {
	            count += rs.getInt(1);
	         }
	         
	         str = "select count(*) from traveler where tr_writer='"+id+"'";
	         pstmt = conn.prepareStatement(str);
	         rs = pstmt.executeQuery();
	         if (rs.next()) {
	            count += rs.getInt(1);
	         }
	         
	         str = "select count(*) from buyer where b_writer='"+id+"'";
	         pstmt = conn.prepareStatement(str);
	         rs = pstmt.executeQuery();
	         if (rs.next()) {
	            count += rs.getInt(1);
	         }
	        
	     } catch(Exception ex) {
	         ex.printStackTrace();
	     } finally {
	         if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	         if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	         if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	     }
	     return count;
	}

	public List allGetArticle(String id, int start, int end) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String str="";
		List articleList=null; 
		/*List<String, List> allList =new ArrayList<>();*/
		
		try {
			conn = getConnection();
			str= "select *  from ( select t_num,t_writer,t_subject,t_reg_date,t_readcount,rownum r from ( select * from tripreview where t_writer = ? order by t_num desc) order by t_num desc) where r >= ? and r <= ?";
			pstmt = conn.prepareStatement(str);
			
			pstmt.setString(1, id);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();

			while(rs.next()) {
				GetArticleDataBean gadb = new GetArticleDataBean();
				gadb.setNum(rs.getInt("t_num"));
				gadb.setWriter(rs.getString("t_writer"));
				gadb.setSubject(rs.getString("t_subject"));
				gadb.setReg_date(rs.getString("t_reg_date"));
				gadb.setReadcount(rs.getInt("t_readcount"));	
				articleList.add(gadb);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			 if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	         if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	         if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		
		return articleList;
	}
	
	public int allGetcommentCount(String id) throws Exception {
		Connection conn = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     String str = "";
	     int count=0;

	     try {
	    	 conn = getConnection();
	         str = "select count(*) from tripreviewcomment where tc_writer='"+id+"'";
	         pstmt = conn.prepareStatement(str);
	         rs = pstmt.executeQuery();
	         if (rs.next()) {
	            count += rs.getInt(1);
	         }
	         
	         str = "select count(*) from traveler_comment where trc_writer='"+id+"'";
	         pstmt = conn.prepareStatement(str);
	         rs = pstmt.executeQuery();
	         if (rs.next()) {
	            count += rs.getInt(1);
	         }
	         
	         str = "select count(*) from buyer_comment where bc_writer='"+id+"'";
	         pstmt = conn.prepareStatement(str);
	         rs = pstmt.executeQuery();
	         if (rs.next()) {
	            count += rs.getInt(1);
	         }
	         
	     } catch(Exception ex) {
	         ex.printStackTrace();
	     } finally {
	         if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	         if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	         if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	     }
	     return count;
	}
	
	
	
	public List allGetcomment(String id, int start, int end) throws Exception {
		List commentlist = null;
		
		return commentlist;
				
	}
	
	
	
	public int TripreviewArticleCount(String id) throws Exception {
		 Connection conn = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     String str = "";
	     int count=0;

	     try {
	         conn = getConnection();
	         str = "select count(*) from tripreview where t_writer='"+id+"'";
	         pstmt = conn.prepareStatement(str);
	         rs = pstmt.executeQuery();
	         if (rs.next()) {
	            count += rs.getInt(1);
	         }
	     } catch(Exception ex) {
	         ex.printStackTrace();
	     } finally {
	         if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	         if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	         if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	     }
	     return count;
	}
	
	public List TripreviewGetArticle(String id, int start, int end) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String str="";
		List articleList=null; 
		try {
			conn = getConnection();
			str= "select *  from ( select t_num,t_writer,t_subject,t_reg_date,t_readcount,rownum r from ( select * from tripreview where t_writer = ? order by t_num desc) order by t_num desc) where r >= ? and r <= ?";
			pstmt = conn.prepareStatement(str);
			
			pstmt.setString(1, id);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			articleList = new ArrayList(end);
			
			while(rs.next()) {
				GetArticleDataBean gadb = new GetArticleDataBean();
				gadb.setNum(rs.getInt("t_num"));
				gadb.setWriter(rs.getString("t_writer"));
				gadb.setSubject(rs.getString("t_subject"));
				gadb.setReg_date(rs.getString("t_reg_date"));
				gadb.setReadcount(rs.getInt("t_readcount"));	
				articleList.add(gadb);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			 if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	         if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	         if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return articleList;
	}
	
	
	public int TravelerArticleCount(String id) throws Exception {
		 Connection conn = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     String str = "";
	     int count=0;

	     try {
	         conn = getConnection();
	         str = "select count(*) from traveler where tr_writer='"+id+"'";
	         pstmt = conn.prepareStatement(str);
	         rs = pstmt.executeQuery();
	         if (rs.next()) {
	            count += rs.getInt(1);
	         }
	     } catch(Exception ex) {
	         ex.printStackTrace();
	     } finally {
	         if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	         if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	         if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	     }
	     return count;
	}
	
	public List TravelerGetArticle(String id, int start, int end) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String str="";
		List articleList=null; 
		try {
			conn = getConnection();
			str= "select *  from ( select tr_num,tr_writer,tr_subject,tr_reg_date,tr_readcount,rownum r from ( select * from traveler where tr_writer = ? order by tr_num desc) order by tr_num desc) where r >= ? and r <= ?";
			pstmt = conn.prepareStatement(str);
			
			pstmt.setString(1, id);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			articleList = new ArrayList(end);
			
			while(rs.next()) {
				GetArticleDataBean gadb = new GetArticleDataBean();
				gadb.setNum(rs.getInt("tr_num"));
				gadb.setWriter(rs.getString("tr_writer"));
				gadb.setSubject(rs.getString("tr_subject"));
				gadb.setReg_date(rs.getString("tr_reg_date"));
				gadb.setReadcount(rs.getInt("tr_readcount"));	
				articleList.add(gadb);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			 if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	         if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	         if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return articleList;
	}
	
	public int BuyerArticleCount(String id) throws Exception {
		 Connection conn = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     String str = "";
	     int count=0;

	     try {
	         conn = getConnection();
	         str = "select count(*) from buyer where b_writer='"+id+"'";
	         pstmt = conn.prepareStatement(str);
	         rs = pstmt.executeQuery();
	         if (rs.next()) {
	            count += rs.getInt(1);
	         }
	     } catch(Exception ex) {
	         ex.printStackTrace();
	     } finally {
	         if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	         if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	         if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	     }
	     return count;
	}
	
	public List BuyerGetArticle(String id, int start, int end) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String str="";
		List articleList=null; 
		try {
			conn = getConnection();
			str= "select *  from ( select b_num,b_writer,b_subject,b_reg_date,b_readcount,rownum r from ( select * from buyer where b_writer = ? order by b_num desc) order by b_num desc) where r >= ? and r <= ?";
			pstmt = conn.prepareStatement(str);
			
			pstmt.setString(1, id);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			articleList = new ArrayList(end);
			
			while(rs.next()) {
				GetArticleDataBean gadb = new GetArticleDataBean();
				gadb.setNum(rs.getInt("b_num"));
				gadb.setWriter(rs.getString("b_writer"));
				gadb.setSubject(rs.getString("b_subject"));
				gadb.setReg_date(rs.getString("b_reg_date"));
				gadb.setReadcount(rs.getInt("b_readcount"));	
				articleList.add(gadb);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			 if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	         if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	         if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return articleList;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////   COMMENT   ///////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public int TripreviewCommentCount(String id) throws Exception {
		 Connection conn = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     String str = "";
	     int count=0;

	     try {
	         conn = getConnection();
	         str = "select count(*) from tripreviewcomment where tc_writer='"+id+"'";
	         pstmt = conn.prepareStatement(str);
	         rs = pstmt.executeQuery();
	         if (rs.next()) {
	            count += rs.getInt(1);
	         }
	     } catch(Exception ex) {
	         ex.printStackTrace();
	     } finally {
	         if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	         if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	         if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	     }
	     return count;
	}
	
	public List TripreviewGetComment(String id, int start, int end) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String str="";
		List commentList=null; 
		try {
			conn = getConnection();
			str= "select *  from ( select tc_num,t_num,tc_writer,tc_comment,tc_reg_date,rownum r from ( select * from tripreviewcomment where tc_writer = ? order by tc_num desc) order by tc_num desc) where r >= ? and r <= ?";
			pstmt = conn.prepareStatement(str);
			
			pstmt.setString(1, id);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			commentList = new ArrayList(end);
			
			while(rs.next()) {
				GetCommentDataBean gcdb = new GetCommentDataBean();
				gcdb.setCommentnum(rs.getInt("tc_num"));
				gcdb.setArticlenum(rs.getInt("t_num"));
				gcdb.setWriter(rs.getString("tc_writer"));
				gcdb.setComment(rs.getString("tc_comment"));
				gcdb.setDate(rs.getString("tc_reg_date"));	
				commentList.add(gcdb);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			 if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	         if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	         if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return commentList;
	}
	
	
	public int TravelerCommentCount(String id) throws Exception {
		 Connection conn = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     String str = "";
	     int count=0;

	     try {
	         conn = getConnection();
	         str = "select count(*) from traveler_comment where trc_writer='"+id+"'";
	         pstmt = conn.prepareStatement(str);
	         rs = pstmt.executeQuery();
	         if (rs.next()) {
	            count += rs.getInt(1);
	         }
	     } catch(Exception ex) {
	         ex.printStackTrace();
	     } finally {
	         if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	         if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	         if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	     }
	     return count;
	}
	
	public List TravelerGetComment(String id, int start, int end) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String str="";
		List commentList=null; 
		try {
			conn = getConnection();
			str= "select *  from ( select trc_num,tr_num,trc_writer,trc_comment,trc_reg_date,rownum r from ( select * from traveler_comment where trc_writer = ? order by trc_num desc) order by trc_num desc) where r >= ? and r <= ?";
			pstmt = conn.prepareStatement(str);
			
			pstmt.setString(1, id);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			commentList = new ArrayList(end);
			
			while(rs.next()) {
				GetCommentDataBean gcdb = new GetCommentDataBean();
				gcdb.setCommentnum(rs.getInt("trc_num"));
				gcdb.setArticlenum(rs.getInt("tr_num"));
				gcdb.setWriter(rs.getString("trc_writer"));
				gcdb.setComment(rs.getString("trc_comment"));
				gcdb.setDate(rs.getString("trc_reg_date"));	
				commentList.add(gcdb);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			 if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	         if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	         if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return commentList;
	}
	
	public int BuyerCommentCount(String id) throws Exception {
		 Connection conn = null;
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     String str = "";
	     int count=0;

	     try {
	         conn = getConnection();
	         str = "select count(*) from buyer_comment where bc_writer='"+id+"'";
	         pstmt = conn.prepareStatement(str);
	         rs = pstmt.executeQuery();
	         if (rs.next()) {
	            count += rs.getInt(1);
	         }
	     } catch(Exception ex) {
	         ex.printStackTrace();
	     } finally {
	         if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	         if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	         if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	     }
	     return count;
	}
	
	public List BuyerGetComment(String id, int start, int end) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String str="";
		List commentList=null; 
		try {
			conn = getConnection();
			str= "select *  from ( select bc_num,b_num,bc_writer,bc_comment,bc_reg_date,rownum r from ( select * from buyer_comment where bc_writer = ? order by bc_num desc) order by bc_num desc) where r >= ? and r <= ?";
			pstmt = conn.prepareStatement(str);
			
			pstmt.setString(1, id);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			commentList = new ArrayList(end);
			
			while(rs.next()) {
				GetCommentDataBean gcdb = new GetCommentDataBean();
				gcdb.setCommentnum(rs.getInt("bc_num"));
				gcdb.setArticlenum(rs.getInt("b_num"));
				gcdb.setWriter(rs.getString("bc_writer"));
				gcdb.setComment(rs.getString("bc_comment"));
				gcdb.setDate(rs.getString("bc_reg_date"));		
				commentList.add(gcdb);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			 if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	         if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	         if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return commentList;
	}
}
