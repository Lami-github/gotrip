package action.myPagePoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import exchange.ExchangeDataBean;
import member.MemberDBBean;

public class PointExchangePro1Action implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id == null) {
		   return "/JY/nullCommand.jsp";
		}
		 request.setCharacterEncoding("utf-8");
		 ExchangeDataBean member= new ExchangeDataBean();
		 member.setAc_holder(request.getParameter("ac_holder"));
		 member.setBankname(request.getParameter("bankname"));
		 member.setAc_number(request.getParameter("ac_number"));
		 member.setEx_point(new Integer(request.getParameter("update_point")));
		 MemberDBBean dbPro=MemberDBBean.getInstance();
		 dbPro.exchangePoint(member);
		 dbPro.reDucePoint(id, new Integer(request.getParameter("update_point")));
		
		 return "/km/myPagePoint/pointExchangePro1.jsp";
	}
		
}
