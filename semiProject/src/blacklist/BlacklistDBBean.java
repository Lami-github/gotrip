package blacklist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;



public class BlacklistDBBean {
	private static BlacklistDBBean instance = new BlacklistDBBean();

	// LogonDBBean m = LogonDBBean.getInstance();
	public static BlacklistDBBean getInstance() { //***
		return instance;
	}

	private BlacklistDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	//JY
	public int getMemberCount() throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from blacklist");
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

	//JY
	public List getMembers(int start, int end) throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		List memberList = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select bl_num, writer, reporter, bl_subject, bl_reg_date, board_id, re_num, re_comment,report_status"
							+ " from (select bl_num, writer, reporter, bl_subject, bl_reg_date, board_id, re_num, re_comment,report_status,rownum r "
							+ "from blacklist) where r >= ? and r<=?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				memberList = new ArrayList(end);
				
				
		
				do {
					String bl_type = "";
					String re_comment = rs.getString("re_comment");
					int board_id = rs.getInt("board_id");
					pstmt2 = conn.prepareStatement("select board_name from board_type where board_id=?");
					pstmt2.setInt(1, board_id);
					rs2 = pstmt2.executeQuery();
					if (rs2.next()) {
						System.out.println(re_comment);
						if (re_comment != null)
							bl_type = rs2.getString("board_name") + " 댓글";
						else
							bl_type = rs2.getString("board_name") + " 글";
					}
					BlacklistDataBean member = new BlacklistDataBean();

					member.setBl_num(rs.getInt("bl_num"));
					member.setWriter(rs.getString("writer"));
					member.setReporter(rs.getString("reporter"));
					member.setBl_subject(rs.getString("bl_subject"));
					member.setBl_reg_date(rs.getString("bl_reg_date"));
					member.setBoard_id(board_id);
					member.setRe_num(rs.getInt("re_num"));
					member.setRe_comment(rs.getInt("re_comment"));
					
					member.setReport_status(rs.getString("report_status"));
					member.setBl_type(bl_type);

					memberList.add(member);
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
		return memberList;
	}


	//JY
	public int getMemberCount(int n, String searchKeyword) throws Exception { //***

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String[] column_name = { "bl_subject", "writer", "reporter", "report_status" };

		int x = 0;

		try {
			conn = getConnection();
				pstmt = conn.prepareStatement("select count (*) from blacklist " + "where " + column_name[n] + " like '%"
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

	//JY
	public List getMembers(int start, int end, int n, String searchKeyword) throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		List memberList = null;

		String[] column_name = { "bl_subject", "writer", "reporter", "content", "report_status" };

		try {
			conn = getConnection();

			String sql = "select bl_num, writer, reporter, bl_subject, bl_reg_date, board_id, re_num, re_comment, report_status" + 
					" from (select bl_num, writer, reporter, bl_subject, bl_reg_date, board_id, re_num, re_comment, report_status,rownum r "
					+ "from blacklist) where " + column_name[n] + " like '%" + searchKeyword + "%'  and r >= ? and r <= ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				memberList = new ArrayList(end);
				String bl_type = "";
				String re_comment = rs.getString("re_comment");
				int board_id = rs.getInt("board_id");
				pstmt2 = conn.prepareStatement("select board_name from board_type where board_id=?");
				pstmt2.setInt(1, board_id);
				rs2 = pstmt2.executeQuery();
				if (rs2.next()) {
					if (re_comment != null)
						bl_type = rs2.getString("board_name") + " 댓글";
					else
						bl_type = rs2.getString("board_name") + " 글";
				}

				do {
					BlacklistDataBean member = new BlacklistDataBean();
					
					member.setBl_num(rs.getInt("bl_num"));
					member.setWriter(rs.getString("writer"));
					member.setReporter(rs.getString("reporter"));
					member.setBl_subject(rs.getString("bl_subject"));
					member.setBl_reg_date(rs.getString("bl_reg_date"));
					member.setBoard_id(board_id);
					member.setRe_num(rs.getInt("re_num"));
					member.setRe_comment(rs.getInt("re_comment"));
					
					member.setReport_status(rs.getString("report_status"));
					member.setBl_type(bl_type);

					memberList.add(member);
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

		return memberList;
	}
	
	//JY
	public BlacklistDataBean getMember(int bl_num) throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		BlacklistDataBean member = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select bl_num, writer, reporter, bl_subject, bl_reg_date, board_id, re_num, re_comment, report_status"
							+ " from blacklist where bl_num = ?");
			pstmt.setInt(1, bl_num);
			rs = pstmt.executeQuery();
			 member = new BlacklistDataBean();
			if (rs.next()) {
					member.setBl_num(rs.getInt("bl_num"));
					member.setWriter(rs.getString("writer"));
					member.setReporter(rs.getString("reporter"));
					member.setBl_subject(rs.getString("bl_subject"));
					member.setBl_reg_date(rs.getString("bl_reg_date"));
					member.setBoard_id(Integer.parseInt(rs.getString("board_id")));
					member.setRe_num(rs.getInt("re_num"));
					member.setRe_comment(rs.getInt("re_comment"));
					
					member.setReport_status(rs.getString("report_status"));

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
		return member;
	}
	
	//JY
	public void updateMember(int bl_num,String writer,String report) throws Exception { //***
		Connection conn = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int warn = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select warn from member where id=?");
			pstmt.setString(1, writer);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				warn=rs.getInt("warn");
			}
			if (report.equals("true")) {
				if(warn >=2) {
					pstmt = conn.prepareStatement("update member set warn=warn+1,blacklist='T'  where id = ?");
					pstmt.setString(1, writer);
					pstmt.executeUpdate();

				
				}else {
					pstmt = conn.prepareStatement("update member set warn=warn+1 where id = ?");
					pstmt.setString(1, writer);
					pstmt.executeUpdate();
				}
				pstmt = conn.prepareStatement("update blacklist set report_status='신고완료' where bl_num = ?");
				pstmt.setInt(1, bl_num);
				pstmt.executeUpdate();
			}
			else {

				pstmt = conn.prepareStatement("update blacklist set report_status='신고거절' where bl_num = ?");
				pstmt.setInt(1, bl_num);
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

	//MJ
	public void blackArticle(int board_id, int re_num,String reporter,String writer ,String bl_subject) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_name="";
		
		if ( board_id == 1) {
			board_name="tripreview";
		}else if (board_id==2) {
			board_name="buyer";
		}else if(board_id ==3) {
			board_name="traveler";
		}else {
			board_name="";
		}

		
		
		try {
			conn = getConnection();
			String str = "insert into blacklist values(blacklist_seq.NEXTVAL,?,?,?,sysdate,?,?,'','대기')";
			pstmt = conn.prepareStatement(str);
			pstmt.setString(1, writer);
			pstmt.setString(2, reporter);
			pstmt.setString(3, bl_subject);
			pstmt.setInt(4, board_id);
			pstmt.setInt(5, re_num);
			
			pstmt.execute();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)		try {		rs.close();			} catch (SQLException ex) {	}
			if (pstmt != null)	try {		pstmt.close();		} catch (SQLException ex) {	}
			if (conn != null)	try {		conn.close();		} catch (SQLException ex) {	}
		}
	}
	
	//MJ
	public void blackComment(int board_id, int re_num,String reporter,String writer ,String bl_subject,int re_comment) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_name="";
		if ( board_id == 1) {
			board_name="tripreviewcomment";
		}else if (board_id==2) {
			board_name="buyer_comment";
		}else if(board_id ==3) {
			board_name="traveler_comment";
		}else {
			board_name="";
		}
		
		try {
			conn = getConnection();
			String str = "insert into blacklist values(blacklist_seq.NEXTVAL,?,?,?,sysdate,?,?,?,'대기')";
			pstmt = conn.prepareStatement(str);
			pstmt.setString(1, writer);
			pstmt.setString(2, reporter);
			pstmt.setString(3, bl_subject);
			pstmt.setInt(4, board_id);
			pstmt.setInt(5, re_num);
			pstmt.setInt(6, re_comment);
			pstmt.execute();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)		try {		rs.close();			} catch (SQLException ex) {	}
			if (pstmt != null)	try {		pstmt.close();		} catch (SQLException ex) {	}
			if (conn != null)	try {		conn.close();		} catch (SQLException ex) {	}
		}
	}
}
