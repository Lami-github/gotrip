package action.buyer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buyer.BuyerDBBean;
import controller.CommandAction;

public class BuyerUpdateProAction implements CommandAction { 
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		int b_num = Integer.parseInt(request.getParameter("b_num"));// 게시글번호
		String b_subject = request.getParameter("b_subject"); //변경된 게시글 제목
		String b_item = request.getParameter("b_item"); //변경된 상품명
		String b_count = request.getParameter("b_count"); //변경된 상품개수
		String b_price = request.getParameter("b_price"); //변경된 상품가격
		String b_content = request.getParameter("b_content"); // 변경된 게시글 내용
		String b_country = request.getParameter("b_country"); // 변경된 게시글 내용
		
		BuyerDBBean dbPro = BuyerDBBean.getInstance();
		dbPro.setBuyerBoardUpdatePro(b_num,b_subject,b_country,b_item,b_count,b_price,b_content);
						
		request.setAttribute("b_num", new Integer(b_num));
				
		return "/NA/buyer/updateFormPro.jsp";
	}
}