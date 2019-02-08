package action.Notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CommandAction;
import notice.NoticeDataBean;
import notice.NoticeDBBean;

public class NoticeDetailFormAction implements CommandAction{
	//�� ���� ó��
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int num = Integer.parseInt(request.getParameter("num")); //�ش� �۹�ȣ
		String pageNum = request.getParameter("pageNum"); //�ش������� ��ȣ
		
		NoticeDBBean dbPro = NoticeDBBean.getInstance(); //DBó��
		NoticeDataBean article = dbPro.getArticle(num); //�ش� �� ��ȣ�� ���� �ش� ���ڵ�
		
		//�ش� �信�� ����� �Ӽ�
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
		
		return "/JY/Notice/MainNoticeDetailForm.jsp"; //�ش� ��
	}
}
