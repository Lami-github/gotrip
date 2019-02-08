package adminaction.Payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import point.PointDBBean;
import point.PointDataBean;
import controller.CommandAction;

public class PointUpdateProAction implements CommandAction {// ȸ������ ó��

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");// �ѱ� ���ڵ�

		String num = request.getParameter("num");
		String id = request.getParameter("id");
		String point = request.getParameter("point");
		String type = request.getParameter("type");
		String date = request.getParameter("date");
		String check = request.getParameter("check");

		PointDBBean dbPro = PointDBBean.getInstance();// DBó��
		PointDataBean member = new PointDataBean();
		if (check.equals("insert")) {
			member.setId(id);
			member.setUpdate_point(Integer.parseInt(point));
			member.setType(type);
			member.setUpdate_date(date);
		} else
			member.setNum(Integer.parseInt(num));

		dbPro.UpdatePoint(member, check);
		// �ش� �信�� ����� �Ӽ�

		return "/JY/Payment/PointUpdatePro.jsp";// �ش� ��
	}
}