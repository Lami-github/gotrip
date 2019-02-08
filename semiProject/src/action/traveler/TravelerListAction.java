package action.traveler;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import traveler.TravelerDBBean;

public class TravelerListAction implements CommandAction { 
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		String pageNum = request.getParameter("pageNum"); // 페이지 번호
		if(pageNum == null) {
			pageNum = "1";
		}
		String a = request.getParameter("n"); // 분류
		String search = request.getParameter("search"); // 검색어	
		int n = 0;
		
		if(a == null) {
			a = "0";
			n = Integer.parseInt(a);
		}else n = Integer.parseInt(a);
		
		int pageSize = 8;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1; 
		int endRow = currentPage * pageSize; 
		int count = 0;
		int number = 0;
		
		List travelerBoardList = null;
		TravelerDBBean dbPro = TravelerDBBean.getInstance();
		
		if(search == null) {
			count = dbPro.getTravelerBoardCount();
			}
		else {
			count = dbPro.getTravelerBoardCount(n,search);
		}
		
		if(count > 0) {
			if(search == null) 
				travelerBoardList = dbPro.getTravelerBoard(startRow, endRow);
			else travelerBoardList = dbPro.getTravelerBoard(startRow, endRow, n, search);
		}else {
			travelerBoardList = Collections.EMPTY_LIST;
		}
		
		number=count-(currentPage-1)*pageSize;
						
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("travelerBoardList", travelerBoardList);
		
		return "/NA/traveler/list.jsp";
	}
}
