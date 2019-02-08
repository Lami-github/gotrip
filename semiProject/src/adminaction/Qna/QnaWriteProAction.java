package adminaction.Qna;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Qna.QnaDBBean;
import Qna.QnaDataBean;
import controller.CommandAction;


public class QnaWriteProAction implements CommandAction {
	//涝仿等 臂 贸府
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		QnaDataBean article = new QnaDataBean(); //单捞磐贸府 后
		
		article.setQ_subject(request.getParameter("q_subject"));
		article.setQ_content(request.getParameter("q_content"));
		

		QnaDBBean dbPro = QnaDBBean.getInstance(); //DB贸府
		dbPro.insertArticle(article);
		
		return "/JY/Qna/QnaWritePro.jsp";
	}
}
