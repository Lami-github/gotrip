package action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class LoginFormAction implements CommandAction{

	 public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		 
		 
		 
		 
		 
		 return "/km/login/loginForm.jsp";
	 }
}
