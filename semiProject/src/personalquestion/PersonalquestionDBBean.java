package personalquestion;

import java.sql.*;
import javax.sql.*;

import javax.naming.*;
import javax.servlet.http.HttpServlet;
import java.util.*;

public class PersonalquestionDBBean {
	private static PersonalquestionDBBean instance = new PersonalquestionDBBean();

	public static PersonalquestionDBBean getInstance() { // ***
		return instance;
	}

	private PersonalquestionDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	// JY
	public void insertArticle(PersonalquestionDataBean article) throws Exception { // ***asd
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 답변글인지 일반글인지를 구분해서 입력시켜주는 로직!!!
		int num = article.getPq_num();
		int ref = article.getRef();
		int re_step = article.getRe_step();
		int re_level = article.getRe_level();
		int number = 0;
		String sql = "";

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select max(pq_num) from personalquestion");
			rs = pstmt.executeQuery();

			if (rs.next())
				number = rs.getInt(1) + 1;
			else
				number = 1;

			if (num != 0) //
			{
				sql = "update personalquestion set re_step=re_step+1 where ref= ? and re_step> ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();
				re_step = re_step + 1;
				re_level = re_level + 1;
			} else {
				ref = number;
				re_step = 0;
				re_level = 0;
			}
			// 쿼리를 작성
			sql = "insert into personalquestion(pq_num,pq_type,pq_subject,writer,";
			sql += "ref,re_step,re_level,pq_content,search) values(personalquestion_seq.NEXTVAL,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "결제문의");
			pstmt.setString(2, "문의합니다");
			pstmt.setString(3, "user1");
			pstmt.setInt(4, ref);
			pstmt.setInt(5, re_step);
			pstmt.setInt(6, re_level);
			pstmt.setString(7, "안녕하세요");
			pstmt.setString(8, "user1");

			pstmt.executeUpdate();
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

	public void insertComment(PersonalquestionDataBean article) throws Exception { // ***asd
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 답변글인지 일반글인지를 구분해서 입력시켜주는 로직!!!
		int num = article.getPq_num();
		int ref = article.getRef();
		int re_step = article.getRe_step();
		int re_level = article.getRe_level();
		int number = 0;
		String sql = "";

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select max(pq_num) from personalquestion");
			rs = pstmt.executeQuery();

			if (rs.next())
				number = rs.getInt(1) + 1;
			else
				number = 1;

			if (num != 0) //
			{
				sql = "update personalquestion set re_step=re_step+1 where ref= ? and re_step> ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();
				re_step = re_step + 1;
				re_level = re_level + 1;
			} else {
				ref = number;
				re_step = 0;
				re_level = 0;
			}
			// 쿼리를 작성
			sql = "insert into personalquestion(pq_num,pq_type,pq_subject,writer,";
			sql += "ref,re_step,re_level,pq_content,search) values(pq_num.NEXTVAL,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getPq_type());
			pstmt.setString(2, article.getPq_subject());
			pstmt.setString(3, article.getWriter());
			pstmt.setInt(4, ref);
			pstmt.setInt(5, re_step);
			pstmt.setInt(6, re_level);
			pstmt.setString(7, article.getPq_content());
			pstmt.setString(8, article.getSearch());

			pstmt.executeUpdate();
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

	// JY
	public PersonalquestionDataBean getArticle(int num) throws Exception { // ***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PersonalquestionDataBean article = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from personalquestion where pq_num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new PersonalquestionDataBean();

				article.setPq_num(rs.getInt("pq_num"));
				article.setPq_type(rs.getString("pq_type"));
				article.setPq_subject(rs.getString("pq_subject"));
				article.setWriter(rs.getString("writer"));
				article.setPq_reg_date(rs.getString("pq_reg_date"));
				article.setPq_content(rs.getString("pq_content"));
				article.setRef(rs.getInt("ref"));
				article.setRe_step(rs.getInt("re_step"));
				article.setRe_level(rs.getInt("re_level"));
				System.out.println(rs.getString("pq_subject"));

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
		return article;
	}

	// JY
	public int getArticleCount() throws Exception { // ***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from personalquestion");
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
	public List getArticles(int start, int end) throws Exception { // ***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select pq_num,pq_type,pq_subject,writer,pq_reg_date,pq_content,ref,re_step,re_level,r  "
							+ "from (select pq_num,pq_type,pq_subject,writer,pq_reg_date,pq_content,ref,re_step,re_level,rownum r "
							+ "from (select pq_num,pq_type,pq_subject,writer,pq_reg_date,pq_content,ref,re_step,re_level "
							+ "from personalquestion order by ref desc, re_step asc) order by ref desc, re_step asc ) where r >= ? and r <= ? ");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList(end);
				do {
					PersonalquestionDataBean article = new PersonalquestionDataBean();
					article.setPq_num(rs.getInt("pq_num"));
					article.setPq_type(rs.getString("pq_type"));
					article.setPq_subject(rs.getString("pq_subject"));
					article.setWriter(rs.getString("writer"));
					article.setPq_reg_date(rs.getString("pq_reg_date"));
					article.setPq_content(rs.getString("pq_content"));
					article.setRef(rs.getInt("ref"));
					article.setRe_step(rs.getInt("re_step"));
					article.setRe_level(rs.getInt("re_level"));

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
	public int getCategoryCount(String select) throws Exception { // ***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String text = "";

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from personalquestion where pq_type=?");
			pstmt.setString(1, select);

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
	public List getCategoryArticles(int start, int end, String select) throws Exception { // ***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List articleList = null;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select pq_num,pq_type,pq_subject,writer,pq_reg_date,pq_content,ref,re_step,re_level,r  "
							+ "from (select pq_num,pq_type,pq_subject,writer,pq_reg_date,pq_content,ref,re_step,re_level,rownum r "
							+ "from (select pq_num,pq_type,pq_subject,writer,pq_reg_date,pq_content,ref,re_step,re_level "
							+ "from personalquestion order by ref desc, re_step asc) order by ref desc, re_step asc ) "
							+ "where r >= ? and r <= ? and pq_type = ?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			pstmt.setString(3, select);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				articleList = new ArrayList(end);
				do {
					PersonalquestionDataBean article = new PersonalquestionDataBean();
					article.setPq_num(rs.getInt("pq_num"));
					article.setPq_type(rs.getString("pq_type"));
					article.setPq_subject(rs.getString("pq_subject"));
					article.setWriter(rs.getString("writer"));
					article.setPq_reg_date(rs.getString("pq_reg_date"));
					article.setPq_content(rs.getString("pq_content"));
					article.setRef(rs.getInt("ref"));
					article.setRe_step(rs.getInt("re_step"));
					article.setRe_level(rs.getInt("re_level"));

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

	//MJ
	public int getQuestionCount(String search) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			String str = "select count(*) from personalquestion where search=?";

			pstmt = conn.prepareStatement(str);

			pstmt.setString(1, search);

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

	//MJ
	public List questionlist(String search, int start, int end) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List q_list = new ArrayList(end);

		try {
			con = getConnection();
			String str = "select *  from (select pq_num,pq_type,pq_subject,writer,pq_reg_date,pq_content,ref,re_step,re_level,search,rownum r from (select * from personalquestion where search = ? order by ref desc, re_step asc) order by ref desc, re_step asc ) where r >= ? and r <= ?";
			pstmt = con.prepareStatement(str);
			pstmt.setString(1, search);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				PersonalquestionDataBean pdb = new PersonalquestionDataBean();
				pdb.setPq_num(rs.getInt("pq_num"));
				pdb.setPq_type(rs.getString("pq_type"));
				pdb.setPq_subject(rs.getString("pq_subject"));
				pdb.setWriter(rs.getString("writer"));
				pdb.setPq_reg_date(rs.getString("pq_reg_date"));
				pdb.setPq_content(rs.getString("pq_content"));
				pdb.setRef(rs.getInt("ref"));
				pdb.setRe_step(rs.getInt("re_step"));
				pdb.setRe_level(rs.getInt("re_level"));
				pdb.setSearch(rs.getString("search"));
				q_list.add(pdb);
			}
		} catch (Exception ex) {
			System.out.println("Exception" + ex);
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
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
		}

		return q_list;
	}

	//MJ
	public PersonalquestionDataBean getQuestion(int pq_num, String pq_type, String writer) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PersonalquestionDataBean pdb = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from personalquestion where pq_num = ? and pq_type = ? and writer = ?");
			pstmt.setInt(1, pq_num);
			pstmt.setString(2, pq_type);
			pstmt.setString(3, writer);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				pdb = new PersonalquestionDataBean();
				pdb.setPq_num(rs.getInt("pq_num"));
				pdb.setPq_type(rs.getString("pq_type"));
				pdb.setPq_subject(rs.getString("pq_subject"));
				pdb.setWriter(rs.getString("writer"));
				pdb.setPq_reg_date(rs.getString("pq_reg_date"));
				pdb.setPq_content(rs.getString("pq_content"));
				pdb.setRef(rs.getInt("ref"));
				pdb.setRe_step(rs.getInt("re_step"));
				pdb.setRe_level(rs.getInt("re_level"));
				pdb.setSearch(rs.getString("search"));
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
		return pdb;
	}
}