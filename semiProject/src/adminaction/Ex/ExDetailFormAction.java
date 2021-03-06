package adminaction.Ex;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import exchange.ExchangeDBBean;
import exchange.ExchangeDataBean;


public class ExDetailFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num")); //해당글번호
		String pageNum = request.getParameter("pageNum"); //해당 페이지번호
		
		ExchangeDBBean dbPro = ExchangeDBBean.getInstance(); // 디비처리
		ExchangeDataBean article = dbPro.getArticle(num); // 해당 글번호에 대한 해당 레코드
		
		//해당 뷰에서 사용할 속성
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
		
		return "/JY/Ex/ExDetailForm.jsp";
	}

}
