package action.tripreview;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import photo.PhotoDBBean;
import tripreview.TripreviewDataBean;
import tripreview.TripreviewDBBean;

public class TripreViewListAction implements CommandAction { 
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		String pageNum = request.getParameter("pageNum"); // 페이지 번호
		if(pageNum == null) {
			pageNum = "1";
		}
		String hashTagText = request.getParameter("hashTagText"); // 검색할 해시태그
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
		String imgPath = "";
		
		List tripreViewList = null;
		TripreviewDBBean dbPro = TripreviewDBBean.getInstance();
		
		if(search == null & hashTagText == null)
			count = dbPro.getTripreViewCount();
		else
			count = dbPro.getTripreViewCount(n,hashTagText,search);
				
		if(count > 0) {
			if(search == null & hashTagText == null) 
				tripreViewList = dbPro.getTripreView(startRow, endRow);
			else tripreViewList = dbPro.getTripreView(startRow, endRow, n, hashTagText, search);
		}else {
			tripreViewList = Collections.EMPTY_LIST;
		}
		TripreviewDataBean tripreView = new TripreviewDataBean();
		PhotoDBBean dbPhoto = PhotoDBBean.getInstance();
		
		String country = "나라";
		String season = "계절";
		String thema = "테마";
		
		List countryList;
		List seasonList;
		List themaList;
			
		countryList = dbPro.getHashTag(country);
		seasonList = dbPro.getHashTag(season);
		themaList = dbPro.getHashTag(thema);
		
		number=count-(currentPage-1)*pageSize;			
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("tripreViewList", tripreViewList);
		
		request.setAttribute("countryList", countryList);
		request.setAttribute("seasonList", seasonList);
		request.setAttribute("themaList", themaList);
		
		return "/NA/tripreView/list.jsp";
	}
}