package action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class InputFormAction implements CommandAction{//ȸ������ ó��

	public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {
		
				
		return "/km/login/inputForm.jsp";
}
}
