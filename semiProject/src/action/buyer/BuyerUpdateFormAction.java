package action.buyer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buyer.BuyerDBBean;
import buyer.BuyerDataBean;
import controller.CommandAction;

public class BuyerUpdateFormAction implements CommandAction { 
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
	

		int b_num = Integer.parseInt(request.getParameter("b_num"));// 게시글번호
		
		BuyerDBBean dbPro = BuyerDBBean.getInstance();
		BuyerDataBean buyerBoard = dbPro.getBuyerBoardUpdateForm(b_num);
				

		request.setAttribute("b_num", new Integer(b_num));
		
		request.setAttribute("buyerBoard", buyerBoard); 
		
		return "/NA/buyer/updateForm.jsp";
	}
}