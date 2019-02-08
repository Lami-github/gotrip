package tripreview;

import java.sql.*;
import javax.sql.*;

import HashTag.HashTagDataBean;
import blacklist.BlacklistDataBean;
import photo.PhotoDBBean;

import javax.naming.*;
import javax.servlet.http.HttpServlet;
import java.util.*;

public class TripreviewDBBean{   
    private static TripreviewDBBean instance = new TripreviewDBBean();
   
    public static TripreviewDBBean getInstance() {
        return instance;
    }
   
    private TripreviewDBBean() {
    }
   
    private Connection getConnection() throws Exception {
    String jdbcDriver = "jdbc:apache:commons:dbcp:pool";         
        return DriverManager.getConnection(jdbcDriver);
    }
    
	
	
   
    //list.jsp : 페이징을 위해서 전체 DB에 입력된 행의수가 필요하다...!!!
    public int getArticleCount() throws Exception { //***
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int x=0;

        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement("select count(*) from tripreview");
            rs = pstmt.executeQuery();

            if (rs.next()) {
               x= rs.getInt(1);
}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
return x;
    }
    
    public int getArticleCount(int n, String searchKeyword) throws Exception { //***

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String[] column_name = { "t_subject", "t_writer", "t_content"};

		int x = 0;

		try {
			conn = getConnection();
				pstmt = conn.prepareStatement("select count (*) from tripreview " + "where " + column_name[n] + " like '%"
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

    

    //list.jsp ==> Paging!!! DB로부터 여러행을 결과로 받는다.
	public List getArticles(int start, int end) throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;
		try {
			conn = getConnection();
System.out.println(start);
System.out.println(end);
			pstmt = conn.prepareStatement(
					"select t_num,t_subject,t_writer,t_reg_date from"
					+ "(select t_num,t_subject,t_writer,t_reg_date,rownum r from tripreview) where r >= ? and r <= ? ");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			System.out.println("ccccccccccccccccccccc");
			if (rs.next()) {
				articleList = new ArrayList(end);
				do {
					System.out.println("dddddddddddddddddddddd");
					TripreviewDataBean article = new TripreviewDataBean();
					article.setT_num(rs.getInt("t_num"));

					article.setT_subject(rs.getString("t_subject"));
					article.setT_writer(rs.getString("t_writer"));
					article.setT_reg_date(rs.getString("t_reg_date"));
					
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
	
	public List getArticles(int start, int end, int n, String searchKeyword) throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;

		String[] column_name = { "t_subject", "t_writer", "t_content"};

		try {
			conn = getConnection();

			String sql = "select t_num,t_subject,t_writer,t_reg_date from"
					+ "(select t_num,t_subject,t_writer,t_reg_date,t_content, rownum r from tripreview) where " + column_name[n] + " like '%" + searchKeyword + "%'  and r >= ? and r <= ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList(end);
				do {
					TripreviewDataBean article = new TripreviewDataBean();
					article.setT_num(rs.getInt("t_num"));

					article.setT_subject(rs.getString("t_subject"));
					article.setT_writer(rs.getString("t_writer"));
					article.setT_reg_date(rs.getString("t_reg_date"));
					
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
	public int getTripreViewCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from tripreview");
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
	public List getTripreView(int start, int end) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List tripreViewList = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select t_num,t_writer,t_subject,t_reg_date,t_content,t_readcount,photo_id,t_htag,r "
							+ "from (select t_num,t_writer,t_subject,t_reg_date,t_content,t_readcount,photo_id,t_htag,rownum r "
							+ "from (select * "
							+ "from tripreview order by t_num desc) order by t_num desc) where r >= ? and r <= ? ");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				tripreViewList = new ArrayList(end);
				do {
					TripreviewDataBean tripreView = new TripreviewDataBean();
					tripreView.setT_num(rs.getInt("t_num"));
					tripreView.setT_writer(rs.getString("t_writer"));
					tripreView.setT_subject(rs.getString("t_subject"));
					tripreView.setT_reg_date(rs.getString("t_reg_date"));
					tripreView.setT_content(rs.getString("t_content"));
					tripreView.setT_readcount(rs.getInt("t_readcount"));
					tripreView.setPhoto_id(rs.getString("photo_id"));
					tripreView.setT_htag(rs.getString("t_htag"));
					if(tripreView.getPhoto_id() != null) {
						PhotoDBBean dbPhoto = PhotoDBBean.getInstance();
						tripreView.setImagePath(dbPhoto.getImgPathFirst(tripreView.getPhoto_id()));
					}else tripreView.setImagePath("");
					
					tripreViewList.add(tripreView);
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
		return tripreViewList;
	}
	
	//NA
	public int getTripreViewCount(int n, String hashTagText, String search) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		String[] column_name = {"t_subject","t_content"};
		
		String[] array = hashTagText.split(" ");
		
		int s = array.length; // 해시태그의 갯수
		
		int x = 0;
		
		try
		{
			conn = getConnection();
			
			if(s == 0) {
				pstmt = conn.prepareStatement("select count (*) from tripreview where "+column_name[n]+" like '%"+search+"%'");
			}else if(s == 1) {
				pstmt = conn.prepareStatement("select count (*) "
						+ "from (select * from tripreview where t_htag like '%"+array[0]+"%') where "+column_name[n]+" like '%"+search+"%'");
			}else if(s == 2) {
				pstmt = conn.prepareStatement("select count (*) "
						+ "from (select * from tripreview where t_htag like '%"+array[0]+"%' and t_htag like '%"+array[1]+"%') where "+column_name[n]+" like '%"+search+"%'");
			}else if(s == 3) {
				pstmt = conn.prepareStatement("select count (*) "
						+ "from (select * from tripreview where t_htag like '%"+array[0]+"%' and t_htag like '%"+array[1]+"%' and t_htag like '%"+array[2]+"%') where "+column_name[n]+" like '%"+search+"%'");
			}else if(s == 4) {
			pstmt = conn.prepareStatement("select count (*) "
							+ "from (select * from tripreview where t_htag like '%"+array[0]+"%' and t_htag like '%"+array[1]+"%' and t_htag like '%"+array[2]+"%' and t_htag like '%"+array[3]+"%')"
							+ " where "+column_name[n]+" like '%"+search+"%'");
			}
			
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
	public List getTripreView(int start, int end, int n, String hashTagText, String search) throws Exception
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List tripreViewList = null;		
		
		String[] column_name = {"t_subject","t_content"}; // 분류
		
		String[] array = hashTagText.split(" ");
		
		int s = array.length; // 해시태그의 갯수
		
		try
		{
			conn = getConnection();
			String sql = "";
			if(s == 0) {
				sql ="select t_num,t_writer,t_subject,t_reg_date,t_content,t_readcount,photo_id,t_htag,r "
					+ "from (select t_num,t_writer,t_subject,t_reg_date,t_content,t_readcount,photo_id,t_htag,rownum r "
					+ "from (select * "
					+ "from tripreview order by t_num desc) where "+column_name[n]+" like '%"+search+"%' order by t_num desc) where r >= ? and r <= ? ";
			}else if(s == 1) {
				sql ="select t_num,t_writer,t_subject,t_reg_date,t_content,t_readcount,photo_id,t_htag,r "
						+ "from (select t_num,t_writer,t_subject,t_reg_date,t_content,t_readcount,photo_id,t_htag,rownum r "
						+ "from (select * "
						+ "from (select * "
						+ "from tripreview where t_htag like '%"+array[0]+"%') order by t_num desc) where "+column_name[n]+" like '%"+search+"%' order by t_num desc) where r >= ? and r <= ? ";
			}else if(s == 2) {
				sql ="select t_num,t_writer,t_subject,t_reg_date,t_content,t_readcount,photo_id,t_htag,r "
						+ "from (select t_num,t_writer,t_subject,t_reg_date,t_content,t_readcount,photo_id,t_htag,rownum r "
						+ "from (select * "
						+ "from (select * "
						+ "from tripreview where t_htag like '%"+array[0]+"%' and t_htag like '%"+array[1]+"%') order by t_num desc) where "+column_name[n]+" like '%"+search+"%' order by t_num desc) where r >= ? and r <= ? ";
			}else if(s == 3) {
				sql ="select t_num,t_writer,t_subject,t_reg_date,t_content,t_readcount,photo_id,t_htag,r "
						+ "from (select t_num,t_writer,t_subject,t_reg_date,t_content,t_readcount,photo_id,t_htag,rownum r "
						+ "from (select * "
						+ "from (select * "
						+ "from tripreview where t_htag like '%"+array[0]+"%' and t_htag like '%"+array[1]+"%' and t_htag like '%"+array[2]+"%') order by t_num desc) where "+column_name[n]+" like '%"+search+"%' order by t_num desc) where r >= ? and r <= ? ";
			}else if(s == 4) {
				sql ="select t_num,t_writer,t_subject,t_reg_date,t_content,t_readcount,photo_id,t_htag,r "
						+ "from (select t_num,t_writer,t_subject,t_reg_date,t_content,t_readcount,photo_id,t_htag,rownum r "
						+ "from (select * "
						+ "from (select * "
						+ "from tripreview where t_htag like '%"+array[0]+"%' and t_htag like '%"+array[1]+"%' and t_htag like '%"+array[2]+"%' and t_htag like '%"+array[3]+"%') order by t_num desc) where "+column_name[n]+" like '%"+search+"%' order by t_num desc) where r >= ? and r <= ? ";
			}
						
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2,	end);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				tripreViewList = new ArrayList(end);
				do {
					TripreviewDataBean tripreView = new TripreviewDataBean();
					tripreView.setT_num(rs.getInt("t_num"));
					tripreView.setT_writer(rs.getString("t_writer"));
					tripreView.setT_subject(rs.getString("t_subject"));
					tripreView.setT_reg_date(rs.getString("t_reg_date"));
					tripreView.setT_content(rs.getString("t_content"));
					tripreView.setT_readcount(rs.getInt("t_readcount"));
					tripreView.setPhoto_id(rs.getString("photo_id"));
					tripreView.setT_htag(rs.getString("t_htag"));
					if(tripreView.getPhoto_id() != null) {
						PhotoDBBean dbPhoto = PhotoDBBean.getInstance();
						tripreView.setImagePath(dbPhoto.getImgPathFirst(tripreView.getPhoto_id()));
					}else tripreView.setImagePath("");
					
					tripreViewList.add(tripreView);
				}while(rs.next());
				
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
		
		return tripreViewList;
	}
	
	//NA
	public void setTripreViewList(String id,String t_subject,String t_content,String photo_id,String t_htag) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			conn = getConnection();
				
			String sql = "insert into tripreview(t_num,t_writer,t_subject,t_content,photo_id,t_htag) values(tripreview_num.nextval,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,t_subject);
			pstmt.setString(3,t_content);
			pstmt.setString(4,photo_id);
			pstmt.setString(5,t_htag);
			
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
	
	//NA
	public TripreviewDataBean getContentForm(int t_num) throws Exception  {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		TripreviewDataBean tripreView = new TripreviewDataBean();
		
		try
		{
			conn = getConnection();
			String sql = "update tripreview set t_readcount=t_readcount+1 where t_num = ?";
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, t_num);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select * from tripreview where t_num = ?");
			pstmt.setInt(1, t_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				tripreView.setT_num(rs.getInt("t_num"));
				tripreView.setT_writer(rs.getString("t_writer"));
				tripreView.setT_subject(rs.getString("t_subject"));
				tripreView.setT_reg_date(rs.getString("t_reg_date"));
				tripreView.setT_content(rs.getString("t_content"));
				tripreView.setT_readcount(rs.getInt("t_readcount"));
				tripreView.setPhoto_id(rs.getString("photo_id"));
				tripreView.setT_htag(rs.getString("t_htag"));
				
		}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(rs != null) try {rs.close();} catch(SQLException ex){}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex){}
			if(conn != null) try {conn.close();} catch(SQLException ex){}
		}
		return tripreView;
	}
	
	//NA
	public void setBoardDelete(int t_num, String photo_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String[] array;
		
		try
		{
			conn = getConnection();
		
		if(photo_id != null) {
			array = photo_id.split(" ");
		
			if(array.length == 1) {		
				pstmt = conn.prepareStatement("delete from photo where photo_id = ?");
			}else if(array.length == 2) {
				pstmt = conn.prepareStatement("delete from photo where photo_id = ? or photo_id = ?");
			}else if(array.length == 3) {
				pstmt = conn.prepareStatement("delete from photo where photo_id = ? or photo_id = ? or photo_id = ?");
			}else if(array.length == 4) {
				pstmt = conn.prepareStatement("delete from photo where photo_id = ? or photo_id = ? or photo_id = ? or photo_id = ?");
			}else if(array.length == 5) {
				pstmt = conn.prepareStatement("delete from photo where photo_id = ? or photo_id = ? or photo_id = ? or photo_id = ? or photo_id = ?");
			}
			int i = 1;
			
			for(String s : array) {
				pstmt.setString(i,s);
				i++;			
			}
			pstmt.executeUpdate();
		}
		
			pstmt = conn.prepareStatement("delete from tripreview where t_num = ?");
			pstmt.setInt(1,t_num);
			
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
	
	//NA
	public void setTripreViewUpdatePro(int t_num,String t_subject,String t_content,String t_htag) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			conn = getConnection();
				
			String sql = "update tripreview set t_subject = ?,t_content = ?,t_htag = ? where t_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,t_subject);
			pstmt.setString(2,t_content);
			pstmt.setString(3,t_htag);
			pstmt.setInt(4,t_num);
						
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
	
	//NA
	public List getHashTag(String htag) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List hashTagList = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select * from hashtag where h_type = ?");
			pstmt.setString(1, htag);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				hashTagList = new ArrayList();
				do {
					HashTagDataBean hashTag = new HashTagDataBean();
					hashTag.setH_num(rs.getInt("h_num"));
					hashTag.setH_type(rs.getString("h_type"));
					hashTag.setH_name(rs.getString("h_name"));
					System.out.println("h_num::" + rs.getInt("h_num"));
					hashTagList.add(hashTag);
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
		return hashTagList;
	}

  
}