package adminaction.Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class LoginFormAction implements CommandAction { //회원인증 폼 처리

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		return "/JY/login/adminlogin.jsp";//해당 
	}

}
