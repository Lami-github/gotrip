package adminaction.PQ;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import personalquestion.PersonalquestionDBBean;
import personalquestion.PersonalquestionDataBean;
import controller.CommandAction;


public class PQDetailFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int pq_num = Integer.parseInt(request.getParameter("pq_num")); //�ش�۹�ȣ
		String pageNum = request.getParameter("pageNum"); //�ش� ��������ȣ
		
		PersonalquestionDBBean dbPro = PersonalquestionDBBean.getInstance(); // ���ó��
		PersonalquestionDataBean article = dbPro.getArticle(pq_num); // �ش� �۹�ȣ�� ���� �ش� ���ڵ�
		
		//�ش� �信�� ����� �Ӽ�
		request.setAttribute("pq_num", pq_num);
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
		
		return "/JY/PQ/PQDetailForm.jsp";
	}

}
