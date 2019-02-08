package action.myPageTrade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import trade.TradeDBBean;

public class InputInvoice_numAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		String invoice_num=request.getParameter("invoice_num");
		int trade_num=new Integer(request.getParameter("trade_num"));
		
		TradeDBBean dbPro=TradeDBBean.getInstance();
		dbPro.inputInvoice_Number(trade_num, invoice_num);
		
		
		
		return "/km/myPageTrade/inputInvoice_num.jsp";
}
}
