package action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import member.MemberDBBean;

public class FindpwdPro2Action implements CommandAction{

	 public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		 request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			int pwdquiz = Integer.parseInt(request.getParameter("pwdquiz"));
			String pwdanswer = request.getParameter("pwdanswer");

			MemberDBBean dbPro = MemberDBBean.getInstance();
			int check = dbPro.checkQuiz(id, pwdquiz, pwdanswer);
			
			request.setAttribute("id", id);
			request.setAttribute("check", check);
			return "/km/login/findpwdForm3.jsp";
	 }}