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
		//pay_list�� �ҷ��ͼ� pay_no�� ����
		//insertPaymentInfo�޼ҵ�� imp_uid�� �������� ����. �켱 0�� ������.
		
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
		//PayListDataBean, memberDataBean�� ������ �ʿ��� ������ �ҷ���.
		//�Ʒ��� insertPaymentlist�޼ҵ� ������ �� �ʿ���.	
		
		return link;
		///"EB/MyPage/payment/IamportTest.jsp?pay_no="+pay_no
		//������ IamportTest.jsp�� pay_no�� ���.

	}
}
