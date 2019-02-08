package action.payinsert;

import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import member.MemberDataBean;
import PayList.*;


public class InsertAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		PayListDataBean pldb = new PayListDataBean();    
        MemberDataBean uldb = new MemberDataBean();
		
		
		pldb.setPg(request.getParameter("pg"));
		pldb.setPay_method(request.getParameter("pay_method"));
		pldb.setEmail(request.getParameter("email"));
		pldb.setP_name(request.getParameter("p_name"));
		pldb.setPhonenumber(Integer.parseInt(request.getParameter("phone")));  
		pldb.setAddress(request.getParameter("address"));
		pldb.setZipcode(Integer.parseInt(request.getParameter("zipcode")));  
		pldb.setPay_price(Integer.parseInt(request.getParameter("pay_price")));
		pldb.setName(request.getParameter("name"));
		
		PayListDBBean pdbb = PayListDBBean.getInstance();
		String link = pdbb.insertPaylist(pldb);
		//pay_list를 불러와서 pay_no를 저장
		//insertPaymentInfo메소드는 imp_uid를 저장하지 못함. 우선 0을 저장함.
		
		int pay_no = Integer.parseInt((link.split("=")[1]));
		
		request.setAttribute("pg", request.getParameter("pg"));
		request.setAttribute("pay_method", request.getParameter("pay_method"));
		request.setAttribute("reg_date", System.currentTimeMillis());
		request.setAttribute("p_name", request.getParameter("p_name"));
		request.setAttribute("email", request.getParameter("email"));
		request.setAttribute("name", request.getParameter("name"));
		request.setAttribute("phone", request.getParameter("phone"));
		request.setAttribute("address", request.getParameter("address"));
		request.setAttribute("zipcode",Integer.parseInt(request.getParameter("zipcode")));
		request.setAttribute("pay_price", Integer.parseInt(request.getParameter("pay_price")));
		request.setAttribute("pay_no", pay_no);
		//PayListDataBean, memberDataBean에 결제에 필요한 값들을 불러옴.
		//아래의 insertPaymentlist메소드 실행할 때 필요함.	
		
		return link;
		///"EB/MyPage/payment/IamportTest.jsp?pay_no="+pay_no
		//성공시 IamportTest.jsp에 pay_no을 들고감.

	}
}
