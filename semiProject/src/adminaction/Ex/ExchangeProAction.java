package adminaction.Ex;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import exchange.ExchangeDBBean;


//�Էµ� ��ó��
public class ExchangeProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8"); // �ѱ� ���ڵ�
		String report = request.getParameter("report");
		
		int ex_num = Integer.parseInt(request.getParameter("num"));
		
		ExchangeDBBean dbPro = ExchangeDBBean.getInstance(); //DBó��
		dbPro.updateMember(ex_num);

		return "/JY/Ex/ExchangePro.jsp";
	} 

}
