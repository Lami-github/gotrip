package action.traveler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

import controller.CommandAction;
import photo.*;
import traveler.TravelerDBBean;
import traveler.TravelerDataBean;
  
public class TravelerDetailAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		int tr_num = Integer.parseInt(request.getParameter("tr_num"));
		String pageNum = request.getParameter("pageNum");
		
		
		List comment=null;
		
		TravelerDBBean dbPro = TravelerDBBean.getInstance();
		TravelerDataBean article = dbPro.getTravelerArticle(tr_num);
		comment = dbPro.getTravelerComment(tr_num);
		
	
		String photo_id = article.getPhoto_id().substring(0, article.getPhoto_id().length()-1);
		int photoid = Integer.parseInt(photo_id);
		
		PhotoDBBean pdb = PhotoDBBean.getInstance();
		PhotoDataBean photo = pdb.getPhoto(photoid);
		
		request.setAttribute("tr_num",tr_num);
		request.setAttribute("pageNum",new Integer(pageNum));
		request.setAttribute("article",article);
		request.setAttribute("photo", photo);
		request.setAttribute("comment", comment);
		
		return "/mj/traveler/travelerDetail.jsp";
	}
}
