package action.traveler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import traveler.TravelerDBBean;

public class TravelerCommentEditAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		String trc_comment_edit = request.getParameter("trc_comment_edit");
		int trc_num = Integer.parseInt(request.getParameter("trc_num"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int tr_num = Integer.parseInt(request.getParameter("tr_num"));
		
		TravelerDBBean tdb = TravelerDBBean.getInstance();
		tdb.updateTravelerComment(trc_comment_edit,trc_num);
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("tr_num", tr_num);
		
		return "/mj/traveler/travelerdetailgo.jsp";
	}
		
}
