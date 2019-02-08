package action.tripreview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import tripreview.comment.TripreViewCommentDBBean;


public class TripreCommentMoidfyAction implements CommandAction { 
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		int tc_num = Integer.parseInt(request.getParameter("tc_num")); //코멘트번호
		int t_num = Integer.parseInt(request.getParameter("t_num")); //게시글 번호
		String tc_comment = request.getParameter("tc_comment"); // 새로운 코멘트 내용
		
		TripreViewCommentDBBean dbcPro = TripreViewCommentDBBean.getInstance();
		dbcPro.setUpdateComment(tc_num, tc_comment);
		
		request.setAttribute("t_num", new Integer(t_num)); // 게시글 번호
		
		
		return "/NA/tripreView/commentDeletePro.jsp";
		
	}
		
	}
