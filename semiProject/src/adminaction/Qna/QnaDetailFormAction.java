package adminaction.Qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Qna.QnaDBBean;
import Qna.QnaDataBean;
import controller.CommandAction;


public class QnaDetailFormAction implements CommandAction{
	//�� ���� ó��
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int num = Integer.parseInt(request.getParameter("num")); //�ش� �۹�ȣ
		String pageNum = request.getParameter("pageNum"); //�ش������� ��ȣ
		
		QnaDBBean dbPro = QnaDBBean.getInstance(); //DBó��
		QnaDataBean article = dbPro.getArticle(num); //�ش� �� ��ȣ�� ���� �ش� ���ڵ�
		
		//�ش� �信�� ����� �Ӽ�
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
		
		return "/JY/Qna/QnaDetailForm.jsp"; //�ش� ��
	}
}
