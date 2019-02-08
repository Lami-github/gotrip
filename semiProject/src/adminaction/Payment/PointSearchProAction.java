package adminaction.Payment;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import point.PointDBBean;

public class PointSearchProAction implements CommandAction {//ȸ������ ó��
   
    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {

        request.setCharacterEncoding("utf-8");//�ѱ� ���ڵ�
        
        String pageNum = request.getParameter("pageNum");
    	String search = request.getParameter("search");
    	
    	int searchn = 0;
    	int pageSize = 10;// �� �������� ���� ����
    	int currentPage = Integer.parseInt(pageNum);
    	System.out.println(currentPage);
    	int startRow = (currentPage * 3) -2;
    	int endRow = currentPage * pageSize;
    	int count = 0;
    	int number = 0;
    	
    	if(pageNum == null)
    	{
    		pageNum = "1";
    	}
    	//pagenum�� parameter������ �Ѿ���� �ʾҴٸ�, �� ù��° ��������.
    	
    	
    	if(search == null)
    	{
    		search = "";
    	}
    	else
    	{
    		searchn = Integer.parseInt(request.getParameter("searchn"));
    	}
    	
    	List pointList = null;
    	PointDBBean dbPro = PointDBBean.getInstance();//DBó��

    	
		if(search.equals("") || search == null)
    		count = dbPro.getMemberCount();
    	else
    		count = dbPro.getMemberCount(searchn,search);
    	
    	if(count > 0)
    	{
    		if(search.equals("") || search == null)
    			pointList = dbPro.getMembers(startRow, endRow);
    		else
    			pointList = dbPro.getMembers(startRow, endRow, searchn, search);
    	}else {
			pointList = Collections.EMPTY_LIST;
		}
    	number = count-(currentPage - 1) * pageSize;

        //�ش� �信�� ����� �Ӽ�
        
        request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("pointList", pointList);
		


        return "/JY/Payment/PaymentForm.jsp";//�ش� ��
    }
}