package action.myPageChangeMInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import controller.CommandAction;

public class ChangeMemberInfoFormAction implements CommandAction{

	
	
	
	 public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		 
		 
		 
		 return "/km/myPageChangeMInfo/changeMemberInfoForm.jsp";
	 }

}
