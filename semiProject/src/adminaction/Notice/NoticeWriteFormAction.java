package adminaction.Notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.CommandAction;

public class NoticeWriteFormAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setAttribute("modify", 0);
		
		return "/JY/Notice/NoticeWriteForm.jsp"; //ÇØ´ç ºä
	}
}
