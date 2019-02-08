package buyer.comment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuyerCommentDBBean {
	private static BuyerCommentDBBean instance = new BuyerCommentDBBean();

	public static BuyerCommentDBBean getInstance() {
		return instance;
	}
	private BuyerCommentDBBean() {
	}
	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	public void setBuyerBoardComment(String id, int b_num,String commentText) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try
		{
			conn = getConnection();
				
			String sql = "insert into buyer_comment(bc_num,b_num,bc_writer,bc_comment) values(buyer_comment_num.nextval,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,b_num);
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
	
	public List getBuyerBoardComment( int b_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List buyerBoardCommentList = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select bc_num,b_num,bc_writer,bc_comment,bc_reg_date,r "
							+ "from (select bc_num,b_num,bc_writer,bc_comment,bc_reg_date,rownum r "
							+ "from (select * "
							+ "from buyer_comment where b_num = ? order by b_num desc) order by b_num desc) ");
			pstmt.setInt(1, b_num);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				buyerBoardCommentList = new ArrayList();
				do {
					BuyerCommentDataBean buyerBoardComment = new BuyerCommentDataBean();
					buyerBoardComment.setBc_num(rs.getInt("bc_num"));
					buyerBoardComment.setB_num(rs.getInt("b_num"));
					buyerBoardComment.setBc_writer(rs.getString("bc_writer"));
					buyerBoardComment.setBc_reg_date(rs.getString("bc_reg_date"));
					buyerBoardComment.setBc_comment(rs.getString("bc_comment"));
					
					buyerBoardCommentList.add(buyerBoardComment);
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
		return buyerBoardCommentList;
	}
	
	public int getBuyerBoardCommentCount(int b_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from buyer_comment where b_num = ?");
			pstmt.setInt(1, b_num);
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
	
	public void setUpdateComment(int bc_num, String bc_comment) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("update buyer_comment set bc_comment= ? where bc_num = ?");
			pstmt.setString(1, bc_comment);
			pstmt.setInt(2, bc_num);
			
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
	
	public void setDeleteComment(int bc_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("delete from buyer_comment where bc_num = ?");
			pstmt.setInt(1,bc_num);
			
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