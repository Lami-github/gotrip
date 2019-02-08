package adminaction.Qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class QnaWriteFormAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setAttribute("modify", 0);
		
		return "/JY/Qna/QnaWriteForm.jsp"; //ÇØ´ç ºä
	}
}
