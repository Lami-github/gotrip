package adminaction;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buyer.BuyerDBBean;
import controller.CommandAction;
import traveler.TravelerDBBean;
import tripreview.TripreviewDBBean;

public class BoardFormAction implements CommandAction { //회원인증 폼 처리

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String pageNum = request.getParameter("pageNum"); // 페이지 번호
		String search = request.getParameter("search");
		String select = request.getParameter("select");
		if(pageNum == null) {
			pageNum ="1";
		}
		int searchn = 0;
		int pageSize = 10;// 한 페이지의 글의 개수
		int currentPage = currentPage = Integer.parseInt(pageNum);;
		int startRow = (currentPage-1)*pageSize +1; // 한페이지의 시작글 번호
		int endRow = currentPage* pageSize;
		int count =0;
		int number=0;
		
		
		if(select == null) {
			select = "tripreview";
		}
		
		if(search == null)
    	{
    		search = "";
    	}
    	else
    	{
    		searchn = Integer.parseInt(request.getParameter("searchn"));
    	}
		
		List ArticleList = null;
		if (select.equals("tripreview")) {
			TripreviewDBBean dbPro = TripreviewDBBean.getInstance(); // DB연동
			if(search.equals("") || search == null)
	    		count = dbPro.getArticleCount();
	    	else
	    		count = dbPro.getArticleCount(searchn,search);
			if(count > 0 ) {
			
				if(search.equals("") || search == null) {
					
					ArticleList = dbPro.getArticles(startRow, endRow);
				}
	    		else
	    			ArticleList = dbPro.getArticles(startRow, endRow, searchn, search);
			}else {
				ArticleList = Collections.EMPTY_LIST;
			}
		}
		else if (select.equals("traveler")) {
			TravelerDBBean dbPro = TravelerDBBean.getInstance(); // DB연동
			if(search.equals("") || search == null)
	    		count = dbPro.getArticleCount();
	    	else
	    		count = dbPro.getArticleCount(searchn,search);
			if(count > 0 ) {
				if(search.equals("") || search == null)
					ArticleList = dbPro.getArticles(startRow, endRow);
	    		else
	    			ArticleList = dbPro.getArticles(startRow, endRow, searchn, search);
			}else {
				ArticleList = Collections.EMPTY_LIST;
			}
		}
		else{
			BuyerDBBean dbPro = BuyerDBBean.getInstance(); // DB연동
			if(search.equals("") || search == null)
	    		count = dbPro.getArticleCount();
	    	else
	    		count = dbPro.getArticleCount(searchn,search);
			if(count > 0 ) {
				if(search.equals("") || search == null)
					ArticleList = dbPro.getArticles(startRow, endRow);
	    		else
	    			ArticleList = dbPro.getArticles(startRow, endRow, searchn, search);
			}else {
				ArticleList = Collections.EMPTY_LIST;
			}
		}
		
		
		
		number = count-(currentPage-1)*pageSize; // 글목록에 표시할 글번호
		
		//해당 뷰에서 사용할 속성
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("select", select);
		request.setAttribute("ArticleList", ArticleList);
		
		return "/JY/BoardForm.jsp";//해당 
	}

}
