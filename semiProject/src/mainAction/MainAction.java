package mainAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminaction.StatDBBean;
import controller.CommandAction;


public class MainAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
              
		
		
		
		MainDBBean dbPro= MainDBBean.getInstance();
		int[] f_num=dbPro.getFestArticle();
		int[] tr_num=dbPro.getTravelArticle();
		int[] t_num=dbPro.getReviewArticle();
		
		String[] f_img=dbPro.getFestImg();
		String[] tr_img=dbPro.getTravelImg();
		String[] t_img=dbPro.getReviewImg();	
		
		request.setAttribute("t_img", t_img);
		request.setAttribute("tr_img", tr_img);
		request.setAttribute("f_img", f_img);
		request.setAttribute("f_num", f_num);
		request.setAttribute("tr_num", tr_num);
		request.setAttribute("t_num", t_num);
		
		
		
		StatDBBean sdb = StatDBBean.getInstance();
		
		sdb.visitorcount();
		
		
		
		return "/main.jsp";
	}
}
