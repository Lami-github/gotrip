 package action.payinsert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CommandAction;
import member.MemberDBBean;
import PayList.PayListDBBean;
import adminaction.StatDBBean;

public class InsertImp_uidAction implements CommandAction {

	// üũ �� ã�Ƽ� update ������ �޼���
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		String imp_uid = "";
		int pay_no = 0;
		int check1 = 0;
		int check2 = 0;
		
		imp_uid=request.getParameter("imp_uid");
		pay_no=Integer.parseInt(request.getParameter("pay_no"));
		System.out.println("InsertImp_uid���� imp_uid:::"+imp_uid+", pay_no:::"+pay_no);
		PayListDBBean pldbb = PayListDBBean.getInstance();
		try{
			check1 = pldbb.insertImp_uid(imp_uid, pay_no);
			check2 = pldbb.insertState(pay_no);
			//insertImp_uid��� ������ update���� ����.
			System.out.println("InsertImp_uid���� check1�̶� check2��ħ");
			if(check1==0 || check2==0){
				return "/MyPage/payment/Fail.jsp";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		int point = pldbb.getPoint(pay_no);
		
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		
		if(id==null) {
			return "/view/nullCommand.jsp";
		}
		
		MemberDBBean mdb = MemberDBBean.getInstance();
		mdb.insertPoint(id, point);
		
		StatDBBean sdb = StatDBBean.getInstance();
		sdb.UpdatepaymentCH(point);
		
		return "/EB/MyPage/payment/InsertSuccess.jsp";
		//check!=0 -> �������� -> InsertSuccess.jsp�� �̵�.
	}

}
