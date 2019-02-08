package action.buyer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buyer.comment.BuyerCommentDBBean;
import controller.CommandAction;

public class BuyerCommentDeleteAction implements CommandAction {
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		int bc_num = Integer.parseInt(request.getParameter("bc_num")); //�ڸ�Ʈ��ȣ
		int b_num = Integer.parseInt(request.getParameter("b_num")); //�Խñ� ��ȣ
		
		BuyerCommentDBBean dbcPro = BuyerCommentDBBean.getInstance();
		dbcPro.setDeleteComment(bc_num);
		
		request.setAttribute("b_num", new Integer(b_num)); // �Խñ� ��ȣ
		
		
		return "/NA/buyer/commentDeletePro.jsp";
		
	}
}
