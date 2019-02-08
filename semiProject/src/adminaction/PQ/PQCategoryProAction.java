package adminaction.PQ;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import personalquestion.PersonalquestionDBBean;

public class PQCategoryProAction implements CommandAction {//회원인증 처리
   
    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {

        request.setCharacterEncoding("utf-8");//한글 인코딩
        
        String pageNum = request.getParameter("pageNum");
    	String select = request.getParameter("select");
    	
    	int searchn = 0;
    	int pageSize = 10;// 한 페이지의 글의 개수
    	
    	if(pageNum == null)
    	{
    		pageNum = "1";
    	}
    	//pagenum이 parameter값으로 넘어오지 않았다면, 맨 첫번째 페이지로.
    	
    	

    	
    	int currentPage = Integer.parseInt(pageNum);
    	
    	int startRow = (currentPage * 3) -2;
    	int endRow = currentPage * pageSize;
    	int count = 0;
    	int number = 0;
    	
    	List ArticleList = null;
    	PersonalquestionDBBean dbPro = PersonalquestionDBBean.getInstance();//DB처리
    	
    	if(select.equals("") || select == null)
    		count = dbPro.getArticleCount();
    	else
    		count = dbPro.getCategoryCount(select);
    	System.out.println("count: "+count);
    	if(count > 0)
    	{
    		if(select.equals("") || select == null) {
    			
    			ArticleList = dbPro.getArticles(startRow, endRow);
    		}
    		else {
    			
    			ArticleList = dbPro.getCategoryArticles(startRow, endRow, select);
    		}
    	}
    	
    	number = count-(currentPage - 1) * pageSize;

        //해당 뷰에서 사용할 속성
        
        request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("ArticleList", ArticleList);
		


        return "/JY/PQ/PQForm.jsp";//해당 뷰
    }
}