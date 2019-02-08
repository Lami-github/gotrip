package action.myPageChangeMInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import member.MemberDBBean;

public class DeleteMemberProAction implements CommandAction{

	 public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		 request.setCharacterEncoding("utf-8");
		 
		 HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id");
		 if(id == null) {
		    return "/JY/nullCommand.jsp";
		 }
		 String password = request.getParameter("password");
		 MemberDBBean dbPro = MemberDBBean.getInstance();
		 int check = dbPro.deleteMember(id, password);
		 
		 request.setAttribute("check", check);
		 
		 
		return "/km/myPageChangeMInfo/deleteMemberPro.jsp"; 
	 }}