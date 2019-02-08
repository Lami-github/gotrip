package action.payment;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import member.MemberDBBean;
import member.MemberDataBean;
import PayList.PayListDBBean;
import PayList.PayListDataBean;


public class PaymentInsertForm implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
	    String id = (String)session.getAttribute("id");
	   
		
		MemberDataBean member = new MemberDataBean();
	    MemberDBBean dbPro = MemberDBBean.getInstance();
	    member = dbPro.getMember(id);
	    
	    request.setAttribute("member", member);
		
		return "/EB/Main_Payment.jsp";
	}    

}


