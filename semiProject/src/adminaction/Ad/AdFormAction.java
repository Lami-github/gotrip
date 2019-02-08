package adminaction.Ad;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ad.AdDBBean;
import controller.CommandAction;


public class AdFormAction implements CommandAction { //ȸ������ �� ó��

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String pageNum = request.getParameter("pageNum"); // ������ ��ȣ
		
		if(pageNum == null) {
			pageNum ="1";
		}
		int pageSize = 10;// �� �������� ���� ����
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize +1; // ���������� ���۱� ��ȣ
		int endRow = currentPage* pageSize;
		int count =0;
		int number=0;
		
		List adList = null;
		AdDBBean dbPro = AdDBBean.getInstance(); // DB����
		count = dbPro.getAdCount(); // ��ü���Ǽ�
		
		if(count > 0 ) {
			adList = dbPro.getAds(startRow, endRow);
			//������������ �ش��ϴ� �� ���
		}else {
			adList = Collections.EMPTY_LIST;
		}
		
		number = count-(currentPage-1)*pageSize; // �۸�Ͽ� ǥ���� �۹�ȣ
		
		//�ش� �信�� ����� �Ӽ�
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("adList", adList);
		
		return "/JY/Ad/AdForm.jsp";//�ش� 
	}

}
