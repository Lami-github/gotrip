package action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import member.MemberDBBean;

public class ChangePwdAction  implements CommandAction{

	 public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		
		 request.setCharacterEncoding("utf-8");
		 String id=request.getParameter("id");
		 String password=request.getParameter("password");
		 MemberDBBean dbPro = MemberDBBean.getInstance();
		 dbPro.changePass(password, id);
		 
		 		 		 
		 return "/km/login/changePwd.jsp";
	 }

}
