package action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import member.MemberDBBean;
import certification.*;

public class FindIdProAction implements CommandAction{

	 public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		 request.setCharacterEncoding("utf-8");
		 
		 String name = request.getParameter("name");
			String email = request.getParameter("email");
				
			MemberDBBean dbPro = MemberDBBean.getInstance();
			String dbid = dbPro.findId(name, email);
				
			SendMail mail = SendMail.getInstance();
			mail.IDmailSender(dbid,email);
				
			request.setAttribute("dbid", dbid);				 		 		 
		 		 
		return "/km/login/findIdPro.jsp";
	 }
	 }