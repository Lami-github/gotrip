package action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class FindpwdPro1Action implements CommandAction{

	 public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		 request.setCharacterEncoding("utf-8");
		 
		 String id = request.getParameter("id");
		 
		 request.setAttribute("id", id);
		 
		 return "/km/login/findpwdPro1.jsp";
	 }

}
