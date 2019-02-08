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
		int num = Integer.parseInt(request.getParameter("num")); //�ش�۹�ȣ
		String pageNum = request.getParameter("pageNum"); //�ش� ��������ȣ
		
		ExchangeDBBean dbPro = ExchangeDBBean.getInstance(); // ���ó��
		ExchangeDataBean article = dbPro.getArticle(num); // �ش� �۹�ȣ�� ���� �ش� ���ڵ�
		
		//�ش� �信�� ����� �Ӽ�
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
		
		return "/JY/Ex/ExDetailForm.jsp";
	}

}
