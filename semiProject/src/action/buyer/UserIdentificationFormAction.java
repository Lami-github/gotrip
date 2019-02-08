package action.buyer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class UserIdentificationFormAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int b_num = Integer.parseInt(request.getParameter("b_num"));
		String b_writer = request.getParameter("b_writer");
		String trade_country = request.getParameter("trade_country");
		String trade_item = request.getParameter("trade_item");
		String trade_count = request.getParameter("trade_count");
		String trade_point = request.getParameter("trade_point");
		request.setAttribute("b_num", b_num);
		request.setAttribute("b_writer", b_writer);
		request.setAttribute("trade_count", trade_count);
		request.setAttribute("trade_item", trade_item);
		request.setAttribute("trade_point", trade_point);
		request.setAttribute("trade_country", trade_country);
		
		return "/NA/buyer/userIdentification.jsp";
	}
}
