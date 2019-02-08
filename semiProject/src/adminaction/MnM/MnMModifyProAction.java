package adminaction.MnM;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDBBean;
import member.MemberDataBean;
import controller.CommandAction;

public class MnMModifyProAction implements CommandAction {//ȸ������ ó��

    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {

        request.setCharacterEncoding("utf-8");//�ѱ� ���ڵ�
        
        String id = request.getParameter("id");
	    String point  = request.getParameter("point");
	    String warn  = request.getParameter("warn");
	    String blacklist  = request.getParameter("blacklist");
	    String grade  = request.getParameter("grade");

	    MemberDBBean dbPro = MemberDBBean.getInstance();//DBó��
        
	    MemberDataBean member = new MemberDataBean();
        member.setId(id);
        if(point.equals(""))
        	member.setPoint(0);
        else
        	member.setPoint(Integer.parseInt(point));
        if(warn.equals(""))
        	member.setWarn(0);
        else
        	member.setWarn(Integer.parseInt(warn));
        member.setBlacklist(blacklist);
        member.setGrade(grade);
        
        
        dbPro.updateMember(member);
        //�ش� �信�� ����� �Ӽ�


        return "/JY/MnM/MnMModifyPro.jsp";//�ش� ��
    }
}