package action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import member.MemberDBBean;

public class FindpwdForm3Action  implements CommandAction{//회원인증 처리

	public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {
		
		
	
		
		return "/km/login/findpwdForm3.jsp";
}
}
