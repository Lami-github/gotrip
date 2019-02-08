package member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import exchange.ExchangeDataBean;
import point.PointDataBean;
import pwdquiz.PwdquizDataBean;
import trade.TradeDataBean;

public class MemberDBBean {
	private static MemberDBBean instance = new MemberDBBean();

	// LogonDBBean m = LogonDBBean.getInstance();
	public static MemberDBBean getInstance() { // ***
		return instance;
	}

	private MemberDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}

	public int adminuserCheck(String id, String passwd) throws Exception { // ***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpasswd = "";
		int x = -1;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select grade,password from member where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbpasswd = rs.getString("password");
				if (rs.getString("grade").equals("admin")) {
					if (dbpasswd.equals(passwd))
						x = 1; // 인증성공
					else
						x = 0; // 비밀번호 틀림
				} else
					x = 2; // 권한이없음
			} else
				x = -1; // 해당 아이디없음
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
	public void reDucePoint(String id, int point) throws Exception{
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn= getConnection();
			pstmt=conn.prepareStatement("select * from member where id=?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
			
			pstmt=conn.prepareStatement("update member set point=point-? where id=?");
			pstmt.setInt(1, point);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			
			pstmt=conn.prepareStatement("insert into point values(point_seq.NEXTVAL,?,SYSDATE,'환전',?,?)");
			pstmt.setString(1, id);
			pstmt.setInt(2, point);
			pstmt.setInt(3, rs.getInt("point")-point);
			pstmt.executeUpdate();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		
		
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
			if(conn!=null)try {conn.close();}catch(SQLException ex) {}
		}
		
	}
	
	public int userCheck(String id, String password) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpasswd = "";
		int x = 0; 
		String dbblacklist = "T";

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select password,blacklist from MEMBER where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbpasswd = rs.getString("password");
				if (dbpasswd.equals(password)) {
					x = 1;
					if (dbblacklist.equals(rs.getString("blacklist"))) {
						x = -1; 
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
		return x;
	}

	public int getMemberCount() throws Exception { // ***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select count(*) from member");
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

	public List getMembers(int start, int end) throws Exception { // ***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List memberList = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select id, name, phonenumber, email, point, warn, blacklist, grade"
					+ " from (select id, name, phonenumber, email, point, warn, blacklist, grade, rownum r"
					+ " from member) where r >= ? and r<=?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				memberList = new ArrayList(end);
				do {
					MemberDataBean member = new MemberDataBean();
					member.setId(rs.getString("id"));
					member.setName(rs.getString("name"));
					member.setPhonenumber(rs.getString("phonenumber"));
					member.setEmail(rs.getString("email"));
					member.setPoint(rs.getInt("point"));
					member.setWarn(rs.getInt("warn"));
					member.setBlacklist(rs.getString("blacklist"));
					member.setGrade(rs.getString("grade"));

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

	public void updateMember(MemberDataBean member) throws Exception { // ***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int point = 0;
		int warn = 0;
		String blacklist = "F";
		String grade = "일반";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select point, warn, blacklist,grade from member where id=?");
			pstmt.setString(1, member.getId());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				point = rs.getInt("point");
				warn = rs.getInt("warn");
				blacklist = rs.getString("blacklist");

				grade = rs.getString("grade");

			}
			pstmt = conn.prepareStatement("update member set point=?,warn=?,blacklist=?,grade=? where id=?");
			pstmt.setInt(1, point);
			pstmt.setInt(2, warn);
			pstmt.setString(3, blacklist);
			pstmt.setString(4, grade);
			pstmt.setString(5, member.getId());

			if (member.getPoint() != 0)
				pstmt.setInt(1, member.getPoint());
			if (member.getWarn() != 0)
				pstmt.setInt(2, member.getWarn());
			if (!member.getBlacklist().equals(""))
				pstmt.setString(3, member.getBlacklist());
			if (!member.getGrade().equals(""))
				pstmt.setString(4, member.getGrade());

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
	public List getQuiz(String id) throws Exception{
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List quizList= new ArrayList();
		
		try {
			conn=getConnection();
			pstmt= conn.prepareStatement("select * from pwdquiz natural join member where pwdquiz=pquiz_num and id=? ");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {								
				PwdquizDataBean quiz= new PwdquizDataBean();
				quiz.setPquiz_num(new Integer(rs.getInt("pquiz_num")));
				quiz.setQuiz(rs.getString("quiz"));
				quizList.add(quiz);
				}while(rs.next());
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
			if(conn!=null)try {conn.close();}catch(SQLException ex) {}
		}
		return quizList;
		
	}
	public List getElseQuiz(String id) throws Exception{
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List elsequizList= new ArrayList();
		try {
			conn=getConnection();
			pstmt= conn.prepareStatement("select * from pwdquiz natural join member where pwdquiz!=pquiz_num and id=? order by pquiz_num");
			
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {								
				PwdquizDataBean quiz= new PwdquizDataBean();
				quiz.setPquiz_num(new Integer(rs.getInt("pquiz_num")));
				quiz.setQuiz(rs.getString("quiz"));
				elsequizList.add(quiz);
				}while(rs.next());
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
			if(conn!=null)try {conn.close();}catch(SQLException ex) {}
		}
		return elsequizList;
	}

	public int getMemberCount(int n, String searchKeyword) throws Exception { // ***

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String[] column_name = { "id", "name", "warn", "grade" };

		int x = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"select count (*) from member " + "where " + column_name[n] + " like '%" + searchKeyword + "%'");

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

	public List getMembers(int start, int end, int n, String searchKeyword) throws Exception { // ***
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List memberList = null;

		String[] column_name = { "id", "name", "warn", "grade" };

		try {
			conn = getConnection();

			String sql = "select id, name, phonenumber, email, point, warn, blacklist, grade "
					+ "from (select id, name, phonenumber, email, point, warn, blacklist, grade, rownum r "
					+ "from member) where " + column_name[n] + " like '%" + searchKeyword + "%'  and r >= ? and r <= ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				memberList = new ArrayList(end);

				do {
					MemberDataBean member = new MemberDataBean();

					member.setId(rs.getString("id"));
					member.setName(rs.getString("name"));
					member.setPhonenumber(rs.getString("phonenumber"));
					member.setEmail(rs.getString("email"));
					member.setPoint(rs.getInt("point"));
					member.setWarn(rs.getInt("warn"));
					member.setBlacklist(rs.getString("blacklist"));
					member.setGrade(rs.getString("grade"));

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

	// km
	public void insertMember(MemberDataBean member) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into MEMBER values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getPhonenumber());
			pstmt.setString(5, member.getEmail());
			pstmt.setInt(6, member.getPwdquiz());
			pstmt.setString(7, member.getPwdanswer());
			pstmt.setInt(8, member.getWarn());
			pstmt.setString(9, member.getBlacklist());
			pstmt.setInt(10, member.getZipcode());
			pstmt.setString(11, member.getAddress());
			pstmt.setString(12, member.getAddress1());
			pstmt.setString(13, member.getGrade());
			pstmt.setInt(14, member.getPoint());
			
			
			

			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();// 에러출력 메세지보단 화면을 띄워서 안됏다고 말해주는게 낫다고 하심.
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

	// km
	public void insertUpdateMember(MemberDataBean member, String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"update MEMBER set password= ? , phonenumber= ?, zipcode= ?, address= ?, address1= ?, pwdquiz= ?, pwdanswer= ? where id=?");
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getPhonenumber());
			pstmt.setInt(3, member.getZipcode());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getAddress1());
			pstmt.setInt(6, member.getPwdquiz());
			pstmt.setString(7, member.getPwdanswer());
			pstmt.setString(8, id);

			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();// 에러출력 메세지보단 화면을 띄워서 안됏다고 말해주는게 낫다고 하심.
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

	 //km
	public int userCheck(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select id from member where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = 1;
			} else
				x = 0;
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

	 //km
	public int checkQuiz(String id, int pwdquiz, String pwdanswer) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select password from MEMBER where id=? and pwdquiz=? and pwdanswer=?");
			pstmt.setString(1, id);
			pstmt.setInt(2, pwdquiz);
			pstmt.setString(3, pwdanswer);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = 1;
			} else
				x = -1;
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

	 //km
	public int confirmId(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select id from MEMBER where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next())
				x = 1;
			else
				x = -1;

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

	 //km
	public MemberDataBean updateMember(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		MemberDataBean article = null;

		ResultSet rs = null;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from MEMBER where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new MemberDataBean();
				article.setPassword(rs.getString("password"));
				article.setPhonenumber(rs.getString("phonenumber"));
				article.setZipcode(new Integer(rs.getString("zipcode")));
				article.setPwdanswer(rs.getString("pwdanswer"));
				article.setName(rs.getString("name"));
				article.setEmail(rs.getString("email"));
				article.setAddress(rs.getString("address"));
				article.setAddress1(rs.getString("address1"));
				article.setPwdquiz(new Integer(rs.getString("pwdquiz")));
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

	 //km
	public PwdquizDataBean updatequiz(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PwdquizDataBean article1 = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"select Pquiz_num, quiz   from pwdquiz natural join Member where Pquiz_num=pwdquiz and id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				article1 = new PwdquizDataBean();
				article1.setQuiz(rs.getString("quiz"));

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
		return article1;
	}

	 //km
	public int deleteMember(String id, String password) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpasswd = "";
		int x = 0;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from MEMBER where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbpasswd = rs.getString("password");

				if (dbpasswd.equals(password)) {

					pstmt = conn.prepareStatement("delete from MEMBER where id=?");
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					System.out.println("delete3");
					x = 1;
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
		return x;

	}

	 //km
	public String findId(String name, String email) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbid = "";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select id from MEMBER where name=? and email=?");
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbid = rs.getString("id");
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

		return dbid;
	}

	 //km
	public String findPass(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbinfo = "";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from MEMBER where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbinfo += rs.getString("password");
				dbinfo += "/";
				dbinfo += rs.getString("email");
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

		return dbinfo;
	}

	 //km
	public int userPoint(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int point = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select point from MEMBER where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				point = rs.getInt("point");

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

		return point;
	}

	 //km
	public void changePass(String password, String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update MEMBER set password=?" + " where id=?");
			pstmt.setString(1, password);
			pstmt.setString(2, id);
			System.out.println(id + 11);
			System.out.println(password + 11);
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

	 //km
	public Vector zipcodeRead(String area4) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector vecList = new Vector();

		try {
			con = getConnection();
			String strQuery = "select * from zipcode where area4 like '" + area4 + "%'";
			pstmt = con.prepareStatement(strQuery);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ZipcodeBean tempZipcode = new ZipcodeBean();
				tempZipcode.setZipcode(rs.getString("zipcode"));
				tempZipcode.setArea1(rs.getString("area1"));
				tempZipcode.setArea2(rs.getString("area2"));
				tempZipcode.setArea3(rs.getString("area3"));
				tempZipcode.setArea4(rs.getString("area4"));
				vecList.addElement(tempZipcode);
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
		return vecList;
	}

	 //km
	public int userCheck1(String password) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select point from MEMBER where password=?");
			pstmt.setString(1, password);
			rs = pstmt.executeQuery();
			System.out.println(password);
			if (rs.next()) {
				x = 1;
			} else
				x = 0;

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
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}

	 //km
	public List<PointDataBean> getPoint(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<PointDataBean> pointList1 = new ArrayList<PointDataBean>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from point natural join member where id=?");
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					PointDataBean member = new PointDataBean();
					member.setNum(rs.getInt("num"));
					member.setId(rs.getString("id"));
					member.setType(rs.getString("type"));
					member.setUpdate_point(rs.getInt("update_point"));
					member.setUpdate_date(rs.getString("update_date"));
					member.setAfter_point(rs.getInt("after_point"));
					pointList1.add(member);

				} while (rs.next());
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
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return pointList1;
	}

	 //km
	public void exchangePoint(ExchangeDataBean member) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into exchange values(exchange_seq.NEXTVAL,?,?,?,?)");
			pstmt.setString(1, member.getBankname());
			pstmt.setString(2, member.getAc_number());
			pstmt.setString(3, member.getAc_holder());
			pstmt.setInt(4, member.getEx_point());
			pstmt.executeUpdate();
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
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}

	}

	 //km
	public List getArticle(String id, int start, int end) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TradeDataBean> tradeList = new ArrayList();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"select * from (select trade_num,b_id,tr_id,trade_item,trade_count,del_state,invoice_num,trade_point,trade_sdate,trade_edate,standby,rownum r from trade "
					+ "where b_id=?) where r >= ? and r<=?");
			
			pstmt.setString(1, id);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					TradeDataBean trade = new TradeDataBean();
					System.out.println(rs.getString("trade_num") + "/" + rs.getString("trade_item") + "/" + rs.getString("invoice_num") +"/" + rs.getInt("trade_point")+"/"+ rs.getString("del_state") );
					
					trade.setTrade_num(new Integer(rs.getString("trade_num")));
					trade.setTrade_item(rs.getString("trade_item"));
					trade.setInvoice_num(rs.getString("invoice_num"));
					trade.setTrade_point(new Integer(rs.getInt("trade_point")));
					trade.setDel_state(rs.getString("del_state"));
					
					tradeList.add(trade);

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

		return tradeList;

	}

	 //km
	public List getArticle1(String id, int start, int end) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TradeDataBean> tradeList = new ArrayList();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"select * from (select trade_num,b_id,tr_id,trade_item,trade_count,del_state,invoice_num,trade_point,trade_sdate,trade_edate,standby,rownum r from trade where tr_id=?) \"\r\n"
							+ "               + \"where r >= ? and r<=?");
			pstmt.setString(1, id);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					TradeDataBean trade = new TradeDataBean();
					trade.setTrade_num(new Integer(rs.getString("trade_num")));
					trade.setTrade_item(rs.getString("trade_item"));
					trade.setInvoice_num(rs.getString("invoice_num"));
					trade.setTrade_point(new Integer(rs.getInt("trade_point")));
					trade.setDel_state(rs.getString("del_state"));

					tradeList.add(trade);

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

		return tradeList;

	}
	 //km
	public TradeDataBean getTravelerList(int trade_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		TradeDataBean member = new TradeDataBean();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from trade member where trade_num=?");
			pstmt.setInt(1, trade_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member.setTr_id(rs.getString("tr_id"));
				member.setTrade_item(rs.getString("trade_item"));
				member.setTrade_point(Integer.parseInt((rs.getString("trade_point"))));
				member.setTrade_count(new Integer(rs.getString("trade_count")));
				member.setInvoice_num(rs.getString("invoice_num"));

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
	 //km
	public MemberDataBean getBuyerInfo(int trade_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDataBean member1 = new MemberDataBean();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from trade natural join member where trade_num=? and id=b_id");
			pstmt.setInt(1, trade_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member1.setName(rs.getString("name"));
				member1.setAddress(rs.getString("address") + rs.getString("address1"));

				member1.setZipcode(rs.getInt("zipcode"));
				member1.setPhonenumber(rs.getString("phonenumber"));
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
		return member1;
	}

	 //km
	public MemberDataBean getTravelerInfo(int trade_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDataBean member1 = new MemberDataBean();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from trade natural join member where trade_num=? and id=tr_id");
			pstmt.setInt(1, trade_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member1.setName(rs.getString("name"));
				member1.setAddress(rs.getString("address") + rs.getString("address1"));
				member1.setZipcode(rs.getInt("zipcode"));
				member1.setPhonenumber(rs.getString("phonenumber"));
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
		return member1;
	}

	 //km
	public int getArticleCount(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from trade where tr_id=? ");
			pstmt.setString(1, id);
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

	 //km
	public int getArticleCount1(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from trade where b_id=?");
			pstmt.setString(1, id);
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
	
	//EB
	public MemberDataBean getMember(String id)throws Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		MemberDataBean member=null;
		
		try {
			conn=getConnection();
			
			pstmt=conn.prepareStatement("select * from MEMBER where id =?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberDataBean();
				member.setId(id);
				System.out.println("id: " + id);
				member.setPassword(rs.getString("password"));
				member.setAddress(rs.getString("address"));
				member.setName(rs.getString("name"));
				member.setPhonenumber(rs.getString("phonenumber"));
				member.setEmail(rs.getString("email"));
				member.setZipcode(rs.getInt("zipcode"));
				System.out.println("zipcode: "+rs.getInt("zipcode"));
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
			if(conn!=null)try {conn.close();}catch(SQLException ex) {}
			
		}
		return member;
	}
	
	//EB
	public void insertPoint (String id,int point) throws Exception {
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("update MEMBER set point=point+? where id=?");
			pstmt.setInt(1, point);
			pstmt.setString(2, id);
			
			pstmt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
			if(conn!=null)try {conn.close();}catch(SQLException ex) {}
		}
	}

}
