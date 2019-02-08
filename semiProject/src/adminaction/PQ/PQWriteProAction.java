package adminaction.PQ;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import personalquestion.PersonalquestionDBBean;
import personalquestion.PersonalquestionDataBean;
import controller.CommandAction;



//涝仿等 臂贸府
public class PQWriteProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8"); // 茄臂 牢内爹
		
		PersonalquestionDataBean article = new PersonalquestionDataBean(); // 单捞磐贸府 后
		article.setPq_num(Integer.parseInt(request.getParameter("pq_num")));
		article.setPq_type(request.getParameter("pq_type"));
		article.setPq_subject(request.getParameter("pq_subject"));
		article.setWriter(request.getParameter("writer"));
		article.setPq_reg_date(request.getParameter("pq_reg_date"));
		article.setPq_content(request.getParameter("pq_content"));
		article.setRef(Integer.parseInt(request.getParameter("ref")));
		article.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		article.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		article.setSearch(request.getParameter("search"));
		
		PersonalquestionDBBean dbPro = PersonalquestionDBBean.getInstance(); //DB贸府
		dbPro.insertComment(article);

		return "/JY/PQ/PQWritePro.jsp";
	} 

}
