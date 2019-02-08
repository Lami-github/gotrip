package action.myboard;

import java.util.*;

import javax.servlet.http.*;
import controller.CommandAction;
import myboard.MyboardDBBean;

public class MyboardAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		String option = request.getParameter("option");
		System.out.println("id::" + id);
		if (id == null) {
			return "/view/nullCommand.jsp";
		}
		
		if(option == null) {
			option = "tripreview";;
		}
		
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 10;
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = 0;
		int number = 0;
		
		List article = null;
		MyboardDBBean mdbbean = MyboardDBBean.getInstance();
		
		if(option.equals("tripreview")) {
			count = mdbbean.TripreviewArticleCount(id);
			System.out.println("count::"+count);
			if (count > 0) {
				article = mdbbean.TripreviewGetArticle(id,startRow,endRow); 
		    }else { 
		    	article = Collections.EMPTY_LIST;
		    }
		}
		else if(option.equals("traveler")) {
			count = mdbbean.TravelerArticleCount(id);
			if (count > 0) {
				article = mdbbean.TravelerGetArticle(id,startRow,endRow); 
		    }else { 
		    	article = Collections.EMPTY_LIST;
		    }
		}else if(option.equals("buyer")) {
			count = mdbbean.BuyerArticleCount(id);
			if (count > 0) {
				article = mdbbean.BuyerGetArticle(id,startRow,endRow); 
		    }else { 
		    	article = Collections.EMPTY_LIST;
		    }
		}
		else {
			count = mdbbean.allGetArticleCount(id);
			if (count > 0) {
				article = mdbbean.allGetArticle(id,startRow,endRow); 
		    }else { 
		    	article = Collections.EMPTY_LIST;
		    }
		}
		number=count-(currentPage-1)*pageSize;
		
		request.setAttribute("option", option);
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow",new Integer(startRow));
		request.setAttribute("endRow",new Integer(endRow));
		request.setAttribute("count",new Integer(count));
		request.setAttribute("pageSize",new Integer(pageSize));
		request.setAttribute("number",new Integer(number));
		request.setAttribute("article", article);
		
		return "/mj/myboard/myboardmain.jsp";
	}
}