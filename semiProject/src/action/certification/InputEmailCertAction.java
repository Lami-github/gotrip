package action.certification;

import javax.servlet.http.*;
import controller.CommandAction;

import certification.*;

public class InputEmailCertAction implements CommandAction {
		public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {
			
			String email = request.getParameter("email");
			
			SendMail mail = SendMail.getInstance();
			String certnum = Integer.toString(mail.InputmailSender(email));
			
			request.setAttribute("certnum",certnum);
			
			return "/km/login/inputEmailCerti.jsp";
	}
}