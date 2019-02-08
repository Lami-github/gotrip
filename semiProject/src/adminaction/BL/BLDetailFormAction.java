package adminaction.BL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blacklist.BlacklistDBBean;
import blacklist.BlacklistDataBean;
import controller.CommandAction;




public class BLDetailFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(request.getParameter("num")); //�ش�۹�ȣ
		String pageNum = request.getParameter("pageNum"); //�ش� ��������ȣ
		
		BlacklistDBBean dbPro = BlacklistDBBean.getInstance(); // ���ó��
		BlacklistDataBean member = dbPro.getMember(num); // �ش� �۹�ȣ�� ���� �ش� ���ڵ�
		
		//�ش� �信�� ����� �Ӽ�
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("member", member);
		
		return "/JY/BL/BLDetailForm.jsp";
	}

}
