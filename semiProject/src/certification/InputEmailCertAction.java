package certification;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class InputEmailCertAction implements CommandAction {
		public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {
			
			String email = request.getParameter("email");
			
			SendMail mail = SendMail.getInstance();
			String certnum = Integer.toString(mail.InputmailSender(email));
			
			request.setAttribute("certnum",certnum);
			
			return "/km/inputEmailCerti.jsp";
	}
}