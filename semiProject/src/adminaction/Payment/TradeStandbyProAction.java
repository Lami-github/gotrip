package adminaction.Payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trade.TradeDBBean;
import trade.TradeDataBean;
import controller.CommandAction;

public class TradeStandbyProAction implements CommandAction {// ȸ������ ó��

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");// �ѱ� ���ڵ�

		String trade_num = request.getParameter("trade_num");
		

		TradeDBBean dbPro = TradeDBBean.getInstance();// DBó��
		
		
		dbPro.updateMember(Integer.parseInt(trade_num));

		
		// �ش� �信�� ����� �Ӽ�

		return "/JY/Payment/TradeStandbyPro.jsp";// �ش� ��
	}
}