package action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class FindpwdForm1Action implements CommandAction{

	 public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		 return "/km/login/findpwdForm1.jsp";
	 }

}
