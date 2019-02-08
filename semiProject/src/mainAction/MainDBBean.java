package mainAction;

import java.sql.*;
import java.util.*;

public class MainDBBean {
	private static MainDBBean instance = new MainDBBean();

	public static MainDBBean getInstance() {
		return instance;
	}

	private MainDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	public List getLayout() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List layout = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("");
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)			try {	rs.close();		} catch (SQLException ex) {	}
			if (pstmt != null)		try {	pstmt.close();	} catch (SQLException ex) {	}
			if (conn != null)		try {	conn.close();	} catch (SQLException ex) {	}
		}
		return layout;
	}
	public int[] getFestArticle(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=  null;
		int[] f_num = new int[2];
		try{
		conn=getConnection();
		pstmt=conn.prepareStatement("select f_num, rownum r from (select rownum r, f_num, f_readcount from(select f_num,f_readcount,rownum r from festival order by f_readcount desc)) where r>=1 and r<=2");
		rs=pstmt.executeQuery();
		for(int i=0; rs.next(); i++) {
			f_num[i] = rs.getInt("f_num");
		}
		}catch(Exception ex) {
			ex.printStackTrace();
			
			
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
			if(conn!=null)try {conn.close();}catch(SQLException ex) {}
		}
		return f_num;
		}
	public int[] getTravelArticle(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=  null;
		int[] tr_num = new int[2];
		try{
		conn=getConnection();
		pstmt=conn.prepareStatement("select tr_num, rownum r from (select rownum r, tr_num, tr_readcount from(select tr_num,tr_readcount,rownum r from traveler order by tr_readcount desc)) where r>=1 and r<=2");
		rs=pstmt.executeQuery();
		for(int i=0; rs.next(); i++) {
			tr_num[i] = rs.getInt("tr_num");
		}
		}catch(Exception ex) {
			ex.printStackTrace();
			
			
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
			if(conn!=null)try {conn.close();}catch(SQLException ex) {}
		}
		return tr_num;
		}
	public int[] getReviewArticle(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=  null;
		int[] t_num = new int[2];
		try{
		conn=getConnection();
		pstmt=conn.prepareStatement("select t_num, rownum r from (select rownum r, t_num, t_readcount from(select t_num,t_readcount,rownum r from tripreview order by t_readcount desc)) where r>=1 and r<=2");
		rs=pstmt.executeQuery();
		for(int i=0; rs.next(); i++) {
			t_num[i] = rs.getInt("t_num");
		}
		}catch(Exception ex) {
			ex.printStackTrace();
			
			
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
			if(conn!=null)try {conn.close();}catch(SQLException ex) {}
		}
		return t_num;
		}
	public String[] getFestImg() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String[] f_img= new String[2];
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("select f_num, photo_id, rownum r from (select rownum r, f_num, f_readcount, photo_id from(select f_num,f_readcount,rownum r, photo_id from festival order by f_readcount desc)) where r>=1 and r<=2");
		rs=pstmt.executeQuery();
		for(int i=0; rs.next(); i++) {
			f_img[i] = rs.getString("photo_id");			
		}
		}catch(Exception ex) {
			ex.printStackTrace();
						
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
			if(conn!=null)try {conn.close();}catch(SQLException ex) {}
		}
		return f_img;
		
	}
	public String[] getTravelImg() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String[] tr_img= new String[2];
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("select tr_num, photo_id, rownum r from (select rownum r, tr_num, tr_readcount, photo_id from(select tr_num,tr_readcount,rownum r, photo_id from traveler order by tr_readcount desc)) where r>=1 and r<=2");
		rs=pstmt.executeQuery();
		for(int i=0; rs.next(); i++) {
			tr_img[i] = rs.getString("photo_id");			
		}
		}catch(Exception ex) {
			ex.printStackTrace();
						
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
			if(conn!=null)try {conn.close();}catch(SQLException ex) {}
		}
		return tr_img;		
	}
	public String[] getReviewImg() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String[] t_img= new String[2];
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("select t_num, photo_id, rownum r from (select rownum r, t_num, t_readcount, photo_id from(select t_num,t_readcount,rownum r, photo_id from tripreview order by t_readcount desc)) where r>=1 and r<=2");
		rs=pstmt.executeQuery();
		for(int i=0; rs.next(); i++) {
			t_img[i] = rs.getString("photo_id");			
		}
		}catch(Exception ex) {
			ex.printStackTrace();
						
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
			if(conn!=null)try {conn.close();}catch(SQLException ex) {}
		}
		return t_img;
		
	}
		
	
	
	
}
