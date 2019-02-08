package action.traveler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import traveler.TravelerDBBean;

public class DealRequestAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String tr_num = request.getParameter("tr_num");
		
		TravelerDBBean tdb = TravelerDBBean.getInstance();
		String traveler = tdb.travelerSearch(tr_num);
		
		request.setAttribute("traveler", traveler);
		request.setAttribute("tr_num", tr_num);
		
		return "/mj/traveler/dealRequest.jsp";
	}
}
