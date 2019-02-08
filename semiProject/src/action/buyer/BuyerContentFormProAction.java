package action.buyer;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buyer.comment.BuyerCommentDBBean;
import controller.CommandAction;

public class BuyerContentFormProAction implements CommandAction { 
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		String commentId = request.getParameter("id"); //코멘트 작성하는 사람 id(현재 로그인한사람의 id)
		int b_num = Integer.parseInt(request.getParameter("b_num"));// 게시글번호
		String commentText = request.getParameter("commentText"); //코멘트 내용

		BuyerCommentDBBean dbcPro = BuyerCommentDBBean.getInstance();
		if(commentText != null) {
			dbcPro.setBuyerBoardComment(commentId,b_num,commentText);
			}
		
		request.setAttribute("b_num", new Integer(b_num)); // 게시글 넘버
		
		return "/NA/buyer/contentFormPro.jsp";
	}
}