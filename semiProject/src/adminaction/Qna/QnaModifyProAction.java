package adminaction.Qna;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Qna.QnaDBBean;
import Qna.QnaDataBean;
import controller.CommandAction;


public class QnaModifyProAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		String pageNum = request.getParameter("pageNum");
		int num = Integer.parseInt(request.getParameter("q_num"));
		QnaDataBean article = new QnaDataBean();
		article.setQ_num(num);
		article.setQ_subject(request.getParameter("q_subject"));
		article.setQ_content(request.getParameter("q_content"));

		QnaDBBean dbPro = QnaDBBean.getInstance();
		dbPro.updateArticle(article);
		
		request.setAttribute("pageNum", new Integer(pageNum));
		
		return "/JY/Qna/QnaModifyPro.jsp";
	}
}
