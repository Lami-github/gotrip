package action.myPageTrade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import member.MemberDBBean;
import member.MemberDataBean;
import trade.TradeDataBean;

public class TravelerPageAction implements CommandAction{

	 public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		 request.setCharacterEncoding("utf-8");
		 
		 int trade_num=Integer.parseInt(request.getParameter("trade_num"));
		 
		 
		 MemberDBBean dbPro= MemberDBBean.getInstance();
		 TradeDataBean member=dbPro.getTravelerList(trade_num);
		 MemberDataBean member1=dbPro.getBuyerInfo(trade_num);
		 request.setAttribute("trade_num", trade_num);
		 request.setAttribute("member", member);
		 request.setAttribute("member1", member1);
		return "/km/myPageTrade/travelerPage.jsp"; 
	 }
	 }