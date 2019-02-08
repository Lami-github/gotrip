package action.buyer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buyer.BuyerDBBean;
import controller.CommandAction;


public class DealRequestAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String b_num = request.getParameter("b_num");
		
		BuyerDBBean bdb = BuyerDBBean.getInstance();
		String buyer = bdb.buyerSearch(b_num);
		
		request.setAttribute("buyer", buyer);
		request.setAttribute("b_num", b_num);
		
		return "/NA/buyer/dealRequest.jsp";
	}
}
