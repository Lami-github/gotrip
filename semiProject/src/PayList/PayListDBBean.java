package PayList;
import java.sql.*;
import java.util.*;


import PayList.PayListDataBean;
import jdbc.loader.JdbcUtil;

public class PayListDBBean {
	private static PayListDBBean instance = new PayListDBBean();
	
	public static PayListDBBean getInstance(){
		return instance;
	}

	private PayListDBBean(){
	}
	
	private Connection getConnection() throws Exception{	// 해당클래스 안에서만 사용하기 위해 private설정.
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
	public String insertPaylist(PayListDataBean a) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int pay_no=0;  
		try{  
			conn = getConnection();
				sql="insert into pay_list values(pay_no_seq.nextval,?,?,?,?,?,?,?,0)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, a.getP_name());
				pstmt.setString(2, a.getPg());//number
				pstmt.setString(3, a.getPay_method());
				pstmt.setString(4, a.getReg_date());
				pstmt.setString(5, a.getUserid());
				pstmt.setInt(6,a.getPay_price());
				pstmt.setString(7, a.getImp_uid());
				
				int check = pstmt.executeUpdate();
				if(check >= 1){
					System.out.println("insert문 성공");
					
					sql = "select pay_no_seq.currval from pay_list";
					
					pstmt= conn.prepareStatement(sql);
					
					rs=pstmt.executeQuery();
					if(rs.next()) {
						pay_no = rs.getInt(1);
					}
				}  		

		}catch(Exception e){
			System.out.println("예외");
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
			JdbcUtil.close(rs);
			
		}
		return "/EB/MyPage/payment/IamportTest.jsp?pay_no="+pay_no;
	}	

	public int insertImp_uid(String imp_uid, int pay_no) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		int check = 0;
		try{
			conn = getConnection();
			sql = "update pay_list set imp_uid=? where pay_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, imp_uid);
			pstmt.setInt(2, pay_no);
			check = pstmt.executeUpdate();
			System.out.println("update문 한 후 check:::"+check);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return check;
		//check값이 0이면 Fail.jsp로 감.
	}
	
	public int insertState(int pay_no) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		int check = 0;
		try{
			conn = getConnection();
			sql = "update pay_list set state=1 where pay_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pay_no);
			check = pstmt.executeUpdate();
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);  
			JdbcUtil.close(conn);
		}
		return check;
		//check가 0이면 Fail.jsp로 감
	}

	public String getImp_uid(int pay_no) throws Throwable{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String imp_uid = "";
		String sql = "";
		
		try{
			conn = getConnection();
			sql = "select imp_uid from pay_list where pay_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pay_no);
			rs = pstmt.executeQuery();
			if(rs.next()){
				imp_uid = rs.getString("imp_uid");
			}else{
				imp_uid = "결제 정보가 온전치 않습니다. 해당 카드사에 문의 바랍니다.";
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return imp_uid;
	}
	
	public int deletePayment(int pay_no) throws Throwable{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		int check = 0;
		try{
			conn = getConnection();
			sql = "delete pay_list where pay_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pay_no);
			check = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
		}
		return check;
	}

	public int getPoint(int pay_no) throws Throwable{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "";
		int point = 0;
		try{
			conn = getConnection();
			sql = "select pay_price from pay_list where pay_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pay_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				point = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return point;
	}
	
}
	
