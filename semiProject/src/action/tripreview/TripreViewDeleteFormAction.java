package action.tripreview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import tripreview.TripreviewDBBean;

public class TripreViewDeleteFormAction implements CommandAction { 
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		

		int t_num = Integer.parseInt(request.getParameter("t_num")); // 글번호
		String photo_id = request.getParameter("photo_id"); // 사진
			
		TripreviewDBBean dbPro = TripreviewDBBean.getInstance();
		dbPro.setBoardDelete(t_num,photo_id);
		

		
		return "/NA/tripreView/listPro.jsp";
	}
		
}