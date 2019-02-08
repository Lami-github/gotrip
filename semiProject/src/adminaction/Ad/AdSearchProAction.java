package adminaction.Ad;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.AdDBBean;
import controller.CommandAction;

public class AdSearchProAction implements CommandAction {//ȸ������ ó��
   
    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {

        request.setCharacterEncoding("utf-8");//�ѱ� ���ڵ�
        
        String pageNum = request.getParameter("pageNum");
    	String search = request.getParameter("search");
    	
    	int searchn = 0;
    	int pageSize = 10;// �� �������� ���� ����
    	
    	if(pageNum == null)
    	{
    		pageNum = "1";
    	}
    	
    	int currentPage = Integer.parseInt(pageNum);
    	System.out.println(currentPage);
    	int startRow = (currentPage * 3) -2;
    	int endRow = currentPage * pageSize;
    	int count = 0;
    	int number = 0;
    	
    	
    	//pagenum�� parameter������ �Ѿ���� �ʾҴٸ�, �� ù��° ��������.
    	
    	
    	if(search == null)
    	{
    		search = "";
    	}
    	else
    	{
    		searchn = Integer.parseInt(request.getParameter("searchn"));
    	}
    	
    	List adList = null;
    	AdDBBean dbPro = AdDBBean.getInstance();//DBó��

    	
		if(search.equals("") || search == null)
    		count = dbPro.getAdCount();
    	else
    		count = dbPro.getAdCount(searchn,search);
    	
    	if(count > 0)
    	{
    		if(search.equals("") || search == null)
    			adList = dbPro.getAds(startRow, endRow);
    		else
    			adList = dbPro.getAds(startRow, endRow, searchn, search);
    	}else {
    		adList = Collections.EMPTY_LIST;
		}
    	number = count-(currentPage - 1) * pageSize;

        //�ش� �信�� ����� �Ӽ�
        
        request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("adList", adList);
		


        return "/JY/Ad/AdForm.jsp";//�ش� ��
    }
}