package action.buyer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buyer.comment.BuyerCommentDBBean;
import controller.CommandAction;

public class BuyerCommentModifyAction implements CommandAction { 
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		int bc_num = Integer.parseInt(request.getParameter("bc_num")); //코멘트번호
		int b_num = Integer.parseInt(request.getParameter("b_num")); //게시글 번호

		String bc_comment = request.getParameter("bc_comment"); // 새로운 코멘트 내용
		
		BuyerCommentDBBean dbcPro = BuyerCommentDBBean.getInstance();
		dbcPro.setUpdateComment(bc_num, bc_comment);
		
		request.setAttribute("b_num", new Integer(b_num)); // 게시글 번호

		
		
		return "/NA/buyer/commentDeletePro.jsp";
		
	}
		
	}
