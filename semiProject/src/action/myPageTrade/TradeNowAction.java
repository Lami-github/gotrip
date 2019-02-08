package action.myPageTrade;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import member.MemberDBBean;

public class TradeNowAction implements CommandAction{

	
	
	
	 public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		 //글번호
		 MemberDBBean dbPro= MemberDBBean.getInstance();
		
		 
		
		 
		String tr_pageNum= request.getParameter("tr_pageNum");
		 String b_pageNum= request.getParameter("b_pageNum");
		 HttpSession session = request.getSession();
		 String id = (String)session.getAttribute("id");
		 if(id == null) {
		    return "/JY/nullCommand.jsp";
		 }
		 if(tr_pageNum == null) {
			 tr_pageNum="1";
		 }
		 int tr_pageSize= 3;
		 int tr_currentPage = Integer.parseInt(tr_pageNum);
		 int tr_startRow=(tr_currentPage * tr_pageSize)-(tr_pageSize -1);
		 int tr_endRow = tr_currentPage * tr_pageSize;
		 int tr_count=0;
		 int tr_number=0;
		 
		
		 tr_count =dbPro.getArticleCount(id);
		 
		 if (tr_count > 0) {
			 
		 }
			 	
					
		 if(b_pageNum == null) {
			 b_pageNum="1";
		 }
		 int b_pageSize= 3;
		 int b_currentPage = Integer.parseInt(b_pageNum);
		 int b_startRow=(b_currentPage * b_pageSize)-(b_pageSize -1);
		 int b_endRow = b_currentPage * b_pageSize;
		 int b_count=0;
		 int b_number=0;
		 System.out.println("bs::"+b_startRow);
		 System.out.println("be::"+b_endRow);
		 System.out.println("trs::"+tr_startRow);
		 System.out.println("tre::"+tr_endRow);
		 b_count =dbPro.getArticleCount1(id);
		 
		 if (b_count > 0) {
			 
		 }
		 System.out.println("b_count::"+b_count);
		 System.out.println("tr_count::"+tr_count);
		 b_number=b_count-(b_currentPage -1) *b_pageSize;		 	
		
		 tr_number=tr_count-(tr_currentPage -1) *tr_pageSize;	
		 
		 //요건 구매자
		 List b_tradeList=dbPro.getArticle(id,b_startRow,b_endRow);
		 //요건 판매자
		 
		 System.out.println(b_tradeList.size());
		 
		 List tr_tradeList=dbPro.getArticle1(id,tr_startRow,tr_endRow);
		 System.out.println("b_currentPage::"+b_currentPage);
		 System.out.println("tr_currentPage::"+tr_currentPage);
		 //구매자
		 request.setAttribute("tr_number", new Integer(tr_number));
		 request.setAttribute("tr_endRow", new Integer(tr_endRow));
		 request.setAttribute("tr_startRow", new Integer(tr_startRow));
		 request.setAttribute("tr_currentPage", new Integer(tr_currentPage));
		 request.setAttribute("tr_pageNum",new Integer(tr_pageNum));
		 request.setAttribute("tr_pageSize", new Integer(tr_pageSize));
		 request.setAttribute("tr_count", new Integer(tr_count));
		
		 request.setAttribute("b_number", new Integer(b_number));
		 request.setAttribute("b_endRow", new Integer(b_endRow));
		 request.setAttribute("b_startRow", new Integer(b_startRow));
		 request.setAttribute("b_currentPage", new Integer(b_currentPage));
		 request.setAttribute("b_pageNum",new Integer(b_pageNum));
		request.setAttribute("b_pageSize", new Integer(b_pageSize));
		 request.setAttribute("b_count", new Integer(b_count));
		 
		 request.setAttribute("b_tradeList",b_tradeList);
		 request.setAttribute("tr_tradeList",tr_tradeList);
		 request.setAttribute("id", id);
		 
		 return "/km/myPageTrade/tradeNow.jsp";
	 }
}