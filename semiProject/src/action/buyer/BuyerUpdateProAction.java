package action.buyer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buyer.BuyerDBBean;
import controller.CommandAction;

public class BuyerUpdateProAction implements CommandAction { 
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		int b_num = Integer.parseInt(request.getParameter("b_num"));// �Խñ۹�ȣ
		String b_subject = request.getParameter("b_subject"); //����� �Խñ� ����
		String b_item = request.getParameter("b_item"); //����� ��ǰ��
		String b_count = request.getParameter("b_count"); //����� ��ǰ����
		String b_price = request.getParameter("b_price"); //����� ��ǰ����
		String b_content = request.getParameter("b_content"); // ����� �Խñ� ����
		String b_country = request.getParameter("b_country"); // ����� �Խñ� ����
		
		BuyerDBBean dbPro = BuyerDBBean.getInstance();
		dbPro.setBuyerBoardUpdatePro(b_num,b_subject,b_country,b_item,b_count,b_price,b_content);
						
		request.setAttribute("b_num", new Integer(b_num));
				
		return "/NA/buyer/updateFormPro.jsp";
	}
}