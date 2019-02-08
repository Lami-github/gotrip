package action.PQ;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class PQWriteFormAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		
		return "/JY/PQ/MainPQWriteForm.jsp"; //ÇØ´ç ºä
	}
}
