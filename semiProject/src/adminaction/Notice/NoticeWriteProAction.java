package adminaction.Notice;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeDBBean;
import notice.NoticeDataBean;
import controller.CommandAction;

public class NoticeWriteProAction implements CommandAction {
	//�Էµ� �� ó��
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		NoticeDataBean article = new NoticeDataBean(); //������ó�� ��
		
		article.setN_subject(request.getParameter("n_subject"));
		article.setN_content(request.getParameter("n_content"));
		article.setN_reg_date(new Timestamp(System.currentTimeMillis()));

		NoticeDBBean dbPro = NoticeDBBean.getInstance(); //DBó��
		dbPro.insertArticle(article);
		
		return "/JY/Notice/NoticeWritePro.jsp";
	}
}
