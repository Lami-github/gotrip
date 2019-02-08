package adminaction.Notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeDataBean;
import notice.NoticeDBBean;
import controller.CommandAction;

public class NoticeModifyProAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		String pageNum = request.getParameter("pageNum");
		int num = Integer.parseInt(request.getParameter("num"));
		NoticeDataBean article = new NoticeDataBean();
		article.setN_num(num);
		article.setN_subject(request.getParameter("subject"));
		article.setN_content(request.getParameter("content"));

		NoticeDBBean dbPro = NoticeDBBean.getInstance();
		dbPro.updateArticle(article);
		
		request.setAttribute("pageNum", new Integer(pageNum));
		
		return "/JY/Notice/NoticeModifyPro.jsp";
	}
}
