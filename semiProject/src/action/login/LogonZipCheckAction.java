package action.login;

import java.util.Vector;
import javax.servlet.http.*;
import controller.CommandAction;
import member.*;

public class LogonZipCheckAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable	{
		request.setCharacterEncoding("utf-8");
		String check = request.getParameter("check");
		String area4 = request.getParameter("area4");
		
		MemberDBBean manager = MemberDBBean.getInstance();
		Vector zipcodeList = manager.zipcodeRead(area4);
		int totalList = zipcodeList.size();
		
		request.setAttribute("zipcodeList",zipcodeList);
		request.setAttribute("check", check);
		request.setAttribute("totalList", new Integer(totalList));
		
		return "/km/login/ZipCheck.jsp";
	}

}
