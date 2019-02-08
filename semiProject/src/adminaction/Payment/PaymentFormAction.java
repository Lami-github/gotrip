package adminaction.Payment;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import point.PointDBBean;
import trade.TradeDBBean;

public class PaymentFormAction implements CommandAction { // 회원인증 폼 처리

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String p_pageNum = request.getParameter("p_pageNum"); // 페이지 번호
		String tr_pageNum = request.getParameter("tr_pageNum"); // 페이지 번호
		HttpSession session = request.getSession();
		String admin_id = (String)session.getAttribute("admin_id");
		if(admin_id == null) {
			return "/JY/nullCommand.jsp";
		}
		if (p_pageNum == null) {
			p_pageNum = "1";
		}
		
		if (tr_pageNum == null) {
			tr_pageNum = "1";
		}
		int pageSize = 5;// 한 페이지의 글의 개수
		int p_currentPage = Integer.parseInt(p_pageNum);
		int p_startRow = (p_currentPage - 1) * pageSize + 1; // 한페이지의 시작글 번호
		int p_endRow = p_currentPage * pageSize;
		int p_count = 0;
		int p_number = 0;

		int tr_currentPage = Integer.parseInt(tr_pageNum);
		int tr_startRow = (tr_currentPage - 1) * pageSize + 1; // 한페이지의 시작글 번호
		int tr_endRow = tr_currentPage * pageSize;
		int tr_count = 0;
		int tr_number = 0;

		List pointList = null;
		List tradeList = null;
		PointDBBean p_dbPro = PointDBBean.getInstance(); // DB연동
		TradeDBBean tr_dbPro = TradeDBBean.getInstance(); 
		p_count = p_dbPro.getMemberCount(); // 전체글의수
		tr_count = tr_dbPro.getMemberCount(); // 전체글의수

		if (p_count > 0) {
			pointList = p_dbPro.getMembers(p_startRow, p_endRow);
			// 현재페이지에 해당하는 글 목록
		} else {
			pointList = Collections.EMPTY_LIST;
		}
		
		if (tr_count > 0) {
			tradeList = tr_dbPro.getMembers(tr_startRow, tr_endRow);
			// 현재페이지에 해당하는 글 목록
		} else {
			tradeList = Collections.EMPTY_LIST;
		}

		p_number = p_count - (p_currentPage - 1) * pageSize; // 글목록에 표시할 글번호
		tr_number = tr_count - (tr_currentPage - 1) * pageSize; // 글목록에 표시할 글번호
		


		// 해당 뷰에서 사용할 속성
		request.setAttribute("p_currentPage", new Integer(p_currentPage));
		request.setAttribute("p_startRow", new Integer(p_startRow));
		request.setAttribute("p_endRow", new Integer(p_endRow));
		request.setAttribute("p_count", new Integer(p_count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("p_number", new Integer(p_number));
		request.setAttribute("pointList", pointList);
		
		request.setAttribute("tr_currentPage", new Integer(tr_currentPage));
		request.setAttribute("tr_startRow", new Integer(tr_startRow));
		request.setAttribute("tr_endRow", new Integer(tr_endRow));
		request.setAttribute("tr_count", new Integer(tr_count));
		request.setAttribute("tr_number", new Integer(tr_number));
		request.setAttribute("tradeList", tradeList);
		

		return "/JY/Payment/PaymentForm.jsp";// 해당
	}

}
