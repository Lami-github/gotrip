package action.tripreview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import tripreview.TripreviewDBBean;

public class TripreViewUpdateProAction implements CommandAction { 
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		String t_subject = request.getParameter("t_subject"); //게시글 내용
		int t_num = Integer.parseInt(request.getParameter("t_num"));// 게시글번호
		String t_htag = request.getParameter("t_htag"); //해시태그
		String t_content = request.getParameter("t_content"); // 사진 id
		
		TripreviewDBBean dbPro = TripreviewDBBean.getInstance();
		dbPro.setTripreViewUpdatePro(t_num,t_subject,t_content,t_htag);
		
		
				
		request.setAttribute("t_num", new Integer(t_num));
				
		return "/NA/tripreView/updateFormPro.jsp";
	}
}