package action.myquestion;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import personalquestion.PersonalquestionDBBean;
import personalquestion.PersonalquestionDataBean;


public class QcontentAction implements CommandAction{
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	
         int pq_num=Integer.parseInt(request.getParameter("pq_num"));
		 
         String pq_type=request.getParameter("pq_type");
         
         String writer = request.getParameter("writer");
        		          
         PersonalquestionDBBean qdb = PersonalquestionDBBean.getInstance();
         PersonalquestionDataBean QuestionContent = qdb.getQuestion(pq_num,pq_type,writer);
		 
		 request.setAttribute("QuestionContent", QuestionContent);
		 
		return "/mj/personalQuestion/questionContent.jsp";
	}
}