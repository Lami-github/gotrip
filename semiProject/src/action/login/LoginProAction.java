package action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import member.MemberDBBean;

public class LoginProAction implements CommandAction {// 회원인증 처리

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");
	
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberDBBean dbPro = MemberDBBean.getInstance();
		int check = dbPro.userCheck(id, password);

		request.setAttribute("check", new Integer(check));
		request.setAttribute("id", id);
		
		return "/km/login/loginPro.jsp";
	}
}
