package action.PQ;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import personalquestion.PersonalquestionDBBean;
import personalquestion.PersonalquestionDataBean;

public class PQWriteProAction implements CommandAction {
	//�Էµ� �� ó��
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		PersonalquestionDataBean article = new PersonalquestionDataBean(); //������ó�� ��
		
	/*	article.setPq_subject(request.getParameter("pq_subject"));
		article.setPq_type(request.getParameter("sendtype"));
		System.out.println("send_pq: "+request.getParameter("sendtype"));
		article.setPq_content(request.getParameter("pq_content"));
		article.setWriter(request.getParameter("writer"));*/

		PersonalquestionDBBean dbPro = PersonalquestionDBBean.getInstance(); //DBó��
		dbPro.insertArticle(article);
		
		return "/JY/PQ/MainPQWritePro.jsp";
	}
}
