package adminaction;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buyer.BuyerDBBean;
import controller.CommandAction;
import traveler.TravelerDBBean;
import tripreview.TripreviewDBBean;

public class BoardFormAction implements CommandAction { //ȸ������ �� ó��

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String pageNum = request.getParameter("pageNum"); // ������ ��ȣ
		String search = request.getParameter("search");
		String select = request.getParameter("select");
		if(pageNum == null) {
			pageNum ="1";
		}
		int searchn = 0;
		int pageSize = 10;// �� �������� ���� ����
		int currentPage = currentPage = Integer.parseInt(pageNum);;
		int startRow = (currentPage-1)*pageSize +1; // ���������� ���۱� ��ȣ
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
			TripreviewDBBean dbPro = TripreviewDBBean.getInstance(); // DB����
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
			TravelerDBBean dbPro = TravelerDBBean.getInstance(); // DB����
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
			BuyerDBBean dbPro = BuyerDBBean.getInstance(); // DB����
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
		
		
		
		number = count-(currentPage-1)*pageSize; // �۸�Ͽ� ǥ���� �۹�ȣ
		
		//�ش� �信�� ����� �Ӽ�
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("select", select);
		request.setAttribute("ArticleList", ArticleList);
		
		return "/JY/BoardForm.jsp";//�ش� 
	}

}
