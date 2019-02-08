package action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import member.MemberDBBean;
import certification.SendMail;

public class FindpwdForm4Action  implements CommandAction{//회원인증 처리

	public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {
		
		String id = request.getParameter("id");
		MemberDBBean mdbbean = MemberDBBean.getInstance();
////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////
		String dbinfo = mdbbean.findPass(id);
		
		String dbPasswd = dbinfo.split("/")[0];
		String email = dbinfo.split("/")[1];
		
		SendMail mail = SendMail.getInstance();
		mail.PWmailSender(dbPasswd,email);
	
		
		return "/km/login/findpwdForm4.jsp";
}
}
	