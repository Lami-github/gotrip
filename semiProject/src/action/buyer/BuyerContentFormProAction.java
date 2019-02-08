package action.buyer;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buyer.comment.BuyerCommentDBBean;
import controller.CommandAction;

public class BuyerContentFormProAction implements CommandAction { 
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		String commentId = request.getParameter("id"); //�ڸ�Ʈ �ۼ��ϴ� ��� id(���� �α����ѻ���� id)
		int b_num = Integer.parseInt(request.getParameter("b_num"));// �Խñ۹�ȣ
		String commentText = request.getParameter("commentText"); //�ڸ�Ʈ ����

		BuyerCommentDBBean dbcPro = BuyerCommentDBBean.getInstance();
		if(commentText != null) {
			dbcPro.setBuyerBoardComment(commentId,b_num,commentText);
			}
		
		request.setAttribute("b_num", new Integer(b_num)); // �Խñ� �ѹ�
		
		return "/NA/buyer/contentFormPro.jsp";
	}
}