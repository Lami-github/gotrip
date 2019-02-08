package action.myPageChangeMInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;

public class DeleteMemberFormAction implements CommandAction{

	 public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		 request.setCharacterEncoding("utf-8");
		 
		return "/km/myPageChangeMInfo/deleteMemberForm.jsp"; 
	 }
	 }