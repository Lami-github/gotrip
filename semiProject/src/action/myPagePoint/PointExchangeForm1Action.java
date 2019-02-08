package action.myPagePoint;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import member.MemberDBBean;

public class PointExchangeForm1Action implements CommandAction{

	 public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		 
		 request.setCharacterEncoding("utf-8");
		 HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id");
		 if(id == null) {
		    return "/JY/nullCommand.jsp";
		 }
		 
		 String password= request.getParameter("password");
		
		 MemberDBBean dbPro = MemberDBBean.getInstance();
		 int check= dbPro.userCheck(id,password);
		 
		 List member = dbPro.getPoint(id);		 
		 
		 int point = dbPro.userPoint(id);
		  
		 		 
		 request.setAttribute("check", new Integer(check));
		 
		 request.setAttribute("point", point);	
		 request.setAttribute("member", member);
		 return "/km/myPagePoint/pointExchangeForm1.jsp";
	 }

}