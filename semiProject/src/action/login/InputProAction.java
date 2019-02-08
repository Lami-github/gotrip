package action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import member.MemberDBBean;
import member.MemberDataBean;

public class InputProAction implements CommandAction{//회원인증 처리

	public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		MemberDataBean member = new MemberDataBean();
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));			
		
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setPhonenumber(request.getParameter("phonenumber"));
		member.setZipcode(new Integer(request.getParameter("zipcode")));
		member.setAddress(request.getParameter("address"));
		member.setAddress1(request.getParameter("address1"));
		member.setPwdquiz(new Integer(request.getParameter("pwdquiz")));
		member.setPwdanswer(request.getParameter("pwdanswer"));
		member.setWarn(new Integer(request.getParameter("warn")));
		member.setGrade(request.getParameter("grade"));
		member.setPoint(new Integer(request.getParameter("point")));
		member.setBlacklist(request.getParameter("blacklist"));
		MemberDBBean dbPro= MemberDBBean.getInstance();
		dbPro.insertMember(member);	
			
		
		
		
	return "/km/login/inputPro.jsp";
	}	
}
