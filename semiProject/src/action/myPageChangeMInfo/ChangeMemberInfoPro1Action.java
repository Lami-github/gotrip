package action.myPageChangeMInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import member.MemberDBBean;
import member.MemberDataBean;


public class ChangeMemberInfoPro1Action implements CommandAction{

	
	
	
	 public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		 
		 request.setCharacterEncoding("utf-8");
		 MemberDataBean member = new MemberDataBean();
		 MemberDBBean dbPro= MemberDBBean.getInstance();
		 
		 HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id");
		 if(id == null) {
		    return "/JY/nullCommand.jsp";
		 }
		 member.setPassword(request.getParameter("password"));
		 member.setPhonenumber(request.getParameter("phonenumber"));
		 member.setZipcode(new Integer(request.getParameter("zipcode")));
		 member.setAddress(request.getParameter("address"));
		 member.setAddress1(request.getParameter("address1"));
		 
		 member.setPwdquiz(new Integer(request.getParameter("pwdquiz")));
		 member.setPwdanswer(request.getParameter("pwdanswer"));
		 
		 dbPro.insertUpdateMember(member, id);
		 
		 
		 return "/km/myPageChangeMInfo/changeMemberInfoPro1.jsp";
	 }

}
