package buyer;

import java.sql.*;
import javax.sql.*;

import photo.PhotoDBBean;
import traveler.TravelerDataBean;
import tripreview.TripreviewDataBean;

import javax.naming.*;
import javax.servlet.http.HttpServlet;
import java.util.*;

public class BuyerDBBean {
	private static BuyerDBBean instance = new BuyerDBBean();

	public static BuyerDBBean getInstance() {
		return instance;
	}

	private BuyerDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	// JY
	public int getArticleCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from buyer");
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
	public int getArticleCount(int n, String searchKeyword) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String[] column_name = { "b_subject", "b_writer", "b_content" };

		int x = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"select count (*) from buyer " + "where " + column_name[n] + " like '%" + searchKeyword + "%'");

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

			pstmt = conn.prepareStatement("select b_num,b_subject,b_writer,b_reg_date from"
					+ "(select b_num,b_subject,b_writer,b_reg_date,rownum r from buyer) where r >= ? and r <= ? ");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList(end);
				do {
					BuyerDataBean article = new BuyerDataBean();
					article.setB_num(rs.getInt("b_num"));

					article.setB_subject(rs.getString("b_subject"));
					article.setB_writer(rs.getString("b_writer"));
					article.setB_reg_date(rs.getString("b_reg_date"));

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

		String[] column_name = { "b_subject", "b_writer", "b_content" };

		try {
			conn = getConnection();

			String sql = "select b_num,b_subject,b_writer,b_reg_date from"
					+ "(select b_num,b_subject,b_writer,b_reg_date,b_content, rownum r from buyer) " + "where "
					+ column_name[n] + " like '%" + searchKeyword + "%'  and r >= ? and r <= ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList(end);
				do {
					BuyerDataBean article = new BuyerDataBean();
					article.setB_num(rs.getInt("b_num"));

					article.setB_subject(rs.getString("b_subject"));
					article.setB_writer(rs.getString("b_writer"));
					article.setB_reg_date(rs.getString("b_reg_date"));

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

	//NA
	public int getBuyerBoardCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from buyer");
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
	public int getBuyerBoardCount(int n, String search) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String[] column_name = { "b_subject", "b_country", "b_item" };

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select count(*) from buyer where " + column_name[n] + " like '%" + search + "%'");

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

	//NA
	public List getBuyerBoard(int start, int end) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List buyerBoardList = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select b_num,b_writer,b_subject,b_country,b_item,b_count,b_price,b_reg_date,b_content,b_readcount,photo_id,r "
							+ "from (select b_num,b_writer,b_subject,b_country,b_item,b_count,b_price,b_reg_date,b_content,b_readcount,photo_id,rownum r "
							+ "from (select * "
							+ "from buyer order by b_num desc) order by b_num desc) where r >= ? and r <= ? ");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				buyerBoardList = new ArrayList(end);
				do {
					BuyerDataBean buyerBoard = new BuyerDataBean();
					buyerBoard.setB_num(rs.getInt("b_num"));
					buyerBoard.setB_writer(rs.getString("b_writer"));
					buyerBoard.setB_subject(rs.getString("b_subject"));
					buyerBoard.setB_country(rs.getString("b_country"));
					buyerBoard.setB_item(rs.getString("b_item"));
					buyerBoard.setB_count(rs.getInt("b_count"));
					buyerBoard.setB_price(rs.getInt("b_price"));
					buyerBoard.setB_reg_date(rs.getString("b_reg_date"));
					buyerBoard.setB_content(rs.getString("b_content"));
					buyerBoard.setB_readcount(rs.getInt("b_readcount"));
					buyerBoard.setPhoto_id(rs.getString("photo_id"));
					if (buyerBoard.getPhoto_id() != null) {
						PhotoDBBean dbPhoto = PhotoDBBean.getInstance();
						buyerBoard.setFirstImagePath(dbPhoto.getImgPathFirst(buyerBoard.getPhoto_id()));
					} else
						buyerBoard.setFirstImagePath("");

					buyerBoardList.add(buyerBoard);
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
		return buyerBoardList;
	}

	//NA
	public List getBuyerBoard(int start, int end, int n, String search) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List buyerBoardList = null;

		String[] column_name = { "b_subject", "b_country", "b_item" }; // 분류

		try {
			conn = getConnection();
			String sql = "";

			sql = "select b_num,b_writer,b_subject,b_country,b_item,b_count,b_price,b_reg_date,b_content,b_readcount,photo_id,r "
					+ "from (select b_num,b_writer,b_subject,b_country,b_item,b_count,b_price,b_reg_date,b_content,b_readcount,photo_id,rownum r "
					+ "from (select * " + "from buyer order by b_num desc) where " + column_name[n] + " like '%"
					+ search + "%' order by b_num desc) where r >= ? and r <= ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				buyerBoardList = new ArrayList(end);
				do {
					BuyerDataBean buyerBoard = new BuyerDataBean();
					buyerBoard.setB_num(rs.getInt("b_num"));
					buyerBoard.setB_writer(rs.getString("b_writer"));
					buyerBoard.setB_subject(rs.getString("b_subject"));
					buyerBoard.setB_country(rs.getString("b_country"));
					buyerBoard.setB_item(rs.getString("b_item"));
					buyerBoard.setB_count(rs.getInt("b_count"));
					buyerBoard.setB_price(rs.getInt("b_price"));
					buyerBoard.setB_reg_date(rs.getString("b_reg_date"));
					buyerBoard.setB_content(rs.getString("b_content"));
					buyerBoard.setB_readcount(rs.getInt("b_readcount"));
					buyerBoard.setPhoto_id(rs.getString("photo_id"));
					if (buyerBoard.getPhoto_id() != null) {
						PhotoDBBean dbPhoto = PhotoDBBean.getInstance();
						buyerBoard.setFirstImagePath(dbPhoto.getImgPathFirst(buyerBoard.getPhoto_id()));
					} else
						buyerBoard.setFirstImagePath("");

					buyerBoardList.add(buyerBoard);
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

		return buyerBoardList;
	}

	//NA
	public void setBuyerBoardList(String id, String b_subject, String b_country, String b_item, int count, int b_price,
			String b_content, String photo_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into buyer(b_num,b_writer,b_subject,b_country,b_item,b_count,b_price,b_content,photo_id) values(buyerBoard_num.nextval,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, b_subject);
			pstmt.setString(3, b_country);
			pstmt.setString(4, b_item);
			pstmt.setInt(5, count);
			pstmt.setInt(6, b_price);
			pstmt.setString(7, b_content);
			pstmt.setString(8, photo_id);

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
	public BuyerDataBean getContentForm(int b_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		BuyerDataBean buyerBoard = new BuyerDataBean();

		try {
			conn = getConnection();
			String sql = "update buyer set b_readcount=b_readcount+1 where b_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_num);
			pstmt.executeUpdate();

			pstmt = conn.prepareStatement("select * from buyer where b_num = ?");
			pstmt.setInt(1, b_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				buyerBoard.setB_num(rs.getInt("b_num"));
				buyerBoard.setB_writer(rs.getString("b_writer"));
				buyerBoard.setB_subject(rs.getString("b_subject"));
				buyerBoard.setB_country(rs.getString("b_country"));
				buyerBoard.setB_item(rs.getString("b_item"));
				buyerBoard.setB_count(rs.getInt("b_count"));
				buyerBoard.setB_price(rs.getInt("b_price"));
				buyerBoard.setB_reg_date(rs.getString("b_reg_date"));
				buyerBoard.setB_content(rs.getString("b_content"));
				buyerBoard.setB_readcount(rs.getInt("b_readcount"));
				buyerBoard.setPhoto_id(rs.getString("photo_id"));
				if (buyerBoard.getPhoto_id() != null) {
					PhotoDBBean dbPhoto = PhotoDBBean.getInstance();
					buyerBoard.setFirstImagePath(dbPhoto.getImgPathFirst(buyerBoard.getPhoto_id()));
				} else
					buyerBoard.setFirstImagePath("");
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
		return buyerBoard;
	}

	//NA
	public void setBoardDelete(int b_num, String photo_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String[] array;

		try {
			conn = getConnection();

			if (photo_id != null) {
				array = photo_id.split(" ");

				if (array.length == 1) {
					pstmt = conn.prepareStatement("delete from photo where photo_id = ?");
				} else if (array.length == 2) {
					pstmt = conn.prepareStatement("delete from photo where photo_id = ? or photo_id = ?");
				} else if (array.length == 3) {
					pstmt = conn
							.prepareStatement("delete from photo where photo_id = ? or photo_id = ? or photo_id = ?");
				} else if (array.length == 4) {
					pstmt = conn.prepareStatement(
							"delete from photo where photo_id = ? or photo_id = ? or photo_id = ? or photo_id = ?");
				} else if (array.length == 5) {
					pstmt = conn.prepareStatement(
							"delete from photo where photo_id = ? or photo_id = ? or photo_id = ? or photo_id = ? or photo_id = ?");
				}
				int i = 1;

				for (String s : array) {
					pstmt.setString(i, s);
					i++;
				}
				pstmt.executeUpdate();
			}

			pstmt = conn.prepareStatement("delete from buyer where b_num = ?");
			pstmt.setInt(1, b_num);

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
	public BuyerDataBean getBuyerBoardUpdateForm(int b_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		BuyerDataBean buyerBoard = new BuyerDataBean();
		try {
			conn = getConnection();

			String sql = "select * from buyer where b_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_num);

			pstmt.executeQuery();
			rs = pstmt.executeQuery();
			if (rs.next()) {

				buyerBoard.setB_num(rs.getInt("b_num"));
				buyerBoard.setB_writer(rs.getString("b_writer"));
				buyerBoard.setB_subject(rs.getString("b_subject"));
				buyerBoard.setB_country(rs.getString("b_country"));
				buyerBoard.setB_item(rs.getString("b_item"));
				buyerBoard.setB_count(rs.getInt("b_count"));
				buyerBoard.setB_price(rs.getInt("b_price"));
				buyerBoard.setB_reg_date(rs.getString("b_reg_date"));
				buyerBoard.setB_content(rs.getString("b_content"));
				buyerBoard.setB_readcount(rs.getInt("b_readcount"));
				buyerBoard.setPhoto_id(rs.getString("photo_id"));
				if (buyerBoard.getPhoto_id() != null) {
					PhotoDBBean dbPhoto = PhotoDBBean.getInstance();
					buyerBoard.setFirstImagePath(dbPhoto.getImgPathFirst(buyerBoard.getPhoto_id()));
				} else
					buyerBoard.setFirstImagePath("");
			}

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

		return buyerBoard;
	}

	//NA
	public void setBuyerBoardUpdatePro(int b_num, String b_subject, String b_country, String b_item, String b_count,
			String b_price, String b_content) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();

			String sql = "update buyer set b_subject = ?,b_country = ?,b_item = ?,b_count = ?,b_price = ?,b_content = ? where b_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b_subject);
			pstmt.setString(2, b_country);
			pstmt.setString(3, b_item);
			pstmt.setString(4, b_count);
			pstmt.setString(5, b_price);
			pstmt.setString(6, b_content);
			pstmt.setInt(7, b_num);

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
		public String buyerSearch(String b_num) throws Exception {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String buyer = "";
			int b_nums = Integer.parseInt(b_num);
			
			try {
				conn = getConnection();

				String str = "select b_writer from buyer where b_num=?";

				pstmt = conn.prepareStatement(str);

				pstmt.setInt(1, b_nums);

				rs = pstmt.executeQuery();

				if (rs.next()) {
					buyer = rs.getString("b_writer");
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
			return buyer;
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

				check=pstmt.executeUpdate();
				
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
		
		public int pointcheck(String id, int point) throws Exception {
			Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        int check = -1;
	        String str = "";
	        int current_point = 0;
	        try {
	        	str = "select point from member where id = ?";
				pstmt = conn.prepareStatement(str);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					current_point = rs.getInt("point");
				}
				
				if(current_point -point > 0) 
					check = 1;
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