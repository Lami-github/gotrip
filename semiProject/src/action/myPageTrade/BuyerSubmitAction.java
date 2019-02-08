package action.myPageTrade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminaction.StatDBBean;
import controller.CommandAction;
import trade.TradeDBBean;

public class BuyerSubmitAction implements CommandAction{

	 public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		 request.setCharacterEncoding("utf-8");
		 
		
		int trade_num=new Integer(request.getParameter("trade_num"));
		TradeDBBean dbPro = TradeDBBean.getInstance();
		String db = dbPro.submitItem(trade_num);
		
		String tr_id = db.substring(0, db.indexOf("/"));
		int point = Integer.parseInt(db.substring(db.indexOf("/")+1,db.length()));
		
		int check = dbPro.pointUpdate(tr_id,point);

////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////		
		if(check == 1) {
			StatDBBean sdb = StatDBBean.getInstance();
			sdb.successtradeCount();
		}
		StatDBBean sdb = StatDBBean.getInstance();
		sdb.successtradeCount();
		 
		 return "/km/myPageTrade/buyerSubmit.jsp";
	 }
}
