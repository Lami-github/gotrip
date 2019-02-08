package action.festival;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import festival.FestivalDBBean;

public class FestivalFormAction implements CommandAction { //ȸ������ �� ó��

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String pageNum = request.getParameter("pageNum"); // ������ ��ȣ
		
		if(pageNum == null) {
			pageNum ="1";
		}
		int pageSize = 8;// �� �������� ���� ����
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize +1; // ���������� ���۱� ��ȣ
		int endRow = currentPage* pageSize;
		int count =0;
		int number=0;
		
		List articleList1 = null;
		List articleList2 = null;
		FestivalDBBean dbPro = FestivalDBBean.getInstance(); // DB����
		count = dbPro.getArticleCount(); // ��ü���Ǽ�
		
		if(count > 0 ) {
			articleList1 = dbPro.getArticles(startRow, endRow);
			//������������ �ش��ϴ� �� ���
		}else {
			articleList1 = Collections.EMPTY_LIST;
		}
		
		number = count-(currentPage-1)*pageSize; // �۸�Ͽ� ǥ���� �۹�ȣ
		
		//�ش� �信�� ����� �Ӽ�
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("articleList", articleList1);
		
		return "/JY/Festival/MainFestivalForm.jsp";//�ش� 
	}

}
