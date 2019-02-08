package action.payinsert;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import PayList.PayListDBBean;

public class PaymentCancelAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		int pay_no = Integer.parseInt(request.getParameter("pay_no"));
		String imp_uid = "";
		int check = 0;
		PayListDBBean pldbb = PayListDBBean.getInstance();
		try{
			imp_uid=pldbb.getImp_uid(pay_no);
			if(imp_uid!=null){
				request.setAttribute("imp_uid", imp_uid);
				check = pldbb.deletePayment(pay_no);
				if(check>0){
					return "/EB/Payment_List/cancelPayment.jsp";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/EB/Payment_List/ListPro.do?check="+check;
	}

}
