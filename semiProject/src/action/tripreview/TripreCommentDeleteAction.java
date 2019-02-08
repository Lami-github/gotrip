package action.tripreview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import tripreview.comment.TripreViewCommentDBBean;


public class TripreCommentDeleteAction implements CommandAction {
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		int tc_num = Integer.parseInt(request.getParameter("tc_num")); //�ڸ�Ʈ��ȣ
		int t_num = Integer.parseInt(request.getParameter("t_num")); //�Խñ� ��ȣ
		
		TripreViewCommentDBBean dbcPro = TripreViewCommentDBBean.getInstance();
		dbcPro.setDeleteComment(tc_num);
		
		request.setAttribute("t_num", new Integer(t_num)); // �Խñ� ��ȣ
		
		
		return "/NA/tripreView/commentDeletePro.jsp";
		
	}
}
