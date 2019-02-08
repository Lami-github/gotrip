package action.buyer;

import javax.servlet.http.*;

import buyer.BuyerDBBean;
import controller.CommandAction;

public class TradeAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		if (id == null) {
			return "/view/nullCommand.jsp";
		}
		
		String b_writer = request.getParameter("b_writer");
		String trade_item = request.getParameter("trade_item");
		int trade_count = Integer.parseInt(request.getParameter("trade_count"));
		int trade_point = Integer.parseInt(request.getParameter("trade_point"));
		
		int check1 = -1;
		
		BuyerDBBean bdb = BuyerDBBean.getInstance();
		
		int memberupdate = bdb.pointUpdate(b_writer,trade_point);
		
		if(memberupdate == 1) {
			check1 = bdb.trade(id, b_writer, trade_item, trade_count, trade_point);
		
		}
		request.setAttribute("memberupdate", memberupdate);
			request.setAttribute("check1",check1);
		
		return "/NA/buyer/tradecheck.jsp";
	}

}
