package adminaction.Notice;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeDBBean;
import notice.NoticeDataBean;
import controller.CommandAction;

public class NoticeWriteProAction implements CommandAction {
	//涝仿等 臂 贸府
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		NoticeDataBean article = new NoticeDataBean(); //单捞磐贸府 后
		
		article.setN_subject(request.getParameter("n_subject"));
		article.setN_content(request.getParameter("n_content"));
		article.setN_reg_date(new Timestamp(System.currentTimeMillis()));

		NoticeDBBean dbPro = NoticeDBBean.getInstance(); //DB贸府
		dbPro.insertArticle(article);
		
		return "/JY/Notice/NoticeWritePro.jsp";
	}
}
