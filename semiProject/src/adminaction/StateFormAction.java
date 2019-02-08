package adminaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blacklist.BlacklistDBBean;
import controller.CommandAction;

public class StateFormAction implements CommandAction { //회원인증 폼 처리

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		ArrayList visitstat = new ArrayList();
		ArrayList articlestat = new ArrayList();
		ArrayList paymentstat = new ArrayList();
		ArrayList tradeavgstat = new ArrayList();
		
		
		StatDBBean sdb = StatDBBean.getInstance();
		visitstat = sdb.getvisitorcount();
		articlestat = sdb.getWritecount();
		String split=sdb.getAlltradeCount();
		paymentstat = sdb.getpaymentStat();
		tradeavgstat = sdb.getTradeCount();
		
		
		int total = Integer.parseInt((split.split("/")[0]));
		int succeed = Integer.parseInt((split.split("/")[1]));
		int requests = total-succeed;
		
		System.out.println(total + "/" + succeed);
		
		request.setAttribute("visitstat", visitstat);
		request.setAttribute("articlestat", articlestat);
		request.setAttribute("paymentstat", paymentstat);
		request.setAttribute("tradeavgstat", tradeavgstat);
		request.setAttribute("requests", requests);
		request.setAttribute("succeed", succeed);
		
		return "/JY/State/StateForm.jsp";
	}

}
