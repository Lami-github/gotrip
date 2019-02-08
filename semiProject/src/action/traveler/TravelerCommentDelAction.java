package action.traveler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import traveler.TravelerDBBean;

public class TravelerCommentDelAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		HttpSession session = request.getSession(false);
		String trc_writer = (String) session.getAttribute("id");
		if (trc_writer == null) {
			return "/view/nullCommand.jsp";
		}
		int trc_num = Integer.parseInt(request.getParameter("trc_num"));
		
		TravelerDBBean tdb = TravelerDBBean.getInstance();
		tdb.travelerCommentDel(trc_num,trc_writer);
		
		return "/mj/traveler/travelerdetailgo.jsp";
	}
}
