package action.myPageTrade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import trade.TradeDBBean;

public class CancelTradeAction implements CommandAction{

	
	
	
	 public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		 
		 TradeDBBean dbPro=TradeDBBean.getInstance();
		 
		 HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id");
		 if(id == null) {
		    return "/JY/nullCommand.jsp";
		 }
		 int trade_num=new Integer(request.getParameter("trade_num"));
		 
		 dbPro.cancelTrade(trade_num);
		 
		 
		 return "/km/myPageTrade/cancelTrade.jsp";
	 }

}


