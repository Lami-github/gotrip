package photo;

import java.sql.*;
import javax.sql.*;

import HashTag.HashTagDataBean;
import buyer.BuyerDataBean;
import personalquestion.PersonalquestionDataBean;

import javax.naming.*;
import javax.servlet.http.HttpServlet;
import java.util.*;

public class PhotoDBBean {
	private static PhotoDBBean instance = new PhotoDBBean();

	public static PhotoDBBean getInstance() { //***
		return instance;
	}

	private PhotoDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	//JY
	public String getArticles(String photo_id) throws Exception { //***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String[] photos;
		String photoList = "";
		try {
			conn = getConnection();
			photos = photo_id.split(" ");
			for (int i = 0; i < photos.length; i++) {
			
				pstmt = conn.prepareStatement("select photo_id,img from photo where photo_id=?");
				pstmt.setInt(1, Integer.parseInt(photos[i]));

				rs = pstmt.executeQuery();

				if (rs.next()) {
					
					do {
						photoList = photoList + rs.getString("img")+",";
						if(i == photos.length-1) {
							photoList += rs.getString("img");
						}
					} while (rs.next());
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
		return photoList;
	}

	

	//JY
	public String insertPhoto(String name, String path, int index, int size) { //***
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		String photo_id="";

		try {
			conn = getConnection();
			// Äõ¸®¸¦ ÀÛ¼º
			sql = "insert into photo(photo_id,img,imgpath) values(photo_num.nextval,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, path);
			pstmt.executeUpdate();
			conn.commit();
			pstmt = conn.prepareStatement("select max(photo_id) from photo ");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					photo_id += rs.getString(1);
				}while(rs.next());
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
		return photo_id;

	}
	
	//MJ
	public PhotoDataBean getPhoto(int photo_id) throws Exception {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PhotoDataBean pdb=null;
        try {
            conn = getConnection();

            pstmt = conn.prepareStatement("select * from photo where photo_id = ?");
            pstmt.setInt(1, photo_id);
            
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	pdb = new PhotoDataBean();
            	pdb.setPhoto_id(rs.getInt("photo_id"));
            	pdb.setImg(rs.getString("img"));
            	pdb.setImgpath(rs.getString("imgpath"));
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return pdb;
	}
	
	//MJ
	public String[] getImgPath(String photo_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String[] array = photo_id.split(" ");
		
		String[] imgpath = new String[5];
				
		try {
			conn = getConnection();

			if(array.length == 1) {
				pstmt = conn.prepareStatement("select * from photo where photo_id = ?");
				int photo_id1 = Integer.parseInt(array[0]);
				pstmt.setInt(1, photo_id1);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					imgpath[0] = rs.getString("imgpath");
				}
			}else if(array.length == 2) {
				pstmt = conn.prepareStatement("select * from photo where photo_id = ?");
				int photo_id1 = Integer.parseInt(array[0]);
				int photo_id2 = Integer.parseInt(array[1]);
				pstmt.setInt(1, photo_id1);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					imgpath[0] = rs.getString("imgpath");
				}
				pstmt.setInt(1, photo_id2);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					imgpath[1] = rs.getString("imgpath");
				}
			}else if(array.length == 3) {
				pstmt = conn.prepareStatement("select * from photo where photo_id = ?");
				int photo_id1 = Integer.parseInt(array[0]);
				int photo_id2 = Integer.parseInt(array[1]);
				int photo_id3 = Integer.parseInt(array[2]);
				pstmt.setInt(1, photo_id1);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					imgpath[0] = rs.getString("imgpath");
				}
				pstmt.setInt(1, photo_id2);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					imgpath[1] = rs.getString("imgpath");
				}
				pstmt.setInt(1, photo_id3);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					imgpath[2] = rs.getString("imgpath");
				}
			}else if(array.length == 4) {
				pstmt = conn.prepareStatement("select * from photo where photo_id = ?");
				int photo_id1 = Integer.parseInt(array[0]);
				int photo_id2 = Integer.parseInt(array[1]);
				int photo_id3 = Integer.parseInt(array[2]);
				int photo_id4 = Integer.parseInt(array[3]);
				pstmt.setInt(1, photo_id1);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					imgpath[0] = rs.getString("imgpath");
				}
				pstmt.setInt(1, photo_id2);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					imgpath[1] = rs.getString("imgpath");
				}
				pstmt.setInt(1, photo_id3);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					imgpath[2] = rs.getString("imgpath");
				}
				pstmt.setInt(1, photo_id4);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					imgpath[3] = rs.getString("imgpath");
				}
			}else if(array.length == 5) {
				pstmt = conn.prepareStatement("select * from photo where photo_id = ?");
				int photo_id1 = Integer.parseInt(array[0]);
				int photo_id2 = Integer.parseInt(array[1]);
				int photo_id3 = Integer.parseInt(array[2]);
				int photo_id4 = Integer.parseInt(array[3]);
				int photo_id5 = Integer.parseInt(array[4]);
				pstmt.setInt(1, photo_id1);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					imgpath[0] = rs.getString("imgpath");
				}
				pstmt.setInt(1, photo_id2);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					imgpath[1] = rs.getString("imgpath");
				}
				pstmt.setInt(1, photo_id3);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					imgpath[2] = rs.getString("imgpath");
				}
				pstmt.setInt(1, photo_id4);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					imgpath[3] = rs.getString("imgpath");
				}
				pstmt.setInt(1, photo_id5);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					imgpath[4] = rs.getString("imgpath");
				}
			}
			
					
		}catch (Exception ex) {
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
		return imgpath;
	
	}
	
	//MJ
	public void setPhoto(String fileName, String imgPath) throws Exception  {
		Connection conn = null;
		PreparedStatement pstmt = null;
				
		try
		{
			conn = getConnection();
				
			String sql = "insert into photo values(photo_num.nextval,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,fileName);
			pstmt.setString(2,imgPath);
			
			pstmt.executeUpdate();
									
		}
		catch(Exception ex)
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
	public String getPhoto_id() throws Exception  {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String photo_id = "";
		
		try
		{
			conn = getConnection();
				
			pstmt = conn.prepareStatement("select photo_num.nextval from dual");
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				photo_id = (rs.getInt("nextval")-1)+"";
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
		return photo_id;
	}
	
	//MJ
	public String getImgPathFirst(String photo_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String[] array = photo_id.split(" ");
		String imgPath ="";				
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select * from photo where photo_id = ?");
			int photo_id1 = Integer.parseInt(array[0]);
			pstmt.setInt(1, photo_id1);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			imgPath = rs.getString("img");
			}
						
		}catch (Exception ex) {
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
		return imgPath;
	
	}
	
	//MJ
	public String getImgName(String photo_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String[] photo = photo_id.split(" ");
		
		int photo1 = Integer.parseInt(photo[0]);
		String imgName ="";				
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select * from photo where photo_id = ?");
			pstmt.setInt(1, photo1);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			imgName = rs.getString("img");
			}
						
		}catch (Exception ex) {
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
		return imgName;
	
	}
	
	
	
	//NA
	public String[] getImgNameAll(String photo_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String[] photo = photo_id.split(" ");
		int x = photo.length;
		String[] imgName = new String[x];
		
		int i = 0;
		
		try {
			for(String a : photo) {
				if(a != null) {
					int photo1 = Integer.parseInt(photo[i]);
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select * from photo where photo_id = ?");
			pstmt.setInt(1, photo1);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			imgName[i] = rs.getString("img");
			}
			i++;
				}
			}
		}catch (Exception ex) {
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
		return imgName;
	
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