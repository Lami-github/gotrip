package traveler;

import java.sql.*;
import javax.sql.*;

import buyer.BuyerDataBean;
import photo.PhotoDBBean;
import traveler.comment.TravelerCommentDataBean;

import javax.naming.*;
import javax.servlet.http.HttpServlet;
import java.util.*;

public class TravelerDBBean {
	private static TravelerDBBean instance = new TravelerDBBean();

	public static TravelerDBBean getInstance() {
		return instance;
	}

	private TravelerDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	// JY
	public int getArticleCount() throws Exception { // ***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from traveler");
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

	// JY
	public int getArticleCount(int n, String searchKeyword) throws Exception { // ***

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String[] column_name = { "tr_subject", "tr_writer", "tr_content" };

		int x = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"select count (*) from traveler " + "where " + column_name[n] + " like '%" + searchKeyword + "%'");

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

	// JY
	public List getArticles(int start, int end) throws Exception { // ***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select tr_num,tr_subject,tr_writer,tr_reg_date from"
					+ "(select tr_num,tr_subject,tr_writer,tr_reg_date,rownum r from traveler) where r >= ? and r <= ? ");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList(end);
				do {
					TravelerDataBean article = new TravelerDataBean();
					article.setTr_num(rs.getInt("tr_num"));

					article.setTr_subject(rs.getString("tr_subject"));
					article.setTr_writer(rs.getString("tr_writer"));
					article.setTr_reg_date(rs.getString("tr_reg_date"));

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

	// JY
	public List getArticles(int start, int end, int n, String searchKeyword) throws Exception { // ***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;

		String[] column_name = { "tr_subject", "tr_writer", "tr_content" };

		try {
			conn = getConnection();

			String sql = "select tr_num,tr_subject,tr_writer,tr_reg_date from"
					+ "(select tr_num,tr_subject,tr_writer,tr_reg_date,tr_content, rownum r from traveler) " + "where "
					+ column_name[n] + " like '%" + searchKeyword + "%'  and r >= ? and r <= ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList(end);
				do {
					TravelerDataBean article = new TravelerDataBean();
					article.setTr_num(rs.getInt("tr_num"));

					article.setTr_subject(rs.getString("tr_subject"));
					article.setTr_writer(rs.getString("tr_writer"));
					article.setTr_reg_date(rs.getString("tr_reg_date"));

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

	// MJ
	public int userIdentification(String id, String password) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int check = -1;
		String checkPassword = "";

		try {
			conn = getConnection();

			String str = "select password from member where id=?";
			pstmt = conn.prepareStatement(str);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				checkPassword = rs.getString(1);
			}
			if (password.equals(checkPassword)) {
				check = 1;
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
		return check;
	}

	//MJ
	public String travelerSearch(String tr_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String traveler = "";
		int tr_nums = Integer.parseInt(tr_num);

		try {
			conn = getConnection();

			String str = "select tr_writer from traveler where tr_num=?";

			pstmt = conn.prepareStatement(str);

			pstmt.setInt(1, tr_nums);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				traveler = rs.getString("tr_writer");
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
		return traveler;
	}

	//MJ
	public int trade(String b_id, String tr_id, String trade_item, int trade_count, int trade_point) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int check = -1;

		try {
			conn = getConnection();

			String str = "insert into trade values(trade_seq.NEXTVAL,?,?,?,?,'배송전','',?,'','','F')";
			pstmt = conn.prepareStatement(str);

			pstmt.setString(1, b_id);
			pstmt.setString(2, tr_id);
			pstmt.setString(3, trade_item);
			pstmt.setInt(4, trade_count);
			pstmt.setInt(5, trade_point);

			check = pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
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
		return check;
	}

	//MJ
	public int travelerUpdate(int tr_num, int pay) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int limit_money = 0;
		int check = -1;
		try {
			conn = getConnection();
			String str = "select limit_money from traveler where tr_num=?";
			pstmt = conn.prepareStatement(str);
			pstmt.setInt(1, tr_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				limit_money = rs.getInt("limit_money");
			}

			if ((limit_money - pay) < 0) {
				return check;
			} else {
				try {
					String str2 = "update traveler set limit_money = limit_money-? where tr_num=?";
					pstmt = conn.prepareStatement(str2);

					pstmt.setInt(1, pay);
					pstmt.setInt(2, tr_num);

					check = pstmt.executeUpdate();

				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
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
		return check;
	}

	//MJ
	public TravelerDataBean getTravelerArticle(int tr_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TravelerDataBean tdb = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("update traveler set tr_readcount=tr_readcount+1 where tr_num = ?");
			pstmt.setInt(1, tr_num);
			pstmt.executeUpdate();

			pstmt = conn.prepareStatement("select * from traveler where tr_num = ?");
			pstmt.setInt(1, tr_num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				tdb = new TravelerDataBean();
				tdb.setTr_num(rs.getInt("tr_num"));
				tdb.setTr_writer(rs.getString("tr_writer"));
				tdb.setTr_subject(rs.getString("tr_subject"));
				tdb.setTr_reg_date(rs.getString("tr_reg_date"));
				tdb.setBegin_country(rs.getString("begin_country"));
				tdb.setArrived_country(rs.getString("arrived_country"));
				tdb.setBegin_day(rs.getString("begin_day"));
				tdb.setArrived_day(rs.getString("arrived_day"));
				tdb.setLimit_money(rs.getInt("limit_money"));
				tdb.setTr_content(rs.getString("tr_content"));
				tdb.setTr_readcount(rs.getInt("tr_readcount"));
				tdb.setPhoto_id(rs.getString("photo_id"));
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
		return tdb;
	}

	//MJ
	public List getTravelerComment(int tr_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List comment = new ArrayList();
		TravelerCommentDataBean tcdb = null;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from traveler_comment where tr_num = ?");
			pstmt.setInt(1, tr_num);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				tcdb = new TravelerCommentDataBean();
				tcdb.setTrc_num(rs.getInt("trc_num"));
				tcdb.setTr_num(rs.getInt("tr_num"));
				tcdb.setTrc_writer(rs.getString("trc_writer"));
				tcdb.setTrc_comment(rs.getString("trc_comment"));
				tcdb.setTrc_reg_date(rs.getString("trc_reg_date"));
				comment.add(tcdb);
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
		return comment;
	}
	
	//MJ
	public void insertTravelerComment(String trc_writer, String trc_comment, int tr_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("insert into traveler_comment values (trc_num_seq.NEXTVAL,?,?,?,sysdate)");
			pstmt.setInt(1, tr_num);
			pstmt.setString(2, trc_writer);
			pstmt.setString(3, trc_comment);

			pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
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
	public void travelerCommentDel(int trc_num, String trc_writer) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("delete from traveler where trc_num=? and trc_writer=?");

			pstmt.setInt(1, trc_num);
			pstmt.setString(2, trc_writer);

			pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
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
	
	//NA
	public int getTravelerBoardCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from traveler");
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
	
	//NA
	public int getTravelerBoardCount(int n, String search) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		
		String[] column_name = {"tr_writer","begin_country","arrived_country"};
			
		int x = 0;
		
		try
		{
			conn = getConnection();
			
			
			pstmt = conn.prepareStatement("select count(*) from traveler where "+column_name[n]+" like '%"+search+"%'");
		

			rs = pstmt.executeQuery();
			
			if(rs.next())
				x = rs.getInt(1);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(rs != null) try {rs.close();} catch(SQLException ex){}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex){}
			if(conn != null) try {conn.close();} catch(SQLException ex){}
		}
		return x;
	}
	
	//NA
	public List getTravelerBoard(int start, int end) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List travelerBoardList = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select tr_num,tr_writer,tr_subject,tr_reg_date,begin_country,arrived_country,begin_day,arrived_day,limit_money,tr_content,tr_readcount,photo_id,r "
							+ "from (select tr_num,tr_writer,tr_subject,tr_reg_date,begin_country,arrived_country,begin_day,arrived_day,limit_money,tr_content,tr_readcount,photo_id,rownum r "
							+ "from (select * "
							+ "from traveler order by tr_num desc) order by tr_num desc) where r >= ? and r <= ? ");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			String imgPath = "";
			
			if (rs.next()) {
				travelerBoardList = new ArrayList(end);
				do {
					TravelerDataBean travelerBoard = new TravelerDataBean();
					travelerBoard.setTr_num(rs.getInt("tr_num"));
					travelerBoard.setTr_writer(rs.getString("tr_writer"));
					travelerBoard.setTr_subject(rs.getString("tr_subject"));
					travelerBoard.setTr_reg_date(rs.getString("tr_reg_date"));
					travelerBoard.setBegin_country(rs.getString("begin_country"));
					travelerBoard.setArrived_country(rs.getString("arrived_country"));
					travelerBoard.setBegin_day(rs.getString("begin_day"));
					travelerBoard.setArrived_day(rs.getString("arrived_day"));
					travelerBoard.setLimit_money(rs.getInt("limit_money"));
					travelerBoard.setTr_content(rs.getString("tr_content"));
					travelerBoard.setTr_readcount(rs.getInt("tr_readcount"));
					travelerBoard.setPhoto_id(rs.getString("photo_id"));
					if(rs.getString("photo_id") == null) {
						imgPath = "2255204458A13F7F03.png"; // 프로필사진이 없는사람의 기본사진경로
					}else {
					PhotoDBBean dbPhoto = PhotoDBBean.getInstance();
					imgPath = dbPhoto.getImgPathFirst(travelerBoard.getPhoto_id());
					travelerBoard.setImgPath(imgPath);
					}
					
					travelerBoardList.add(travelerBoard);
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
		return travelerBoardList;
	}
	
	//NA
	public List getTravelerBoard(int start, int end, int n, String search) throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List travelerBoardList = null;		
	
		
		String[] column_name = {"tr_writer","begin_country","arrived_country"}; // 분류

		try
		{
			conn = getConnection();
			String sql = "";

				sql ="select tr_num,tr_writer,tr_subject,tr_reg_date,begin_country,arrived_country,begin_day,arrived_day,limit_money,tr_content,tr_readcount,photo_id,r "
					+ "from (select tr_num,tr_writer,tr_subject,tr_reg_date,begin_country,arrived_country,begin_day,arrived_day,limit_money,tr_content,tr_readcount,photo_id,rownum r "
					+ "from (select * "
					+ "from traveler order by tr_num desc) where "+column_name[n]+" like '%"+search+"%' order by tr_num desc) where r >= ? and r <= ? ";
				
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2,	end);
			
			rs = pstmt.executeQuery();
			
			String imgPath = "";
			
			if (rs.next()) {
				travelerBoardList = new ArrayList(end);
				do {
					TravelerDataBean travelerBoard = new TravelerDataBean();
					travelerBoard.setTr_num(rs.getInt("tr_num"));
					travelerBoard.setTr_writer(rs.getString("tr_writer"));
					travelerBoard.setTr_subject(rs.getString("tr_subject"));
					travelerBoard.setTr_reg_date(rs.getString("tr_reg_date"));
					travelerBoard.setBegin_country(rs.getString("begin_country"));
					travelerBoard.setArrived_country(rs.getString("arrived_country"));
					travelerBoard.setBegin_day(rs.getString("begin_day"));
					travelerBoard.setArrived_day(rs.getString("arrived_day"));
					travelerBoard.setLimit_money(rs.getInt("limit_money"));
					travelerBoard.setTr_content(rs.getString("tr_content"));
					travelerBoard.setTr_readcount(rs.getInt("tr_readcount"));
					travelerBoard.setPhoto_id(rs.getString("photo_id"));
					if(rs.getString("photo_id") != null) {
						PhotoDBBean dbPhoto = PhotoDBBean.getInstance();
						imgPath = dbPhoto.getImgPathFirst(travelerBoard.getPhoto_id());
					travelerBoard.setImgPath(imgPath);
					}
										
					travelerBoardList.add(travelerBoard);
				} while (rs.next());
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(rs != null) try {rs.close();} catch(SQLException ex){}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex){}
			if(conn != null) try {conn.close();} catch(SQLException ex){}
		}
		
		return travelerBoardList;
	}
	
	//NA
	public void setTravelerBoardList(String id,String tr_subject,String begin_country,String arrived_country,String begin_day,String arrived_day,int limit_money,String tr_content,String photo_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
				
		try
		{
			conn = getConnection();
				
			String sql = "insert into traveler(tr_num,tr_writer,tr_subject,begin_country,arrived_country,begin_day,arrived_day,limit_money,tr_content,photo_id) values(traveler_tr_num.nextval,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,tr_subject);
			pstmt.setString(3,begin_country);
			pstmt.setString(4,arrived_country);
			pstmt.setString(5,begin_day);
			pstmt.setString(6,arrived_day);
			pstmt.setInt(7,limit_money);
			pstmt.setString(8,tr_content);
			pstmt.setString(9,photo_id);
		
			
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
	
	//MJ
	public void updateTravelerComment(String trc_comment,int trc_num) throws Exception {
		Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
        	conn = getConnection();
        	
        	pstmt = conn.prepareStatement("update traveler_comment set trc_comment=?,trc_reg_date=sysdate where trc_num=?");
            pstmt.setString(1, trc_comment);
            pstmt.setInt(2, trc_num);

            pstmt.executeUpdate();
            
        }catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
	}
	
	
	public int pointUpdate(String id, int point) throws Exception {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int check = -1;
        String str = "";
        int current_point = 0;
        try {
        	conn = getConnection();
        	
        	str = "select point from member where id = ?";
        	pstmt = conn.prepareStatement(str);
        	pstmt.setString(1, id);
        	rs = pstmt.executeQuery();
		
        	if(rs.next()) {
        		current_point = rs.getInt("point");
        	}
        	
        	if(current_point - point>0) {
        	
	        	str = "update member set point = point-? where id=?";
	        	pstmt = conn.prepareStatement(str);
			
	        	pstmt.setInt(1,point);
	        	pstmt.setString(2, id);
			
	        	check = pstmt.executeUpdate();
			
	        	if(check == 1 ) {
	        		str = "insert into point values(point_seq.NEXTVAL, ?, sysdate, '구매', ?, ?)";
	        		pstmt = conn.prepareStatement(str);
	        		pstmt.setString(1,id);
	        		pstmt.setInt(2,point);
	        		pstmt.setInt(3, current_point-point);
	        	
	        		check = pstmt.executeUpdate();
	        	}
        	}
        }catch(Exception ex) {
            ex.printStackTrace();
        } finally {
        	if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        
        return check;
	}
	
}