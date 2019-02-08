package tripreview.comment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TripreViewCommentDBBean {
	private static TripreViewCommentDBBean instance = new TripreViewCommentDBBean();

	public static TripreViewCommentDBBean getInstance() {
		return instance;
	}
	private TripreViewCommentDBBean() {
	}
	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	public int getTripreViewCommentCount(int t_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from tripreviewcomment where t_num = ?");
			pstmt.setInt(1, t_num);
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
	
	public List getTripreViewComment( int t_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List tripreViewCommentList = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select tc_num,t_num,tc_writer,tc_comment,tc_reg_date,r "
							+ "from (select tc_num,t_num,tc_writer,tc_comment,tc_reg_date,rownum r "
							+ "from (select * "
							+ "from tripreviewcomment where t_num = ? order by t_num desc) order by t_num desc)");
			pstmt.setInt(1, t_num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				tripreViewCommentList = new ArrayList();
				do {
					TripreViewCommentDataBean tripreViewComment = new TripreViewCommentDataBean();
					tripreViewComment.setTc_num(rs.getInt("tc_num"));
					tripreViewComment.setT_num(rs.getInt("t_num"));
					tripreViewComment.setTc_writer(rs.getString("tc_writer"));
					tripreViewComment.setTc_reg_date(rs.getString("tc_reg_date"));
					tripreViewComment.setTc_comment(rs.getString("tc_comment"));
					
					tripreViewCommentList.add(tripreViewComment);
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
		return tripreViewCommentList;
	}
	
	public void setTripreViewComment(String id, int t_num,String commentText) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = getConnection();
				
			String sql = "insert into tripreviewcomment(tc_num,t_num,tc_writer,tc_comment) values(tripreviewcomment_num.nextval,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,t_num);
			pstmt.setString(2,id);
			pstmt.setString(3,commentText);
			
			pstmt.executeUpdate();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex){}
			if(conn != null) try {conn.close();} catch(SQLException ex){}
		}
		
	}
	public void setUpdateComment(int tc_num, String tc_comment) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("update tripreviewcomment set tc_comment= ? where tc_num = ?");
			pstmt.setString(1, tc_comment);
			pstmt.setInt(2, tc_num);
			
			pstmt.executeUpdate();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex){}
			if(conn != null) try {conn.close();} catch(SQLException ex){}
		}
		
	}
	
	public void setDeleteComment(int tc_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("delete from tripreviewcomment where tc_num = ?");
			pstmt.setInt(1,tc_num);
			
			pstmt.executeUpdate();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex){}
			if(conn != null) try {conn.close();} catch(SQLException ex){}
		}
		
	}
}
