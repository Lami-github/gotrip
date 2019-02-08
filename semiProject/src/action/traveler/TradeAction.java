package action.traveler;

import javax.servlet.http.*;
import controller.CommandAction;
import traveler.TravelerDBBean;

public class TradeAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		if (id == null) {
			return "/view/nullCommand.jsp";
		}
		
		int tr_num = Integer.parseInt(request.getParameter("tr_num"));
		String traveler = request.getParameter("traveler");
		String trade_item = request.getParameter("trade_item");
		int trade_count = Integer.parseInt(request.getParameter("trade_count"));
		int trade_point = Integer.parseInt(request.getParameter("trade_point"));
		
		int check = -1, check1 = -1;
		
		TravelerDBBean tdb = TravelerDBBean.getInstance();
		
		int memberupdate = tdb.pointUpdate(id,trade_point);
		
		if(memberupdate == 1) {
		
		check = tdb.travelerUpdate(tr_num,trade_point);
		if(check == -1) {
			request.setAttribute("check", check);
			return "/mj/traveler/tradecheck.jsp";
		}
		}
		check1 = tdb.trade(id, traveler, trade_item, trade_count, trade_point);
		
		request.setAttribute("memberupdate", memberupdate);
		request.setAttribute("check", check);
		request.setAttribute("check1",check1);
		
		return "/mj/traveler/tradecheck.jsp";
	}

}
