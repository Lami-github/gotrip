package adminaction.PQ;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import personalquestion.PersonalquestionDBBean;

public class PQCategoryProAction implements CommandAction {//ȸ������ ó��
   
    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {

        request.setCharacterEncoding("utf-8");//�ѱ� ���ڵ�
        
        String pageNum = request.getParameter("pageNum");
    	String select = request.getParameter("select");
    	
    	int searchn = 0;
    	int pageSize = 10;// �� �������� ���� ����
    	
    	if(pageNum == null)
    	{
    		pageNum = "1";
    	}
    	//pagenum�� parameter������ �Ѿ���� �ʾҴٸ�, �� ù��° ��������.
    	
    	

    	
    	int currentPage = Integer.parseInt(pageNum);
    	
    	int startRow = (currentPage * 3) -2;
    	int endRow = currentPage * pageSize;
    	int count = 0;
    	int number = 0;
    	
    	List ArticleList = null;
    	PersonalquestionDBBean dbPro = PersonalquestionDBBean.getInstance();//DBó��
    	
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

        //�ش� �信�� ����� �Ӽ�
        
        request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("ArticleList", ArticleList);
		


        return "/JY/PQ/PQForm.jsp";//�ش� ��
    }
}