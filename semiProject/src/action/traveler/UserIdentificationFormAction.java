package action.traveler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class UserIdentificationFormAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int tr_num = Integer.parseInt(request.getParameter("tr_num"));
		request.setAttribute("tr_num", tr_num);
		return "/mj/traveler/userIdentification.jsp";
	}
}
