package adminaction.BL;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import blacklist.BlacklistDBBean;

public class BLSearchProAction implements CommandAction {//회원인증 처리
   
    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {

        request.setCharacterEncoding("utf-8");//한글 인코딩
        
        String pageNum = request.getParameter("pageNum");
    	String search = request.getParameter("search");
    	
    	int searchn = 0;
    	int pageSize = 10;// 한 페이지의 글의 개수
    	
    	if(pageNum == null)
    	{
    		pageNum = "1";
    	}
    	//pagenum이 parameter값으로 넘어오지 않았다면, 맨 첫번째 페이지로.
    	
    	
    	if(search == null)
    	{
    		search = "";
    	}
    	else
    	{
    		searchn = Integer.parseInt(request.getParameter("searchn"));
    	}
    	

    	
    	int currentPage = Integer.parseInt(pageNum);
    	System.out.println(currentPage);
    	int startRow = (currentPage * 3) -2;
    	int endRow = currentPage * pageSize;
    	int count = 0;
    	int number = 0;
    	
    	List memberList = null;
    	BlacklistDBBean dbPro = BlacklistDBBean.getInstance();//DB처리
    	
    	if(search.equals("") || search == null)
    		count = dbPro.getMemberCount();
    	else
    		count = dbPro.getMemberCount(searchn,search);
    	
    	if(count > 0)
    	{
    		if(search.equals("") || search == null)
    			memberList = dbPro.getMembers(startRow, endRow);
    		else
    			memberList = dbPro.getMembers(startRow, endRow, searchn, search);
    	}
    	
    	number = count-(currentPage - 1) * pageSize;

        //해당 뷰에서 사용할 속성
        
        request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("memberList", memberList);
		


        return "/JY/BL/BLForm.jsp";//해당 뷰
    }
}