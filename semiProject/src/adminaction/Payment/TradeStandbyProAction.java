package adminaction.Payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trade.TradeDBBean;
import trade.TradeDataBean;
import controller.CommandAction;

public class TradeStandbyProAction implements CommandAction {// 회원인증 처리

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");// 한글 인코딩

		String trade_num = request.getParameter("trade_num");
		

		TradeDBBean dbPro = TradeDBBean.getInstance();// DB처리
		
		
		dbPro.updateMember(Integer.parseInt(trade_num));

		
		// 해당 뷰에서 사용할 속성

		return "/JY/Payment/TradeStandbyPro.jsp";// 해당 뷰
	}
}