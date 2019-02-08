package action.traveler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import traveler.TravelerDBBean;

public class TravelerCommentAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession(false);
		String trc_writer = (String) session.getAttribute("id");
		String trc_comment = request.getParameter("trc_comment");
		int tr_num = Integer.parseInt(request.getParameter("tr_num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		TravelerDBBean tdb = TravelerDBBean.getInstance();
		tdb.insertTravelerComment(trc_writer,trc_comment,tr_num);
		
		request.setAttribute("tr_num", tr_num);
		request.setAttribute("pageNum", pageNum);
		
		return "/mj/traveler/travelerdetailgo.jsp";
	}
}
