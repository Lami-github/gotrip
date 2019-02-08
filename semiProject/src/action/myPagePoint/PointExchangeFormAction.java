package action.myPagePoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;

public class PointExchangeFormAction implements CommandAction{

	 public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		 
		 HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id");
		 if(id == null) {
		    return "/JY/nullCommand.jsp";
		 }
				 
		 request.setAttribute("id", id);
		 
		 return "/km/myPagePoint/pointExchangeForm.jsp";
	 }

}

