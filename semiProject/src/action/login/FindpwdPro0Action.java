package action.login;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import member.MemberDBBean;
public class FindpwdPro0Action implements CommandAction{//회원인증 처리

	public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		MemberDBBean dbPro = MemberDBBean.getInstance();
		int check = dbPro.userCheck(id);
		
		request.setAttribute("check", new Integer(check));
		request.setAttribute("id", id);

		return "/km/login/findpwdPro0.jsp";
	}
}
