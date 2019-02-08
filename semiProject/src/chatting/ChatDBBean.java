package chatting;

import java.sql.*;
import java.util.ArrayList;

import chatting.*;

public class ChatDBBean {
	 private static ChatDBBean instance = new ChatDBBean();
	   
	    public static ChatDBBean getInstance() {
	        return instance;
	    }
	   
	    private ChatDBBean() {
	    }
	   
	    private Connection getConnection() throws Exception {
	    String jdbcDriver = "jdbc:apache:commons:dbcp:pool";         
	        return DriverManager.getConnection(jdbcDriver);
	    }
	    
	    public ArrayList chatData(int trade_num) throws Exception{
	    	Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList chatlist = new ArrayList();
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select content from chatroom where room=? order by count");
				pstmt.setInt(1, trade_num);

				rs = pstmt.executeQuery();
				
				while(rs.next()){
		        	chatlist.add(rs.getString("content"));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null)
					try {		rs.close();		} catch (SQLException ex) {	}
				if (pstmt != null)
					try {		pstmt.close();	} catch (SQLException ex) {	}
				if (conn != null)
					try {		conn.close();	} catch (SQLException ex) {	}
			}
			return chatlist;
	    }
	    
	    public void chatInsert(String message, int trade_num) throws Exception{
	    	Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("insert into chatroom values (chatroom_seq.NEXTVAL,?,?)");
				pstmt.setInt(1, trade_num);
				pstmt.setString(2, message);
				
				pstmt.execute();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (rs != null)
					try {		rs.close();		} catch (SQLException ex) {	}
				if (pstmt != null)
					try {		pstmt.close();	} catch (SQLException ex) {	}
				if (conn != null)
					try {		conn.close();	} catch (SQLException ex) {	}
			}
	    }
}
