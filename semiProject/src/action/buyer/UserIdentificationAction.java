package action.buyer;

import javax.servlet.http.*;

import buyer.BuyerDBBean;
import controller.CommandAction;

public class UserIdentificationAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		String password = request.getParameter("password");
		String b_num = request.getParameter("b_num");
		String b_writer = request.getParameter("b_writer");
		String trade_country = request.getParameter("trade_country");
		String trade_item = request.getParameter("trade_item");
		String trade_count = request.getParameter("trade_count");
		String trade_point = request.getParameter("trade_point");
		
		if (id == null) {
			return "/view/nullCommand.jsp";
		}
		
		BuyerDBBean bdb = BuyerDBBean.getInstance();
		int check = bdb.userIdentification(id, password);

		request.setAttribute("check", check);
		request.setAttribute("b_num", b_num);
		request.setAttribute("b_writer", b_writer);
		request.setAttribute("trade_count", trade_count);
		request.setAttribute("trade_item", trade_item);
		request.setAttribute("trade_point", trade_point);
		request.setAttribute("trade_country", trade_country);
		return "/NA/buyer/dealRequest.jsp";
	}

}
