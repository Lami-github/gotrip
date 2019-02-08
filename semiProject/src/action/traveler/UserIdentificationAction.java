package action.traveler;

import javax.servlet.http.*;
import controller.CommandAction;
import traveler.TravelerDBBean;

public class UserIdentificationAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		String password = request.getParameter("password");
		String tr_num = request.getParameter("tr_num");
		if (id == null) {
			return "/view/nullCommand.jsp";
		}
		
		TravelerDBBean tdb = TravelerDBBean.getInstance();
		int check = tdb.userIdentification(id, password);

		request.setAttribute("check", check);
		request.setAttribute("tr_num", tr_num);
		return "/mj/traveler/usercheck.jsp";
	}

}
