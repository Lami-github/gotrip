package action.buyer;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buyer.BuyerDBBean;
import controller.CommandAction;

public class BuyerDeleteFormAction implements CommandAction { 
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
	
		int b_num = Integer.parseInt(request.getParameter("b_num")); // 글번호
		String photo_id = request.getParameter("photo_id"); // 사진
			
		BuyerDBBean dbPro = BuyerDBBean.getInstance();
		dbPro.setBoardDelete(b_num,photo_id);
		
		
		return "/NA/buyer/listPro.jsp";
	}
		
}