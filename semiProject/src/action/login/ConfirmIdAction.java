package action.login;

import javax.servlet.http.*;

import controller.CommandAction;
import member.MemberDBBean;

public class ConfirmIdAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response ) throws Throwable {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String idcheck = request.getParameter("idcheck");
		
		MemberDBBean dbPro = MemberDBBean.getInstance();
		int check = dbPro.confirmId(id);
		
		request.setAttribute("id", id);
		request.setAttribute("check", new Integer(check));
		request.setAttribute("idcheck", idcheck);
		
		return "/km/login/confirmId.jsp";
	}

}
