package action.myPagePoint;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import member.MemberDBBean;
import point.PointDBBean;

public class MyPagePointAction implements CommandAction{

	 public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		
		 request.setCharacterEncoding("utf-8");
		 
		 HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id");
		 if(id == null) {
		    return "/JY/nullCommand.jsp";
		 }
		 PointDBBean dbPpo=PointDBBean.getInstance();
		 
		 dbPpo.updatePoint(id);
		 dbPpo.updatePoint1(id);//포인트 확인먼저..
		 
		 MemberDBBean dbPro = MemberDBBean.getInstance();
		 
		 int point = dbPro.userPoint(id);
		 
		 List member = dbPro.getPoint(id); 	 	 
		 

		 
		 request.setAttribute("member", member);
		 request.setAttribute("point", point);			  
		 request.setAttribute("id", id);
		 
		 
		 
		 
		 return "/km/myPagePoint/myPagePoint.jsp";
		 
		 
		 
		 
		 
		 
		 
	 }
}
