	package action.myPageChangeMInfo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import member.MemberDBBean;
import member.MemberDataBean;

public class ChangeMemberInfoForm1Action implements CommandAction{

	 public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		
		 
		 HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id");
		 if(id == null) {
		    return "/JY/nullCommand.jsp";
		 }
		
	
		 String password = request.getParameter("password");
			
		 MemberDBBean dbPro=MemberDBBean.getInstance();
		 int check = dbPro.userCheck(id, password);
	
		 MemberDataBean article= dbPro.updateMember(id);
	
		 List article1 = dbPro.getQuiz(id);
		 List elseQuizList = dbPro.getElseQuiz(id);
		 
		 request.setAttribute("elseQuizList",elseQuizList );		 
		 request.setAttribute("check", new Integer(check));
		 request.setAttribute("article", article);
		 request.setAttribute("article1", article1);
		 return "/km/myPageChangeMInfo/changeMemberInfoForm1.jsp";
	 }

}
