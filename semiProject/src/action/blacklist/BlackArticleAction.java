package action.blacklist;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blacklist.BlacklistDBBean;
import controller.CommandAction;

public class BlackArticleAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		HttpSession session = request.getSession(false);
		String reporter = (String) session.getAttribute("id");
		if (reporter == null) {
			return "/view/nullCommand.jsp";
		}
		
		int re_num = Integer.parseInt(request.getParameter("re_num"));
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		String bl_subject = request.getParameter("bl_subject");
		String writer = request.getParameter("writer");
		
		BlacklistDBBean dbd = BlacklistDBBean.getInstance();
		dbd.blackArticle(board_id, re_num,reporter,writer,bl_subject);
		
		return "/mj/blacklist/blacklist.jsp";
	}
}
