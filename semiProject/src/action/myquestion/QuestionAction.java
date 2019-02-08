package action.myquestion;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import personalquestion.PersonalquestionDBBean;

public class QuestionAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		HttpSession session = request.getSession(false);
	      String search = (String)session.getAttribute("id");
	      if(search == null) {
	         return "/view/nullCommand.jsp";
	      }
		
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 10;
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = 0;
		int number = 0;
		
		List q_list =null;
		PersonalquestionDBBean qdb = PersonalquestionDBBean.getInstance();
		count = qdb.getQuestionCount(search);

		if (count > 0) {
			q_list = qdb.questionlist(search,startRow, endRow);   
	    }else { 
	    	q_list = Collections.EMPTY_LIST;
	    }
		
		number=count-(currentPage-1)*pageSize;
		
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow",new Integer(startRow));
		request.setAttribute("endRow",new Integer(endRow));
		request.setAttribute("count",new Integer(count));
		request.setAttribute("pageSize",new Integer(pageSize));
		request.setAttribute("number",new Integer(number));
		request.setAttribute("q_list", q_list);
		
		return "/mj/personalQuestion/myQuestion.jsp";
	}
}