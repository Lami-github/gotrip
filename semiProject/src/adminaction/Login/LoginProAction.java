package adminaction.Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDBBean;
import controller.CommandAction;

public class LoginProAction implements CommandAction {//ȸ������ ó��

    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {

        request.setCharacterEncoding("utf-8");//�ѱ� ���ڵ�
        
        String id = request.getParameter("id");
	    String passwd  = request.getParameter("passwd");

	    MemberDBBean dbPro = MemberDBBean.getInstance();//DBó��
        int check=dbPro.adminuserCheck(id,passwd);

        //�ش� �信�� ����� �Ӽ�
        request.setAttribute("check", new Integer(check));
        request.setAttribute("id", id);


        return "/JY/login/adminloginPro.jsp";//�ش� ��
    }
}