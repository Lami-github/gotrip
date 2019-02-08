package adminaction.Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDBBean;
import controller.CommandAction;

public class LoginProAction implements CommandAction {//회원인증 처리

    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {

        request.setCharacterEncoding("utf-8");//한글 인코딩
        
        String id = request.getParameter("id");
	    String passwd  = request.getParameter("passwd");

	    MemberDBBean dbPro = MemberDBBean.getInstance();//DB처리
        int check=dbPro.adminuserCheck(id,passwd);

        //해당 뷰에서 사용할 속성
        request.setAttribute("check", new Integer(check));
        request.setAttribute("id", id);


        return "/JY/login/adminloginPro.jsp";//해당 뷰
    }
}